package com.lsgx.admin.scheduling;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsgx.admin.service.AnnounceService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.sms.SmsSenderService;
import com.lsgx.admin.util.StringUtil;
import com.lsgx.admin.util.TaskCache;

/**
 * 短信发送计划任务.
 * Date: 2013-06-04 下午2:51
 *
 * @author liangyong
 *         since 2.0
 */
public class SmsMessageTask
{
    protected transient final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private AnnounceService announceService;
    
    @Autowired
    private SmsSenderService smsSenderService;
    
    @Autowired
    private ConfigService configService;
    
    private String runState = null;

    /**
     * 短信发送.
     */
    public void execute()
    {
        runState = configService.selectByKey("sms_message_schedule");
        if (StringUtil.isNotEmpty(runState) && ("true").equals(runState.trim()))
        {
            sendSms();
            logger.info("短信发送成功。。");
        }
    }
    
    private void sendSms()
    {
        if (TaskCache.smsThread == null)
        {
            TaskCache.smsThread = new SmsSendThread(announceService, smsSenderService);
            TaskCache.smsThread.start();
            
            logger.info("create threade SmsSendThread success. ");
        }
        else
        {
            Date now = new Date();
            long lastSmsSengTime = TaskCache.getLastSmsSendTime();
            if (now.getTime() - lastSmsSengTime >= 30000)
            {
                String msg = "短信发送故障,最后运行时间：" + new Date(lastSmsSengTime);
                logger.info(msg);
                TaskCache.smsThread.runStatus = false;
                TaskCache.smsThread = new SmsSendThread(announceService, smsSenderService);
                TaskCache.smsThread.start();
            }
        }
        
    }
}
