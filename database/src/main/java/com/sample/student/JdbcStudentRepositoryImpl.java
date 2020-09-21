package com.sample.student;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcStudentRepositoryImpl implements StudentRepository {
	
	JdbcTemplate jdbcTemplate;
	
	public JdbcStudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> findAllStudents() {
		return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper(Student.class));
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Student> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
