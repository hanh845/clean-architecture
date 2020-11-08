package com.sample.student.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.student.Student;
import com.sample.student.usecase.StudentUseCase;


@RestController
@ComponentScan("com.sample.student")
public class StudentController {
	
	private final StudentUseCase studentUseCase;

	@Autowired
	public StudentController(StudentUseCase studentUseCase) {
		this.studentUseCase = studentUseCase;
	}

	@PostMapping("/students")
	public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception {
		int result = studentUseCase.createStudentUseCase(student);
		return new ResponseEntity<>(String.valueOf(result), HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> GetAllStudents() {
		List<Student> lsStudents = studentUseCase.getAllStudentsUseCase();
		return new ResponseEntity<>(lsStudents, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") Long id) {
		Student student = studentUseCase.findStudentByIdUseCase(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String test() {
		return "Hello, World";
	}
}
