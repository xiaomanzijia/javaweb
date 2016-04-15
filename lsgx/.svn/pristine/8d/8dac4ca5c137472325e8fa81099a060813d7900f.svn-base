package com.lsgx.admin.controller.system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionRole;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.ActionUserRole;
import com.lsgx.admin.model.vo.ActionUserVO;
import com.lsgx.admin.service.ActionRoleService;
import com.lsgx.admin.service.ActionUserRoleService;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.MD5;

/**
 *  用户表  action
 * @author dell
 */
@Controller
public class ActionUserController extends BaseController{
	
	@Autowired
	private ActionUserService actionUserService;
	@Autowired
	private ActionUserRoleService actionUserRoleService;
	@Autowired
	private ActionRoleService actionRoleService;
	
	//返回用户列表页面
    private static String actionUserList = "ActionUser/actionUserList";
	
    private static String actionUserAdd = "ActionUser/actionUserAdd";
	
    private static String actionUserEdit = "ActionUser/actionUserEdit";
    
    private static String actionUserDetail = "ActionUser/actionUserDetail";
	
	//角色用户关联页面
    private static String actionUserRole = "ActionUser/actionUserRole";
	
    private static String ACTION_USER_LIST = "system/action_uesr_list";
    
    @RequestMapping(value = "/actionUser.do", method = RequestMethod.GET)
    // @ActionLog(content = "登录")
    public String actionUser(HttpServletRequest req, HttpServletResponse resp, ModelMap model)
    {
        return ACTION_USER_LIST;
    }

