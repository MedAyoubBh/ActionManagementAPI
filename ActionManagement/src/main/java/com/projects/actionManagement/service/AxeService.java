package com.projects.actionManagement.service;

import java.util.List;

import com.projects.actionManagement.entity.ActionPlan;
import com.projects.actionManagement.entity.Axe;

public interface AxeService {
	List<Axe> getAllAxes();
	List<Axe> getAllAxesByActionPlan(ActionPlan pa);
	Axe getAxeById(Long id);
	Axe addNewAxe(List<String> list);
	Axe updateAxe(Axe axe,Long id);
	String deleteAxeById(Long id);
}
