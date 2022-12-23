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
public class Problem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private int criticity;
	
	@Column(nullable = false)
	private Long numberByAxe;
	
	@JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.DETACH)
	private Axe axe;
	
	

	public Problem() {}

	public Problem(Long id, String description, int criticity, Long numberByAxe, Axe axe) {
		super();
		this.id = id;
		this.description = description;
		this.criticity = criticity;
		this.numberByAxe = numberByAxe;
		this.axe = axe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCriticity() {
		return criticity;
	}

	public void setCriticity(int criticity) {
		this.criticity = criticity;
	}

	public Long getNumberByAxe() {
		return numberByAxe;
	}


	public void setNumberByAxe(Long numberByAxe) {
		this.numberByAxe = numberByAxe;
	}

	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
}
