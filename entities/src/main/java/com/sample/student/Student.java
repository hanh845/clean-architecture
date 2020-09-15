package com.sample.student;

import lombok.Data;

@Data
public class Student {

	private Long id;

	private String name;

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
