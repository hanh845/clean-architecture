package configuration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.sample.student.Student;
import com.sample.student.StudentRepository;
import com.sample.student.spring.controller.SpringStudentController;
import com.sample.student.usecase.impl.CreateStudentUseCaseImpl;
import com.sample.student.usecase.impl.FindStudentByIdUseCaseImpl;
import com.sample.student.usecase.impl.GetAllStudentsUseCaseImpl;


public class StudentControllerTest {
	
	
//	@Test
//	public void testGetAllStudents() {
//		
//		List<Student> students = new ArrayList<Student>();
//		Student student_1 = new Student(50l, "hanh", "1");
//		Student student_2 = new Student(51l, "test", "0");
//		students.add(student_1);
//		students.add(student_2);
//		
//		StudentRepository studentRepository = mock(StudentRepository.class);
//		when(studentRepository.findAllStudents()).thenReturn(students);
//		
//		List<Student> lsStudentsTest = studentRepository.findAllStudents();
//		
//		SpringStudentController controller = new SpringStudentController(new CreateStudentUseCaseImpl()
//				, new GetAllStudentsUseCaseImpl(), new FindStudentByIdUseCaseImpl());
//		
//		ResponseEntity<List<Student>> lsStudents = controller.allUsers();
//		int result = lsStudents.getBody().size();
//		
//		assertEquals(20, result);
//	}

	
}
