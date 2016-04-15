package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.vo.NewsVO;

@Repository
public interface NewsMapper extends BaseMapper<NewsVO>{
	
	//获取新闻列表
	List<NewsVO> selectByParam(NewsVO nVo);
	//添加新闻
	void addNews(NewsVO newsVO);
	//获取单条新闻
	NewsVO selectById(Integer id);
	//删除新闻
	void deleteNews(Integer id);
	//编辑新闻
	void editNews(NewsVO newsVO);
	//获取爱心故事列表
	List<NewsVO> selectLoveStoryByParam(NewsVO nVo);
	//获取爱心故事助学列表
	List<NewsVO> selectHelpStudyByParam(NewsVO nVo);
	//获取爱心故事疾病列表
	List<NewsVO> selectDiseaseByParam(NewsVO nVo);
	//获取爱心故事助学建学校列表
	List<NewsVO> selectHelpStudyBuildSchoolByParam(NewsVO nVo);

}
