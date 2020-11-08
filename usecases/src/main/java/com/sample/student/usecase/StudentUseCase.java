package com.sample.student.usecase;

import java.util.List;

import com.sample.student.Student;

public interface StudentUseCase {

	public int createStudentUseCase(Student category) throws Exception;

	public Student findStudentByIdUseCase(Long id);

	public List<Student> getAllStudentsUseCase();

}
