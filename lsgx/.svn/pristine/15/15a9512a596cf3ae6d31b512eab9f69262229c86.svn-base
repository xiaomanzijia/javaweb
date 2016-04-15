package com.lsgx.admin.controller.capital;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.vo.CapitalinoutVO;
import com.lsgx.admin.service.CapitalinoutService;
import com.lsgx.admin.service.DonateRecordService;
import com.lsgx.admin.service.ProjectService;

@Controller
@RequestMapping("/capital")
public class CapitalInOutController extends BaseController
{
    @Autowired
    private CapitalinoutService capitalinoutService;
    
    @Autowired
    private DonateRecordService donateRecordService;
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping(value = "/capitalInOutList")
    @ActionLog(content = "查询项目列表")
    public String capitalInOutList(CapitalinoutVO vo, ModelMap model)
    {
        List<Capitalinout> list = capitalinoutService.select(vo);
        
        PageInfo<Capitalinout> page = new PageInfo<Capitalinout>(list);
        model.put("list", list);
        model.put("page", page);
        model.put("capitalinout", vo);
        return "capital/capitalinout_list";
    }
    
    @RequestMapping(value = "/cancelCapitalIn")
    @ResponseBody
    @ActionLog(content = "取消认购")
    public String cancelCapitalIn(HttpServletRequest req, @RequestParam("id")
    int id, ModelMap model)
    {
        Capitalinout capitalinout = capitalinoutService.queryByLock(id);
        if (capitalinout != null && capitalinout.getPayState().intValue() == 300)//未支付才能取消
        {
            DonateRecord donateRecord = new DonateRecord();
            donateRecord.setCapitalinoutId(capitalinout.getId());
            donateRecord.setUserId(capitalinout.getUserId());
            List<DonateRecord> donateList = donateRecordService.queryByDonate(donateRecord);
            if (donateList != null)
            {
                for (DonateRecord dr : donateList)
                {
                    Project project = new Project();
                    Integer projectId = dr.getProjectId();
                    project = projectService.queryByLock(projectId);
                    Integer leaveCopies = project.getLeaveCopies() == null ? 0 : project.getLeaveCopies();
                    Integer donateCopies = dr.getDonateCopies() == null ? 0 : dr.getDonateCopies();
                    // 恢复后剩余分数
                    int leave = leaveCopies.intValue() + donateCopies.intValue();
                    if (leaveCopies.intValue() == 0 && project.getField().equals("garden"))
                    {
                        project.setState(204);
                    }
                    project.setLeaveCopies(leave);
                    projectService.update(project);
                    logger.info("未支付项目剩余份数增加projectId:" + project.getId());
                }
            }
            donateRecord.setState(301);
            donateRecordService.update(donateRecord);
            logger.info("未支付捐款记录改为失败donateRecordId:" + donateRecord.getId());
            capitalinout.setPayState(301);
            capitalinout.setPayNum(super.getActionUser(req).getUserName() + "手动改为失败");
            capitalinoutService.update(capitalinout);
            logger.info("资金未支付:capitalId:" + capitalinout.getId());
        }
        return responseSuccess("capitalInOutList", "取消成功", null);
    }
    
    @RequestMapping(value = "/mendCapitalIn")
    @ResponseBody
    @ActionLog(content = "补单认购")
    public String mendCapitalIn(@RequestParam("id")
    int id, HttpServletRequest req, ModelMap model)
    {
        Capitalinout capitalinout = capitalinoutService.queryByLock(id);
        if (capitalinout != null && capitalinout.getPayState().intValue() == 300)//未支付才能补单
        {
            DonateRecord donateRecord = new DonateRecord();
            donateRecord.setCapitalinoutId(capitalinout.getId());
            donateRecord.setUserId(capitalinout.getUserId());
            List<DonateRecord> donateList = donateRecordService.queryByDonate(donateRecord);
            if (donateList != null)
            {
                for (DonateRecord dr : donateList)
                {
                    Project project = new Project();
                    Integer projectId = dr.getProjectId();
                    project = projectService.queryByLock(projectId);
                    Double donatAmount_p = project.getDonatAmount() == null ? 0 : project.getDonatAmount();
                    Double donatAmount_d = dr.getDonatAmount() == null ? 0 : dr.getDonatAmount();
                    // 恢复后剩余分数
                    donatAmount_p = donatAmount_p.doubleValue() + donatAmount_d.doubleValue();
                    project.setDonatAmount(donatAmount_p);
                    projectService.update(project);
                    logger.info("未支付补单项目金额增加projectId:" + project.getId());
                }
            }
            donateRecord.setState(302);
            donateRecordService.update(donateRecord);
            logger.info("未支付补单捐款记录改为成功donateRecordId:" + donateRecord.getId());
            capitalinout.setPayState(302);
            capitalinout.setPayNum(super.getActionUser(req).getUserName() + "补单");
            capitalinoutService.update(capitalinout);
            logger.info("资金未支付超时自动取:capitalId:" + capitalinout.getId());
        }
        return responseSuccess("capitalInOutList", "补单认购成功", null);
    }

}
