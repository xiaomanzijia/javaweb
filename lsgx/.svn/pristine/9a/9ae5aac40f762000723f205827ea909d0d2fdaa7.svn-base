package com.lsgx.admin.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.lsgx.admin.model.UserCard;

public class UserCardVO extends UserCard implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -6331887117176461199L;

    public final static int PAGE_SHOW_COUNT = 20;
    
    private int pageNum = 1;
    
    private int numPerPage = 0;
    
    private String orderField;
    
    private String orderDirection;
    /**
     * 前台用户名
     * */
    private String userName;
    
    /**
     * 开始时间 查询时用
     * */
    private Date startDate;
    
    /**
     * 截止时间  查询时用
     * */
    private Date endDate;
    
    public int getPageNum()
    {
        return pageNum;
    }
    
    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }
    
    public int getNumPerPage()
    {
        return numPerPage > 0 ? numPerPage : PAGE_SHOW_COUNT;
    }
    
    public void setNumPerPage(int numPerPage)
    {
        this.numPerPage = numPerPage;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    
    public Date getEndDate()
    {
        return endDate;
    }
    
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public String getOrderField()
    {
        return orderField;
    }

    public void setOrderField(String orderField)
    {
        this.orderField = orderField;
    }

    public String getOrderDirection()
    {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection)
    {
        this.orderDirection = orderDirection;
    }
}
