package com.sample.student.spring.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sample.student.JpaStudentRepositoryImpl;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.StudentUseCase;
import com.sample.student.usecase.impl.StudentUseCaseImpl;

@Configuration
@ComponentScan("com.sample.student")
public class Config {

	@Bean(name = "studentUseCase")
	public StudentUseCase studentUseCase(@Qualifier("studentRepository") StudentRepository repository) {
		return new StudentUseCaseImpl(repository);
	}

//	@Bean(name = "studentRepository")
//	public StudentRepository studentRepository(JdbcTemplate jdbcTemplate) {
//		return new JdbcStudentRepositoryImpl(jdbcTemplate);
//	}

//	@Bean(name = "studentRepository")
//	public StudentRepository studentRepository() {
//		return new InMemoryRepositoryImpl();
//	}
	
	@Bean(name = "studentRepository")
	public StudentRepository studentRepository(EntityManagerFactory entityManagerFactory) {
		return new JpaStudentRepositoryImpl(entityManagerFactory);
	}
	
}