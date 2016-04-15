package com.lsgx.admin.mapper;

import com.lsgx.admin.model.Testname;
import com.lsgx.admin.model.TestnameExample;
import java.util.List;

import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.vo.NameTestVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestnameMapper {
    List<Testname> queryUserTestList(Testname vo);

    int countByExample(TestnameExample example);

    int deleteByExample(TestnameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Testname record);

    int insertSelective(Testname record);

    List<Testname> selectByExample(TestnameExample example);

    Testname selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Testname record, @Param("example") TestnameExample example);

    int updateByExample(@Param("record") Testname record, @Param("example") TestnameExample example);

    int updateByPrimaryKeySelective(Testname record);

    int updateByPrimaryKey(Testname record);
}