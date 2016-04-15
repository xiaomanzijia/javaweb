package com.lsgx.admin.mapper;

import java.util.List;

import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.SystemNotifyVO;

public interface SystemNotifyMapper extends BaseMapper<SystemNotify>{
	
	//获取通告列表
	//List<SystemNotifyVO> selectAll();
	//添加通告消息
	void notifyAdd(SystemNotify sNotify);
	//通过参数获取通告消息列表
	List<SystemNotifyVO> selectByParam(SystemNotifyVO sNotifyVO);

}
