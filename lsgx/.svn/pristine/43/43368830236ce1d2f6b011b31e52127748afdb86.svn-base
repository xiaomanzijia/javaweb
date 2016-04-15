package com.lsgx.admin.controller.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ProjectSchedule;
import com.lsgx.admin.model.vo.ProjectScheduleVO;
import com.lsgx.admin.service.ProjectScheduleService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/projectSchedule")
public class ProjectScheduleController extends BaseController
{
    @Autowired
    private ProjectScheduleService projectScheduleService;
    
    @RequestMapping(value = "/projectScheduleList")
    @ActionLog(content = "查询执行进度列表")
    public String projectScheduleList(ProjectScheduleVO vo, ModelMap model)
    {
        List<ProjectSchedule> list = projectScheduleService.select(vo);
        List<ProjectSchedule> list12 = new ArrayList<ProjectSchedule>();
        for (ProjectSchedule projectSchedule : list)
        {
            if (StringUtil.isNotEmpty(projectSchedule.getDescription()))
            {
                if (projectSchedule.getDescription().length() > 12)
                {
                    projectSchedule.setDescriptionShort(projectSchedule.getDescription().substring(0, 12) + "...");
                }
                else
                {
                    projectSchedule.setDescriptionShort(projectSchedule.getDescription());
                }
            }
            list12.add(projectSchedule);
        }
        PageInfo<ProjectSchedule> page = new PageInfo<ProjectSchedule>(list);
        model.put("list", list12);
        model.put("page", page);
        model.put("projectSchedule", vo);
        JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "projectSchedule_list", "", "", ""));
        return "project/projectSchedule_list";
    }

    @RequestMapping(value = "/initAddProjectSchedule")
    public String initAddProjectSchedule(ProjectSchedule projectSchedule, ModelMap model)
    {
        model.put("projectSchedule", projectSchedule);
        return "project/projectSchedule_add";
    }
    
    @RequestMapping(value = "/addProjectSchedule")
    @ResponseBody
    @ActionLog(content = "添加执行进度列表")
    public String addProjectSchedule(ProjectSchedule projectSchedule, HttpServletRequest req, ModelMap model)
    {
        projectSchedule.setOperator(super.getActionUser(req).getId());
        projectSchedule.setOperatorTime(new Date());
        projectScheduleService.save(projectSchedule);
        model.put("projectSchedule", projectSchedule);
        saveLogDetail("添加执行进度列表:" + projectSchedule.getOperator());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "projectSchedule_list", "", "closeCurrent", ""));
    }
    
    @RequestMapping(value = "/initUpdateProjectSchedule")
    public String initUpdateProjectSchedule(ProjectSchedule projectSchedule, ModelMap model)
    {
        projectSchedule = projectScheduleService.queryById(projectSchedule.getId());
        model.put("projectSchedule", projectSchedule);
        return "project/projectSchedule_edit";
    }
    
    @RequestMapping(value = "/updateProjectSchedule")
    @ResponseBody
    @ActionLog(content = "修改执行进度列表")
    public String updateProjectSchedule(ProjectSchedule projectSchedule, HttpServletRequest req, ModelMap model)
    {
        projectSchedule.setOperator(super.getActionUser(req).getId());
        projectSchedule.setOperatorTime(new Date());
        projectScheduleService.update(projectSchedule);
        model.put("projectSchedule", projectSchedule);
        saveLogDetail("修改执行进度列表:" + projectSchedule.getOperator());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "projectSchedule_list", "", "closeCurrent", ""));
    }
}
