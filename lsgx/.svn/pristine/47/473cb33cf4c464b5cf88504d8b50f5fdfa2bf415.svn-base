package com.lsgx.admin.controller.project;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.controller.project.vo.CustomerServiceInfo;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.SystemNotifyVO;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.util.JsonUtil;

/**
 * 客服协助为求助人申请求助项目
 * @author yangc
 */

@Controller
@RequestMapping("/customerService")
public class CustomerServiceController extends BaseController{
	
	@Autowired
	private SystemNotifyService systemNotifyService;
	
	@Autowired
	private ActionUserService aUserService;
	/**
	 * 显示客服协助求助人的信息
	 */
	@RequestMapping(value="/showCustomerServiceInfo")
	public String showInformation(CustomerServiceInfo cInfo,ModelMap model,HttpServletRequest req){
		String user_id=super.getActionUser(req).getId().toString();
		SystemNotifyVO systemNotify = new SystemNotifyVO();
		systemNotify.setSender("客服协助");
		if(cInfo.getName()!=null){
			systemNotify.setContent("{\"name\":\""+cInfo.getName());
		}
		if(cInfo.getStartDate()!=null){
			systemNotify.setStartDate(cInfo.getStartDate());
		}
		if(cInfo.getEndDate()!=null){
			systemNotify.setEndDate(cInfo.getEndDate());
		}
		if(cInfo.getStateString()!=null && cInfo.getStateString() !=""){
			String[] strs = cInfo.getStateString().split(",");
			systemNotify.setState(Integer.parseInt(strs[0]));
			systemNotify.setIsShow(Integer.parseInt(strs[1]));
		}
		if(cInfo.getIsShow()!=null){
			cInfo.setStateString(Integer.toString(cInfo.getState())+","+Integer.toString(cInfo.getIsShow()));
		}
		List<SystemNotify> sysList = systemNotifyService.queryByParam(systemNotify);
		PageInfo<SystemNotify> page = new PageInfo<SystemNotify>(sysList);
		List<CustomerServiceInfo> csInfos = new ArrayList<CustomerServiceInfo>();
		for(SystemNotify systVo :sysList){
			String contentInfo = systVo.getContent();
			List<String> info = JsonUtil.jsonToList(contentInfo);
			CustomerServiceInfo csInfo = new CustomerServiceInfo();
			csInfo.setName(info.get(0));
			csInfo.setPhone(info.get(1));
			csInfo.setQq(info.get(2));
			if(!(systVo.getSubject().equals("客服协助"))){
				csInfo.setSubject(systVo.getSubject());
				ActionUser user = aUserService.queryById(Integer.parseInt(systVo.getSubject()));
				if(user!=null&&user.getRealName()!=null){
					csInfo.setSubjectName(user.getRealName());
				}
			}
			csInfo.setId(systVo.getId());
			csInfo.setState(systVo.getState());
			csInfo.setIsShow(systVo.getIsShow());
			csInfo.setTime(systVo.getCreateTime());
			csInfo.setUserId(systVo.getUserid());
			csInfos.add(csInfo);
		}
		model.put("user_id", user_id);
		model.put("csInfos", csInfos);
		model.put("cInfo", cInfo);
		model.put("page", page);
		return "customerService/customerService_list";
	}
	
	/**
	 * 客服接受求助申请信息
	 */
	@RequestMapping(value="/customerReceive")
	@ResponseBody
	public String customerReceive(CustomerServiceInfo cInfo,HttpServletRequest req){
		SystemNotify sysNotify = systemNotifyService.queryById(cInfo.getId());
		sysNotify.setState(cInfo.getState());
		sysNotify.setSubject(super.getActionUser(req).getId().toString());
		int flag =systemNotifyService.update(sysNotify);
		if(flag == 1){
			return responseSuccess("customerServiceList", "customer receive success", "");
		}else{
			return responseFaild("customerServiceList", "customer receive fail", "");
		}
	}
	
	/**
	 * 获取客服接受求助申请信息时所填项目id的页面
	 */
	@RequestMapping(value="/customerdo")
	public String customerdo(CustomerServiceInfo cInfo,ModelMap model){
		model.put("cInfo", cInfo);
		return "customerService/customerService_edit";
	}
	
	/**
	 * 客服接受求助申请信息
	 */
	@RequestMapping(value="/customerDispose")
	@ResponseBody
	public String customerDispose(CustomerServiceInfo cInfo){
		SystemNotify sysNotify = systemNotifyService.queryById(cInfo.getId());
		sysNotify.setIsShow(cInfo.getIsShow());
		sysNotify.setUserid(cInfo.getUserId());  //这里的userid是客服协助求助人申请的项目id
		int flag =systemNotifyService.update(sysNotify);
		if(flag == 1){
			if(cInfo.getIsShow()==1){
				return responseSuccess("customerServiceList", "customer dispose success", "closeCurrent");
			}else{
				return responseSuccess("customerServiceList", "customer dispose success", "");
			}
		}else{
			return responseFaild("customerServiceList", "customer dispose fail", "closeCurrent");
		}
		
	}

}
