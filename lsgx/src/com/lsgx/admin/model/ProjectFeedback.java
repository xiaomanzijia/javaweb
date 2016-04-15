package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 项目反馈
 * @author phx
 *
 */

public class ProjectFeedback implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -5396723439483242758L;
    
    private Integer id;
    
    private Integer projectId;
    
    private Integer feedbackPeople;
    
    private String content;
    
    private String contentShort;

    private Date feedbackTime;
    
    private Integer audit;
    
    private Integer auditState;
    
    /**
     * 内容图片id
     */
    private String contentImageId;
    
    /**
     * 内容图片地址
     */
    private List<String> contentImageUrl;
    
    private String userName;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public Integer getProjectId()
    {
        return projectId;
    }
    
    public void setProjectId(Integer projectId)
    {
        this.projectId = projectId;
    }
    
    public Integer getFeedbackPeople()
    {
        return feedbackPeople;
    }
    
    public void setFeedbackPeople(Integer feedbackPeople)
    {
        this.feedbackPeople = feedbackPeople;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public Date getFeedbackTime()
    {
        return feedbackTime;
    }
    
    public void setFeedbackTime(Date feedbackTime)
    {
        this.feedbackTime = feedbackTime;
    }
    
    public Integer getAudit()
    {
        return audit;
    }
    
    public void setAudit(Integer audit)
    {
        this.audit = audit;
    }
    
    public Integer getAuditState()
    {
        return auditState;
    }
    
    public void setAuditState(Integer auditState)
    {
        this.auditState = auditState;
    }
    
    public String getContentImageId()
    {
        return contentImageId;
    }
    
    public void setContentImageId(String contentImageId)
    {
        this.contentImageId = contentImageId;
    }
    
    public List<String> getContentImageUrl()
    {
        return contentImageUrl;
    }
    
    public void setContentImageUrl(List<String> contentImageUrl)
    {
        this.contentImageUrl = contentImageUrl;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    @Override
    public String toString()
    {
        return "ProjectFeedback [id=" + id + ", projectId=" + projectId + ", feedbackPeople=" + feedbackPeople + ", content=" + content + ", feedbackTime=" + feedbackTime + ", audit=" + audit
            + ", auditState=" + auditState + "]";
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
