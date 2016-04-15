package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Project extends BaseBean implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -3737314003232993609L;
    
    private Integer id;
    
    /**
     * 领域
     */
    private String field;
    
    /**
     * 项目类型
     */
    private String type;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 内容
     */
    private String content;
    
    /**
     * 所在地
     */
    private String location;
    
    /**
     * 详细地址
     */
    private String detailAddress;
    
    /**
     * 求救金额
     */
    private Double cryMoney;
    
    /**
     * 你的身份
     */
    private String identity;
    
    /**
     * 求救人信息
     */
    private String information;
    
    /**
     * 收款方式
     */
    private String payMethod;
    
    /**
     * 开户人姓名
     */
    private String accountName;
    
    /**
     * 开户银行
     */
    private String accountBank;
    
    /**
     * 收款号码
     */
    private String collectNum;
    
    /**
     * 已募捐金额
     */
    private Double donatAmount;
    
    /**
     * 已打款金额
     */
    private Double panyAmount;
    
    /**
     * 状态
     */
    private Integer state;
    
    /**
     * 注册时间
     */
    private Date registrTime;
    
    /**
     * 是否热门  0：非热门  1：热门
     */
    private Integer hot;
    
    /**
     * 最后一次更新时间
     */
    private Date lastUpdateTime;
    
    /**
     * 负责人
     */
    private Integer head;
    
    /**
     * 排序
     */
    private Integer sort;
    
    /**
     * 点击率
     */
    private Integer clickRate;
    
    /**
     * 捐款笔数
     */
    private Integer donationNum;
    
    /**
    * 总认购份数
    */
    private Integer totalCopies;
    
    /**
     * 剩余认购份数
     */
    private Integer leaveCopies;
    
    /**
     * 项目截止时间
     */
    private Date deadline;
    
    /**
     * 副标题
     */
    private String subTitle;
    
    private String coverImageUrl;
    
    private List<String> contentImageUrl;
    
    private Integer coverImageId;
    
    /**
     * 内容图片ID，多个ID以逗号分隔
     */
    private String contentImageId;
    
    /**
     * 项目发起人
     */
    private Integer userId;
    
    /**
     * 善管家角色
     */
    private Integer role;

    /**
     * 每份多少元
     */
    private Double perMoney;
    /**
     * 求助原因
     */
    private String cryCause;
    /**
     * 项目是否隐藏 0：显示 1：隐藏
     */
    private Integer isHide;

    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getField()
    {
        return field;
    }
    
    public void setField(String field)
    {
        this.field = field;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public String getDetailAddress()
    {
        return detailAddress;
    }
    
    public void setDetailAddress(String detailAddress)
    {
        this.detailAddress = detailAddress;
    }
    
    public Double getCryMoney()
    {
        return cryMoney;
    }
    
    public void setCryMoney(Double cryMoney)
    {
        this.cryMoney = cryMoney;
    }
    
    public String getIdentity()
    {
        return identity;
    }
    
    public void setIdentity(String identity)
    {
        this.identity = identity;
    }
    
    public String getInformation()
    {
        return information;
    }
    
    public void setInformation(String information)
    {
        this.information = information;
    }
    
    public String getPayMethod()
    {
        return payMethod;
    }
    
    public void setPayMethod(String payMethod)
    {
        this.payMethod = payMethod;
    }
    
    public String getAccountName()
    {
        return accountName;
    }
    
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    
    public String getAccountBank()
    {
        return accountBank;
    }
    
    public void setAccountBank(String accountBank)
    {
        this.accountBank = accountBank;
    }
    
    public String getCollectNum()
    {
        return collectNum;
    }
    
    public void setCollectNum(String collectNum)
    {
        this.collectNum = collectNum;
    }
    
    public Double getPanyAmount()
    {
        return panyAmount;
    }
    
    public void setPanyAmount(Double panyAmount)
    {
        this.panyAmount = panyAmount;
    }
    
    public Integer getState()
    {
        return state;
    }
    
    public void setState(Integer state)
    {
        this.state = state;
    }
    
    public Date getRegistrTime()
    {
        return registrTime;
    }
    
    public void setRegistrTime(Date registrTime)
    {
        this.registrTime = registrTime;
    }
    
    public Integer getHot()
    {
        return hot;
    }
    
    public void setHot(Integer hot)
    {
        this.hot = hot;
    }
    
    public Integer getHead()
    {
        return head;
    }
    
    public void setHead(Integer head)
    {
        this.head = head;
    }
    
    public Integer getSort()
    {
        return sort;
    }
    
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }
    
    public Integer getClickRate()
    {
        return clickRate;
    }
    
    public void setClickRate(Integer clickRate)
    {
        this.clickRate = clickRate;
    }
    
    public Integer getDonationNum()
    {
        return donationNum;
    }
    
    public void setDonationNum(Integer donationNum)
    {
        this.donationNum = donationNum;
    }
    
    public Date getDeadline()
    {
        return deadline;
    }
    
    public void setDeadline(Date deadline)
    {
        this.deadline = deadline;
    }

    public Integer getTotalCopies()
    {
        return totalCopies;
    }
    
    public void setTotalCopies(Integer totalCopies)
    {
        this.totalCopies = totalCopies;
    }
    
    public Integer getLeaveCopies()
    {
        return leaveCopies;
    }
    
    public void setLeaveCopies(Integer leaveCopies)
    {
        this.leaveCopies = leaveCopies;
    }
    
    public String getSubTitle()
    {
        return subTitle;
    }
    
    public void setSubTitle(String subTitle)
    {
        this.subTitle = subTitle;
    }
    
    public String getCoverImageUrl()
    {
        return coverImageUrl;
    }
    
    public void setCoverImageUrl(String coverImageUrl)
    {
        this.coverImageUrl = coverImageUrl;
    }
    
    public Integer getCoverImageId()
    {
        return coverImageId;
    }
    
    public void setCoverImageId(Integer coverImageId)
    {
        this.coverImageId = coverImageId;
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
    
    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }
    
    public Double getDonatAmount()
    {
        return donatAmount;
    }
    
    public void setDonatAmount(Double donatAmount)
    {
        this.donatAmount = donatAmount;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public Integer getRole()
    {
        return role;
    }
    
    public void setRole(Integer role)
    {
        this.role = role;
    }

    public Double getPerMoney()
    {
        return perMoney;
    }
    
    public void setPerMoney(Double perMoney)
    {
        this.perMoney = perMoney;
    }

	public String getCryCause() {
		return cryCause;
	}

	public void setCryCause(String cryCause) {
		this.cryCause = cryCause;
	}

	public Integer getIsHide() {
		return isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}
    

}
