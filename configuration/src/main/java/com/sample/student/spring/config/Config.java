package com.sample.student.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.GetAllStudentsUseCase;

@Configuration
public class Config {

	private final SpringConfig config = new SpringConfig();

//	@Bean
//	public ObjectMapper objectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		return objectMapper;
//	}

	@Bean
	public CreateStudentUseCase CreateStudentUseCase() {
		return config.CreateStudentUseCase();
	}

	@Bean
	public GetAllStudentsUseCase getAllStudentsUseCase() {
		return config.getAllStudentsUseCase();
	}
}
