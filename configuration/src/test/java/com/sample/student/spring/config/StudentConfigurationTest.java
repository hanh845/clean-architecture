package com.sample.student.spring.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.sample.student.usecase.StudentUseCase;


@SpringBootTest
@ContextConfiguration(classes = Config.class)
public class StudentConfigurationTest {
	
	@Autowired
	private ApplicationContext context;

	@Test
	public void testBeanConfiguration() throws Exception {
		
		assertThat(context.getBean("studentUseCase")).isNotNull();
		
		Assertions.assertTrue(context.getBean(StudentUseCase.class) != null);
		
		assertThat(context.getBean("studentRepository")).isNotNull();
		
		assertThat(context.getBean("entityManager")).isNotNull();
	}
	
}
