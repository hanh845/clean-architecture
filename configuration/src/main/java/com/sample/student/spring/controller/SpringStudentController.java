package com.sample.student.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.student.Student;
import com.sample.student.controller.StudentController;


@RestController
public class SpringStudentController {


//	@Autowired
//	StudentController controller;

	@PostMapping("/students")
	public String createStudent(@RequestBody Student student) throws Exception {
		StudentController.getInstance().createStudent(student);
		return "done";
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> allUsers() {
		return StudentController.getInstance().getAllStudent();
	}
}
