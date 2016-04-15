package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

public class Announce extends BaseBean implements Serializable
{
    
    /**
    * 注释内容
    */
    
    private static final long serialVersionUID = 976089441809611394L;

    private Integer id;

    private Integer userId;

    /**
     * 手机号，邮箱
     */
    private String destination;

    /**
     * 发送原因
     */
    private String cause;
    
    private String causeShort;
    /**
     * 标题
     */
    private String title;
    
    private String titleShort;
    /**
     * 类型，1：短信，2：邮件
     */
    private Integer type;

    /**
     * 优先级:1-10, 1最高
     */
    private Integer priority;

    /**
     * 发送状态：100待发送， 200发送成，300发送失败
     */
    private Integer state;
    /**
     * 发送次数
     */
    private Integer tryCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 发送时所用的接口
     */
    private String sendType;
    /**
     * 发送内容
     */
    private String content;
    
    private String contentShort;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getCause()
    {
        return cause;
    }

    public void setCause(String cause)
    {
        this.cause = cause;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getPriority()
    {
        return priority;
    }

    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getTryCount()
    {
        return tryCount;
    }

    public void setTryCount(Integer tryCount)
    {
        this.tryCount = tryCount;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getSendTime()
    {
        return sendTime;
    }

    public void setSendTime(Date sendTime)
    {
        this.sendTime = sendTime;
    }

    public String getSendType()
    {
        return sendType;
    }

    public void setSendType(String sendType)
    {
        this.sendType = sendType;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getCauseShort()
    {
        return causeShort;
    }
    
    public void setCauseShort(String causeShort)
    {
        this.causeShort = causeShort;
    }
    
    public String getTitleShort()
    {
        return titleShort;
    }
    
    public void setTitleShort(String titleShort)
    {
        this.titleShort = titleShort;
    }

    public String getContentShort()
    {
        return contentShort;
    }
    
    public void setContentShort(String contentShort)
    {
        this.contentShort = contentShort;
    }

}