package com.ssg.Jasmine.dao;

import java.util.List;

import com.ssg.Jasmine.domain.Category;

public interface CategoryDao {

	List<Category> getAllGenres();
	
	String getGenreByCategoryId(int categoryId);
}
