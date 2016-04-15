package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.DonateRecordMapper;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.vo.DonateRecordVO;

@Service
public class DonateRecordService
{
    @Autowired
    private DonateRecordMapper donateRecordMapper;
    
    public List<DonateRecord> select(DonateRecordVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        List<DonateRecord> list = donateRecordMapper.queryByParam(vo);
        return list;
    }

    public List<DonateRecord> queryByDonate(DonateRecord donateRecord)
    {
        List<DonateRecord> list = donateRecordMapper.queryByDonate(donateRecord);
        return list;
    }
    
    public void update(DonateRecord donateRecord)
    {
        donateRecordMapper.update(donateRecord);
    }
    
    public int save(DonateRecord donateRecord){
    	return donateRecordMapper.save(donateRecord);
    }
}
