package com.projects.actionManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.actionManagement.entity.ActionPlan;
import com.projects.actionManagement.service.ActionPlanService;

@RestController
public class ActionPlanController {

	private ActionPlanService actionPlanService;

	public ActionPlanController(ActionPlanService actionPlanService) {
		super();
		this.actionPlanService = actionPlanService;
	}
	
	@GetMapping("/actionplans")
	public ResponseEntity<List<ActionPlan>> getAllActionPlans(){
		return new ResponseEntity<List<ActionPlan>>(actionPlanService.getAllActionPlans(), HttpStatus.OK);
	}
	
	@GetMapping("/actionplans/{id}")
	public ResponseEntity<ActionPlan> getActionPlanById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<ActionPlan>(actionPlanService.getActionPlanById(id),HttpStatus.OK);
	}
	
	@PostMapping("/actionplans/new")
	public ResponseEntity<ActionPlan> addNewActionPlan(@RequestBody ActionPlan pa) {
		return new ResponseEntity<ActionPlan>(actionPlanService.addNewActionPlan(pa),HttpStatus.CREATED);
	}
	
	@PutMapping("/actionplans/update/{id}")
	public ResponseEntity<ActionPlan> updateActionPlan(@RequestBody ActionPlan pa,@PathVariable(name = "id") Long id) {
		return new ResponseEntity<ActionPlan>(actionPlanService.updateActionPlan(pa,id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/actionplans/delete/{id}")
	public ResponseEntity<String> deleteActionPlan(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<String>(actionPlanService.deleteActionPlanById(id),HttpStatus.OK);
	}
	
}
