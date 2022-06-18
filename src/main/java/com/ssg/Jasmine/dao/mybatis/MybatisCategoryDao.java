package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.CategoryDao;
import com.ssg.Jasmine.dao.mybatis.mapper.CategoryMapper;
import com.ssg.Jasmine.domain.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao{

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getAllGenres() {
		return categoryMapper.getAllGenres();
	}

	@Override
	public String getGenreByCategoryId(int categoryId) {
		return categoryMapper.getGenreByCategoryId(categoryId);
	}
	
}
