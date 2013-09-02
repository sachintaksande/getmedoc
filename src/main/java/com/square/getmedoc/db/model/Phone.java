package com.square.getmedoc.db.model;

// Generated Sep 2, 2013 7:42:39 PM by Hibernate Tools 4.0.0

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
 * Phone generated by hbm2java
 */
@Entity
@Table(name = "phone", catalog = "getmedoc")
public class Phone implements java.io.Serializable {

	private Long phoneid;
	private Appuser appuser;
	private int type;
	private String phonenum;
	private String ext;
	private Integer preferred;

	public Phone() {
	}

	public Phone(Appuser appuser, int type, String phonenum) {
		this.appuser = appuser;
		this.type = type;
		this.phonenum = phonenum;
	}

	public Phone(Appuser appuser, int type, String phonenum, String ext,
			Integer preferred) {
		this.appuser = appuser;
		this.type = type;
		this.phonenum = phonenum;
		this.ext = ext;
		this.preferred = preferred;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "phoneid", unique = true, nullable = false)
	public Long getPhoneid() {
		return this.phoneid;
	}

	public void setPhoneid(Long phoneid) {
		this.phoneid = phoneid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appuserid", nullable = false)
	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "phonenum", nullable = false, length = 45)
	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "ext", length = 45)
	public String getExt() {
		return this.ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Column(name = "preferred")
	public Integer getPreferred() {
		return this.preferred;
	}

	public void setPreferred(Integer preferred) {
		this.preferred = preferred;
	}

}
