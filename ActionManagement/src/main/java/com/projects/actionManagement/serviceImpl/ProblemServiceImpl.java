package com.projects.actionManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projects.actionManagement.entity.Axe;
import com.projects.actionManagement.entity.Problem;
import com.projects.actionManagement.repository.ProblemRepository;
import com.projects.actionManagement.service.AxeService;
import com.projects.actionManagement.service.ProblemService;

@Service
public class ProblemServiceImpl implements ProblemService{
	
	private ProblemRepository problemRepository;
	private AxeService axeService;

	public ProblemServiceImpl(ProblemRepository problemRepository,AxeService axeService) {
		super();
		this.problemRepository = problemRepository;
		this.axeService = axeService;
	}

	@Override
	public List<Problem> getAllProblems() {
		return problemRepository.findAll(Sort.by("axe"));
	}

	@Override
	public List<Problem> getAllProblemsByAxe(Axe axe) {
		return problemRepository.findProblemsByAxe(axe);
	}

	@Override
	public Problem getProblemById(Long id) {
		return problemRepository.findById(id).orElseThrow( () -> (new ObjectNotFoundException(id, "Problem")));
	}

	@Override
	public Problem addNewProblem(List<String> list) {
		String description = list.get(0);
		int criticity = Integer.parseInt(list.get(1)); 
		Long numberByAxe = Long.parseLong(list.get(2)); 
		Long idAxe = Long.parseLong(list.get(3));
		Axe axe = axeService.getAxeById(idAxe);
		Problem prob = new Problem();
		prob.setDescription(description);
		prob.setCriticity(criticity);
		prob.setNumberByAxe(numberByAxe);
		prob.setAxe(axe);
		return problemRepository.save(prob);
	}

	@Override
	public Problem updateProblem(Problem prob, Long id) {
		Problem existedProb = problemRepository.findById(id).get();
		existedProb.setDescription(prob.getDescription());
		existedProb.setNumberByAxe(prob.getNumberByAxe());
		existedProb.setCriticity(prob.getCriticity());
		return problemRepository.save(existedProb);
	}

	@Override
	public String deleteProblemById(Long id) {
		Optional<Problem> opt = problemRepository.findById(id);
		if (opt.isPresent()){
			problemRepository.deleteById(id);
			return "Problem "+id+" deleted Succesffully!";
		}
		return "No Existing Problem for This id = "+id;
	}
	
	
	
}
