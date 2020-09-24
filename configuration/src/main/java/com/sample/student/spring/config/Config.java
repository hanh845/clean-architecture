package com.sample.student.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.sample.student.InMemoryRepositoryImpl;
import com.sample.student.JdbcStudentRepositoryImpl;
import com.sample.student.JpaStudentRepositoryImpl;
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
	public FindStudentByIdUseCaseImpl findStudentByIdUseCase(
			@Qualifier("studentRepository") StudentRepository repository) {
		return new FindStudentByIdUseCaseImpl(repository);
	}

//	@Bean(name = "studentRepository")
//	public StudentRepository studentRepository(@Qualifier("jdbcService") JdbcTemplate jdbcTemplate) {
//		return new JdbcStudentRepositoryImpl(jdbcTemplate);
//	}

//	@Bean(name = "studentRepository")
//	public StudentRepository studentRepository() {
//		return new InMemoryRepositoryImpl();
//	}
	
	@Bean(name = "studentRepository")
	public StudentRepository studentRepository(@Qualifier("entityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaStudentRepositoryImpl(entityManagerFactory);
	}


	@Bean(name = "entityManager")
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.sample.student");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean(name = "jdbcService")
	public JdbcTemplate createJdbcTemplate(@Qualifier("dbService") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "dbService")
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}