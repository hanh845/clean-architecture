package com.d4i.sample.student;

import lombok.Data;

@Data
public class Student {

	private Long id;

	private String name;

	private Boolean available;

	public Student() {
		super();
	}

	public Student(Long id, String name, Boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
	}
}
