package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.AuditStaff;
import com.lsgx.admin.model.vo.AuditStaffQueryVO;

@Repository
public interface AuditStaffMapper
{
    
    List<AuditStaff> findByCondition(AuditStaffQueryVO vo);
    
    AuditStaff findById(int id);
    
    public AuditStaff updateAuditStaff(AuditStaff auditStaff);
}

