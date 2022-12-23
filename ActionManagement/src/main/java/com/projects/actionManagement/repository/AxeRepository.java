package com.projects.actionManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.actionManagement.entity.ActionPlan;
import com.projects.actionManagement.entity.Axe;

public interface AxeRepository extends JpaRepository<Axe, Long>{

	 @Query("select new com.projects.actionManagement.entity.Axe(a.id,a.indicator,a.numberByPa,a.pa) from Axe a where  a.pa=?1 order by a.numberByPa ASC")
	 List<Axe> findAxesByActionPlan(ActionPlan pa);
	
}
