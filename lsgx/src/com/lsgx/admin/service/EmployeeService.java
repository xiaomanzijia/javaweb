package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.EmployeeMapper;
import com.lsgx.admin.model.Employee;
import com.lsgx.admin.model.vo.EmployeeVO;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeMapper employeeMapper;
    
    public List<Employee> select(EmployeeVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return employeeMapper.queryByParam(vo);
    }

    public Employee queryEmployeeById(Integer id)
    {
        return employeeMapper.queryById(id);
    }
    
    public void saveEmployee(Employee employee)
    {
        employeeMapper.save(employee);
    }
    
    public void updateEmployee(Employee employee)
    {
        employeeMapper.update(employee);
    }
}
