package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.LoveGroupMentMapper;
import com.lsgx.admin.model.LoveGroupMent;
import com.lsgx.admin.model.vo.LoveGroupMentQueryVO;

@Service
public class LoveGroupMentService
{
    @Autowired
    private LoveGroupMentMapper loveGroupMentMapper;
    
    public List<LoveGroupMent> select(LoveGroupMentQueryVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return loveGroupMentMapper.select(vo);
    }
    
    public void addLoveGroupMent(LoveGroupMent loveGroupMent)
    {
        loveGroupMentMapper.addLoveGroupMent(loveGroupMent);
    }
    
    public void updateLoveGroupMent(LoveGroupMent loveGroupMent)
    {
        loveGroupMentMapper.updateLoveGroupMent(loveGroupMent);
    }
}
