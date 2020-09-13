package com.d4i.sample.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "available", nullable = false)
	private String available;

	public Student() {
		super();
	}

	public Student(Long id, String name, String available) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", available=" + available + "]";
	}

}
