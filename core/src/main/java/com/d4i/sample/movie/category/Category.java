package com.d4i.sample.movie.category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

	@Min(0)
	private Long id;

	@NotEmpty
	private String name;

	private Boolean available;

	
}
