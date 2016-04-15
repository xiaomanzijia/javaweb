package com.lsgx.admin.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.vo.ActionUserVO;

/**
 * 用户表 Mapper
 * @author dell
 *
 */
public interface ActionUserMapper {
	//用户登录查询
	ActionUser queryUser(ActionUser u);
	//用户列表查询
    List<ActionUser> queryUserList(ActionUserVO vo);
	//用户列表总数查询
	int queryUserListCount(Page<ActionUser> page);
	//添加
	void userAdd(ActionUser u);
	//修改
	ActionUser userEdit(int id);
	//修改保存
	void userEditOk(ActionUser u);
	//删除
	void userDelete(int id);
	
	//分配用户__查找全部用户
	List<ActionUser> selectRoleUserList(int createname);
	//用户初始化密码
	void userInit(ActionUser u);
	//用户修改状态
	void userStatus(ActionUser u);
	//通过id查询
	ActionUser queryById(int id);
}
