package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.vo.ProjectQueryVO;

@Repository
public interface ProjectMapper extends BaseMapper<Project>
{
    List<Project> select(ProjectQueryVO vo);
    
    List<Project> selectOutofDeadline();
    
    List<Project> selectEndProject();
}
