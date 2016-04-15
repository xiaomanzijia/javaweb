package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.CapitalinoutMapper;
import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.vo.CapitalinoutVO;

@Service
public class CapitalinoutService
{
    @Autowired
    private CapitalinoutMapper capitalinoutMapper;
    
    public int save(Capitalinout capitalinout)
    {
        return capitalinoutMapper.save(capitalinout);
    }

    public List<Capitalinout> select(CapitalinoutVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return capitalinoutMapper.queryByParam(vo);
    }

    public List<Capitalinout> queryByParam(Capitalinout capitalinout)
    {
        return capitalinoutMapper.queryByParam(capitalinout);
    }
    
    public Capitalinout queryByLock(int id)
    {
        return capitalinoutMapper.queryByLock(id);
    }
    
    public Capitalinout queryByTranNum(String tranNum)
    {
        return capitalinoutMapper.queryByTranNum(tranNum);
    }

    public int update(Capitalinout capitalinout)
    {
        return capitalinoutMapper.update(capitalinout);
    }
    
    public List<Capitalinout> queryUnPayAndTimeout()
    {
        return capitalinoutMapper.queryUnPayAndTimeout();
    }
	 /**
	  * 通过userid查询
	  */
    public Capitalinout selectByuserId(Integer userId)
    {
        return capitalinoutMapper.selectByuserId(userId);
    }
}
