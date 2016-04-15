package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.CompanyGoodHelp;
import com.lsgx.admin.model.vo.CompanyGoodHelpVO;

@Repository
public interface CompanyGoodHelpMapper extends BaseMapper<CompanyGoodHelp>
{
    public List<CompanyGoodHelp> queryUnPayAndTimeout();
    
    public CompanyGoodHelp selectByUserid(int userId);
    
    public List<CompanyGoodHelp> queryByParam(CompanyGoodHelpVO companyGoodHelpVO);
}
