package com.lsgx.admin.controller.project;

import java.util.ArrayList;
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
import com.lsgx.admin.model.ProjectFeedback;
import com.lsgx.admin.model.vo.ProjectFeedbackVO;
import com.lsgx.admin.service.ProjectFeedbackService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/projectfeedback")
public class ProjectFeedbackController extends BaseController
{
    @Autowired
    private ProjectFeedbackService projectFeedbackService;

    @RequestMapping(value = "/projectFeedBackList")
    @ActionLog(content = "查询项目反馈列表")
    public String projectFeedBackList(ProjectFeedbackVO vo, ModelMap model)
    {
        List<ProjectFeedback> list = projectFeedbackService.select(vo);
        List<ProjectFeedback> list12 = new ArrayList<ProjectFeedback>();
        for (ProjectFeedback projectFeedback : list)
        {
            if (StringUtil.isNotEmpty(projectFeedback.getContent()))
            {
                if (projectFeedback.getContent().length() > 12)
                {
                    projectFeedback.setContentShort(projectFeedback.getContent().substring(0, 12) + "...");
                }
                else
                {
                    projectFeedback.setContentShort(projectFeedback.getContent());
                }
            }
            list12.add(projectFeedback);
        }
        PageInfo<ProjectFeedback> page = new PageInfo<ProjectFeedback>(list);
        model.put("list", list12);
        model.put("page", page);
        model.put("projectId", vo.getProjectId());
        model.put("projectFeedback", vo);
        JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "projectfeedback_list", "", "", ""));
        return "project/projectfeedback_list";
    }
    
    @RequestMapping(value = "/auditState")
    @ResponseBody
    @ActionLog(content = "审核项目反馈")
    public String auditState(HttpServletRequest req, ProjectFeedback projectFeedback, ModelMap model)
    {
        if (projectFeedback != null && projectFeedback.getId() != null && projectFeedback.getAuditState() != null
            && projectFeedback.getProjectId() != null)
        {
            String msg = "";
            if (projectFeedback.getAuditState() == 202)
            {
                msg = "审核未通过";
            }
            else
            {
                msg = "审核通过";
            }
            projectFeedback.setAudit(super.getActionUser(req).getId());
            projectFeedbackService.update(projectFeedback);
            
            model.put("projectFeedback", projectFeedback);
            saveLogDetail("审核项目反馈ID:" + projectFeedback.getId() + msg);
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", msg, "projectfeedback_list", "", "", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "参数错误", "projectfeedback_list", "", "", ""));
        }
    }
}
