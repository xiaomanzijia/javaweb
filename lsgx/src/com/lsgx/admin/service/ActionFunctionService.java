package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ActionFunctionMapper;
import com.lsgx.admin.model.ActionFunction;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.vo.ActionFunctionVO;
/**
 *  菜单服务层 service
 * @author dell
 */
@Service("actionFunctionService")
public class ActionFunctionService {
	
	@Autowired
	private ActionFunctionMapper actionFunctionMapper;
	
	/**
	 *  用户登录初始化菜单权限
	 * @param id
	 * @return
	 */
	public List<ActionFunction> indexList(ActionUser user){
        return actionFunctionMapper.indexUserFunParam(user);
	}
	
	/**
	 * 菜单列表查询
	 * @param page
	 * @return 菜单列表信息
	 */
    public List<ActionFunction> queryFunctionList(ActionFunctionVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return actionFunctionMapper.queryFunctionList(vo);
	}
	
	/**
	 * 菜单列表总数查询
	 * @return
	 */
	public int queryFunctionListCount(Page<ActionFunction> page){
		return actionFunctionMapper.queryFunctionListCount(page);
	}
	
	/**
	 * 菜单新增
	 * @param u
	 */
	public void functionAdd(ActionFunction u){
		actionFunctionMapper.functionAdd(u);
	}
	
	/**
	 * 获取单个权限信息父类
	 * @param id
	 * @return
	 */
	public ActionFunction functionEditParentFun(int id){
		return actionFunctionMapper.functionEditParentFun(id);
	}
	
	/**
	 * 菜单信息修改
	 * @param id
	 * @return
	 */
	public ActionFunction functionEdit(int id){
		return actionFunctionMapper.functionEdit(id);
	}
	
	/**
	 * 修改信息保存
	 * @param u
	 */
	public void functionEditOk(ActionFunction u){
		actionFunctionMapper.functionEditOk(u);
	}
	
	/**
	 * 菜单信息删除
	 * @param id
	 */
	public void functionDelete(int id){
		actionFunctionMapper.functionDelete(id);
	}
	/**
	 * 分配权限__查找全部权限
	 * @return
	 */
	public List<ActionFunction> selectRoleFunList(){
		return actionFunctionMapper.selectRoleFunList();
	}
	
	/**
	 * 初始化菜单按钮权限
	 * @param action
	 * @return
	 */
	public List<ActionFunction> functionUserList(ActionUser user){
		return actionFunctionMapper.functionListTo(user.getId());
	}

}
