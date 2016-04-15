package com.lsgx.admin.controller.system;

import java.util.List;

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
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.vo.ConfigQueryVO;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;

@Controller
@RequestMapping("system")
public class ConfigController extends BaseController{
	@Autowired
	private ConfigService configService;
	//系统参数列表页面
	private static String config_list = "system/config_list";
	//系统参数配置页面
	private static String config_add = "system/config_add";
	//系统参数修改页面
	private static String config_edit = "system/config_edit";
	
	/**
	 * 获取参数信息列表
	 *    post
	 * */
	@RequestMapping(value="configList",method=RequestMethod.POST)
	public String showConfigListPost(ConfigQueryVO vo,ModelMap model){
		
		List<Config> list = configService.queryByParam(vo);
		
		PageInfo<Config> page = new PageInfo<Config>(list);
		
		model.put("list", list);
		model.put("page", page);
		model.put("param", vo);
		return config_list;
	}
	/**
	 * 参数列表
	 *     get
	 * */
	@RequestMapping(value="configList",method=RequestMethod.GET)
	public String showConfigListGet(ConfigQueryVO vo,ModelMap model){
		
		return showConfigListPost(vo, model);
	}
	
	/**
	 * 配置参数页面
	 * 		get
	 * */
	@RequestMapping(value="addConfig",method = RequestMethod.GET)
	public String configAdd(){
		
		return config_add;
	}
	
	/** 
	 * 保存添加的系统配置信息  post
	 * @param config
	 * @param model
	 * */
	@RequestMapping(value="addConfig" ,method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="添加系统配置")
	public String addConfig(Config config,ModelMap model){
		saveLogDetail("添加系统配置：" + config.toString());
		config.setEmpty(0);
		configService.configAdd(config);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add config success", "config_list", "", "closeCurrent", ""));
	}
	
	/**
	 * 删除系统参数信息
	 * @param model
	 * */
	@RequestMapping(value="configDelete",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="删除参数")
	public String configDelete(@RequestParam("id") int id,ModelMap model){
		Config config = configService.selectById(id);
		saveLogDetail("删除参数"+config.toString());
		configService.configDelete(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "config_list", "", "", ""));
	}
	
	/**
	 * 修改参数
	 * */
	@RequestMapping(value="configEdit",method=RequestMethod.GET)
	public String configEditGet(Config co,ModelMap model){
		Config config = configService.selectById(co.getId());
		model.put("config", config);
		return config_edit;
	}
	
	/**
	 * 保存修改参数
	 * */
	@RequestMapping(value="configEdit",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="修改参数")
	public String configEdit(Config config,ModelMap model){
		saveLogDetail("修改参数"+config.toString());
		configService.configEdit(config);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit config success", "config_list", "", "closeCurrent", ""));
	}
	

}
