package com.sample.student.controller;

import java.util.List;

import com.sample.student.Student;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;
import com.sample.student.usecase.impl.CreateStudentUseCaseImpl;
import com.sample.student.usecase.impl.GetAllStudentsUseCaseImpl;

public class StudentController {

	private static CreateStudentUseCase createStudentUseCase;
	private static GetAllStudentsUseCase getAllStudentsUseCase;

	private static StudentController studentController;

	public static StudentController getInstance() {
		if (studentController == null) {
			studentController = new StudentController(createStudentUseCase, getAllStudentsUseCase);
		} else {
			return studentController;
		}
		return studentController;
	}

	public StudentController() {
	}

	public StudentController(CreateStudentUseCase createStudentUseCase, GetAllStudentsUseCase getAllStudentsUseCase) {
		if (createStudentUseCase == null) {
			this.createStudentUseCase = new CreateStudentUseCaseImpl();
		} else {
			this.createStudentUseCase = createStudentUseCase;
		}
		if (getAllStudentsUseCase == null) {
			this.getAllStudentsUseCase = new GetAllStudentsUseCaseImpl();
		} else {
			this.getAllStudentsUseCase = getAllStudentsUseCase;
		}
	}

	public void createStudent(Student student) throws Exception {
		createStudentUseCase.execute(student);
	}

	public List<Student> getAllStudent() {
		return getAllStudentsUseCase.execute();
	}

}
