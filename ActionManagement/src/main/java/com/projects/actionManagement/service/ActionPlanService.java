package com.projects.actionManagement.service;

import java.util.List;

import com.projects.actionManagement.entity.ActionPlan;

public interface ActionPlanService {
	List<ActionPlan> getAllActionPlans();
	ActionPlan getActionPlanById(Long id);
	ActionPlan addNewActionPlan(ActionPlan pa);
	ActionPlan updateActionPlan(ActionPlan pa,Long id);
	String deleteActionPlanById(Long id);
}
