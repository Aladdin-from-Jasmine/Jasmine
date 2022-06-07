package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
	List<String> getAllGenres();
	
	String getGenreByCategoryId(int categoryId);
}
