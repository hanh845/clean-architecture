package com.sample.student.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.student.Student;
import com.sample.student.controller.StudentController;


@RestController
public class SpringStudentController {

	Logger logger = Logger.getLogger(this.getClass());

	private final StudentController controller;

	@Autowired
	public SpringStudentController(StudentController controller) {
		super();
		this.controller = controller;
	}

	@GetMapping("/test")
	public void test( ) {
		Student student = new Student(2l, "sample", "1");
		try {
			controller.createStudent(student);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@PostMapping("/students")
	public String createStudent(@RequestBody Student student) {
		try {
			controller.createStudent(student);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "done";
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> allUsers() {
		return controller.getAllStudent();
	}

}
