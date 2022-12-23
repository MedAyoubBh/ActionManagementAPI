package com.projects.actionManagement.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.projects.actionManagement.entity.Action;
import com.projects.actionManagement.entity.Problem;
import com.projects.actionManagement.repository.ActionRepository;
import com.projects.actionManagement.service.ActionService;
import com.projects.actionManagement.service.ProblemService;


@Service
public class ActionServiceImpl implements ActionService{
	
	private ActionRepository actionRepository;
	private ProblemService problemService;

	public ActionServiceImpl(ActionRepository actionRepository,
			com.projects.actionManagement.service.ProblemService problemService) {
		super();
		this.actionRepository = actionRepository;
		this.problemService = problemService;
	}

	@Override
	public List<Action> getAllActions() {
		return actionRepository.findAll(Sort.by("problem"));
	}

	@Override
	public List<Action> getAllActionsByProblem(Problem prob) {
		return actionRepository.findActionsByProblem(prob);
	}

	@Override
	public Action getActionById(Long id) {
		return actionRepository.findById(id).orElseThrow( () -> (new ObjectNotFoundException(id, "Action")));
}

	@Override
	public Action addNewAction(List<String> list) throws ParseException {
		String cause = list.get(0);
		String action = list.get(1);
		Long responsable = Long.parseLong(list.get(2)); 
		LocalDate expectedDate = LocalDate.parse(list.get(3).toString());
		Boolean p = Boolean.parseBoolean(list.get(4));
		Boolean d = Boolean.parseBoolean(list.get(5));
		Boolean c = Boolean.parseBoolean(list.get(6));
		Boolean a = Boolean.parseBoolean(list.get(7)); 
		Long numberByProb = Long.parseLong(list.get(8)); 
		Long idProb = Long.parseLong(list.get(9));
		Problem prob = problemService.getProblemById(idProb);
		Action act = new Action();
		act.setCause(cause);
		act.setAction(action);
		act.setResponsable(responsable);
		act.setExpectatedDate(expectedDate);
		act.setP(p);
		act.setD(d);
		act.setC(c);
		act.setA(a);
		act.setNumberByProblem(numberByProb);
		act.setProblem(prob);
		return actionRepository.save(act);
	}

	@Override
	public Action updateAction(Action act, Long id) {
		Action existedAct = actionRepository.findById(id).get();
		existedAct.setA(act.getA());
		existedAct.setAction(act.getAction());
		existedAct.setC(act.getC());
		existedAct.setCause(act.getCause());
		existedAct.setCheckedDate(act.getCheckedDate());
		existedAct.setD(act.getD());
		existedAct.setDoneDate(act.getDoneDate());
		existedAct.setExpectatedDate(act.getExpectatedDate());
		existedAct.setNumberByProblem(act.getNumberByProblem());
		existedAct.setP(act.getP());
		existedAct.setResponsable(act.getResponsable());
		return actionRepository.save(existedAct);
	}

	@Override
	public String deleteActionById(Long id) {
		Optional<Action> opt = actionRepository.findById(id);
		if (opt.isPresent()){
			actionRepository.deleteById(id);
			return "Action "+id+" deleted Succesffully!";
		}
		return "No Existing Action for This id = "+id;
	}

}
