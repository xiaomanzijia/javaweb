package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.SystemLog;
import com.lsgx.admin.model.vo.LogQueryVO;

@Repository
public interface SystemLogMapper
{
    void save(SystemLog log);
    
    List<SystemLog> findAll();
    
    List<SystemLog> findByCondition(LogQueryVO logQueryVO);
}

