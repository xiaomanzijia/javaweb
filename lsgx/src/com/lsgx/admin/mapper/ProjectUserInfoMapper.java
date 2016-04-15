package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.ProjectUserInfo;

@Repository
public interface ProjectUserInfoMapper extends BaseMapper<ProjectUserInfo>{
	
	/**
	 * 通过项目id查询相关的受助人、证明人、发布人
	 */
	public List<ProjectUserInfo> queryByProjectId(Integer projectId);

}
