package com.ssg.Jasmine.service;

import java.util.List;

public interface CategoryService {
	
	List<String> getAllGenres();
	
	String getGenreByCategoryId(int categoryId);
}
