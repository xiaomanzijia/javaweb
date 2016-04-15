package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsgx.admin.mapper.ProjectUserInfoMapper;
import com.lsgx.admin.model.ProjectUserInfo;

@Service
public class ProjectUserInfoService {
	
	@Autowired
	private ProjectUserInfoMapper projectUserInfoMapper;
	
	public List<ProjectUserInfo> queryByProjectId(Integer projectId){
		
		return projectUserInfoMapper.queryByProjectId(projectId);
	}

}
