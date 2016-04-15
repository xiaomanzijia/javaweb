package com.lsgx.admin.mapper;

import com.lsgx.admin.model.ActionRoleFun;

/**
 * 角色功能关联
 * @author dell
 */
public interface ActionRoleFunMapper {
	//角色功能管理查询
	int selectRoleFun(ActionRoleFun u);
	//删除角色功能
	void roleFunDelete(int id);
	//新增角色功能
	void roleFunAdd(ActionRoleFun u);
	//删除功能
	void funDelete(int id);
}
