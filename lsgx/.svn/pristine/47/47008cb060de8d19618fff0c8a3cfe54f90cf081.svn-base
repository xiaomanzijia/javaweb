package com.lsgx.admin.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.lsgx.admin.model.ActionFunction;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.vo.ActionFunctionVO;
import org.springframework.stereotype.Repository;

/**
 * 菜单表 Mapper
 * @author dell
 */
@Repository
public interface ActionFunctionMapper {
	/**菜单查询*/
    List<ActionFunction> queryFunctionList(ActionFunctionVO vo);
	/**菜单列表总数查询*/
	int queryFunctionListCount(Page<ActionFunction> page);
	/**添加*/
	void functionAdd(ActionFunction u);
	/**获取父类*/
	ActionFunction functionEditParentFun(int id);
	/**修改*/
	ActionFunction functionEdit(int id);
	/**修改保存*/
	void functionEditOk(ActionFunction u);
	/**删除*/
	void functionDelete(int id);
	/**分配权限__查找全部权限*/
	List<ActionFunction> selectRoleFunList();
	
	/**用户登录初始化菜单权限*/
    List<ActionFunction> indexUserFunParam(ActionUser user);
	/**初始化菜单按钮权限*/
	List<ActionFunction> functionListTo(int id);
}
