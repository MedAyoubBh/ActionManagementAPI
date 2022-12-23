package com.projects.actionManagement.service;

import java.text.ParseException;
import java.util.List;

import com.projects.actionManagement.entity.Action;
import com.projects.actionManagement.entity.Problem;

public interface ActionService {

	List<Action> getAllActions();
	List<Action> getAllActionsByProblem(Problem prob);
	Action getActionById(Long id);
	Action addNewAction(List<String> list) throws ParseException;
	Action updateAction(Action prob,Long id);
	String deleteActionById(Long id);
	
}
