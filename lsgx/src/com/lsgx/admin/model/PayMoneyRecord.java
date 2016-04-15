package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

public class PayMoneyRecord implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 5958889358415797931L;
    
    private Integer id;
    /**
     * 资金进出ID
     */
    private Integer capitalinoutId;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 打款金额
     */
    private Double panMoney;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 开户银行
     */
    private String recipientName;
    /**
     *接收银行 
     */
    private String recipientBankType;
    /**
     * 接收账号
     */
    private String account;
    /**
     * 打款时间
     */
    private Date payMoneyTime;
    /**
     *打款人 
     */
    private Integer operator;
    /**
     *打款人姓名 action_user表中的realName
     */
    private String operatorName;
    /**
     *申请人id 
     */
    private Integer userId;
    /**
     *申请人姓名 
     */
    private String userName;
    /**
     * 开户名可能已申请人姓名不一致
     */
    private String accountName;

    private String payNum;
    
    private String tranNum;
    
    private String payType;
    
    private String source;
    /**
     * 申请金额
     */
    private Double applyMoney;
    /**
     *收据id 
     */
    private String receiptImageId;
    /**
     * 申请时间
     */
    private Date createTime;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }
    
    public String getPayNum()
    {
        return payNum;
    }
    
    public void setPayNum(String payNum)
    {
        this.payNum = payNum;
    }
    
    public String getTranNum()
    {
        return tranNum;
    }
    
    public void setTranNum(String tranNum)
    {
        this.tranNum = tranNum;
    }
    
    public String getPayType()
    {
        return payType;
    }
    
    public void setPayType(String payType)
    {
        this.payType = payType;
    }
    
    public Integer getCapitalinoutId()
    {
        return capitalinoutId;
    }
    
    public void setCapitalinoutId(Integer capitalinoutId)
    {
        this.capitalinoutId = capitalinoutId;
    }
    
    public Integer getProjectId()
    {
        return projectId;
    }
    
    public void setProjectId(Integer projectId)
    {
        this.projectId = projectId;
    }
    
    public Double getPanMoney()
    {
        return panMoney;
    }
    
    public void setPanMoney(Double panMoney)
    {
        this.panMoney = panMoney;
    }
    
    public Integer getState()
    {
        return state;
    }
    
    public void setState(Integer state)
    {
        this.state = state;
    }
    
    public String getRecipientName()
    {
        return recipientName;
    }
    
    public void setRecipientName(String recipientName)
    {
        this.recipientName = recipientName;
    }
    
    public String getRecipientBankType()
    {
        return recipientBankType;
    }
    
    public void setRecipientBankType(String recipientBankType)
    {
        this.recipientBankType = recipientBankType;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    public Date getPayMoneyTime()
    {
        return payMoneyTime;
    }
    
    public void setPayMoneyTime(Date payMoneyTime)
    {
        this.payMoneyTime = payMoneyTime;
    }
    
    public Integer getOperator()
    {
        return operator;
    }
    
    public void setOperator(Integer operator)
    {
        this.operator = operator;
    }
    
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getApplyMoney() {
		return applyMoney;
	}

	public void setApplyMoney(Double applyMoney) {
		this.applyMoney = applyMoney;
	}

	public String getReceiptImageId() {
		return receiptImageId;
	}

	public void setReceiptImageId(String receiptImageId) {
		this.receiptImageId = receiptImageId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Override
    public String toString()
    {
        return "PayMoneyRecord [id=" + id + ", capitalinoutId=" + capitalinoutId + ", projectId=" + projectId
            + ", panMoney=" + panMoney + ", state=" + state + ", recipientName=" + recipientName
            + ", recipientBankType=" + recipientBankType + ", account=" + account + ", payMoneyTime=" + payMoneyTime
            + ", operator=" + operator + "]";
    }

}
