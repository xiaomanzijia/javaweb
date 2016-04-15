package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖金进出记录表
 * 
 * @author phx
 * 
 */

public class Capitalinout extends BaseBean implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1304784994396767598L;

    private Integer id;
    
    private Integer userId;
    
    private Integer type;
    
    private Double money;
    
    private String tranNum;
    
    private String payNum;
    
    private String source;
    
    private String payType;
    
    private String bankType;
    
    private String account;
    
    private Integer payState;
    
    private String payFailExplain;
    
    private Date createTime;

    /**
     * 资金进出类型： 进>>  募捐 : 0  充值 : 1   退款：4            出>> 助善 ： 2  提款：3
     */
    private Integer inType;
    
    /**
     * 余额
     */
    private Double balance;

    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public Double getBalance()
    {
        return balance;
    }
    
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }
    
    public Integer getInType()
    {
        return inType;
    }
    
    public void setInType(Integer inType)
    {
        this.inType = inType;
    }

    public Integer getType()
    {
        return type;
    }
    
    public void setType(Integer type)
    {
        this.type = type;
    }
    
    public Double getMoney()
    {
        return money;
    }
    
    public void setMoney(Double money)
    {
        this.money = money;
    }
    
    public String getTranNum()
    {
        return tranNum;
    }
    
    public void setTranNum(String tranNum)
    {
        this.tranNum = tranNum;
    }
    
    public String getPayNum()
    {
        return payNum;
    }
    
    public void setPayNum(String payNum)
    {
        this.payNum = payNum;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }
    
    public String getPayType()
    {
        return payType;
    }
    
    public void setPayType(String payType)
    {
        this.payType = payType;
    }
    
    public String getBankType()
    {
        return bankType;
    }
    
    public void setBankType(String bankType)
    {
        this.bankType = bankType;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    public Integer getPayState()
    {
        return payState;
    }
    
    public void setPayState(Integer payState)
    {
        this.payState = payState;
    }
    
    public String getPayFailExplain()
    {
        return payFailExplain;
    }
    
    public void setPayFailExplain(String payFailExplain)
    {
        this.payFailExplain = payFailExplain;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
}
