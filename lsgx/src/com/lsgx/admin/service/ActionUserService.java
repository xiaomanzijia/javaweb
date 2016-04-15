package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ActionUserMapper;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.vo.ActionUserVO;


/**
 *  用户登录服务层 service
 * @author dell
 */
@Service("actionUserService")
public class ActionUserService {
	
	@Autowired
	private ActionUserMapper actionUserMapper;
	
	/**
	 * 用户登录
	 * @param userName 登录名
	 * @param passWord 密码
	 * @return
	 */
	public ActionUser queryUser(String userName,String passWord){
		ActionUser user = new ActionUser();
        user.setUserName(userName);
		user.setPassword(passWord);
		return actionUserMapper.queryUser(user);
	}
	
	/**
	 * 用户列表查询
	 * @return 用户列表信息
	 */
    public List<ActionUser> queryUserList(ActionUserVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return actionUserMapper.queryUserList(vo);
	}
	
	/**
	 * 用户列表总数查询
	 * @return 用户列表总条数
	 */
	public int queryUserListCount(Page<ActionUser> page){
		return actionUserMapper.queryUserListCount(page);
	}
	
	/**
	 * 用户信息添加
	 * @param u
	 */
	public void userAdd(ActionUser u){
		actionUserMapper.userAdd(u);
	}
	
	/**
	 * 用户信息修改
	 * @param id
	 * @return ActionUser
	 */
	public ActionUser userEdit(int id){
		return actionUserMapper.userEdit(id);
	}
	
	/**
	 * 用户信息修改保存
	 * @param u
	 */
	public void userEditOk(ActionUser u){
		actionUserMapper.userEditOk(u);
	}
	
	/**
	 * 用户信息删除
	 * @param id
	 */
	public void userDelete(int id){
		actionUserMapper.userDelete(id);
	}
	
	/**
	 * 分配用户查询
	 * @return
	 */
	public List<ActionUser> selectRoleUserList(int createname){
		return actionUserMapper.selectRoleUserList(createname);
	}
	
	/**
	 * 用户初始化密码
	 * @param u
	 */
	public void userInit(ActionUser u){
		actionUserMapper.userInit(u);
	}
	
	/**
	 * 用户修改状态
	 * @param u
	 */
	public void userStatus(ActionUser u){
        if (u.getStatus() == 100)
        {
            u.setStatus(101);
        }
        else if (u.getStatus() == 101)
        {
            u.setStatus(100);
		}
		actionUserMapper.userStatus(u);
	}
	/**
	 * 通过id查询
	 * @param id
	 */
	public ActionUser queryById(int id){
		return actionUserMapper.queryById(id);
	}

}
