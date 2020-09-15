package com.sample.student.usecase.impl;

//import org.apache.log4j.Logger;

import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.CreateStudentUseCase;

public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

	//Logger logger = Logger.getLogger(this.getClass());

	private final StudentRepository studentRepository;


	public CreateStudentUseCaseImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public void execute(Student student) throws Exception {

		//logger.debug("student: " + student.toString());

		// if(studentRepository.doesStudentNameExists(student.getName())) {
		// throw new Exception();
		// }
		studentRepository.saveStudent(student);
	}

}
