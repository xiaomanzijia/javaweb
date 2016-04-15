package com.lsgx.admin.scheduling;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.lsgx.admin.constants.AnnounceConstants;
import com.lsgx.admin.model.Announce;
import com.lsgx.admin.model.vo.AnnounceVO;
import com.lsgx.admin.service.AnnounceService;
import com.lsgx.admin.service.sms.SmsSenderService;

public class SmsSendThread extends Thread
{
	protected transient final Logger logger = Logger.getLogger(getClass());
    protected boolean runStatus = true;//运行状态
    
    private AnnounceService announceService;
    
    private SmsSenderService smsSenderService;
    
    public SmsSendThread(AnnounceService announceService, SmsSenderService smsSenderService)
    {
        this.announceService = announceService;
        this.smsSenderService = smsSenderService;
    }
    public void run()
    {
        
        while (runStatus)
        {
            //            announceService = SpringContextUtil.getBean("announceService", AnnounceService.class);
            //            ymSmsSender = SpringContextUtil.getBean("ymSmsSender", YmrtSender.class);

            AnnounceVO announce = new AnnounceVO();
            announce.setState(AnnounceConstants.ANNOUNCE_STATUS_WAIT);
            announce.setType(AnnounceConstants.ANNOUNCE_TYPE_SMS);
            announce.setPageNum(0);
            announce.setNumPerPage(50);
            List<Announce> list = announceService.select(announce);
            
            if (list.isEmpty())
            {
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                }
                
                continue;
            }
            
            
            Iterator<Announce> it = list.iterator();
            while (it.hasNext())
            {
                if (!runStatus)
                    return;
                
                Announce item = it.next();
                
                boolean ret = false;
                if (item.getTryCount() == null || item.getTryCount() <= 3)
                {
                    ret = smsSenderService.send(item);
                    logger.info("发送短信号码："+item.getDestination());
                }
                item.setSendType("ym");
                item.setSendTime(new Date());
                Integer tryCount = announce.getTryCount() == null ? 0 : announce.getTryCount();
                item.setTryCount(tryCount + 1);
                if (ret)
                {
                    item.setState(AnnounceConstants.ANNOUNCE_STATUS_SEND);
                    logger.info("短信发送成功"+item.getId());
                }
                else
                {
                    item.setState(AnnounceConstants.ANNOUNCE_STATUS_FAIL);
                    logger.info("短信发送失败"+item.getId());
                }
                 int flag = announceService.update(item);
                 if(flag == 1){
                	 logger.info("短信表修改成功"+item.getId());
                 }else {
                	 logger.info("短信表修改失败"+item.getId());
                 }
            }
        }
        
    }
    
    
}
