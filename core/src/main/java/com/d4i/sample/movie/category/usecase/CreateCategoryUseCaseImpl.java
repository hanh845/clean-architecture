package com.d4i.sample.movie.category.usecase;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public void execute(Category category) throws Exception   {

		if(categoryRepositoryService.doesCategoryNameExists(category.getName())) {
			throw new Exception();
		};

		categoryRepositoryService.saveCategory(category);
	}

}
