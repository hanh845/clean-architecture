package com.d4i.sample.student.ports;

import java.util.List;

import com.d4i.sample.student.Student;

public interface StudentRepository {

	public List<Student> getAllCategories();
	
	public void saveStudent(Student category) ;

	public Boolean doesStudentNameExists(String name);
}
