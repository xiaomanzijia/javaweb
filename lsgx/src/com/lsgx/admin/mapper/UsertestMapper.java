package com.lsgx.admin.mapper;

import com.github.pagehelper.Page;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.UsertestExample;
import java.util.List;

import com.lsgx.admin.model.vo.ActionUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsertestMapper {

    //用户列表查询
    List<Usertest> queryUserTestList(Usertest vo);
    //用户列表总数查询
    int queryUserTestListCount(Page<Usertest> page);

    void userEditOk(Usertest u);

    void userEditBfileId(Usertest u);

    int countByExample(UsertestExample example);

    int deleteByExample(UsertestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usertest record);

    int insertSelective(Usertest record);

    List<Usertest> selectByExample(UsertestExample example);

    Usertest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usertest record, @Param("example") UsertestExample example);

    int updateByExample(@Param("record") Usertest record, @Param("example") UsertestExample example);

    int updateByPrimaryKeySelective(Usertest record);

    int updateByPrimaryKey(Usertest record);
}