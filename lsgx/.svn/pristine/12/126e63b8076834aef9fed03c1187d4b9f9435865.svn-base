package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信和站内信模板表
 * @author zhuangjianyuan
 *
 */
public class MessageModel implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -3963277402494642421L;

    private String id;//模板ID
    
    private String modelName;//模板名称
    
    private String modelContext;//模板内容
    
    private Integer modelType;//模板类型，1短信，2站内信
    
    private Integer status;//状态100启用,101禁用
    
    private Date createTime;//创建时间
    
    private String note;//备注

    private Integer operator;//操作人
    
    /**
     * 操作人姓名 action_user表中的realName
     */
    private String operatorName;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getModelContext()
    {
        return modelContext;
    }

    public void setModelContext(String modelContext)
    {
        this.modelContext = modelContext;
    }

    public Integer getModelType()
    {
        return modelType;
    }

    public void setModelType(Integer modelType)
    {
        this.modelType = modelType;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
    
    public Integer getOperator()
    {
        return operator;
    }
    
    public void setOperator(Integer operator)
    {
        this.operator = operator;
    }

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
    
}
