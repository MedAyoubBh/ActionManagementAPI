package com.projects.actionManagement.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String cause;
	
	@Column(nullable = false)
	private String action;
	
	@Column(nullable = false)
	private Long responsable;
	
	@Column(nullable = false)
	private LocalDate expectatedDate;
	
	@Column(nullable = false)
	private Boolean p;
	
	@Column(nullable = false)
	private Boolean d;
	
	@Column(nullable = false)
	private Boolean c;
	
	@Column(nullable = false)
	private Boolean a;
	
	@Column(nullable = false)
	private Long numberByProblem;
	
	@Column(nullable = true)
	private Date doneDate;
	
	@Column(nullable = true)
	private Date checkedDate;
	
	@JoinColumn(nullable = false)
	@OneToOne(cascade = CascadeType.DETACH)
	private Problem problem;
	
	
	
	public Action() {}

	public Action(Long id, String cause, String action, Long responsable, LocalDate expectatedDate, Boolean p, Boolean d,
			Boolean c, Boolean a, Long numberByProblem, Date doneDate, Date checkedDate, Problem problem) {
		super();
		this.id = id;
		this.cause = cause;
		this.action = action;
		this.responsable = responsable;
		this.expectatedDate = expectatedDate;
		this.p = p;
		this.d = d;
		this.c = c;
		this.a = a;
		this.numberByProblem = numberByProblem;
		this.doneDate = doneDate;
		this.checkedDate = checkedDate;
		this.problem = problem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getResponsable() {
		return responsable;
	}

	public void setResponsable(Long responsable) {
		this.responsable = responsable;
	}

	public LocalDate getExpectatedDate() {
		return expectatedDate;
	}

	public void setExpectatedDate(LocalDate expectatedDate) {
		this.expectatedDate = expectatedDate;
	}

	public Boolean getP() {
		return p;
	}

	public void setP(Boolean p) {
		this.p = p;
	}

	public Boolean getD() {
		return d;
	}

	public void setD(Boolean d) {
		this.d = d;
	}

	public Boolean getC() {
		return c;
	}

	public void setC(Boolean c) {
		this.c = c;
	}

	public Boolean getA() {
		return a;
	}

	public void setA(Boolean a) {
		this.a = a;
	}

	public Long getNumberByProblem() {
		return numberByProblem;
	}

	public void setNumberByProblem(Long numberByProblem) {
		this.numberByProblem = numberByProblem;
	}

	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	public Date getCheckedDate() {
		return checkedDate;
	}

	public void setCheckedDate(Date checkedDate) {
		this.checkedDate = checkedDate;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
}
