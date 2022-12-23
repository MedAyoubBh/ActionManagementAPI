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

import com.projects.actionManagement.entity.Problem;
import com.projects.actionManagement.service.AxeService;
import com.projects.actionManagement.service.ProblemService;

@RestController
public class ProblemController {
	
	private ProblemService problemService;
	private AxeService axeService;

	public ProblemController(ProblemService problemService,AxeService axeService) {
		super();
		this.axeService = axeService;
		this.problemService = problemService;
	}
	
	@GetMapping("/problems")
	public ResponseEntity<List<Problem>> getAllProblems(){
		return new ResponseEntity<List<Problem>>(problemService.getAllProblems(), HttpStatus.OK);
	}
	
	@GetMapping("/problems/{id}")
	public ResponseEntity<Problem> getProblemById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Problem>(problemService.getProblemById(id),HttpStatus.OK);
	}
	
	@GetMapping("actionplans/{pa_id}/axes/{axe_id}/problems")
	public ResponseEntity<List<Problem>> getAllAxesByActionPlan(@PathVariable(name = "axe_id") Long idPA) {
		return new ResponseEntity<List<Problem>>(problemService.getAllProblemsByAxe(axeService.getAxeById(idPA)),HttpStatus.OK);
	}
	
	@PostMapping("/problems/new")
	public ResponseEntity<Problem> addNewProblem(@RequestBody List<String> list) {
		return new ResponseEntity<Problem>(problemService.addNewProblem(list),HttpStatus.CREATED);
	}
	
	@PutMapping("/problems/update/{id}")
	public ResponseEntity<Problem> updateProblem(@RequestBody Problem prob,@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Problem>(problemService.updateProblem(prob,id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/problems/delete/{id}")
	public ResponseEntity<String> deleteProblem(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<String>(problemService.deleteProblemById(id),HttpStatus.OK);
	}
}
