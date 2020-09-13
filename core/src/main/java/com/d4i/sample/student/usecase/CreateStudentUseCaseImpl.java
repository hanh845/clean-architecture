package com.d4i.sample.student.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d4i.sample.student.Student;
import com.d4i.sample.student.ports.StudentRepository;

@Service
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void execute(Student student) throws Exception   {

//		if(studentRepository.doesStudentNameExists(student.getName())) {
//			throw new Exception();
//		}
		studentRepository.save(student);
	}

}
