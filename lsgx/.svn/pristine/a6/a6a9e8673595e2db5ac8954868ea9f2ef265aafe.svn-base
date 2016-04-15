package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 报告表
 * @author phx
 *
 */

public class Report extends BaseBean implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 6013876966816688893L;
    
    private Integer id;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 报告类型  1：调查报告 2：打款报告 3：考察报告 4：执行报告 5：关闭报告 6：执行进度     
     */
    private Integer type;
    /**
     * 报告内容
     */
    private String content;
    /**
     * 报告内容的省略写
     */
    private String contentShort;
    /**
     * 填写报告的人 id
     */
    private Integer reportPeople;
    /**
     * 操作时间
     */
    private Date operatorTime;
    /**
     * 填写报告人的姓名
     */
    private String reportPeopleName;
    
    /**
     * 内容图片id
     */
    private String contentImageId;
    
    /**
     * 内容图片地址
     */
    private List<String> contentImageUrl;
    
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
    
    public Integer getType()
    {
        return type;
    }
    
    public void setType(Integer type)
    {
        this.type = type;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public Date getOperatorTime()
    {
        return operatorTime;
    }
    
    public void setOperatorTime(Date operatorTime)
    {
        this.operatorTime = operatorTime;
    }
    
    public Integer getReportPeople()
    {
        return reportPeople;
    }
    
    public void setReportPeople(Integer reportPeople)
    {
        this.reportPeople = reportPeople;
    }
    
    public String getReportPeopleName()
    {
        return reportPeopleName;
    }
    
    public void setReportPeopleName(String reportPeopleName)
    {
        this.reportPeopleName = reportPeopleName;
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
    
    @Override
    public String toString()
    {
        return "Report [id=" + id + ", projectId=" + projectId + ", type=" + type + ", content=" + content + ", reportPeople=" + reportPeople + ", operatorTime=" + operatorTime + "]";
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
