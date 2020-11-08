//package usecases;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.sample.student.Student;
//import com.sample.student.StudentRepository;
//import com.sample.student.usecase.StudentUseCase;
//
//@ExtendWith(MockitoExtension.class)
//class StudentUseCaseTest {
//	
//	@Mock
//	StudentRepository studentRepository;
//	
//	@InjectMocks
//	StudentUseCase studentUseCase;
//
//	@Test
//	public void testCreateStudentUseCase() throws Exception {
//		
//		Student student = new Student(50l, "hanh", "1");
//		
//		when(studentRepository.saveStudent(student)).thenReturn(2);
//		
//		assertEquals(2, studentUseCase.createStudentUseCase(student));
//	}
//	
//	@Test
//	void testFindStudentByIdUseCase() {
//		
//		Student student = new Student(50l, "hanh", "1");
//		
//		when(studentRepository.findById(50l)).thenReturn(student);
//		
//		assertEquals("hanh", studentUseCase.findStudentByIdUseCase(50l).getName());
//	}
//
//	@Test
//	void testGetAllStudentsUseCase() {
//		
//		List<Student> students = new ArrayList<Student>();
//		Student student_1 = new Student(50l, "hanh", "1");
//		Student student_2 = new Student(51l, "test", "0");
//		students.add(student_1);
//		students.add(student_2);
//		
//		when(studentRepository.findAllStudents()).thenReturn(students);
//		
//		List<Student> lsStudents = studentUseCase.getAllStudentsUseCase();
//		
//		assertEquals(2, lsStudents.size());
//	}
//
//}
