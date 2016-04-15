package com.lsgx.admin.controller.news;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.vo.NewsVO;
import com.lsgx.admin.service.NewsService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;

@Controller
@RequestMapping("/helpStudy")
public class HelpStudyController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	/**
	 * 获取新闻建学校列表 get
	 * */
	@RequestMapping(value="/buildSchoolList",method=RequestMethod.GET)
	public String buildSchoolGET(NewsVO nVo,ModelMap model,HttpSession session){
		return buildSchoolPOST(nVo, model,session);
	}
	/**
	 * 获取新闻建学校列表 post
	 * */
	@RequestMapping(value="/buildSchoolList",method=RequestMethod.POST)
	public String buildSchoolPOST(NewsVO nVo,ModelMap model,HttpSession session){
		List<NewsVO> buildSchoolList = newsService.selectHelpStudyBuildSchoolByParam(nVo);
		PageInfo<NewsVO> page = new PageInfo<NewsVO>(buildSchoolList);
		model.put("news", buildSchoolList);
		model.put("page", page);
		model.put("nVo", nVo);
		return "/helpStudy/buildSchool_list";
	}
	/**
	 * 得到发布页面  get
	 * */
	@RequestMapping(value="/buildSchoolSend",method=RequestMethod.GET)
	public String buildSchoolSend(HttpSession session){
		session.setAttribute("main_column","爱心故事");
		session.setAttribute("sub_column", "助学");
		session.setAttribute("third_column", "建学校");
		return "/helpStudy/buildSchool_send";
	}
	/**
	 * 爱心故事发布 post
	 * */
	@RequestMapping(value="/buildSchoolSend",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="爱心故事建学校发布")
	public String sendBuildSchool(NewsVO nVo){
		saveLogDetail("爱心故事建学校发布"+nVo.toString());
		nVo.setCreateTime(new Date());
		nVo.setOrderTime(new Date());
		newsService.addNews(nVo);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add loveStory success", "buildSchoolList", "", "closeCurrent", ""));
	}
	/**
	 * 删除助学建学校信息
	 */
	@RequestMapping(value="/buildSchoolDelete")
	@ResponseBody
	@ActionLog(content="删除爱心故事助学建学校信息")
	public String loveStoryDelete(@RequestParam("id") int id){
		NewsVO nVo = newsService.selectById(id);
		saveLogDetail("删除爱心故事助学建学校信息"+nVo.toString());
		newsService.deleteNews(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "buildSchoolList", "", "", ""));
	}
	
	/**
	 * 获取爱心故事编辑页面
	 */
	@RequestMapping(value="/buildSchoolEdit")
	public String loveStoryEditGET(@RequestParam("id") int id,ModelMap model){
		NewsVO newsVO = newsService.selectById(id);
		model.put("newsVO", newsVO);
		return "/helpStudy/buildSchool_edit";
	}
	/**
	 * 保存爱心故事编辑页面
	 */
	@RequestMapping(value="/editbuildSchool")
	@ResponseBody
	@ActionLog(content="编辑爱心故事助学建学校")
	public String loveStoryEdit(NewsVO newsVO){
		saveLogDetail("编辑爱心故事助学建学校"+newsVO.toString());
		newsVO.setCreateTime(new Date());
		newsVO.setOrderTime(new Date());
		newsService.editNews(newsVO);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit loveStory success", "buildSchoolList", "", "closeCurrent", ""));
	}

}
