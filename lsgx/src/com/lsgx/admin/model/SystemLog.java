package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class SystemLog extends BaseBean implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    /**
     * 用户等陆名
     */
    private String userName;
    
    /**
     * 真实姓名
     */
    private String realName;
    
    /**
     * 操作时间
     */
    private Date operateTime;
    
    /**
     * IP
     */
    private String IP;
    
    /**
     * 操作类型
     */
    private String operateType;
    
    /**
     * URL
     */
    private String url;
    
    /**
     * 操作内容
     */
    private String content;
    
    /**
     * 详情
     */
    private String details;
    
    /**
     * 详细显示
     */
    private String showDetails;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    
    public Date getOperateTime()
    {
        return operateTime;
    }
    
    public void setOperateTime(Date operateTime)
    {
        this.operateTime = operateTime;
    }
    
    public String getIP()
    {
        return IP;
    }
    
    public void setIP(String iP)
    {
        IP = iP;
    }
    
    public String getOperateType()
    {
        return operateType;
    }
    
    public void setOperateType(String operateType)
    {
        this.operateType = operateType;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getDetails()
    {
        return details;
    }
    
    public void setDetails(String details)
    {
        this.details = details;
    }
    
    public String getShowDetails()
    {
        if (StringUtils.isNotEmpty(this.details) && this.details.length() > 20)
        {
            return this.details.substring(0, 20) + "...";
        }
        else
        {
            showDetails = getDetails();
        }
        return showDetails;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getRealName()
    {
        return realName;
    }
    
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

}
