package com.sample.student.usecase.impl;

import java.util.List;

import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.StudentUseCase;

public class StudentUseCaseImpl implements StudentUseCase {
	
	private StudentRepository studentRepository;

	public StudentUseCaseImpl() {
	}
	
	public StudentUseCaseImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public int createStudentUseCase(Student student) throws Exception {
		return studentRepository.saveStudent(student);
	}

	@Override
	public Student findStudentByIdUseCase(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> getAllStudentsUseCase() {
		return studentRepository.findAllStudents();
	}

}
