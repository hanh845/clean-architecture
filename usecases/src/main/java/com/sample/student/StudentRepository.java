package com.sample.student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

	public List<Student> findAllStudents();

	public void saveStudent(Student student);

	Optional<Student> findById(Long id);

//	Optional<Student> findByName(String name);

}
