package com.lsgx.admin.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.SystemNotifyVO;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping(value="user")
public class NotifyController extends BaseController{
	
	@Autowired
	private SystemNotifyService syNotifyService;
	
	private static String notifyList = "systemNotify/notify_list";
	
	/**
	 * 获取通告列表  post
	 * @param snv
	 * @param model
	 * */
	@RequestMapping(value="notifyList",method=RequestMethod.POST)
	public String notifyListPOST(SystemNotifyVO snv,ModelMap model){
		List<SystemNotifyVO> snVos = syNotifyService.selectByParam(snv);
		List<SystemNotifyVO> snVos2 = new ArrayList<SystemNotifyVO>();
		for(SystemNotifyVO sNotifyVO:snVos){
			if(StringUtil.isNotEmpty(sNotifyVO.getContent())){
				if(sNotifyVO.getContent().length()>12){
					sNotifyVO.setContentShort(sNotifyVO.getContent().substring(0, 12)+"...");
				}else{
					sNotifyVO.setContentShort(sNotifyVO.getContent());
				}
			}
			snVos2.add(sNotifyVO);
		}
		PageInfo<SystemNotifyVO> page = new PageInfo<SystemNotifyVO>(snVos);
		model.put("snVos", snVos2);
		model.put("page", page);
		model.put("snv", snv);
		return notifyList;
	}
	
	/**
	 * 获取通告列表  get
	 * @param snv
	 * @param model
	 * */
	@RequestMapping(value="notifyList",method=RequestMethod.GET)
	public String notifyListGET(SystemNotifyVO snv,ModelMap model) {
		
		return notifyListPOST(snv, model);
	}
	
	/**
	 * 获取发送通告消息的页面
	 * */
	@RequestMapping(value="notifySend",method=RequestMethod.GET)
	public String sendNotify(){
		
		return "systemNotify/notify_send";
	}
	
	
	/**
	 * 发送通告消息
	 * */
	@RequestMapping(value="notifySend",method=RequestMethod.POST)
	@ResponseBody
	@ActionLog(content="发送通告")
	public String notifySend(SystemNotifyVO sNotify, ModelMap model){
		SystemNotify systemNotify = new SystemNotify();
		String[] userids = sNotify.getUserIds().split("\\,");
		for(String userid : userids){
		saveLogDetail("发送通告：" + systemNotify.toString());
		systemNotify.setUserid(Integer.parseInt(userid));
		systemNotify.setSender(sNotify.getSender());
		systemNotify.setSubject(sNotify.getSubject());
		systemNotify.setContent(sNotify.getContent());
		systemNotify.setState(0);
		systemNotify.setIsShow(1);
		systemNotify.setCreateTime(new Date());
		syNotifyService.notifyAdd(systemNotify);
		}
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "send notify success", "notifyList", "", "closeCurrent", ""));
	}

}
