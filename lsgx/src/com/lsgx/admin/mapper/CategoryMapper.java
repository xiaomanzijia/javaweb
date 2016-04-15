package com.lsgx.admin.mapper;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.Category;


@Repository
public interface CategoryMapper extends BaseMapper<Category>{
	
/**
 * 父接口中有方法申明，无需再写
 */
	
	public Category selectById(int id);

}
