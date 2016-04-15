package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.MessageModelMapper;
import com.lsgx.admin.model.MessageModel;
import com.lsgx.admin.model.vo.MessageModelVO;

@Service
public class MessageModelService
{
    @Autowired
    private MessageModelMapper messageModelMapper;
    
    public List<MessageModel> findByCondition(MessageModelVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        
        return messageModelMapper.findByCondition(vo);
    }
    
    public int save(MessageModel messageModel)
    {
        return messageModelMapper.save(messageModel);
    }
    
    public int delete(Integer id)
    {
        return messageModelMapper.delete(id);
    }
    
    public int update(MessageModel messageModel)
    {
        return messageModelMapper.update(messageModel);
    }
    
    public MessageModel queryById(int id)
    {
        return messageModelMapper.queryById(id);
    }
    
    public MessageModel queryByLock(int id)
    {
        return messageModelMapper.queryByLock(id);
    }
    
    public MessageModel queryByModelName(String modelName)
    {
        return messageModelMapper.queryByModelName(modelName);
    }
}
