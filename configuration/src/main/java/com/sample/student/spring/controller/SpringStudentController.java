package com.sample.student.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.student.Student;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;


@RestController
@ComponentScan("com.sample.student")
public class SpringStudentController {
	
	private final CreateStudentUseCase createStudentUseCase;
	private final GetAllStudentsUseCase getAllStudentsUseCase;

	@Autowired
	public SpringStudentController(CreateStudentUseCase createStudentUseCase
			, GetAllStudentsUseCase getAllStudentsUseCase ) {
		this.createStudentUseCase = createStudentUseCase;
		this.getAllStudentsUseCase = getAllStudentsUseCase;
	}

	@PostMapping("/students")
	public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception {
		createStudentUseCase.execute(student);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> allUsers() {
		List<Student> lsStudents = getAllStudentsUseCase.execute();
		return new ResponseEntity<>(lsStudents, HttpStatus.OK);
	}
	
}
