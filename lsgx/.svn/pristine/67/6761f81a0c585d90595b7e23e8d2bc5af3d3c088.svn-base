package com.lsgx.admin.controller.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.ProjectFeedback;
import com.lsgx.admin.model.Report;
import com.lsgx.admin.model.vo.ReportVO;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.ProjectFeedbackService;
import com.lsgx.admin.service.ReportService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.DateUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController
{
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private BFileService bFileService;
    
    @Autowired
    private ActionUserService actionUserService;
    
    @Autowired
    private ProjectFeedbackService projectFeedbackService;
    
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/reportList")
    @ActionLog(content = "查询报告列表")
    public String reportList(ReportVO vo, ModelMap model)
    {
        List<Report> list = reportService.select(vo);
        List<Report> list12 = new ArrayList<Report>();
        for (Report report : list)
        {
            if (StringUtil.isNotEmpty(report.getContent()))
            {
                if (report.getContent().length() > 12)
                {
                    report.setContentShort(report.getContent().substring(0, 12) + "...");
                }
                else
                {
                    report.setContentShort(report.getContent());
                }
            }
            if(report.getType()== 6){
            	ActionUser actionUser = actionUserService.queryById(report.getReportPeople());
            	if(actionUser !=null){
            		report.setReportPeopleName(actionUser.getRealName());
            	}
            }
            if(report.getType() != 6){
            	FrontUser frontUser = userService.queryById(report.getReportPeople());
            	if(frontUser != null){
            		report.setReportPeopleName(frontUser.getUserName());
            	}
            }
            list12.add(report);
        }
        PageInfo<Report> page = new PageInfo<Report>(list);
        model.put("list", list12);
        model.put("page", page);
        model.put("projectId", vo.getProjectId());
        model.put("report", vo);
        JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "report_list", "", "", ""));
        return "report/report_list";
    }
    
    @RequestMapping(value = "/initAddReport")
    public String initAddReport(Report report, ModelMap model)
    {
        model.put("report", report);
        return "report/report_add";
    }
    
    @RequestMapping(value = "/addReport")
    @ResponseBody
    @ActionLog(content = "添加执行进度")
    public String addReport(Report report, HttpServletRequest req, ModelMap model)
    {
        report.setReportPeople(super.getActionUser(req).getId());
        report.setOperatorTime(new Date());
        report.setType(6);//执行进度
        reportService.save(report);
        
        //入库一条记录到反馈表中
        ProjectFeedback projectFeedback = new ProjectFeedback();
        projectFeedback.setProjectId(report.getProjectId());
        projectFeedback.setFeedbackPeople(report.getReportPeople());
        projectFeedback.setContent(report.getContent());
        projectFeedback.setContentImageId(report.getContentImageId());
        projectFeedback.setFeedbackTime(report.getOperatorTime());
        projectFeedback.setAudit(report.getId());
        projectFeedback.setAuditState(203);
        projectFeedbackService.save(projectFeedback);
        
        model.put("report", report);
        saveLogDetail("添加执行进度列表:" + report.getReportPeople());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "report_list", "", "closeCurrent", ""));
    }
    
    @RequestMapping(value = "/initUpdateReport")
    public String initUpdateReport(Report report, ModelMap model)
    {
        report = reportService.queryById(report.getId());
        model.put("report", report);
        return "report/report_edit";
    }
    
    @RequestMapping(value = "/updateReport")
    @ResponseBody
    @ActionLog(content = "修改执行进度")
    public String updateReport(Report report, HttpServletRequest req, ModelMap model)
    {
        report.setReportPeople(super.getActionUser(req).getId());
        report.setOperatorTime(new Date());
        reportService.update(report);
        
        //修改相应反馈表中的记录
        ProjectFeedback projectFeedback = projectFeedbackService.queryByAudit(report.getId());
        if(projectFeedback != null){
        	projectFeedback.setProjectId(report.getProjectId());
        	projectFeedback.setFeedbackPeople(report.getReportPeople());
        	projectFeedback.setContent(report.getContent());
        	projectFeedback.setContentImageId(report.getContentImageId());
        	projectFeedback.setFeedbackTime(report.getOperatorTime());
        	projectFeedback.setAudit(report.getId());
        	projectFeedback.setAuditState(203);
            projectFeedbackService.update(projectFeedback);
        }
        model.put("report", report);
        saveLogDetail("修改执行进度列表:" + report.getReportPeople());
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "report_list", "", "closeCurrent", ""));
    }

    /**
     * 图片管理
     * @param project
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageImg")
    public String manageImg(Report report, ModelMap model)
    {

        Config config = new Config();
        config.setConfigKey("fileBasicURL");
        String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
        if(StringUtil.isEmpty(fileBasicURL)){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileBasicURL is null", "manage_img", "", "", ""));
        }
        String realPath = "http://res.17xs.org/picture/";
        List<BFile> imgList = new ArrayList<BFile>();
        report = reportService.queryById(report.getId());
        if (report != null && StringUtil.isNotEmpty(report.getContentImageId()))
        {
            String[] image_ids = report.getContentImageId().split("\\,");
            for (String image_id : image_ids)
            {
                if (StringUtil.isNotEmpty(image_id))
                {
                    BFile bFile = bFileService.queryById(Integer.parseInt(image_id));
                    if(bFile!=null){
                        bFile.setUrl(realPath + bFile.getUrl());
                        imgList.add(bFile);
                    }
                }
            }
        }
        model.put("imgList", imgList);
        model.put("report", report);
        return "report/report_img";
    }
    
    /**
     * 上传图片弹出框
     */
    @RequestMapping(value = "/uploadImg")
    public String uploadImg(Report report, ModelMap model)
    {
        if (report.getId() != null)
        {
            report = reportService.queryById(report.getId());
        }
        model.put("report", report);
        return "report/uploadImg";
        
    }

    /**
     * 上传图片 控制在500KB以内，最多可上传10张图片
     */
    @RequestMapping(value = "/uploadImgAjax")
    @ActionLog(content = "上传图片")
    @ResponseBody
    public String uploadImgAjax(HttpServletRequest request,Report report, @RequestParam("file") MultipartFile file, ModelMap model)
    {
        if(report!=null&&report.getId()!=null&&file!=null){
            // 得到上传服务器的路径
            Config config = new Config();
            config.setConfigKey("fileBasicURL");
            String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
            if(StringUtil.isEmpty(fileBasicURL)){
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileBasicURL is null", "manage_img", "", "closeCurrent", ""));
            }
//            String realPath = request.getSession().getServletContext().getRealPath("/upload/picture/parkProgramDetail/");//项目绝对路径
            String today = DateUtil.parseToFormatDateString(new Date(), "yyyyMMdd");
            String realPath = fileBasicURL + "/upload/picture/projectAudit/" + today + "/";
            if (ImageTool.isImageAllowType(file.getOriginalFilename()))//刷选格式
            {
                if (file.getSize() > 2 * 1024 * 1024)//文件大小2M
                {
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "上传失败，图片大小超过2M", "manage_img", "", "closeCurrent", ""));
                }
                else
                {
                    String newFileName = ImageTool.upload(file, realPath);//图片上传--返回上传成功后图片的新名字（包括后缀）
                    if(StringUtil.isNotEmpty(newFileName)){//不为空代表上传成功
                        BFile bFile = new BFile();
                        bFile.setCategory("projectAudit");
                        bFile.setFileType("picture");
                        bFile.setUrl("projectAudit/" + today + "/" + newFileName);
                        int result = bFileService.save(bFile);
                        if (result > 0)
                        {
                            report = reportService.queryById(report.getId());
                            String contentImageId = "";
                            if (report != null)
                            {
                                contentImageId = report.getContentImageId() == null ? "" : report.getContentImageId();
                                List<BFile> bFile_list = bFileService.queryByParam(bFile);
                                if (bFile_list != null && bFile_list.size() > 0)
                                {
                                    if (contentImageId.equals(""))
                                    {
                                        contentImageId += bFile_list.get(0).getId();
                                    }
                                    else
                                    {
                                        contentImageId += "," + bFile_list.get(0).getId();
                                    }
                                }
                                report.setContentImageId(contentImageId);
                                reportService.update(report);
                                
                              //添加图片到相应反馈表中
                                ProjectFeedback projectFeedback = projectFeedbackService.queryByAudit(report.getId());
                                if(projectFeedback != null){
                                	projectFeedback.setContentImageId(report.getContentImageId());
                                    projectFeedbackService.update(projectFeedback);
                                }
                                model.put("report", report);
                            }
                        }
                    }
                }
            }else{
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for errorType", "manage_img", "", "closeCurrent", ""));
            }
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "upload success", "manage_img", "", "closeCurrent", ""));
        }else{
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "manage_img", "", "closeCurrent", ""));
        }
    }
    
    /**
     * 删除图片
     */
    @RequestMapping(value = "/delImgAjax")
    @ActionLog(content = "删除图片")
    @ResponseBody
    public String delImgAjax(Report report, @RequestParam("imgId")Integer imgId, ModelMap model)
    {
        if (report != null && report.getId() != null && imgId != null)
        {
            report = reportService.queryById(report.getId());
            String contentImageId = "";
            if (report != null)
            {
                contentImageId = report.getContentImageId() == null ? "" : report.getContentImageId();
                if (contentImageId.indexOf(imgId + "") > 0)
                {
                    contentImageId = contentImageId.replaceAll("," + imgId, "");
                    contentImageId = contentImageId.replaceAll(imgId + ",", "");
                    contentImageId = contentImageId.replaceAll(imgId + "", "");
                }
                report.setContentImageId(contentImageId);
                reportService.update(report);
                
              //删除相应反馈表中的图片
                ProjectFeedback projectFeedback = projectFeedbackService.queryByAudit(report.getId());
                if(projectFeedback != null){
                	projectFeedback.setContentImageId(report.getContentImageId());
                    projectFeedbackService.update(projectFeedback);
                }
                
                Config config = new Config();
                config.setConfigKey("fileBasicURL");
                String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
                if (StringUtil.isEmpty(fileBasicURL))
                {
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300","faild for fileBasicURL is null","manage_img", "","",""));
                }
                String realPath = fileBasicURL + "/upload/picture/";
                BFile bFile = bFileService.queryById(imgId);
                boolean result = ImageTool.deletePicture(realPath + bFile.getUrl());//删除图片
                if (result)
                {
                    bFileService.delete(imgId);
                }
                model.put("report", report);
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "", "", "", ""));
            }else{
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "", "", "", ""));
            }
        }else{
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "", "", "", ""));
        }
    }
    
}
