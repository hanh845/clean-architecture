package com.d4i.sample.movie.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.d4i.sample.movie.category.Book;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookController {
	
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1l, "Spring web sample", "Hanh"));
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		String result = String.format("Hello %s!", name);
		return result;
	}
	
}
