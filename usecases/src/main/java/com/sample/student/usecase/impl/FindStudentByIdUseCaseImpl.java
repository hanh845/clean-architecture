package com.sample.student.usecase.impl;

import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.FindStudentByIdUseCase;

public class FindStudentByIdUseCaseImpl implements FindStudentByIdUseCase {

	private StudentRepository studentRepository;
	
	public FindStudentByIdUseCaseImpl() {
	}

	public FindStudentByIdUseCaseImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student execute(Long id) {
		return studentRepository.findById(id);
	}

}
