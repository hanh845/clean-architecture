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
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.FindStudentByIdUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;


@RestController
@ComponentScan("com.sample.student")
public class SpringStudentController {
	
	private final CreateStudentUseCase createStudentUseCase;
	private final GetAllStudentsUseCase getAllStudentsUseCase;
	private final FindStudentByIdUseCase findStudentByIdUseCase;

	@Autowired
	public SpringStudentController(CreateStudentUseCase createStudentUseCase
			, GetAllStudentsUseCase getAllStudentsUseCase 
			, FindStudentByIdUseCase findStudentByIdUseCase) {
		this.createStudentUseCase = createStudentUseCase;
		this.getAllStudentsUseCase = getAllStudentsUseCase;
		this.findStudentByIdUseCase = findStudentByIdUseCase;
	}

	@PostMapping("/students")
	public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception {
		int result = createStudentUseCase.execute(student);
		return new ResponseEntity<>(String.valueOf(result), HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> allUsers() {
		List<Student> lsStudents = getAllStudentsUseCase.execute();
		return new ResponseEntity<>(lsStudents, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") Long id) {
		Student student = findStudentByIdUseCase.execute(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
}
