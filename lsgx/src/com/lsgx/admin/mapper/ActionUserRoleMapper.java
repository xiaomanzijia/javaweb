package com.lsgx.admin.mapper;

import com.lsgx.admin.model.ActionUserRole;

/**
 * 用户角色关联
 * @author dell
 */
public interface ActionUserRoleMapper {
    ActionUserRole queryUserRole(ActionUserRole actionUserRole);
	//用户角色管理查询
	int selectUserRole(ActionUserRole u);
	//删除
	void userRoleDelete(int id);
	//新增
	void userRoleAdd(ActionUserRole u);
	//删除用户角色关联
	void userDeleteId(int id);
}
