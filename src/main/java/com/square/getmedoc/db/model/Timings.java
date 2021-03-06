package com.square.getmedoc.db.model;

// Generated Oct 22, 2013 11:20:48 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Timings generated by hbm2java
 */
@Entity
@Table(name = "timings", catalog = "getmedoc")
public class Timings implements java.io.Serializable {

	private Integer id;
	private Appuser appuser;
	private Address address;
	private Date from;
	private Date to;

	public Timings() {
	}

	public Timings(Appuser appuser, Date from, Date to) {
		this.appuser = appuser;
		this.from = from;
		this.to = to;
	}

	public Timings(Appuser appuser, Address address, Date from, Date to) {
		this.appuser = appuser;
		this.address = address;
		this.from = from;
		this.to = to;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
	@JoinColumn(name = "addressid")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "from", nullable = false, length = 8)
	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "to", nullable = false, length = 8)
	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}
