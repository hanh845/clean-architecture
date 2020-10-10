package database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.student.Student;
import com.sample.student.StudentRepository;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
//@SpringBootTest(classes = DemoApplication.class)
@SpringBootTest
public class JpaStudentRepositoryTest {
	
	@Autowired
	@Qualifier("jpaStudentRepositoryImpl")
	StudentRepository studentRepository;

	@Test
	void testSaveStudent() {
		
		Student student = new Student(6l, "marry", "1");
		
		int id = studentRepository.saveStudent(student);
		
		Student expected = studentRepository.findById(6l);
		
		assertEquals(id, expected.getId());
	}

}
