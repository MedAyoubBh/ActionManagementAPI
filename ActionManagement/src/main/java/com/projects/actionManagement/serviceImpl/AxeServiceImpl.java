package com.projects.actionManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projects.actionManagement.entity.ActionPlan;
import com.projects.actionManagement.entity.Axe;
import com.projects.actionManagement.repository.AxeRepository;
import com.projects.actionManagement.service.ActionPlanService;
import com.projects.actionManagement.service.AxeService;

@Service
public class AxeServiceImpl implements AxeService{
	
	private AxeRepository axeRepository;
	private ActionPlanService actionPlanService;

	public AxeServiceImpl(AxeRepository axeRepository,ActionPlanService actionPlanService) {
		super();
		this.axeRepository = axeRepository;
		this.actionPlanService = actionPlanService;
	}

	@Override
	public List<Axe> getAllAxes() {
		return axeRepository.findAll(Sort.by("pa"));
	}
	
	@Override
	public List<Axe> getAllAxesByActionPlan(ActionPlan pa) {
		return axeRepository.findAxesByActionPlan(pa);
	}

	@Override
	public Axe getAxeById(Long id) {
		return axeRepository.findById(id).orElseThrow( () -> (new ObjectNotFoundException(id, "Axe")));
	}

	@Override
	public Axe addNewAxe(List<String> list) {
		String indicator = list.get(0);
		Long numberByPa = Long.parseLong(list.get(1)); 
		Long idPA = Long.parseLong(list.get(2));
		ActionPlan pa = actionPlanService.getActionPlanById(idPA);
		Axe axe = new Axe();
		axe.setIndicator(indicator);
		axe.setNumberByPa(numberByPa);
		axe.setPa(pa);
		return axeRepository.save(axe);
	}

	@Override
	public Axe updateAxe(Axe axe, Long id) {
		Axe existedAxe = axeRepository.findById(id).get();
		existedAxe.setIndicator(axe.getIndicator());
		existedAxe.setNumberByPa(axe.getNumberByPa());
		return axeRepository.save(existedAxe);
	}

	@Override
	public String deleteAxeById(Long id) {
		Optional<Axe> opt = axeRepository.findById(id);
		if (opt.isPresent()){
			axeRepository.deleteById(id);
			return "Axe "+id+" deleted Succesffully!";
		}
		return "No Existing Axe for This id = "+id;
	}

}
