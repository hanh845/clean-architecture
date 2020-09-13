package com.d4i.sample.student.usecase;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d4i.sample.student.Student;
import com.d4i.sample.student.ports.StudentRepository;

@Service
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void execute(Student student) throws Exception {

		logger.debug("student: " + student.toString());

		// if(studentRepository.doesStudentNameExists(student.getName())) {
		// throw new Exception();
		// }
		studentRepository.save(student);
	}

}
