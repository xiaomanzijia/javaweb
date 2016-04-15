package com.lsgx.admin.model.vo;

import com.lsgx.admin.model.Area;

public class AreaVO extends Area
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -8583395693644011203L;
    
    public final static int PAGE_SHOW_COUNT = 20;
    
    private int pageNum = 1;
    
    private int numPerPage = 0;
    
    private String orderField;
    
    private String orderDirection;
    
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
