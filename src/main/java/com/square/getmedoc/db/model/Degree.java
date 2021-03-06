package com.square.getmedoc.db.model;

// Generated Oct 22, 2013 11:20:48 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Degree generated by hbm2java
 */
@Entity
@Table(name = "degree", catalog = "getmedoc")
public class Degree implements java.io.Serializable {

	private Long id;
	private Appuser appuser;
	private Choice choice;

	public Degree() {
	}

	public Degree(Appuser appuser, Choice choice) {
		this.appuser = appuser;
		this.choice = choice;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorid", nullable = false)
	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "choiceid", nullable = false)
	public Choice getChoice() {
		return this.choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

}
