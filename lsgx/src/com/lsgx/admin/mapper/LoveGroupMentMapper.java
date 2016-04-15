package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.LoveGroupMent;
import com.lsgx.admin.model.vo.LoveGroupMentQueryVO;

@Repository
public interface LoveGroupMentMapper
{
    List<LoveGroupMent> select(LoveGroupMentQueryVO vo);
    
    public void addLoveGroupMent(LoveGroupMent loveGroupMent);
    
    public void updateLoveGroupMent(LoveGroupMent loveGroupMent);
}
