package com.lsgx.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsgx.admin.mapper.ActionRoleFunMapper;
import com.lsgx.admin.model.ActionRoleFun;
/**
 *  角色权限服务层 service
 * @author dell
 */
@Service("actionRoleFunService")
public class ActionRoleFunService {
	
	@Autowired
	private ActionRoleFunMapper actionRoleFunMapper;
	
	/**
	 * 角色权限信息查询
	 * @return 角色权限总条数
	 */
	public int selectRoleFun(ActionRoleFun u){
		return actionRoleFunMapper.selectRoleFun(u);
	}
	
	/**
	 * 删除权限关联信息
	 * @param id
	 */
	public void funDelete(int id){
		actionRoleFunMapper.funDelete(id);
	}
	
	/**
	 * 删除角色权限关联信息
	 * @param id
	 */
	public void roleFunDelete(int id){
		actionRoleFunMapper.roleFunDelete(id);
	}
	
	/**
	 * 新增角色权限关联信息
	 * @param u
	 */
	public void roleFunAdd(ActionRoleFun u){
		actionRoleFunMapper.roleFunAdd(u);
	}
}
