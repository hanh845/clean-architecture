package com.d4i.sample.student.usecase;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d4i.sample.student.Student;
import com.d4i.sample.student.ports.StudentRepository;

@Service
public class GetAllStudentsUseCaseImpl implements GetAllStudentsUseCase {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> execute() {

		return studentRepository.findAll();
	}

}
