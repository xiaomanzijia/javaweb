package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ActionRoleMapper;
import com.lsgx.admin.model.ActionRole;
import com.lsgx.admin.model.vo.ActionRoleVO;
/**
 *  角色服务层 service
 * @author dell
 */
@Service("actionRoleService")
public class ActionRoleService {
	
	@Autowired
	private ActionRoleMapper actionRoleMapper;
	
	/**
	 * 角色列表查询
	 * @param page
	 * @return 角色列表信息
	 */
    public List<ActionRole> queryRoleList(ActionRoleVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return actionRoleMapper.queryRoleList(vo);
	}
	
	/**
	 * 角色列表总数查询
	 * @return
	 */
	public int queryRoleListCount(Page<ActionRole> page){
		return actionRoleMapper.queryRoleListCount(page);
	}
	
	/**
	 * 角色新增
	 * @param u
	 */
	public void roleAdd(ActionRole u){
		actionRoleMapper.roleAdd(u);
	}
	
	/**
	 * 角色信息修改
	 * @param id
	 * @return
	 */
	public ActionRole roleEdit(int id){
		return actionRoleMapper.roleEdit(id);
	}
	
	/**
	 * 角色修改信息保存
	 * @param u
	 */
	public void roleEditOk(ActionRole u){
		actionRoleMapper.roleEditOk(u);
	}
	
	/**
	 * 角色信息删除
	 * @param id
	 */
	public void roleDelete(int id){
		actionRoleMapper.roleDelete(id);
	}
	
	/**
	 * 分配角色--查询全部角色信息
	 * @param isAdmin 0：超管群组，1：普通群组
	 * @return
	 */
	public List<ActionRole> selectRoleList(int isAdmin){
		return actionRoleMapper.selectRoleList(isAdmin);
	}
}
