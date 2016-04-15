package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

import com.lsgx.admin.controller.user.vo.LoveGroupFile;

/**
 * 人员审核表
 */

public class AuditStaff extends BaseBean implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -8208274837512602545L;
    
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 状态 200：未提交 201：未审核 202：未通过 203通过
     */
    private Integer state;
    /**
     * 需要审核的资料
     */
    private String fileId;
    /**
     * 审核内容
     */
    private String reviewContent;
    /**
     * 审核内容的省略写
     */
    private String reviewContentShort;
    /**
     * 审核人员类型 helpPeople：实名审核， loveGroup：爱心团审核,company:企业审核
     */
    private String personType;
    /**
     * 审核时间
     */
    private Date reviewTime;
    /**
     * 审核人id
     */
    private Integer reviewPerson;
    
    private String userName;
    
    private String realName;
    /**
     * 审核人姓名  action_user表中的realName
     */
    private String reviewPersonName;

    private LoveGroupFile loveGroupFile;
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
    
    public Integer getState()
    {
        return state;
    }
    
    public void setState(Integer state)
    {
        this.state = state;
    }
    
    public String getFileId()
    {
        return fileId;
    }
    
    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }
    
    public String getReviewContent()
    {
        return reviewContent;
    }
    
    public void setReviewContent(String reviewContent)
    {
        this.reviewContent = reviewContent;
    }
    
    public String getPersonType()
    {
        return personType;
    }
    
    public void setPersonType(String personType)
    {
        this.personType = personType;
    }
    
    public Date getReviewTime()
    {
        return reviewTime;
    }
    
    public void setReviewTime(Date reviewTime)
    {
        this.reviewTime = reviewTime;
    }
    
    public Integer getReviewPerson()
    {
        return reviewPerson;
    }
    
    public void setReviewPerson(Integer reviewPerson)
    {
        this.reviewPerson = reviewPerson;
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

    public String getReviewPersonName()
    {
        return reviewPersonName;
    }
    
    public void setReviewPersonName(String reviewPersonName)
    {
        this.reviewPersonName = reviewPersonName;
    }

    public LoveGroupFile getLoveGroupFile()
    {
        return loveGroupFile;
    }
    
    public void setLoveGroupFile(LoveGroupFile loveGroupFile)
    {
        this.loveGroupFile = loveGroupFile;
    }

    public String getReviewContentShort()
    {
        return reviewContentShort;
    }
    
    public void setReviewContentShort(String reviewContentShort)
    {
        this.reviewContentShort = reviewContentShort;
    }

}
