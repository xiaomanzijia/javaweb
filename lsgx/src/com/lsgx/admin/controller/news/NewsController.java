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
@RequestMapping("/news")
public class NewsController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	/**
	 * 获取新闻公告列表 post
	 * */
	@RequestMapping(value="/newsList",method=RequestMethod.POST)
	public String newsListPOST(NewsVO nVo,ModelMap model){
		List<NewsVO> newslist = newsService.selectByParam(nVo);
		List<NewsVO> newsVOs = new ArrayList<NewsVO>();
		for(NewsVO newsVO : newslist){
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
			newsVOs.add(newsVO);
		}
		PageInfo<NewsVO> page = new PageInfo<NewsVO>(newslist);
		model.put("news", newsVOs);
		model.put("page", page);
		model.put("nVo", nVo);
		return "news/news_list";
	}
	/**
	 * 获取新闻公告列表 get
	 * */
	@RequestMapping(value="/newsList",method=RequestMethod.GET)
	public String newsListGET(NewsVO nVo,ModelMap model){
		return newsListPOST(nVo, model);
	}
	
	/**
	 * 得到新闻发布页面  get
	 * */
	@RequestMapping(value="/newsSend",method=RequestMethod.GET)
	public String newsSend(HttpSession session){
		session.setAttribute("news_column","公告");
		return "/news/news_send";
	}
	
	/**
	 * 新闻发布   post
	 * */
	@RequestMapping(value="/newsSend",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="新闻发布")
	public String sendNews(NewsVO newsVO,ModelMap model){
		saveLogDetail("新闻发布：" + newsVO.toString());
		if(newsVO.getNews_column() == null){
			newsVO.setNews_column("公告");
		}
		newsVO.setCreateTime(new Date());
		newsVO.setOrderTime(new Date());
		newsService.addNews(newsVO);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add news success", "newsList", "", "closeCurrent", ""));
	}
	/**
	 * 获取修改新闻页面
	 */
	@RequestMapping(value="/newsEdit",method=RequestMethod.GET)
	public String newsEditGET(NewsVO nVo,ModelMap model){
		NewsVO newsVO = newsService.selectById(nVo.getId());
		model.put("newsVo", newsVO);
		return "/news/news_edit";
	}
	/**
	 * 保存修改新闻页面
	 */
	@RequestMapping(value="/editNews",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="修改新闻")
	public String newsEdit(NewsVO newsVO,ModelMap model){
		saveLogDetail("修改新闻"+newsVO.toString());
		newsVO.setCreateTime(new Date());
		newsVO.setOrderTime(new Date());
		newsService.editNews(newsVO);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit news success", "newsList", "", "closeCurrent", ""));
	}
	/**
	 * 删除新闻
	 */
	@RequestMapping(value="/newsDelete",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="删除新闻")
	public String newsDelete(@RequestParam("id") int id,ModelMap model){
		NewsVO newsVo = newsService.selectById(id);
		saveLogDetail("删除新闻："+newsVo.toString());
		newsService.deleteNews(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "newsList", "", "", ""));
	}
	
	/**
	 * 显示详细的新闻内容
	 */
	@RequestMapping(value="/showContent")
	public String showContent(@RequestParam("id") int id,ModelMap model){
		NewsVO newsVO = newsService.selectById(id);
		model.put("news", newsVO);
		return "/news/show_detail_content";
	}

}
