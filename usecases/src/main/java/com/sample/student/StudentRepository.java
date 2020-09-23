package com.sample.student;

import java.util.List;

public interface StudentRepository {

	public List<Student> findAllStudents();
	public int saveStudent(Student student);
	Student findById(Long id);
}
