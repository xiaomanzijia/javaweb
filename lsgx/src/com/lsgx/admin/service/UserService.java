package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.UserMapper;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.vo.UserQueryVO;

@Service("userService")
public class UserService
{
    @Autowired
    private UserMapper userMapper;
    
    public List<FrontUser> findByCondition(UserQueryVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        
        return userMapper.findByCondition(vo);
    }
    
    public int updateFrontUser(FrontUser user)
    {
        return userMapper.update(user);
    }
    
    public FrontUser queryById(int id)
    {
        return userMapper.queryById(id);
    }
    
    public FrontUser queryByLock(int id)
    {
        return userMapper.queryByLock(id);
    }

    /**
     * 根据用户查询前端用户
     * @param userName  用户名
     * @return 前端用户
     */
    public FrontUser getUserByUserName(String userName)
    {
        return userMapper.getUserByUserName(userName);
    }
    
    public void saveFrontUser(FrontUser frontUser)
    {
        userMapper.saveFrontUser(frontUser);
    }
    
    public void delete(Integer id)
    {
        userMapper.delete(id);
    }
}

