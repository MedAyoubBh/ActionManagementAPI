package com.projects.actionManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.actionManagement.entity.ActionPlan;

public interface ActionPlanRepository extends JpaRepository<ActionPlan, Long>{

}
