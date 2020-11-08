package com.sample.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class DBStudent {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String available;
	private String username;
	private String password;
	private String grantedAuthoritiesList;

	public DBStudent() {
		super();
	}

	public DBStudent(Long id, String name, String available, String username, String password, String grantedAuthoritiesList) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
		this.username = username;
		this.password = password;
		this.grantedAuthoritiesList = grantedAuthoritiesList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGrantedAuthoritiesList() {
		return grantedAuthoritiesList;
	}

	public void setGrantedAuthoritiesList(String grantedAuthoritiesList) {
		this.grantedAuthoritiesList = grantedAuthoritiesList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
