package com.d4i.sample.student.ports;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d4i.sample.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

//	public List<Student> getAllCategories();
//
//	public void saveStudent(Student category);

//	public Boolean doesStudentNameExists(String name);
}