	/**
	 *  用户列表信息查询  post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserList.do", method = RequestMethod.POST)
    @ActionLog(content = "查询用户列表")
    public String actionUserList(ActionUserVO vo,
			ModelMap model){
		//调用sql查询方法
        List<ActionUser> userList = actionUserService.queryUserList(vo);
        PageInfo<ActionUser> page = new PageInfo<ActionUser>(userList);
		model.put("page", page);
        model.put("userList", userList);
        model.put("actionUser", vo);
        saveLogDetail(null);
		return actionUserList;
		
	}
	
	/**
	 *  用户列表信息查询  get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserList.do", method = RequestMethod.GET)
    public String actionUserListget(ActionUserVO vo,
			ModelMap model){
        return actionUserList(vo, model);
	}
	
	/**
	 *  添加用户 get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserAdd.do", method = RequestMethod.GET)
	public String actionUserAddget(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		return actionUserAdd;
	}
	/**
	 *  添加用户 post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserAdd.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "添加用户")
    public String actionUserAddpost(ActionUser actionUser, HttpServletRequest req,
			ModelMap model) {
        ActionUser acionUserSession = super.getActionUser(req);
		StringBuffer sb = new StringBuffer();
        String password = actionUser.getPassword();
        String pwd = MD5.encodeString(actionUser.getUserName().trim() + password);
        actionUser.setPassword(pwd);
        if (acionUserSession != null)
        {
            actionUser.setCreatename(acionUserSession.getId());
        }
        else
        {
            actionUser.setCreatename(1);
        }
        actionUser.setCreatetime(new Date());
        ActionUser users = actionUserService.queryUser(actionUser.getUserName(), pwd);
		if(users != null){
			sb.append("用户信息已存在: ").append(users.toString());
            saveLogDetail(sb.toString());
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this adminUser is existed", "", "", "", ""));
		}
        saveLogDetail(sb.toString());
        actionUserService.userAdd(actionUser);
        sb.append("用户信息添加成功 ：").append(actionUser.toString());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add success", "actionUserList", "", "closeCurrent", ""));
	}
	
	    /**
     *  跳转修改页面
     * @param req
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/actionUserDetail.do")
    public String actionUserDetail(ActionUser actionUser, HttpServletRequest req, ModelMap model)
    {
        if (actionUser != null && actionUser.getId() != null)
        {
            ActionUser user = actionUserService.userEdit(actionUser.getId());
            model.put("actionUser", user);
        }
        return actionUserDetail;
        
    }
    
    /**
     *  跳转修改页面
     * @param req
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/actionUserEditGET.do")
    public String actionUserEditGET(ActionUser actionUser, HttpServletRequest req,
			ModelMap model) {
        if (actionUser != null && actionUser.getId() != null)
        {
            ActionUser user = actionUserService.userEdit(actionUser.getId());
            model.put("actionUser", user);
        }
        return actionUserEdit;
		
	}
	
	/**
	 * 用户信息修改保存
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/action/actionUserEdit.do")
	@ResponseBody
    @ActionLog(content = "修改用户")
    public String actionUserEditPost(ActionUser actionUser,
			ModelMap model){
		StringBuffer sb = new StringBuffer();
		ActionUser user = actionUserService.userEdit(actionUser.getId());
        actionUser.setCreatename(user.getCreatename());
        actionUser.setCreatetime(user.getCreatetime());
        actionUser.setDepartment(user.getDepartment());
        actionUser.setPassword(user.getPassword());
        actionUser.setStatus(user.getStatus());

        sb.append("修改前：").append(user.toString());
        sb.append("\n修改后：").append(actionUser.toString());
        saveLogDetail(sb.toString());
        actionUserService.userEditOk(actionUser);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit success", "actionUserList", "", "closeCurrent", ""));
		
	}
	
	/**
	 * 用户信息删除
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserDelete.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "删除用户")
    public String actionUserDeletePost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		
		if(user.getCreatename() == 0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this admin is superadmin,can`t delete", "", "", "", ""));
		}
        saveLogDetail("删除用户：" + user.toString());
		//删除用户信息
		actionUserService.userDelete(Integer.parseInt(id));
		//删除用户角色关联信息
		actionUserRoleService.userDeleteId(Integer.parseInt(id));
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "actionUserList", "", "forward", "/action/actionUserList.do"));
	}
	
	/**
	 * 用户信息 初始化密码
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserInit.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "初始化密码")
    public String actionUserInitPost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		if(user.getCreatename() == 0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this admin is superadmin,can`t reset password!", "", "", "", ""));
		}
        String password = MD5.encodeString(user.getUserName().trim() + "123456");
		user.setPassword(password);
        saveLogDetail("用户初始化密码：" + user.toString());
		actionUserService.userInit(user);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200","reset password success","actionUserList","","",""));
	}
	
	/**
	 * 用户信息 修改状态
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserStats.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "修改用户状态")
    public String actionUserStats(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		if(user.getCreatename() == 0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this admin is superadmin,can`t edit", "", "", "", ""));
		}
        saveLogDetail("修改用户状态：" + user.toString());
		actionUserService.userStatus(user);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200",
            "update success",
            "actionUserList",
            "",
            "forward",
            "/action/actionUserList.do"));
	}
	
	
	
	/**
	 * 分配角色 保存Post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserRole.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "分配角色")
    public String actionUserRolePost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String userId = req.getParameter("userId");
		String values = req.getParameter("values");
		//首先删除用户角色关联信息
		actionUserRoleService.userDeleteId(Integer.parseInt(userId));
		String[] value = values.split(",");
		if(value.length >0){
			for(String mp : value){
				ActionUserRole ur = new ActionUserRole();
				ur.setRoleId(Integer.parseInt(mp));
				ur.setUserId(Integer.parseInt(userId));
				actionUserRoleService.userRoleAdd(ur);
			}
		}
        saveLogDetail("角色id：" + values + " \n分配用户id：" + userId);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "give role success", "actionUserList", "", "closeCurrent", ""));
	}
	
	
	/**
	 * 用户分配角色
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionUserRole.do", method = RequestMethod.GET)
	public String actionUserRoleGet(HttpServletRequest req,HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionUser user = actionUserService.userEdit(Integer.parseInt(id));
		List<ActionRole> role = actionRoleService.selectRoleList(user.getCreatename());
		model.put("userId", id);
		model.put("actionStr", getUserRole(role, 0, new StringBuffer(), Integer.parseInt(id)));
		return actionUserRole;
	}
	
	/**
	 * 分配角色信息列表
	 * @param actionUser 角色列表
	 * @param level 等级
	 * @param sb 返回字符串
	 * @param userId 用户ID
	 * @return
	 */
	public String getUserRole(List<ActionRole> actionUser, int level, StringBuffer sb, int userId){
		for (ActionRole tmp : actionUser) {
			// 查询该用户是否已经和该角色存在对应关系
            ActionUserRole aur = new ActionUserRole();
            aur.setUserId(userId);
            aur.setRoleId(tmp.getId());
            int count = actionUserRoleService.selectUserRole(aur);
			if (count > 0) {
				sb.append("<li><a checked=\"true\" tname=\"name\" tvalue=\"").append(tmp.getId()).append("\" >").append(tmp.getRoleName()).append("</a></li>");
			} else {
				sb.append("<li><a tname=\"name\" tvalue=\"").append(tmp.getId()).append("\" >").append(tmp.getRoleName()).append("</a></li>");
			}
		}
		return sb.toString();
	}
	
}
