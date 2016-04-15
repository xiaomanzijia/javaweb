package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ProjectFeedbackMapper;
import com.lsgx.admin.model.ProjectFeedback;
import com.lsgx.admin.model.vo.ProjectFeedbackVO;

@Service
public class ProjectFeedbackService
{
    @Autowired
    private ProjectFeedbackMapper projectFeedbackMapper;
    
    /**
     * 查询反馈信息列表
     * @param vo
     * @return 
     */
    public List<ProjectFeedback> select(ProjectFeedbackVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return projectFeedbackMapper.queryByParam(vo);
    }
    
    /**
     * 更新反馈信息
     * @param projectFeedback
     * @return 
     */
    public int update(ProjectFeedback projectFeedback)
    {
        return projectFeedbackMapper.update(projectFeedback);
    }
    
    /**
     * 通过id查询反馈信息
     * @param id
     * @return 
     */
    public ProjectFeedback queryById(Integer id)
    {
        return projectFeedbackMapper.queryById(id);
    }
    
    /**
     * 保存反馈信息
     * @param projectFeedback
     * @return 
     */
    public int save(ProjectFeedback projectFeedback){
    	
    	return projectFeedbackMapper.save(projectFeedback);
    }
    
    /**
     * 通过审核人id查询
     * @param audit
     * @return 
     */
    public ProjectFeedback queryByAudit(Integer audit){
    	
    	return projectFeedbackMapper.queryByAudit(audit);
    }
}
