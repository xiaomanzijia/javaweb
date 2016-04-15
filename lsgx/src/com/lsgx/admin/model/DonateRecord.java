package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 捐款记录表
 * @author phx
 *
 */

public class DonateRecord extends BaseBean implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 5035342795837651518L;
    
    private Integer id;
    
    private Integer userId;

    private Integer capitalinoutId;
    
    private Integer projectId;
    
    private String donorType;
    
    private String outDonor;
    
    private Double donatAmount;
    
    /**
     * 认捐份数
     */
    private Integer donateCopies;

    private Integer state;
    
    private Date donatTime;
    
    private String donatType;
    
    private Integer companyId;
    
    private Integer monthDonatId;
    
    private Integer donateTog;

    private String projectTitle;
    
    private String userName;
    
    private String leaveWord;

    /** 
     * 交易号
     */
    private String tranNum;
    
    private Date queryStartTime;
    
    private Date queryEndTime;
    
    /**
     * 项目状态
     */
    private Integer pstate;
    
    /**
     * 项目进度 ：百分比
     */
    private Double percent;
    
    /**
     * 项目已募捐金额
     */
    private Double donatAmountpt;
    
    /**
     * 项目求救金额
     */
    private Double cryMoney;
    
    /**
     * 项目领域
     */
    private String field;
    
    /**
     * 来源
     */
    private String source;
    
    /**
     * 企业助善已号召人数
     */
    private Integer goodHelpCount;
    
    /**
     * 企业助善已助善金额
     */
    private Double goodHelpAmount;
    /**
     * 游客留下的信息 有姓名和电话
     */
    private String touristMessage;
    /**
     * 游客捐款时留下的姓名
     */
    private String name;
    /**
     *游客捐款时留下的电话
     */
    private String mobile;

    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public Integer getGoodHelpCount()
    {
        return goodHelpCount;
    }
    
    public void setGoodHelpCount(Integer goodHelpCount)
    {
        this.goodHelpCount = goodHelpCount;
    }
    
    public Double getGoodHelpAmount()
    {
        return goodHelpAmount;
    }
    
    public void setGoodHelpAmount(Double goodHelpAmount)
    {
        this.goodHelpAmount = goodHelpAmount;
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
    
    public String getDonorType()
    {
        return donorType;
    }
    
    public void setDonorType(String donorType)
    {
        this.donorType = donorType;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getOutDonor()
    {
        return outDonor;
    }
    
    public void setOutDonor(String outDonor)
    {
        this.outDonor = outDonor;
    }
    
    public Double getDonatAmount()
    {
        return donatAmount;
    }
    
    public void setDonatAmount(Double donatAmount)
    {
        this.donatAmount = donatAmount;
    }
    
    public Integer getState()
    {
        return state;
    }
    
    public void setState(Integer state)
    {
        this.state = state;
    }
    
    public Date getDonatTime()
    {
        return donatTime;
    }
    
    public void setDonatTime(Date donatTime)
    {
        this.donatTime = donatTime;
    }
    
    public String getDonatType()
    {
        return donatType;
    }
    
    public void setDonatType(String donatType)
    {
        this.donatType = donatType;
    }
    
    public Integer getCompanyId()
    {
        return companyId;
    }
    
    public void setCompanyId(Integer companyId)
    {
        this.companyId = companyId;
    }
    
    public Integer getMonthDonatId()
    {
        return monthDonatId;
    }
    
    public void setMonthDonatId(Integer monthDonatId)
    {
        this.monthDonatId = monthDonatId;
    }
    
    public Integer getDonateTog()
    {
        return donateTog;
    }
    
    public void setDonateTog(Integer donateTog)
    {
        this.donateTog = donateTog;
    }

    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public Integer getDonateCopies()
    {
        return donateCopies;
    }
    
    public void setDonateCopies(Integer donateCopies)
    {
        this.donateCopies = donateCopies;
    }
    
    public String getProjectTitle()
    {
        return projectTitle;
    }
    
    public void setProjectTitle(String projectTitle)
    {
        this.projectTitle = projectTitle;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public String getLeaveWord()
    {
        return leaveWord;
    }
    
    public void setLeaveWord(String leaveWord)
    {
        this.leaveWord = leaveWord;
    }
    
    public Date getQueryStartTime()
    {
        return queryStartTime;
    }
    
    public void setQueryStartTime(Date queryStartTime)
    {
        this.queryStartTime = queryStartTime;
    }
    
    public Date getQueryEndTime()
    {
        return queryEndTime;
    }
    
    public void setQueryEndTime(Date queryEndTime)
    {
        this.queryEndTime = queryEndTime;
    }
    
    public String getTranNum()
    {
        return tranNum;
    }
    
    public void setTranNum(String tranNum)
    {
        this.tranNum = tranNum;
    }
    
    public Integer getPstate()
    {
        return pstate;
    }
    
    public void setPstate(Integer pstate)
    {
        this.pstate = pstate;
    }
    
    public Double getPercent()
    {
        return percent;
    }
    
    public void setPercent(Double percent)
    {
        this.percent = percent;
    }
    
    public Double getDonatAmountpt()
    {
        return donatAmountpt;
    }
    
    public void setDonatAmountpt(Double donatAmountpt)
    {
        this.donatAmountpt = donatAmountpt;
    }
    
    public Double getCryMoney()
    {
        return cryMoney;
    }
    
    public void setCryMoney(Double cryMoney)
    {
        this.cryMoney = cryMoney;
    }
    
    public String getField()
    {
        return field;
    }
    
    public void setField(String field)
    {
        this.field = field;
    }
    
    public String getTouristMessage() {
		return touristMessage;
	}

	public void setTouristMessage(String touristMessage) {
		this.touristMessage = touristMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
    public String toString()
    {
        return "DonateRecord [capitalinoutId=" + capitalinoutId + ", companyId=" + companyId + ", cryMoney=" + cryMoney
            + ", donatAmount=" + donatAmount + ", donatAmountpt=" + donatAmountpt + ", donatTime=" + donatTime
            + ", donatType=" + donatType + ", donateCopies=" + donateCopies + ", donateTog=" + donateTog
            + ", donorType=" + donorType + ", field=" + field + ", id=" + id + ", leaveWord=" + leaveWord
            + ", monthDonatId=" + monthDonatId + ", outDonor=" + outDonor + ", percent=" + percent + ", projectId="
            + projectId + ", projectTitle=" + projectTitle + ", pstate=" + pstate + ", queryEndTime=" + queryEndTime
            + ", queryStartTime=" + queryStartTime + ", source=" + source + ", state=" + state + ", tranNum=" + tranNum
            + ", userId=" + userId + ", userName=" + userName + "]";
    }
    
}
