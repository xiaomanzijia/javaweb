package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ReportMapper;
import com.lsgx.admin.model.Report;
import com.lsgx.admin.model.vo.ReportVO;

@Service
public class ReportService
{
    @Autowired
    ReportMapper reportMapper;
    
    public List<Report> select(ReportVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return reportMapper.queryByParam(vo);
    }
    
    public void save(Report report)
    {
        reportMapper.save(report);
    }
    
    public void update(Report report)
    {
        reportMapper.update(report);
    }
    
    public Report queryById(int id)
    {
        return reportMapper.queryById(id);
    }
}
