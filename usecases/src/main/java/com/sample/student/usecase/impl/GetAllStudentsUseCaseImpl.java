package com.sample.student.usecase.impl;

import java.util.List;

//import org.apache.log4j.Logger;

import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.GetAllStudentsUseCase;

public class GetAllStudentsUseCaseImpl implements GetAllStudentsUseCase {

	//Logger logger = Logger.getLogger(this.getClass());

	private final StudentRepository studentRepository;

	public GetAllStudentsUseCaseImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> execute() {

		return studentRepository.findAllStudents();
	}

}
