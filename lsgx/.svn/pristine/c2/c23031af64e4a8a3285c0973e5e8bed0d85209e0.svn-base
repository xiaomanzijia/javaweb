package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.CategoryMapper;
import com.lsgx.admin.model.Category;
import com.lsgx.admin.model.vo.CategoryVO;

@Service("CategoryService")
public class CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 查询类目列表
	 */
	public List<Category> queryByParam(CategoryVO categoryVO){
		
		PageHelper.startPage(categoryVO.getPageNum(), categoryVO.getNumPerPage());
		return categoryMapper.queryByParam(categoryVO);
	}
	
	/**
	 * 通过id查询类目
	 */
	public Category selectById(int id){
		return categoryMapper.selectById(id);
	}
	
	/**
	 * 删除类目信息
	 */
	public int delete(int id){
		
		return categoryMapper.delete(id);
	}
	
	/**
	 * 修改类目信息
	 */
	public int update(CategoryVO categoryVO){
		
		return categoryMapper.update(categoryVO);
	}
	
	/**
	 * 增加类目信息
	 */
	public int save(CategoryVO categoryVO){
		
		return categoryMapper.save(categoryVO);
	}

}
