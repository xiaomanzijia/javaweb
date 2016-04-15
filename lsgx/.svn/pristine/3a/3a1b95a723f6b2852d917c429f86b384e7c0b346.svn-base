package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.SystemLogMapper;
import com.lsgx.admin.model.SystemLog;
import com.lsgx.admin.model.vo.LogQueryVO;

@Service("systemLogService")
public class SystemLogService
{
    @Autowired
    private SystemLogMapper systemLogMapper;

    SystemLogService(){
        System.out.println(" SystemLogService created" );
    }
    
    public void save(SystemLog log)
    {
        systemLogMapper.save(log);
    }
    
    public List<SystemLog> findAll()
    {
        return systemLogMapper.findAll();
    }

    public List<SystemLog> findByCondition(LogQueryVO logQueryVO)
    {
        PageHelper.startPage(logQueryVO.getPageNum(), logQueryVO.getNumPerPage());
        return systemLogMapper.findByCondition(logQueryVO);
    }

}

