package com.projects.actionManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projects.actionManagement.entity.ActionPlan;
import com.projects.actionManagement.repository.ActionPlanRepository;
import com.projects.actionManagement.service.ActionPlanService;

@Service
public class ActionPlanServiceImpl implements ActionPlanService{
	
	private ActionPlanRepository actionPlanRepo;

	public ActionPlanServiceImpl(ActionPlanRepository actionPlanRepo) {
		super();
		this.actionPlanRepo = actionPlanRepo;
	}

	@Override
	public List<ActionPlan> getAllActionPlans() {
		return actionPlanRepo.findAll(Sort.by("creationDate"));
	}

	@Override
	public ActionPlan getActionPlanById(Long id) {
		return actionPlanRepo.findById(id).orElseThrow(() -> (new ObjectNotFoundException(id, "ActionPlan")));
	}

	@Override
	public ActionPlan addNewActionPlan(ActionPlan pa) {
		return actionPlanRepo.save(pa);
	}

	@Override
	public ActionPlan updateActionPlan(ActionPlan pa,Long id) {
		ActionPlan existedPa = actionPlanRepo.findById(id).get();
		existedPa.setActors(pa.getActors());
		existedPa.setCheckers(pa.getCheckers());
		existedPa.setCreationDate(pa.getCreationDate());
		existedPa.setNom(pa.getNom());
		existedPa.setNumberBySecter(pa.getNumberBySecter());
		existedPa.setParticipants(pa.getParticipants());
		return actionPlanRepo.save(existedPa);
	}

	@Override
	public String deleteActionPlanById(Long id) {
		Optional<ActionPlan> opt = actionPlanRepo.findById(id);
		if (opt.isPresent()){
			actionPlanRepo.deleteById(id);
			return "Action Plan "+id+" deleted Succesffully!";
		}
		return "No Existing Action Plan for This id = "+id;
	}

}
