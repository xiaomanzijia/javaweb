package com.lsgx.admin.scheduling;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.service.CapitalinoutService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.DonateRecordService;
import com.lsgx.admin.service.ProjectService;
import com.lsgx.admin.util.StringUtil;

/**
 * 3分钟未支付捐款自动取消任务
 * @author zhuangjy
 *
 */
public class CancelDonateSchedule
{
    protected transient final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DonateRecordService donateRecordService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private CapitalinoutService capitalinoutService;

    @Autowired
    private ConfigService configService;
    
    private String runState = null;

    public void exec()
    {
        runState = configService.selectByKey("cancel_donate_schedule");
        if (StringUtil.isNotEmpty(runState) && ("true").equals(runState.trim()))
        {
            try
            {
                List<Capitalinout> capitalinoutList = capitalinoutService.queryUnPayAndTimeout();
                if (capitalinoutList != null && capitalinoutList.size() > 0)
                {
                    for (Capitalinout capitalinout : capitalinoutList)
                    {
                        DonateRecord donateRecord = new DonateRecord();
                        donateRecord.setCapitalinoutId(capitalinout.getId());
                        donateRecord.setUserId(capitalinout.getUserId());
                        List<DonateRecord> donateList = donateRecordService.queryByDonate(donateRecord);
                        if (donateList != null && donateList.size() > 0)
                        {
                            for (DonateRecord dr : donateList)
                            {
                                Project project = new Project();
                                Integer projectId = dr.getProjectId();
                                project = projectService.queryByLock(projectId);
                                if (project != null)
                                {
                                    Integer leaveCopies =
                                        project.getLeaveCopies() == null ? 0 : project.getLeaveCopies();
                                    Integer donateCopies = dr.getDonateCopies() == null ? 0 : dr.getDonateCopies();
                                    if (leaveCopies.intValue() == 0 && project.getField().equals("garden"))
                                    {
                                        project.setState(204);
                                    }
                                    // 恢复后剩余分数
                                    int leave = leaveCopies.intValue() + donateCopies.intValue();
                                    project.setLeaveCopies(leave);
                                    projectService.update(project);
                                    logger.info("未支付超时项目剩余份数增加projectId:" + project.getId());
                                }
                            }
                        }
                        donateRecord.setState(301);
                        donateRecordService.update(donateRecord);
                        logger.info("未支付超时捐款记录改为失败donateRecordId:" + donateRecord.getId());
                        capitalinout.setPayState(301);
                        capitalinout.setPayNum("定时任务改为失败");
                        capitalinoutService.update(capitalinout);
                        logger.info("资金未支付超时自动取:capitalId:" + capitalinout.getId());
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                logger.error(e.getCause());
            }

        }
    }
}
