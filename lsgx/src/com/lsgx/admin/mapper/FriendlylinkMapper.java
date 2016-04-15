package com.lsgx.admin.mapper;

import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.FriendlylinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendlylinkMapper {
    int countByExample(FriendlylinkExample example);

    int deleteByExample(FriendlylinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Friendlylink record);

    int insertSelective(Friendlylink record);

    List<Friendlylink> selectByExample(FriendlylinkExample example);

    Friendlylink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Friendlylink record, @Param("example") FriendlylinkExample example);

    int updateByExample(@Param("record") Friendlylink record, @Param("example") FriendlylinkExample example);

    int updateByPrimaryKeySelective(Friendlylink record);

    int updateByPrimaryKey(Friendlylink record);
}