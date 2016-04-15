package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.CompanyGoodHelpMapper;
import com.lsgx.admin.mapper.DonateRecordMapper;
import com.lsgx.admin.model.CompanyGoodHelp;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.vo.CompanyGoodHelpVO;
import com.lsgx.admin.util.Constant;

@Service
public class CompanyGoodHelpService
{
    @Autowired
    private CompanyGoodHelpMapper companyGoodHelpMapper;
    
    @Autowired
    private DonateRecordMapper donateRecordMapper;
    
    public List<CompanyGoodHelp> queryCompanyGoodHelpList(CompanyGoodHelpVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        List<CompanyGoodHelp> list = companyGoodHelpMapper.queryByParam(vo);
        DonateRecord donate = null;
        for (CompanyGoodHelp help : list)
        {
            if (help.getProject_id() != null)
            {
                donate = new DonateRecord();
                donate.setProjectId(help.getProject_id());
                donate.setDonatType(Constant.ENTERPRISE_DONATION);
                
                donate = donateRecordMapper.countByParam(donate);
            }
            if (donate.getGoodHelpAmount() != null)
            {
                help.setGoodHelpAmount(donate.getGoodHelpAmount());
            }
            if (donate.getGoodHelpCount() != null)
            {
                help.setGoodHelpCount(donate.getGoodHelpCount());
            }
        }
        
        return list;
    }
    
    public void updateCompanyGoodHelp(CompanyGoodHelp goodHelp)
    {
        companyGoodHelpMapper.update(goodHelp);
    }
    
    public CompanyGoodHelp queryById(int id)
    {
        return companyGoodHelpMapper.queryById(id);
    }
    /**
     * 查询未付款或超时任务
     */
    public List<CompanyGoodHelp> queryUnPayAndTimeout(){
    	return companyGoodHelpMapper.queryUnPayAndTimeout();
    }
    
    /**
     * 通过用户id查询记录
     */
    public CompanyGoodHelp selectByuserId(int userId){
    	return companyGoodHelpMapper.selectByUserid(userId);
    }
    
    /**
     * 通过一些参数查询数据列表
     */
    public List<CompanyGoodHelp> queryByParam(CompanyGoodHelpVO companyGoodHelpVO){
    	return companyGoodHelpMapper.queryByParam(companyGoodHelpVO);
    }
}
