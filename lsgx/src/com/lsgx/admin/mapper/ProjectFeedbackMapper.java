package com.lsgx.admin.mapper;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.ProjectFeedback;

@Repository
public interface ProjectFeedbackMapper extends BaseMapper<ProjectFeedback>
{
	/**
	 * 通过审核人的id查询
	 * @param audit
	 * @return
	 */
	public ProjectFeedback queryByAudit(Integer audit);
	
}
