package com.sample.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepositoryImpl implements StudentRepository {

	private final Map<Long, Student> inMemoryDb = new HashMap<>();

	@Override
	public List<Student> findAllStudents() {
		return new ArrayList<>(inMemoryDb.values());
	}

	@Override
	public int saveStudent(Student student) {
		inMemoryDb.put(student.getId(), student);
		return 1;
	}

	@Override
	public Student findById(Long id) {
		return inMemoryDb.get(id);
	}
}
