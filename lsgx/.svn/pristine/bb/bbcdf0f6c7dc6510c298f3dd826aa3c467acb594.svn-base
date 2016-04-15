package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.PayMoneyRecordMapper;
import com.lsgx.admin.model.PayMoneyRecord;
import com.lsgx.admin.model.vo.PayMoneyRecordVO;

@Service
public class PayMoneyRecordService
{
    @Autowired
    private PayMoneyRecordMapper payMoneyRecordMapper;

    public void save(PayMoneyRecord payMoneyRecord)
    {
        payMoneyRecordMapper.save(payMoneyRecord);
    }
    
    public void update(PayMoneyRecord payMoneyRecord)
    {
        payMoneyRecordMapper.update(payMoneyRecord);
    }
    
    public List<PayMoneyRecord> select(PayMoneyRecordVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return payMoneyRecordMapper.select(vo);
    }
    
    public PayMoneyRecord queryById(int id)
    {
        return payMoneyRecordMapper.queryById(id);
    }
}
