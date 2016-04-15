package com.lsgx.admin.model;

import java.io.Serializable;

/**
 * 员工
 */
public class Employee implements Serializable
{
    
    private static final long serialVersionUID = 8069925230886636079L;
    
    private Integer id;
    
    /**
     * 
     * 所属公司发起人id
     */
    private Integer company_userId;
    
    /**
     * 员工用户id
     */
    private Integer userId;
    
    /**
     * 员工账号
     */
    private String nickName;
    
    /**
     * 员工姓名
     */
    private String realName;
    
    /**
     * 公司名
     */
    private String companyName;
    
    /**
     * 公司所在省
     */
    private String province;
    
    /**
     * 所在市
     */
    private String city;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 职位
     */
    private String position;
    
    /**
     * 审核状态
     */
    private Integer state;
    
    /**
     * 善级
     */
    private Integer level;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public Integer getLevel()
    {
        return level;
    }
    
    public void setLevel(Integer level)
    {
        this.level = level;
    }
    
    public Integer getCompany_userId()
    {
        return company_userId;
    }
    
    public void setCompany_userId(Integer companyUserId)
    {
        company_userId = companyUserId;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public String getNickName()
    {
        return nickName;
    }
    
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }
    
    public String getRealName()
    {
        return realName;
    }
    
    public void setRealName(String realName)
    {
        this.realName = realName;
    }
    
    public String getCompanyName()
    {
        return companyName;
    }
    
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    
    public String getProvince()
    {
        return province;
    }
    
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public Integer getState()
    {
        return state;
    }
    
    public void setState(Integer state)
    {
        this.state = state;
    }
    
}
