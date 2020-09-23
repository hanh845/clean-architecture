package com.sample.student.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sample.student.InMemoryRepositoryImpl;
import com.sample.student.JdbcStudentRepositoryImpl;
import com.sample.student.StudentRepository;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;
import com.sample.student.usecase.impl.CreateStudentUseCaseImpl;
import com.sample.student.usecase.impl.FindStudentByIdUseCaseImpl;
import com.sample.student.usecase.impl.GetAllStudentsUseCaseImpl;

@Configuration
@ComponentScan("com.sample.student")
public class Config {

	@Bean(name = "CreateStudentUseCase")
	public CreateStudentUseCase CreateStudentUseCase(@Qualifier("studentRepository") StudentRepository repository) {
		return new CreateStudentUseCaseImpl(repository);
	}
	
	@Bean(name = "getAllStudentsUseCase")
	public GetAllStudentsUseCase getAllStudentsUseCase(@Qualifier("studentRepository") StudentRepository repository) {
		return new GetAllStudentsUseCaseImpl(repository);
	}
	
	@Bean(name = "findStudentByIdUseCase")
	public FindStudentByIdUseCaseImpl findStudentByIdUseCase(@Qualifier("studentRepository") StudentRepository repository) {
		return new FindStudentByIdUseCaseImpl(repository);
	}

	@Bean(name = "studentRepository")
	public StudentRepository studentRepository(@Qualifier("jdbcService") JdbcTemplate jdbcTemplate) {
		return new JdbcStudentRepositoryImpl(jdbcTemplate);
	}

//	@Bean(name = "studentRepository")
//	public StudentRepository studentRepository() {
//		return new InMemoryRepositoryImpl();
//	}

	@Bean(name = "jdbcService")
	public JdbcTemplate createJdbcTemplate(@Qualifier("dbService") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "dbService")
	@ConfigurationProperties("spring.datasource")
	public DataSource createDBServiceDataSource() {
		return DataSourceBuilder.create().build();
	}
}