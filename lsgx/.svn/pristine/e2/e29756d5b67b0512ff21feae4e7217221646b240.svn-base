package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ProjectMapper;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.vo.ProjectQueryVO;

@Service
public class ProjectService
{
    @Autowired
    private ProjectMapper projectMapper;
    
    public List<Project> select(ProjectQueryVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return projectMapper.select(vo);
    }
    
    public int update(Project project)
    {

        return projectMapper.update(project);
    }
    
    public int save(Project project)
    {
        
        return projectMapper.save(project);
    }

    public Project queryByLock(Integer id)
    {
        return projectMapper.queryByLock(id);
    }
    
    public Project queryById(Integer id)
    {
        return projectMapper.queryById(id);
    }
    /**
     * 查询募捐完成或截止时间到了的项目
     * */
    public List<Project> selectOutofDeadline(){
    	return projectMapper.selectOutofDeadline();
    }
    /**
     * 查询善管家手动终止的项目
     * */
    public List<Project> selectEndProject(){
    	return projectMapper.selectEndProject();
    }
}
