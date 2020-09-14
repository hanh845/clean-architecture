package com.d4i.sample.student.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4i.sample.student.Student;
import com.d4i.sample.student.usecase.GetAllStudentsUseCase;

@RestController
public class GetAllStudentsController {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	GetAllStudentsUseCase getAllStudentsUseCase;

	@GetMapping("/get-all-students")
	public List<Student> getAllStudent( ) {
		return getAllStudentsUseCase.execute();
	}

	@GetMapping("/test")
	public String test( ) {
		return "hello";
	}

}
