package com.sample.student;

public class Student {

	private Long id;

	private String name;

	private String available;

	public Student() {
		super();
	}
	
	public Student(String name, String available) {
		super();
		this.name = name;
		this.available = available;
	}

	public Student(Long id, String name, String available) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", available=" + available + "]";
	}
}
