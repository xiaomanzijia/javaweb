package com.lsgx.admin.controller.news;

import java.util.ArrayList;
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
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping(value="/loveStory")
public class LoveStoryController extends BaseController{
	@Autowired
	private NewsService newsService;
	
	/**
	 * 获取爱心故事列表 get
	 * */
	@RequestMapping(value="/loveStoryList",method=RequestMethod.GET)
	public String loveStoryGET(NewsVO nVo,ModelMap model){
		return loveStoryPOST(nVo, model);
	}
	/**
	 * 获取爱心故事列表 post
	 * */
	@RequestMapping(value="/loveStoryList",method=RequestMethod.POST)
	public String loveStoryPOST(NewsVO nVo,ModelMap model){
		List<NewsVO> loveStoryList = newsService.selectLoveStoryByParam(nVo);
		List<NewsVO> loveStoryVOs = new ArrayList<NewsVO>();
		for(NewsVO newsVO : loveStoryList){
			if(StringUtil.isNotEmpty(newsVO.getTitle())){
				if(newsVO.getTitle().length() > 10){
					newsVO.setTitleShort(newsVO.getTitle().substring(0, 10)+"...");
				}else{
					newsVO.setTitleShort(newsVO.getTitle());
				}
			}
			if(StringUtil.isNotEmpty(newsVO.getAbstracts())){
				if(newsVO.getAbstracts().length() > 10){
					newsVO.setAbstractsShort(newsVO.getAbstracts().substring(0, 10)+"...");
				}else{
					newsVO.setAbstractsShort(newsVO.getAbstracts());
				}
			}
			if(StringUtil.isNotEmpty(newsVO.getKeywords())){
				if(newsVO.getKeywords().length() > 10){
					newsVO.setKeywordsShort(newsVO.getKeywords().substring(0, 10)+"...");
				}else{
					newsVO.setKeywordsShort(newsVO.getKeywords());
				}
			}
			if(StringUtil.isNotEmpty(newsVO.getContent())){
				if(newsVO.getContent().length() > 20){
					newsVO.setContentShort(newsVO.getContent().substring(0, 20)+"...");
				}else{
					newsVO.setContentShort(newsVO.getContent());
				}
			}
			loveStoryVOs.add(newsVO);
		}
		PageInfo<NewsVO> page = new PageInfo<NewsVO>(loveStoryList);
		model.put("news", loveStoryVOs);
		model.put("page", page);
		model.put("nVo", nVo);
		return "/news/loveStory_list";
	}
	/**
	 * 得到爱心故事发布页面  get
	 * */
	@RequestMapping(value="/loveStorySend",method=RequestMethod.GET)
	public String loveStorySend(HttpSession session){
		session.setAttribute("main_column","爱心故事");
		return "/news/loveStory_send";
	}
	/**
	 * 爱心故事发布 post
	 * */
	@RequestMapping(value="/loveStorySend",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="爱心故事发布")
	public String sendLoveStory(NewsVO nVo){
		saveLogDetail("爱心故事发布"+nVo.toString());
		if(nVo.getNews_column()==null){
			nVo.setNews_column("爱心故事");
		}
		nVo.setCreateTime(new Date());
		nVo.setOrderTime(new Date());
		newsService.addNews(nVo);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add loveStory success", "loveStoryList", "", "closeCurrent", ""));
	}
	/**
	 * 删除爱心故事
	 */
	@RequestMapping(value="/loveStoryDelete")
	@ResponseBody
	@ActionLog(content="删除爱心故事")
	public String loveStoryDelete(@RequestParam("id") int id){
		NewsVO nVo = newsService.selectById(id);
		saveLogDetail("删除爱心故事"+nVo.toString());
		newsService.deleteNews(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "loveStoryList", "", "", ""));
	}
	/**
	 * 获取爱心故事编辑页面
	 */
	@RequestMapping(value="/loveStoryEdit")
	public String loveStoryEditGET(@RequestParam("id") int id,ModelMap model){
		NewsVO newsVO = newsService.selectById(id);
		model.put("newsVO", newsVO);
		return "/news/loveStory_edit";
	}
	/**
	 * 保存爱心故事编辑页面
	 */
	@RequestMapping(value="/editLoveStory")
	@ResponseBody
	@ActionLog(content="编辑爱心故事")
	public String loveStoryEdit(NewsVO newsVO){
		saveLogDetail("编辑爱心故事"+newsVO.toString());
		newsVO.setCreateTime(new Date());
		newsVO.setOrderTime(new Date());
		newsService.editNews(newsVO);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit loveStory success", "loveStoryList", "", "closeCurrent", ""));
	}
	/**
	 * 获取爱心故事助学列表 get
	 * */
	@RequestMapping(value="/studyHelpList",method=RequestMethod.GET)
	public String studyHelpGET(NewsVO nVo,ModelMap model){
		return studyHelpPOST(nVo, model);
	}
	/**
	 * 获取爱心故事助学列表 post
	 * */
	@RequestMapping(value="/studyHelpList",method=RequestMethod.POST)
	public String studyHelpPOST(NewsVO nVo,ModelMap model){
		List<NewsVO> studyHelpList = newsService.selectHelpStudyByParam(nVo);
		PageInfo<NewsVO> page = new PageInfo<NewsVO>(studyHelpList);
		model.put("news", studyHelpList);
		model.put("page", page);
		model.put("nVo", nVo);
		return "/news/studyHelp_list";
	}
	/**
	 * 删除爱心故事助学
	 * */
	@RequestMapping(value="/studyHelpDelete")
	@ResponseBody
	@ActionLog(content="删除爱心故事助学")
	public String studyHelpDelete(@RequestParam("id") int id){
		NewsVO nVo = newsService.selectById(id);
		saveLogDetail("删除爱心故事助学"+nVo.toString());
		newsService.deleteNews(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200","delete success","studyHelpList","","",""));
	}
	/**
	 * 得到爱心故事助学发布页面  get
	 * */
	@RequestMapping(value="/studyHelpSend",method=RequestMethod.GET)
	public String studyHelpSend(HttpSession session){
		session.setAttribute("main_column", "爱心故事");
		session.setAttribute("sub_column", "助学");
		return "/news/studyHelp_send";
	}
	/**
	 * 爱心故事助学发布 post
	 * */
	@RequestMapping(value="/studyHelpSend",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="爱心故事助学发布")
	public String sendstudyHelp(NewsVO nVo){
		saveLogDetail("爱心故事助学发布"+nVo.toString());
		if(nVo.getNews_column()==null||nVo.getSub_column()==null){
			nVo.setNews_column("爱心故事");
			nVo.setSub_column("助学");
		}
		nVo.setCreateTime(new Date());
		nVo.setOrderTime(new Date());
		newsService.addNews(nVo);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add studyHelp success", "studyHelpList", "", "closeCurrent", ""));
	}
	/**
	 * 获取爱心故事助学编辑页面
	 */
	@RequestMapping(value="/studyHelpEdit")
	public String studyHelpEditGET(@RequestParam("id") int id,ModelMap model){
		NewsVO newsVO = newsService.selectById(id);
		model.put("newsVo", newsVO);
		return "/news/studyHelp_edit";
	}
	/**
	 * 保存爱心故事助学编辑页面
	 */
	@RequestMapping(value="/EditStudyHelp")
	@ResponseBody
	@ActionLog(content="编辑爱心故事助学")
	public String studyHelpEdit(NewsVO newsVO){
		saveLogDetail("编辑爱心故事助学"+newsVO.toString());
		newsVO.setCreateTime(new Date());
		newsVO.setOrderTime(new Date());
		newsService.editNews(newsVO);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit studyHelp success", "studyHelpList", "", "closeCurrent", ""));
	}
	
	
	/**
	 * 获取爱心故事疾病列表 get
	 * */
	@RequestMapping(value="/diseaseList",method=RequestMethod.GET)
	public String diseaseListGET(NewsVO nVo,ModelMap model){
		return diseaseListPOST(nVo, model);
	}
	/**
	 * 获取爱心故事疾病列表 post
	 * */
	@RequestMapping(value="/diseaseList",method=RequestMethod.POST)
	public String diseaseListPOST(NewsVO nVo,ModelMap model){
		List<NewsVO> diseaseList = newsService.selectDiseaseByParam(nVo);
		PageInfo<NewsVO> page = new PageInfo<NewsVO>(diseaseList);
		model.put("news", diseaseList);
		model.put("page", page);
		model.put("nVo", nVo);
		return "/news/disease_list";
	}
	/**
	 * 获得爱心故事疾病发布页面  get
	 * */
	@RequestMapping(value="/diseaseSend",method=RequestMethod.GET)
	public String diseaseSend(HttpSession session){
		session.setAttribute("main_column","爱心故事");
		session.setAttribute("sub_column", "疾病");
		return "/news/disease_send";
	}
	/**
	 * 爱心故事疾病发布 post
	 * */
	@RequestMapping(value="/diseaseSend",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="爱心故事疾病发布")
	public String sendDisease(NewsVO nVo){
		saveLogDetail("爱心故事疾病发布"+nVo.toString());
		if(nVo.getNews_column()==null||nVo.getSub_column()==null){
			nVo.setNews_column("爱心故事");
			nVo.setSub_column("疾病");
		}
		nVo.setCreateTime(new Date());
		nVo.setOrderTime(new Date());
		newsService.addNews(nVo);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add disease success", "diseaseList", "", "closeCurrent", ""));
	}
	/**
	 * 获取爱心故事疾病编辑页面
	 */
	@RequestMapping(value="/diseaseEdit")
	public String diseaseEditGET(@RequestParam("id") int id,ModelMap model){
		NewsVO newsVO = newsService.selectById(id);
		model.put("newsVO", newsVO);
		return "/news/disease_edit";
	}
	/**
	 * 保存爱心故事疾病编辑页面
	 */
	@RequestMapping(value="/editDisease")
	@ResponseBody
	@ActionLog(content="编辑爱心故事疾病")
	public String diseaseEdit(NewsVO newsVO){
		saveLogDetail("编辑爱心故事疾病"+newsVO.toString());
		newsVO.setCreateTime(new Date());
		newsVO.setOrderTime(new Date());
		newsService.editNews(newsVO);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit disease success", "diseaseList", "", "closeCurrent", ""));
	}
	/**
	 * 删除爱心故事疾病
	 * */
	@RequestMapping(value="/diseaseDelete")
	@ResponseBody
	@ActionLog(content="删除爱心故事疾病")
	public String diseaseDelete(@RequestParam("id") int id){
		NewsVO nVo = newsService.selectById(id);
		saveLogDetail("删除爱心故事疾病"+nVo.toString());
		newsService.deleteNews(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "diseaseList", "", "", ""));
	}

}
