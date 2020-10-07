package com.sample.student.usecase.impl;


import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.CreateStudentUseCase;

public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

	private StudentRepository studentRepository;

	public CreateStudentUseCaseImpl() {
	}

	public CreateStudentUseCaseImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public int execute(Student student) throws Exception {
		return studentRepository.saveStudent(student);
	}
	
	public String greeting() {
		return "Hello, World";
	}
}
