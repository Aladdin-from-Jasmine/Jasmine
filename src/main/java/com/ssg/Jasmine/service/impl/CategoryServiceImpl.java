package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.CategoryDao;
import com.ssg.Jasmine.domain.Category;
import com.ssg.Jasmine.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllGenres() {
		return categoryDao.getAllGenres();
	}

	@Override
	public String getGenreByCategoryId(int categoryId) {
		return categoryDao.getGenreByCategoryId(categoryId);
	}


}
