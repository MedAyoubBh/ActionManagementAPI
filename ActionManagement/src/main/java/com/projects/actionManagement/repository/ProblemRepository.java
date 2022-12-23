package com.projects.actionManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.actionManagement.entity.Axe;
import com.projects.actionManagement.entity.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long>{

	@Query("select new com.projects.actionManagement.entity.Problem(p.id,p.description,p.criticity,p.numberByAxe,p.axe) from Problem p where  p.axe=?1 order by p.numberByAxe ASC")
	 List<Problem> findProblemsByAxe(Axe axe);
}
