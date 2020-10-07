package configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.sample.student.Student;
import com.sample.student.spring.config.Config;
import com.sample.student.usecase.CreateStudentUseCase;
import com.sample.student.usecase.impl.CreateStudentUseCaseImpl;


@SpringBootTest
@ContextConfiguration(classes = Config.class)
public class StudentConfigurationTest {
	
	@Autowired
	private ApplicationContext context;

	@Test
	public void testBeanConfiguration() throws Exception {
		
		assertThat(context.getBean("createStudentUseCase")).isNotNull();
		
		Assertions.assertTrue(context.getBean(CreateStudentUseCase.class) != null);
		
		assertThat(context.getBean("studentRepository")).isNotNull();
		
		assertThat(context.getBean("entityManager")).isNotNull();
		
	}
	
	@Test
	public void testGreeting() {
		
		CreateStudentUseCaseImpl createStudentUseCase = (CreateStudentUseCaseImpl) context.getBean("createStudentUseCase");
		
		Assertions.assertEquals("Hello, World", createStudentUseCase.greeting());
	}
	
	@Test
	public void testCreateStudentUseCase() throws Exception {
		
		CreateStudentUseCaseImpl createStudentUseCase = (CreateStudentUseCaseImpl) context.getBean("createStudentUseCase");
		
		Student student = new Student("hanh", "1");
		
		assertEquals(22, createStudentUseCase.execute(student));
		
	}
	
}
