package com.sample.student;

import java.util.List;

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
	public int saveStudent(Student student) {
		jdbcTemplate.update("insert into student (id, name, available, username, password, grantedAuthoritiesList) values (?, ?, ?, ?, ?, ?)"
				, new Object[] {student.getId(), student.getName(), student.getAvailable()
						, student.getUsername(), student.getPassword(), student.getGrantedAuthoritiesList()});
		return student.getId().intValue();
		
	}

	@Override
	public Student findById(Long id) {
		return jdbcTemplate.queryForObject("select * from student where id=?"
				, new Object[] {id}
				, new BeanPropertyRowMapper<Student>(Student.class));
	}

	
	

}
