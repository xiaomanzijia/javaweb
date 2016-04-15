package com.lsgx.admin.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.lsgx.admin.model.ActionFunction;
import com.lsgx.admin.model.ActionRole;
import com.lsgx.admin.model.ActionRoleFun;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.ActionUserRole;
import com.lsgx.admin.model.vo.ActionRoleVO;
import com.lsgx.admin.service.ActionFunctionService;
import com.lsgx.admin.service.ActionRoleFunService;
import com.lsgx.admin.service.ActionRoleService;
import com.lsgx.admin.service.ActionUserRoleService;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
/**
 * 角色 action
 * @author dell
 *
 */
@Controller
public class ActionRoleController extends BaseController{
	
	@Autowired //角色
	private ActionRoleService actionRoleService;
	@Autowired //用户
	private ActionUserService actionUserService;
	@Autowired //用户角色
	private ActionUserRoleService actionUserRoleService;
	@Autowired //权限
	private ActionFunctionService actionFunctionService;
	@Autowired //角色权限
	private ActionRoleFunService actionRoleFunService;
	//角色列表页面
    private static String actionRoleList = "ActionRole/actionRoleList";
	//角色添加页面
    private static String actionRoleAdd = "ActionRole/actionRoleAdd";
	//角色修改页面
    private static String actionRoleEdit = "ActionRole/actionRoleEdit";
	//角色用户关联页面
    private static String actionRoleUser = "ActionRole/actionRoleUser";
	//角色权限关联页面
    private static String actionRoleFun = "ActionRole/actionRoleFun";
	/**
	 * 角色列表信息查询  post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleList.do", method = RequestMethod.POST)
    @ActionLog(content = "查询角色列表")
    public String actionRoleListPost(ActionRoleVO vo,
			ModelMap model){
        List<ActionRole> roleList = actionRoleService.queryRoleList(vo);
        PageInfo<ActionRole> page = new PageInfo<ActionRole>(roleList);
		model.put("page", page);
        model.put("roleList", roleList);
        model.put("actionRole", vo);
        saveLogDetail(null);
		return actionRoleList;
	}
	
	/**
	 *  角色列表查询  get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleList.do", method = RequestMethod.GET)
    public String actionRoleListGet(ActionRoleVO vo,
			ModelMap model){
        return actionRoleListPost(vo, model);
	}
	
	/**
	 * 角色信息添加页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleAdd.do", method = RequestMethod.GET)
	public String actionRoleAddGet(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		
		return actionRoleAdd;
	}
	
	/**
	 * 角色信息添加保存
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleAdd.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "添加角色")
    public String actionRoleAddPost(ActionRole vo,
			ModelMap model){
        vo.setIsAdmin(1);
        vo.setCreateTime(new Date());
        saveLogDetail("添加角色信息：" + vo.toString());
        actionRoleService.roleAdd(vo);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", " add role success", "actionRoleList", "", "closeCurrent", ""));
	}
	
	/**
	 * 角色信息修改页面
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleEdit.do", method = RequestMethod.GET)
    public String actionRoleEditGet(ActionRole vo,
			ModelMap model){
        ActionRole role = actionRoleService.roleEdit(vo.getId());
		model.put("role", role);
		return actionRoleEdit;
	}
	
	/**
	 * 角色信息修改保存
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleEdit.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "修改角色")
    public String actionRoleEditPost(ActionRole role,
			ModelMap model){
		StringBuffer sb = new StringBuffer();
		sb.append("修改前：").append(actionRoleService.roleEdit(role.getId()).toString());
		role.setCreateTime(new Date());
		sb.append("\n修改后：").append(role.toString());
        saveLogDetail(sb.toString());
		actionRoleService.roleEditOk(role);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit role success", "actionRoleList", "", "closeCurrent", ""));
	}
	
	/**
	 * 角色信息删除
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleDelete.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "删除角色")
	public String actionRoleDeletePost(@RequestParam("id")int id,
			ModelMap model){
		ActionRole role = actionRoleService.roleEdit(id);
		if(role.getIsAdmin() == 0){
            saveLogDetail("超级管理员组信息不能删除.");
			return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this group is supergroup,can`t delete", "", "", "", ""));
		}
        saveLogDetail("删除角色信息：" + role.toString());
		//删除角色信息
		actionRoleService.roleDelete(id);
		//删除角色权限关联信息
		actionRoleFunService.roleFunDelete(id);
		//删除角色用户关联信息
		actionUserRoleService.userRoleDelete(id);
		return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "actionRoleList", "", "", ""));
	}
	
	/**
	 * 分配用户 保存Post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleUser.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "分配用户")
    public String actionRoleUserPost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String roleId = req.getParameter("roleId");
		String values = req.getParameter("values");
		//首先删除用户角色关联信息
		actionUserRoleService.userRoleDelete(Integer.parseInt(roleId));
		String[] value = values.split(",");
		if(value.length >0){
			for(String mp : value){
				ActionUserRole ur = new ActionUserRole();
				ur.setRoleId(Integer.parseInt(roleId));
				ur.setUserId(Integer.parseInt(mp));
				actionUserRoleService.userRoleAdd(ur);
			}
		}
        saveLogDetail("角色id：" + roleId + " \n分配用户id：" + values);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "give user success", "actionRoleList", "", "closeCurrent", ""));
	}
	
	/**
	 * 分配用户 get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleUser.do", method = RequestMethod.GET)
	public String actionRoleUserGet(HttpServletRequest req,HttpServletResponse resp,
			ModelMap model){
		String id = req.getParameter("id");
		ActionRole ar = actionRoleService.roleEdit(Integer.parseInt(id));
		List<ActionUser> user = actionUserService.selectRoleUserList(ar.getIsAdmin());
		model.put("roleId", id);
		model.put("actionStr", getUserRole(user, 0, new StringBuffer(), Integer.parseInt(id)));
		return actionRoleUser;
	}
	/**
	 * 分配用户信息列表
	 * @param actionUser 用户列表
	 * @param level 等级
	 * @param sb 返回字符串
	 * @param roleId 角色ID
	 * @return
	 */
	public String getUserRole(List<ActionUser> actionUser, int level, StringBuffer sb, int roleId){
		for (ActionUser tmp : actionUser) {
			// 查询该用户是否已经和该角色存在对应关系
            ActionUserRole aur = new ActionUserRole();
            aur.setId(tmp.getId());
            aur.setRoleId(roleId);
            int count = actionUserRoleService.selectUserRole(aur);
			if (count > 0) {
                sb.append("<li><a checked=\"true\" tname=\"name\" tvalue=\"")
                    .append(tmp.getId())
                    .append("\" >")
                    .append(tmp.getUserName())
                    .append("</a></li>");
			} else {
                sb.append("<li><a tname=\"name\" tvalue=\"")
                    .append(tmp.getId())
                    .append("\" >")
                    .append(tmp.getUserName())
                    .append("</a></li>");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 角色权限关联  Get
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleFun.do", method = RequestMethod.GET)
	public String actionRoleFunGet(HttpServletRequest req,HttpServletResponse resp,
			ModelMap model){
		String roleId = req.getParameter("id"); 
		List<ActionFunction> funList = actionFunctionService.selectRoleFunList();
		List<ActionFunction> acFunList = new ArrayList<ActionFunction>();
		for (ActionFunction tmp : funList) {
			if (tmp.getParentFun() == 0) {
				acFunList.add(tmp);
			}
			for (ActionFunction tmpp : funList) {
				if (tmp.getId() == tmpp.getParentFun()) {
					if (tmp.getActionFunctionlist() == null) {
						tmp.setActionFunctionlist(new ArrayList<ActionFunction>());
					}
					tmp.getActionFunctionlist().add(tmpp);
				}
			}
		}
		model.put("roleId", roleId);
		model.put("actionStr", getRoleStr(acFunList, 0, new StringBuffer(), Integer.parseInt(roleId)));
		return actionRoleFun;
	}
	
	/**
	 * 分配权限信息列表
	 * @param actionFunction 权限信息列表
	 * @param level 等级
	 * @param sb 返回字符串
	 * @param roleId 角色ID
	 * @return
	 */
	public String getRoleStr(List<ActionFunction> actionFunction, int level, StringBuffer sb, int roleId) {
		for (ActionFunction tmp : actionFunction) {
			int actionid = tmp.getId();
			String actionname = tmp.getFunName();
            ActionRoleFun arf = new ActionRoleFun();
            arf.setFunId(actionid);
            arf.setRoleId(roleId);
			// 查询该action是否已经和该角色存在对应关系
            int count = actionRoleFunService.selectRoleFun(arf);
			// 判断是否有子类
			List<ActionFunction> list = tmp.getActionFunctionlist();
			if (list != null && list.size() > 0) {
				sb.append("<li><a tname=\"name\" tvalue=\"").append(actionid).append("\" >").append(actionname).append("</a><ul>");
				this.getRoleStr(list, ++level, sb, roleId);
				sb.append("</ul></li>");
			} else {
				if (count > 0) {
					sb.append("<li><a checked=\"true\" tname=\"name\" tvalue=\"").append(actionid).append("\" >").append(actionname).append("</a></li>");
				} else {
					sb.append("<li><a tname=\"name\" tvalue=\"").append(actionid).append("\" >").append(actionname).append("</a></li>");
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 分配权限 保存Post
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/actionRoleFun.do", method = RequestMethod.POST)
	@ResponseBody
    @ActionLog(content = "分配权限")
    public String actionRoleFunPost(HttpServletRequest req, HttpServletResponse resp,
			ModelMap model){
		String roleId = req.getParameter("roleId");
		String values = req.getParameter("values");
		//首先删除用户角色关联信息
		actionRoleFunService.roleFunDelete(Integer.parseInt(roleId));
		String[] value = values.split(",");
		if(value.length >0){
			for(String mp : value){
				ActionRoleFun fun = new ActionRoleFun();
				fun.setRoleId(Integer.parseInt(roleId));
				fun.setFunId(Integer.parseInt(mp));
				actionRoleFunService.roleFunAdd(fun);
				// 递归新增父类权限
				insertParent(Integer.parseInt(roleId), Integer.parseInt(mp));
			}
		}
        saveLogDetail("角色id：" + roleId + " \n分配权限id：" + values);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "give role success", "actionRoleList", "", "closeCurrent", ""));
	}
	/**
	 * 新增父类权限
	 * @param roleId 角色ID
	 * @param funid 权限ID
	 */
	public void insertParent(int roleId, int funid){
		// 查询此权限
		ActionFunction function = actionFunctionService.functionEdit(funid);
		// 若此权限母类ID不为0则寻找母类并新增
		if (function != null) {
			// 判断此条映射是否已经存在
            ActionRoleFun arf = new ActionRoleFun();
            arf.setFunId(function.getParentFun());
            arf.setRoleId(roleId);
            int count = actionRoleFunService.selectRoleFun(arf);
			if (count == 0) {
				//ActionFunction func = actionFunctionService.FunctionEdit(parentid);
				ActionRoleFun fun = new ActionRoleFun();
				fun.setRoleId(roleId);
				fun.setFunId(function.getParentFun());
				actionRoleFunService.roleFunAdd(fun);
				// 递归调用
				insertParent(roleId, function.getParentFun());
			}
		}
	}
}
