package com.sample.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sample.student.entity.StudentEntity;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findById(Long id) {
		StudentEntity student = entityManager.find(StudentEntity.class, id);
		return convertEntity(student);
	}

	private Student convertEntity(StudentEntity studentEntity) {
		Student student = new Student();
		student.setId(studentEntity.getId());
		student.setName(studentEntity.getName());
		student.setAvailable(studentEntity.getAvailable());
		return student;
	}

}
