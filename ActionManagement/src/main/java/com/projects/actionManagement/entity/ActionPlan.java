package com.projects.actionManagement.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ActionPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
	private Long numberBySecter;

	@Column(nullable = false)
	private Long plannerId;

	@Column(nullable = false)
	private Date creationDate;

	@Column(nullable = true)
	private Long[] participants;

	@Column(nullable = true)
	private Long[] checkers;

	@Column(nullable = true)
	private Long[] actors;
	
	
	
	public ActionPlan() {}
	
	public ActionPlan(Long id, String nom, Long numberBySecter, Long plannerId, Date creationDate, Long[] participants,
			Long[] checkers, Long[] actors) {
		super();
		this.id = id;
		this.nom = nom;
		this.numberBySecter = numberBySecter;
		this.plannerId = plannerId;
		this.creationDate = creationDate;
		this.participants = participants;
		this.checkers = checkers;
		this.actors = actors;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getNumberBySecter() {
		return numberBySecter;
	}
	public void setNumberBySecter(Long numberBySecter) {
		this.numberBySecter = numberBySecter;
	}
	public Long getPlannerId() {
		return plannerId;
	}
	public void setPlannerId(Long plannerId) {
		this.plannerId = plannerId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Long[] getParticipants() {
		return participants;
	}
	public void setParticipants(Long[] participants) {
		this.participants = participants;
	}
	public Long[] getCheckers() {
		return checkers;
	}
	public void setCheckers(Long[] checkers) {
		this.checkers = checkers;
	}
	public Long[] getActors() {
		return actors;
	}
	public void setActors(Long[] actors) {
		this.actors = actors;
	}

}
