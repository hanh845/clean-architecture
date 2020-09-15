package com.sample.student.controller;

import java.util.List;

import com.sample.student.Student;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;
//import org.apache.log4j.Logger;

public class StudentController {

	//Logger logger = Logger.getLogger(this.getClass());

	private final CreateStudentUseCase createStudentUseCase;
	private final GetAllStudentsUseCase getAllStudentsUseCase;


	public StudentController(CreateStudentUseCase createStudentUseCase, GetAllStudentsUseCase getAllStudentsUseCase) {
		super();
		this.createStudentUseCase = createStudentUseCase;
		this.getAllStudentsUseCase = getAllStudentsUseCase;
	}

	public void createStudent(Student student) throws Exception {
		createStudentUseCase.execute(student);
	}

	public List<Student> getAllStudent() {
		return getAllStudentsUseCase.execute();
	}

	public String test() {
		return "hello";
	}

}
