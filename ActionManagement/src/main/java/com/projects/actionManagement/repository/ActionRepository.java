package com.projects.actionManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.actionManagement.entity.Action;
import com.projects.actionManagement.entity.Problem;

public interface ActionRepository extends JpaRepository<Action, Long>{

	@Query("select new com.projects.actionManagement.entity.Action(a.id,a.cause,a.action,a.responsable,a.expectatedDate,a.p,a.d,a.c,a.a,a.numberByProblem,a.doneDate,a.checkedDate,a.problem) from Action a where  a.problem=?1 order by a.numberByProblem ASC")
	 List<Action> findActionsByProblem(Problem prob);
	
}
