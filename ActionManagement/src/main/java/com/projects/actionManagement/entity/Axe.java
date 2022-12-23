package com.projects.actionManagement.entity;


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
public class Axe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String indicator;
	
	@Column(nullable = false)
	private Long numberByPa;
	
	@JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.DETACH)
	private ActionPlan pa;
	

	public Axe() {}

	public Axe(Long id, String indicator, Long numberByPa, ActionPlan pa) {
		super();
		this.id = id;
		this.indicator = indicator;
		this.numberByPa = numberByPa;
		this.pa = pa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public Long getNumberByPa() {
		return numberByPa;
	}

	public void setNumberByPa(Long numberByPa) {
		this.numberByPa = numberByPa;
	}

	public ActionPlan getPa() {
		return pa;
	}

	public void setPa(ActionPlan pa) {
		this.pa = pa;
	}

	
	
	
}
