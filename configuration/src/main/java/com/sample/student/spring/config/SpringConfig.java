package com.sample.student.spring.config;

import com.sample.student.StudentRepository;
import com.sample.student.StudentRepositoryImpl;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;
import com.sample.student.usecase.impl.CreateStudentUseCaseImpl;
import com.sample.student.usecase.impl.GetAllStudentsUseCaseImpl;

public class SpringConfig {

	private final StudentRepository studentRepository = new StudentRepositoryImpl();

	public CreateStudentUseCase CreateStudentUseCase() {
		return new CreateStudentUseCaseImpl(studentRepository);
	}

	public GetAllStudentsUseCase getAllStudentsUseCase() {
		return new GetAllStudentsUseCaseImpl(studentRepository);
	}
}
