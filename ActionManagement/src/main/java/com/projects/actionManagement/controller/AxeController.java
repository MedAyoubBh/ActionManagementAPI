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


import com.projects.actionManagement.entity.Axe;
import com.projects.actionManagement.service.AxeService;
import com.projects.actionManagement.service.ActionPlanService;

@RestController
public class AxeController {
	
	private AxeService axeService;
	private ActionPlanService actionPlanService;

	public AxeController(AxeService axeService,ActionPlanService actionPlanService) {
		super();
		this.axeService = axeService;
		this.actionPlanService = actionPlanService;
	}
	
	@GetMapping("/axes")
	public ResponseEntity<List<Axe>> getAllAxes(){
		return new ResponseEntity<List<Axe>>(axeService.getAllAxes(), HttpStatus.OK);
	}
	
	@GetMapping("/axes/{id}")
	public ResponseEntity<Axe> getAxeById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Axe>(axeService.getAxeById(id),HttpStatus.OK);
	}
	
	@GetMapping("actionplans/{pa_id}/axes")
	public ResponseEntity<List<Axe>> getAllAxesByActionPlan(@PathVariable(name = "pa_id") Long idPA) {
		return new ResponseEntity<List<Axe>>(axeService.getAllAxesByActionPlan(actionPlanService.getActionPlanById(idPA)),HttpStatus.OK);
	}
	
	@PostMapping("/axes/new")
	public ResponseEntity<Axe> addNewAxe(@RequestBody List<String> list) {
		return new ResponseEntity<Axe>(axeService.addNewAxe(list),HttpStatus.CREATED);
	}
	
	@PutMapping("/axes/update/{id}")
	public ResponseEntity<Axe> updateAxe(@RequestBody Axe axe,@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Axe>(axeService.updateAxe(axe,id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/axes/delete/{id}")
	public ResponseEntity<String> deleteAxe(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<String>(axeService.deleteAxeById(id),HttpStatus.OK);
	}
	
}
