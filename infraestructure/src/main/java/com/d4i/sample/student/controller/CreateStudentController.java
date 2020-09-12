package com.d4i.sample.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4i.sample.student.Student;
import com.d4i.sample.student.usecase.CreateStudentUseCase;

@RestController
public class CreateStudentController {
	
	@Autowired
	CreateStudentUseCase createStudentUseCase;

	@GetMapping("/create-student")
	public void createStudent( ) {
		Student student = new Student(2l, "sample", false);
		try {
			createStudentUseCase.execute(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
