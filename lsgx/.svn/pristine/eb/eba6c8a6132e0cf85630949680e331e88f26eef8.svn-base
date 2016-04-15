package com.lsgx.admin.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.MessageModel;
import com.lsgx.admin.model.vo.MessageModelVO;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.service.MessageModelService;

@Controller
@RequestMapping("/messagemodel")
public class MessageModelController extends BaseController
{
    @Autowired
    private MessageModelService messageModelService;
    
    @Autowired
    private ActionUserService actionUserService;
    
    @RequestMapping(value = "/messageModelList")
    @ActionLog(content = "查询短信模版列表")
    public String userIndex(MessageModelVO vo, ModelMap model)
    {
        List<MessageModel> list = messageModelService.findByCondition(vo);
        List<MessageModel> messageModels = new ArrayList<MessageModel>();
        PageInfo<MessageModel> page = new PageInfo<MessageModel>(list);
        for(MessageModel messageModel :list){
        	if(messageModel.getOperator() !=null){
        		ActionUser actionUser = actionUserService.queryById(messageModel.getOperator());
        		if(actionUser != null){
        			messageModel.setOperatorName(actionUser.getRealName());
        		}
        		messageModels.add(messageModel);
        	}
        }
        model.put("list", messageModels);
        model.put("page", page);
        model.put("messagemodel", vo);
        return "messagemodel/messageModel_list";
    }
    
    @RequestMapping(value = "/initSave")
    public String initSave(ModelMap model)
    {
        return "messagemodel/messageModel_add";
    }
    
    @RequestMapping(value = "/save")
    @ActionLog(content = "增加模版")
    @ResponseBody
    public String save(MessageModel messageModel, HttpServletRequest req, ModelMap model)
    {
        messageModel.setCreateTime(new Date());
        messageModel.setOperator(super.getActionUser(req).getId());
        int saveSet = messageModelService.save(messageModel);
        if (saveSet > 0)
        {
            return responseSuccess("messageModel_list", "增加模版成功", "closeCurrent");
        }
        else
        {
            return responseFaild("messageModel_list", "增加模版失败", "");
        }
    }
    
    @RequestMapping(value = "/initUpdate")
    public String initSave(@RequestParam("id")
    int id, ModelMap model)
    {
        MessageModel messageModel = messageModelService.queryById(id);
        model.put("messageModel", messageModel);
        return "messagemodel/messageModel_update";
    }
    
    @RequestMapping(value = "/update")
    @ActionLog(content = "修改模版")
    @ResponseBody
    public String update(MessageModel messageModel, HttpServletRequest req, ModelMap model)
    {
        if (messageModel != null)
        {
            messageModel.setOperator(super.getActionUser(req).getId());
            messageModelService.update(messageModel);
            saveLogDetail("修改模版ID:" + messageModel.getId());
            return responseSuccess("messageModel_list", "修改模版成功", "closeCurrent");
        }
        else
        {
            return responseFaild("messageModel_list", "修改模版失败", "");
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "删除模版")
    public String delete(@RequestParam("id")int id, ModelMap model)
    {
        saveLogDetail("删除模版id：" + id);
        messageModelService.delete(id);
        return responseSuccess("messageModel_list", "删除模版成功", "");
    }
}
