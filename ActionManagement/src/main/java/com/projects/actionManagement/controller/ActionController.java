package com.projects.actionManagement.controller;

import java.text.ParseException;
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

import com.projects.actionManagement.entity.Action;
import com.projects.actionManagement.service.ActionService;
import com.projects.actionManagement.service.ProblemService;

@RestController
public class ActionController {
	
	private ActionService actionService;
	private ProblemService problemService;
	
	
	public ActionController(ActionService actionService, ProblemService problemService) {
		super();
		this.actionService = actionService;
		this.problemService = problemService;
	}
	
	@GetMapping("/actions")
	public ResponseEntity<List<Action>> getAllActionss(){
		return new ResponseEntity<List<Action>>(actionService.getAllActions(), HttpStatus.OK);
	}
	
	@GetMapping("/actions/{id}")
	public ResponseEntity<Action> getActionById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Action>(actionService.getActionById(id),HttpStatus.OK);
	}
	
	@GetMapping("actionplans/{pa_id}/axes/{axe_id}/problems/{prob_id}/actions")
	public ResponseEntity<List<Action>> getAllActionsByProblem(@PathVariable(name = "prob_id") Long idProb) {
		return new ResponseEntity<List<Action>>(actionService.getAllActionsByProblem(problemService.getProblemById(idProb)),HttpStatus.OK);
	}
	
	@PostMapping("/actions/new")
	public ResponseEntity<Action> addNewAction(@RequestBody List<String> list) throws ParseException {
		return new ResponseEntity<Action>(actionService.addNewAction(list),HttpStatus.CREATED);
	}
	
	@PutMapping("/actions/update/{id}")
	public ResponseEntity<Action> updateAction(@RequestBody Action act,@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Action>(actionService.updateAction(act,id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/actions/delete/{id}")
	public ResponseEntity<String> deleteAction(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<String>(actionService.deleteActionById(id),HttpStatus.OK);
	}

}
