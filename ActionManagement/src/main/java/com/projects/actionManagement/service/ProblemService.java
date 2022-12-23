package com.projects.actionManagement.service;

import java.util.List;

import com.projects.actionManagement.entity.Axe;
import com.projects.actionManagement.entity.Problem;

public interface ProblemService {
	
	List<Problem> getAllProblems();
	List<Problem> getAllProblemsByAxe(Axe axe);
	Problem getProblemById(Long id);
	Problem addNewProblem(List<String> list);
	Problem updateProblem(Problem prob,Long id);
	String deleteProblemById(Long id);
	
}
