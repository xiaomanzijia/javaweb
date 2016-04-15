package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ProjectScheduleMapper;
import com.lsgx.admin.model.ProjectSchedule;
import com.lsgx.admin.model.vo.ProjectScheduleVO;

@Service
public class ProjectScheduleService
{
    @Autowired
    private ProjectScheduleMapper projectScheduleMapper;
    
    public int save(ProjectSchedule projectSchedule)
    {
        
        return projectScheduleMapper.save(projectSchedule);
    }
    
    public int update(ProjectSchedule projectSchedule)
    {
        
        return projectScheduleMapper.update(projectSchedule);
    }

    public ProjectSchedule queryById(Integer id)
    {
        return projectScheduleMapper.queryById(id);
    }
    
    public List<ProjectSchedule> select(ProjectScheduleVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return projectScheduleMapper.queryByParam(vo);
    }
}
