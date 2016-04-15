package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.LeaveWordMapper;
import com.lsgx.admin.model.LeaveWord;
import com.lsgx.admin.model.vo.LeaveWordVO;

@Service
public class LeaveWordService
{
    
    @Autowired
    private LeaveWordMapper leaveWordMapper;

    public List<LeaveWord> select(LeaveWordVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return leaveWordMapper.select(vo);
    }
    
    public void delete(int id)
    {
        leaveWordMapper.delete(id);
    }
}
