package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.Category;

@Mapper
public interface CategoryMapper {
	List<Category> getAllGenres();
	
	String getGenreByCategoryId(int categoryId);
}
