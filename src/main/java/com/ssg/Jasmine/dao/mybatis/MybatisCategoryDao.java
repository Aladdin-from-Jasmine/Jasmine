package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.CategoryDao;
import com.ssg.Jasmine.dao.mybatis.mapper.CategoryMapper;

@Repository
public class MybatisCategoryDao implements CategoryDao{

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<String> getAllGenres() {
		// TODO Auto-generated method stub
		return categoryMapper.getAllGenres();
	}

	@Override
	public String getGenreByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return categoryMapper.getGenreByCategoryId(categoryId);
	}
	
}
