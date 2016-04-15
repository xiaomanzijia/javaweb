package com.lsgx.admin.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.lsgx.admin.model.ActionRole;
import com.lsgx.admin.model.vo.ActionRoleVO;
/**
 * 角色表 Mapper
 * @author dell
 */
public interface ActionRoleMapper {
	//查询角色列表信息
    List<ActionRole> queryRoleList(ActionRoleVO vo);
	//查询角色列表信息总数
	int queryRoleListCount(Page<ActionRole> page);
	//添加
	void roleAdd(ActionRole u);
	//修改
	ActionRole roleEdit(int id);
	//修改保存
	void roleEditOk(ActionRole u);
	//删除
	void roleDelete(int id);
	//分配角色--查询全部角色信息
	List<ActionRole> selectRoleList(int isAdmin);
}
