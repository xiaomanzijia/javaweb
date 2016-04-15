package com.lsgx.admin.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.UserCard;

@Repository
public interface UserCardMapper extends BaseMapper<UserCard>
{
    UserCard queryUserCardByCard(String card, Integer userId);
    
    //通过卡号查询
    UserCard selectByCard(Map<String, Object> map);
    
}
