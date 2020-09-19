package com.sample.student.usecase.impl;

import java.util.List;


import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.GetAllStudentsUseCase;

public class GetAllStudentsUseCaseImpl implements GetAllStudentsUseCase {

	private StudentRepository studentRepository;

	public GetAllStudentsUseCaseImpl() {
	}

	public GetAllStudentsUseCaseImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> execute() {
		return studentRepository.findAllStudents();
	}

}
