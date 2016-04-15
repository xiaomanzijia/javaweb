package com.lsgx.admin.service;

import com.lsgx.admin.mapper.FriendlylinkMapper;
import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.FriendlylinkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by lin on 2015/12/29.
 */
@Service
public class FriendlyLinkService {

    @Autowired
    private FriendlylinkMapper friendlylinkMapper;

    /**
     * 查询所有友情链接
     * @param friendlylinkExample
     * @return
     */
    public List<Friendlylink> queryFriendlyLink(FriendlylinkExample friendlylinkExample){
        return friendlylinkMapper.selectByExample(friendlylinkExample);
    }

    /**
     * 删除友情链接
     */
    public int deleteFriendlyLink(int id){
        return friendlylinkMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加友情链接
     */
    public int addFriendlyLink(Friendlylink link){
        return friendlylinkMapper.insert(link);
    }

    /**
     * 根据id获取友情链接
     */
    public Friendlylink queryFriendlyLinkById(int id){
        return friendlylinkMapper.selectByPrimaryKey(id);
    }

    /**
     * 编辑友情链接
     */
    public int editFriendlyLink(Friendlylink link){
        return friendlylinkMapper.updateByPrimaryKey(link);
    }
}
