package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.NewsMapper;
import com.lsgx.admin.model.vo.NewsVO;

@Service("NewsService")
public class NewsService {
	
	@Autowired
	private NewsMapper newsMapper;
	
	/**
	 * 获取新闻列表
	 */
	public List<NewsVO> selectByParam(NewsVO newsVO){
		PageHelper.startPage(newsVO.getPageNum(), newsVO.getNumPerPage());
		return newsMapper.selectByParam(newsVO);
	}
	/**
	 * 添加新闻
	 */
	public void addNews(NewsVO newsVO){
		newsMapper.addNews(newsVO);
	}
	/**
	 * 获取单条新闻
	 */
	public NewsVO selectById(Integer id){
		return newsMapper.selectById(id);
	}
	/**
	 * 删除新闻
	 */
	public void deleteNews(Integer id){
		newsMapper.deleteNews(id);
	}
	/**
	 * 编辑新闻
	 */
	public void editNews(NewsVO newsVO){
		newsMapper.editNews(newsVO);
	}
	/**
	 * 获取爱心故事助学列表
	 */
	public List<NewsVO> selectHelpStudyByParam(NewsVO newsVO){
		PageHelper.startPage(newsVO.getPageNum(), newsVO.getNumPerPage());
		return newsMapper.selectHelpStudyByParam(newsVO);
	}
	/**
	 * 获取爱心故事助学建学校列表
	 */
	public List<NewsVO> selectHelpStudyBuildSchoolByParam(NewsVO newsVO){
		PageHelper.startPage(newsVO.getPageNum(), newsVO.getNumPerPage());
		return newsMapper.selectHelpStudyBuildSchoolByParam(newsVO);
	}
	/**
	 * 获取爱心故事疾病列表
	 */
	public List<NewsVO> selectDiseaseByParam(NewsVO newsVO){
		PageHelper.startPage(newsVO.getPageNum(), newsVO.getNumPerPage());
		return newsMapper.selectDiseaseByParam(newsVO);
	}
	/**
	 * 获取爱心故事列表
	 */
	public List<NewsVO> selectLoveStoryByParam(NewsVO newsVO){
		PageHelper.startPage(newsVO.getPageNum(), newsVO.getNumPerPage());
		return newsMapper.selectLoveStoryByParam(newsVO);
	}

}
