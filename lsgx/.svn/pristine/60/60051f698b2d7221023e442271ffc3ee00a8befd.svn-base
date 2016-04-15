package com.lsgx.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.CompanyMapper;
import com.lsgx.admin.model.Company;
import com.lsgx.admin.model.vo.CompanyVO;

@Service("companyService")
public class CompanyService
{
    @Autowired
    private CompanyMapper companyMapper;
    
    public int save(Company company)
    {
        company.setLastUpdateTime(new Date());
        return companyMapper.save(company);
    }

    public int updateCompany(Company company)
    {
        company.setLastUpdateTime(new Date());
        return companyMapper.update(company);
    }
    
    public List<Company> queryCompanyList(CompanyVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        
        List<Company> list = companyMapper.queryByParam(vo);
        
        return list;
    }
    
    public Company queryByCompany(Company company)
    {
        return companyMapper.queryByCompany(company);
    }
    
    public Company queryByCompanyName(String name)
    {
        return companyMapper.queryByCompanyName(name);
    }
    
    public Company queryByLock(Integer id)
    {
        return companyMapper.queryByLock(id);
    }
}
