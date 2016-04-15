package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.SystemNotifyMapper;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.SystemNotifyVO;

@Service("SystemNotifyService")
public class SystemNotifyService {
	
	@Autowired
	private SystemNotifyMapper systemNotifyMapper;
	
	/**
	 * 通过id查询
	 * */
	public SystemNotify queryById(int id){
		
		return systemNotifyMapper.queryById(id);
	}
	
	/**
	 * 添加通告消息
	 * */
	public void notifyAdd(SystemNotify sNotify){
		systemNotifyMapper.notifyAdd(sNotify);
	}
	
	/**
	 * 通过参数查询通告列表
	 * */
	public List<SystemNotifyVO> selectByParam(SystemNotifyVO sVo){
		PageHelper.startPage(sVo.getPageNum(), sVo.getNumPerPage());
		return systemNotifyMapper.selectByParam(sVo);
	}
	
	/**
	 * 查询通告列表
	 * */
	public List<SystemNotify> queryByParam(SystemNotifyVO sVo){
		PageHelper.startPage(sVo.getPageNum(), sVo.getNumPerPage());
		return systemNotifyMapper.queryByParam(sVo);
	}
	
	/**
	 * 更新数据
	 * */
	public int update(SystemNotify sNotify){
		return systemNotifyMapper.update(sNotify);
	}
	

}
