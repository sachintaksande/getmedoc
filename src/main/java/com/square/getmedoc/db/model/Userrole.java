package com.square.getmedoc.db.model;

// Generated Aug 20, 2013 3:02:41 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Userrole generated by hbm2java
 */
@Entity
@Table(name = "userrole", catalog = "getmedoc", uniqueConstraints = @UniqueConstraint(columnNames = "rolename"))
public class Userrole implements java.io.Serializable {

	private Integer roleid;
	private String rolename;
	private String description;
	private Set<Appuser> appusers = new HashSet<Appuser>(0);

	public Userrole() {
	}

	public Userrole(String rolename) {
		this.rolename = rolename;
	}

	public Userrole(String rolename, String description, Set<Appuser> appusers) {
		this.rolename = rolename;
		this.description = description;
		this.appusers = appusers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleid", unique = true, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "rolename", unique = true, nullable = false, length = 128)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userroles")
	public Set<Appuser> getAppusers() {
		return this.appusers;
	}

	public void setAppusers(Set<Appuser> appusers) {
		this.appusers = appusers;
	}

}
