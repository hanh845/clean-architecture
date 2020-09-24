package com.sample.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sample.student.entity.DBStudent;

@Repository
@Transactional
public class JpaStudentRepositoryImpl implements StudentRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public JpaStudentRepositoryImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO
		return null;
	}

	@Override
	public int saveStudent(Student student) {
		DBStudent dbStudent = convertStudentToDBStudent(student);
		int result = entityManager.merge(dbStudent).getId().intValue();
		System.out.println("result: " + result);
		return result;
	}

	@Override
	public Student findById(Long id) {
		DBStudent dbStudent = entityManager.find(DBStudent.class, id);
		return convertDBStudentToStudent(dbStudent);
	}

	private DBStudent convertStudentToDBStudent(Student student) {
		DBStudent dbStudent = new DBStudent();
		dbStudent.setId(student.getId());
		dbStudent.setName(student.getName());
		dbStudent.setAvailable(student.getAvailable());
		return dbStudent;
	}
	
	private Student convertDBStudentToStudent(DBStudent dbStudent) {
		Student student = new Student();
		student.setId(dbStudent.getId());
		student.setName(dbStudent.getName());
		student.setAvailable(dbStudent.getAvailable());
		return student;
	}

}
