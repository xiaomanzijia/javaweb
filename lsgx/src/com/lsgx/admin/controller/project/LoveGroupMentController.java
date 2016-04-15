package com.lsgx.admin.controller.project;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.LoveGroupMent;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.ActionUserVO;
import com.lsgx.admin.model.vo.LoveGroupMentQueryVO;
import com.lsgx.admin.model.vo.UserQueryVO;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.service.LoveGroupMentService;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;

@Controller
@RequestMapping("/lovegroupment")
public class LoveGroupMentController extends BaseController
{
    @Autowired
    private LoveGroupMentService loveGroupMentService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ActionUserService actionUserService;

    @Autowired
    private SystemNotifyService syNotifyService;

    @RequestMapping(value = "/loveGroupMentList")
    @ActionLog(content = "查询爱心团列表")
    public String loveGroupMentList(LoveGroupMentQueryVO vo, ModelMap model)
    {
        List<LoveGroupMent> list = loveGroupMentService.select(vo);
        
        PageInfo<LoveGroupMent> page = new PageInfo<LoveGroupMent>(list);
        model.put("list", list);
        model.put("page", page);
        model.put("projectId", vo.getProjectId());
        model.put("loveGroupMent", vo);
        JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "lovegroupment_list", "", "", ""));
        return "lovegroupment/lovegroupment_list";
    }
    
    
    @RequestMapping(value = "/initUpdateLoveGroupMent")
    public String initUpdateLoveGroupMent(LoveGroupMent loveGroupMent, ModelMap model)
    {
        model.put("loveGroupMent", loveGroupMent);
        model.put("projectId", loveGroupMent.getProjectId());
        return "lovegroupment/lovegroupment_edit_dialog";
    }
    
    @RequestMapping(value = "/addLoveGroupMent")
    @ResponseBody
    @ActionLog(content = "爱心团分配")
    public String addLoveGroupMent(@RequestParam("user_ids")String user_ids,@RequestParam("projectId")int projectId, ModelMap model)
    {
        //user_ids:18@0@0,17@1@1,16@0@2,15@1@1
        String[] user_id = user_ids.split(",");
        
        for (String loves : user_id)
        {
            String[] love = loves.split("@");
            LoveGroupMent loveGroupMent = new LoveGroupMent();
            loveGroupMent.setCreateTime(new Date());
            loveGroupMent.setProjectId(projectId);
            loveGroupMent.setRole(Integer.parseInt(love[1]));
            loveGroupMent.setUserId(Integer.parseInt(love[0]));
            loveGroupMent.setUserType(Integer.parseInt(love[2]));
            loveGroupMentService.addLoveGroupMent(loveGroupMent);
            saveLogDetail("爱心团员分配userId:" + loveGroupMent.getUserId());
            
            SystemNotify sNotify = new SystemNotify();//站内信
            sNotify.setState(0);
            sNotify.setIsShow(1);
            sNotify.setCreateTime(new Date());
            StringBuffer content = new StringBuffer();
            sNotify.setSender("系统消息");
            sNotify.setSubject("加入善管家");
            sNotify.setUserid(Integer.parseInt(love[0]));
            content.append("你成为了项目ID" + projectId + "的善管家");
            sNotify.setContent(content.toString());
            syNotifyService.notifyAdd(sNotify);

        }
        model.put("projectId", projectId);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "lovegroupment_list", "", "closeCurrent", ""));
//        return responseSuccess("lovegroupment_list");
    }
    
    @RequestMapping(value = "/updateLoveGroupMent")
    @ResponseBody
    @ActionLog(content = "爱心团删除")
    public String updateLoveGroupMent(LoveGroupMent loveGroupMent, ModelMap model)
    {
        loveGroupMentService.updateLoveGroupMent(loveGroupMent);
        saveLogDetail("爱心团员修改id:" + loveGroupMent.getId());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "lovegroupment_list", "", "closeCurrent", ""));
//        return responseSuccess("lovegroupment_list");
    }
    
    @RequestMapping(value = "/initAddLoveGroupMent")
    @ActionLog(content = "查找带回用户列表")
    public String initAddLoveGroupMent(UserQueryVO vo,@RequestParam("projectId")int projectId, ModelMap model)
    {
        List<FrontUser> list = userService.findByCondition(vo);
        
        PageInfo<FrontUser> page = new PageInfo<FrontUser>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("projectId", projectId);
        model.put("user", vo);
        return "lovegroupment/addlovegroupment_list";
    }
    
    @RequestMapping(value = "/initAddLoveGroupMentKF")
    @ActionLog(content = "查找带回用户列表")
    public String initAddLoveGroupMentKF(ActionUserVO vo,@RequestParam("projectId")int projectId, ModelMap model)
    {
        List<ActionUser> userList = actionUserService.queryUserList(vo);
        PageInfo<ActionUser> page = new PageInfo<ActionUser>(userList);
        model.put("page", page);
        model.put("userList", userList);
        model.put("user", vo);
        model.put("projectId", projectId);
        return "lovegroupment/addlovegroupmentKF_list";
    }
}
