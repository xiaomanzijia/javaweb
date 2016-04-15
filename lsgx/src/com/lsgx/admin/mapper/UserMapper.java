package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.vo.UserQueryVO;

@Repository
public interface UserMapper extends BaseMapper<FrontUser>
{
    
    List<FrontUser> findByCondition(UserQueryVO vo);
    
    public FrontUser getUserByUserName(String userName);
    
    public void saveFrontUser(FrontUser frontUser);
}

