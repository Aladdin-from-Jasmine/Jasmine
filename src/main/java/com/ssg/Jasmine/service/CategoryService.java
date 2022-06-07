package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Category;

public interface CategoryService {
	
	List<Category> getAllGenres();
	
	String getGenreByCategoryId(int categoryId);
}
