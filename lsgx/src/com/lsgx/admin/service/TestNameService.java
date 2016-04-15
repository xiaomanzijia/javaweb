package com.lsgx.admin.service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.TestnameMapper;
import com.lsgx.admin.mapper.UserMapper;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.Testname;
import com.lsgx.admin.model.TestnameExample;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.vo.NameTestVO;
import com.lsgx.admin.model.vo.UserQueryVO;
import com.lsgx.admin.model.vo.UserTestVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestNameService
{
    @Autowired
    private TestnameMapper testnameMapper;


    
    public int countByExample(TestnameExample example) {
        
        return testnameMapper.countByExample(example) ;
    }

    
    public int deleteByExample(TestnameExample example) {
        return testnameMapper.deleteByExample(example) ;
    }

    
    public int deleteByPrimaryKey(Integer id) {
         return testnameMapper.deleteByPrimaryKey(id) ;
    }

    
    public int insert(Testname record) {
         return testnameMapper.insert(record);
    }

    
    public int insertSelective(Testname record) {
         return testnameMapper.insertSelective(record);
    }

    
    public List<Testname> selectByExample(TestnameExample example) {
        return testnameMapper.selectByExample(example);
    }

    
    public Testname selectByPrimaryKey(Integer id) {
        return testnameMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(@Param("record") Testname record, @Param("example") TestnameExample example) {
         return testnameMapper.updateByExampleSelective(record,example) ;
    }

    
    public int updateByExample(@Param("record") Testname record, @Param("example") TestnameExample example) {
         return testnameMapper.updateByExample(record,example) ;
    }

    
    public int updateByPrimaryKeySelective(Testname record) {
         return testnameMapper.updateByPrimaryKeySelective(record) ;
    }

    
    public int updateByPrimaryKey(Testname record) {
         return testnameMapper.updateByPrimaryKey(record) ;
    }
    public List<Testname> queryUserTestList(NameTestVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return testnameMapper.queryUserTestList(vo);
    }

}

