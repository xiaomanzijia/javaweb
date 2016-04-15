package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.AreaMapper;
import com.lsgx.admin.model.Area;
import com.lsgx.admin.model.vo.AreaVO;

@Service
public class AreaService
{
    @Autowired
    private AreaMapper areaMapper;
    
    public List<Area> select(AreaVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return areaMapper.select(vo);
    }
    
    public void save(Area area)
    {
        areaMapper.save(area);
    }
    
    public int update(Area area)
    {
        return areaMapper.update(area);
    }
    
    public Area queryById(int id)
    {
        return areaMapper.queryById(id);
    }
    
    public List<Area> queryByParam(Area area)
    {
        return areaMapper.queryByParam(area);
    }

    public int delete(int id)
    {
        return areaMapper.delete(id);
    }
}
