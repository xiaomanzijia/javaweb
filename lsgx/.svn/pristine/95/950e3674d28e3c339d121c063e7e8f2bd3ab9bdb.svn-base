package com.lsgx.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsgx.admin.mapper.ActionUserRoleMapper;
import com.lsgx.admin.model.ActionUserRole;

/**
 *  用户登录服务层 service
 * @author dell
 */
@Service("actionUserRoleService")
public class ActionUserRoleService {
	
	@Autowired
	private ActionUserRoleMapper actionUserRoleMapper;
	
    public ActionUserRole queryUserRole(ActionUserRole actionUserRole)
    {
        return actionUserRoleMapper.queryUserRole(actionUserRole);
    }
	/**
	 * 用户角色信息查询
	 * @return 用户角色总条数
	 */
	public int selectUserRole(ActionUserRole u){
		return actionUserRoleMapper.selectUserRole(u);
	}
	
	/**
	 * 删除用户角色关联信息
	 * @param id
	 */
	public void userRoleDelete(int id){
		actionUserRoleMapper.userRoleDelete(id);
	}
	
	/**
	 * 新增用户角色关联信息
	 * @param u
	 */
	public void userRoleAdd(ActionUserRole u){
		actionUserRoleMapper.userRoleAdd(u);
	}
	
	/**
	 * 删除用户角色关联
	 * @param id
	 */
	public void userDeleteId(int id){
		actionUserRoleMapper.userDeleteId(id);
	}
}
