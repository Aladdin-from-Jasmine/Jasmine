package com.ssg.Jasmine.dao;

import java.util.List;

public interface CategoryDao {

	List<String> getAllGenres();
	
	String getGenreByCategoryId(int categoryId);
}
