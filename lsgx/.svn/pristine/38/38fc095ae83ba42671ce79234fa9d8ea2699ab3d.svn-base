package com.lsgx.admin.service.sms;

import com.lsgx.admin.model.Announce;

public interface SmsSenderService
{
    /**
     * 发送短信
     * 
     * @param mobiles 手机号
     * @param content 内容
     * @param priority 优先级
     * @return
     * @see [类、类#方法、类#成员]
     * @author  Jfeng
     */
    public boolean send(String[] mobiles, String content, Integer priority);
    
    public boolean send(Announce announce);

    /**
     * 查询余额
     * @return
     * @see [类、类#方法、类#成员]
     * @author  Jfeng
     */
    public double getBalance();
    
    /**
     * 注册
     * @return
     * @see [类、类#方法、类#成员]
     * @author  Jfeng
     */
    int registCilent();
}

