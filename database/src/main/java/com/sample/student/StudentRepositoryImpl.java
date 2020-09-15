package com.sample.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {

	private final Map<Long, Student> inMemoryDb = new HashMap<>();

	@Override
	public List<Student> findAllStudents() {
		return new ArrayList<>(inMemoryDb.values());
	}

	@Override
	public void saveStudent(Student student) {
		inMemoryDb.put(student.getId(), student);
	}

	@Override
	public Optional<Student> findById(Long id) {
		return Optional.ofNullable(inMemoryDb.get(id));
	}

//	@Override
//	public Optional<Student> findByName(String name) {
//		return inMemoryDb.values().stream()
//				.filter(student -> student.getName().equals(name))
//				.findAny();
//	}

}
