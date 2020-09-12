package com.d4i.sample.student.repository;

import java.util.List;

import com.d4i.sample.student.Student;

public class StudentRepositoryImpl implements com.d4i.sample.student.ports.StudentRepository {

	@Override
	public List<Student> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveStudent(Student category) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean doesStudentNameExists(String name) {
		// TODO Auto-generated method stub
		Boolean result = false;
		return result;
	}

}
