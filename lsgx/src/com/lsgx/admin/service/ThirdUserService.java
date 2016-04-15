package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ThirdUserMapper;
import com.lsgx.admin.model.ThirdUser;
import com.lsgx.admin.model.vo.ThirdUserVO;

@Service
public class ThirdUserService
{
    @Autowired
    private ThirdUserMapper thirdUserMapper;
    
    public List<ThirdUser> findByCondition(ThirdUserVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        
        return thirdUserMapper.queryByParam(vo);
    }
}
