package com.sample.student.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sample.student.StudentRepository;
import com.sample.student.StudentRepositoryImpl;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;
import com.sample.student.usecase.impl.CreateStudentUseCaseImpl;
import com.sample.student.usecase.impl.GetAllStudentsUseCaseImpl;

@Configuration
@ComponentScan("com.sample.student")
public class Config {

	@Bean(name="CreateStudentUseCase")
	public CreateStudentUseCase CreateStudentUseCase(StudentRepository repository) {
		return new CreateStudentUseCaseImpl(repository);
	}

	@Bean(name="studentRepository")
	public StudentRepository studentRepository() {
		return new StudentRepositoryImpl();
	}
	
	@Bean(name="getAllStudentsUseCase")
	public GetAllStudentsUseCase getAllStudentsUseCase(StudentRepository repository) {
		return new GetAllStudentsUseCaseImpl(repository);
	}
}