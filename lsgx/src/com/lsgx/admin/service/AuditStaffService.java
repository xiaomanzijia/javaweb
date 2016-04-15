package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.AuditStaffMapper;
import com.lsgx.admin.model.AuditStaff;
import com.lsgx.admin.model.vo.AuditStaffQueryVO;

@Service("auditStaffService")
public class AuditStaffService
{
    @Autowired
    private AuditStaffMapper auditStaffMapper;
    
    public List<AuditStaff> findByCondition(AuditStaffQueryVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        
        return auditStaffMapper.findByCondition(vo);
    }
    
    public AuditStaff findById(int id)
    {
        return auditStaffMapper.findById(id);
    }
    
    public AuditStaff updateAuditStaff(AuditStaff auditStaff)
    {
        return auditStaffMapper.updateAuditStaff(auditStaff);
    }
}

