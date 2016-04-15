package com.lsgx.admin.controller.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lsgx.admin.constants.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.constants.State;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionUserRole;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Category;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.LoveGroupMent;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.ProjectSchedule;
import com.lsgx.admin.model.ProjectUserInfo;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.CategoryVO;
import com.lsgx.admin.model.vo.LoveGroupMentQueryVO;
import com.lsgx.admin.model.vo.ProjectQueryVO;
import com.lsgx.admin.service.ActionUserRoleService;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.CategoryService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.LoveGroupMentService;
import com.lsgx.admin.service.ProjectScheduleService;
import com.lsgx.admin.service.ProjectService;
import com.lsgx.admin.service.ProjectUserInfoService;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController
{
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private BFileService bFileService;
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private ProjectScheduleService projectScheduleService;
    
    @Autowired
    private LoveGroupMentService loveGroupMentService;
    
    @Autowired
    //用户角色
    private ActionUserRoleService actionUserRoleService;
    
    @Autowired
    private SystemNotifyService syNotifyService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProjectUserInfoService projectUserInfoService;
    
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/projectList")
    @ActionLog(content = "查询项目列表")
    public String projectList(ProjectQueryVO vo, ModelMap model)
    {
    	CategoryVO categoryVO = new CategoryVO();
        List<Project> list = projectService.select(vo);
        List<Category> categorys = categoryService.queryByParam(categoryVO);
        PageInfo<Project> page = new PageInfo<Project>(list);
        model.put("list", list);
        model.put("page", page);
        model.put("project", vo);
        model.put("categorys", categorys);
        return "project/project_list";
    }
    
    @RequestMapping(value = "/showDetail")
    @ActionLog(content = "查看项目详情")
    public String showDetail(Project project, ModelMap model)
    {
        if (project != null && project.getId() != null)
        {
        	List<ProjectUserInfo> proUserInfos = projectUserInfoService.queryByProjectId(project.getId());
        	if(proUserInfos != null && proUserInfos.size() == 3){
        		for(ProjectUserInfo projectUserInfo : proUserInfos){
        			//受助人
        			if(projectUserInfo.getPersonType() == 0){
        				ProjectUserInfo recipient = projectUserInfo;
        				model.put("recipient", recipient);
        			}
        			//证明人
        			if(projectUserInfo.getPersonType() == 1){
        				ProjectUserInfo reference = projectUserInfo;
        				model.put("reference", reference);
        			}
        			//发布人
        			if(projectUserInfo.getPersonType() == 2){
        				ProjectUserInfo issuer = projectUserInfo;
        				model.put("issuer", issuer);
        			}
        		}
        	}
        	FrontUser frontUser = new FrontUser();
            project = projectService.queryById(project.getId());
            if(project !=null){
            	frontUser = userService.queryById(project.getUserId());
            }
//            String realPath = "http://res.17xs.org/picture/";
            String realPath = SystemConstants.Img_real_path;
            List<BFile> imgList = new ArrayList<BFile>();
            if (project != null && StringUtil.isNotEmpty(project.getContentImageId()))
            {
                String[] image_ids = project.getContentImageId().split("\\,");
                for (String image_id : image_ids)
                {
                    if (StringUtil.isNotEmpty(image_id))
                    {
                        BFile bFile = bFileService.queryById(Integer.parseInt(image_id));
                        if (bFile != null)
                        {
                            bFile.setUrl(realPath + bFile.getUrl());
                            imgList.add(bFile);
                        }
                    }
                }
            }
            model.put("imgList", imgList);
            model.put("project", project);
            model.put("user", frontUser);
        }
        return "project/project_detail";
    }

    @RequestMapping(value = "/initSave")
    public String initSave(ModelMap model)
    {
        return "project/project_add";
    }
    
    @RequestMapping(value = "/saveProject")
    @ActionLog(content = "增加项目")
    @ResponseBody
    public String saveProject(Project project, ModelMap model)
    {
        project.setUserId(0);
        project.setLocation(project.getLocation().trim());
        project.setState(240);
        project.setIsHide(0);
        project.setLastUpdateTime(new Date());
        project.setType("enterpriseProject");
        project.setPayMethod("bankPay");
        project.setIdentity("callerI");
        project.setLeaveCopies(project.getTotalCopies());
        project.setCryMoney(project.getPerMoney() * project.getTotalCopies());
        projectService.save(project);
        saveLogDetail("增加项目ID:" + project.getId());
        return responseSuccess("project_list", "增加项目成功", "closeCurrent");
    }
    
    @RequestMapping(value = "/initEdit")
    public String initEdit(Project project, ModelMap model)
    {
        if (project != null && project.getId() != null)
        {
            project = projectService.queryById(project.getId());
            if (project.getTotalCopies() != null)
            {
                project.setPerMoney(project.getCryMoney() / project.getTotalCopies());
            }
            model.put("project", project);
        }
        return "project/project_edit";
    }

    @RequestMapping(value = "/editProject")
    @ActionLog(content = "修改项目")
    @ResponseBody
    public String editProject(Project project, ModelMap model)
    {
        if (project != null && project.getId() != null)
        {
            Project project2 = projectService.queryByLock(project.getId());
            project.setLastUpdateTime(new Date());
            if (project2.getLeaveCopies() == null)
            {
                project.setLeaveCopies(project.getTotalCopies());
            }
            else
            {
                if (project2.getTotalCopies() != null)
                {
                    int chazhi = project.getTotalCopies() - project2.getTotalCopies();//总认购份数变化差值剩余认购份数相应变化差值
                    project.setLeaveCopies(project2.getLeaveCopies() + chazhi);
                }
            }
            projectService.update(project);
            model.put("project", project);
            saveLogDetail("修改项目ID:" + project.getId());
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit success", "project_list", "", "closeCurrent", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "", "", "", ""));
        }
    }
    
    /**
     * 图片管理
     * @param project
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageImg")
    public String manageImg(Project project, ModelMap model)
    {

        Config config = new Config();
        config.setConfigKey("fileBasicURL");
        String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
        if(StringUtil.isEmpty(fileBasicURL)){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileBasicURL is null", "manage_img", "", "", ""));
        }
//        String realPath = "http://res.17xs.org/picture/";
        String realPath = SystemConstants.Img_real_path;
        List<BFile> imgList = new ArrayList<BFile>();
        project = projectService.queryById(project.getId());
        if (project != null && StringUtil.isNotEmpty(project.getContentImageId()))
        {
            String[] image_ids = project.getContentImageId().split("\\,");
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
        model.put("project", project);
        return "project/project_img";
    }
    
    /**
     * 上传图片弹出框
     */
    @RequestMapping(value = "/uploadImg")
    public String uploadImg(Project project, ModelMap model)
    {
        if (project.getId() != null)
        {
            project = projectService.queryById(project.getId());
        }
        model.put("project", project);
        return "project/uploadImg";
        
    }
    
    /**
     * 查看图片详情
     */
    @RequestMapping(value="/imgDetail")
    public String imgDetail(@RequestParam("imgId")Integer imgId, ModelMap model){
//    	String realPath = "http://res.17xs.org/picture/";
    	String realPath = SystemConstants.Img_real_path;
    	BFile bFile = bFileService.queryById(imgId);
    	bFile.setUrl(realPath+bFile.getUrl());
    	model.put("bFile", bFile);
    	
    	return "project/img_description";
    }
    
    /**
     * 修改项目图片说明
     */
    @RequestMapping(value="/editImgDescription")
    @ResponseBody
    @ActionLog(content="修改项目图片说明")
    public String editImgDescription(BFile bf,ModelMap model){
    	BFile bFile = bFileService.queryById(bf.getId());
    	bFile.setDescription(bf.getDescription());
    	saveLogDetail("修改项目图片说明"+bFile.toString());
    	bFileService.update(bFile);
    	return responseSuccess("manage_img", "update success", "closeCurrent");
    }
    /**
     * 控制前台图片的隐藏或显示
     */
    @RequestMapping(value="/hideOrShowImg")
    @ResponseBody
    @ActionLog(content="操作图片在前台的显示")
    public String hideOrShowImg(@RequestParam("imgId") Integer imgId,@RequestParam("isHide") Integer isHide,ModelMap model ){
    	BFile bFile = bFileService.queryById(imgId);
    	bFile.setIsHide(isHide);
    	bFileService.update(bFile);
    	return responseSuccess("manage_img", "update success", "");
    }
    
    /**
     * 上传图片 控制在500KB以内，最多可上传10张图片
     */
    @RequestMapping(value = "/uploadImgAjax")
    @ActionLog(content = "上传图片")
    @ResponseBody
    public String uploadImgAjax(HttpServletRequest request,Project project, @RequestParam("file") MultipartFile file, ModelMap model)
    {
        if(project!=null&&project.getId()!=null&&file!=null){
            // 得到上传服务器的路径
            Config config = new Config();
            config.setConfigKey("fileBasicURL");
            String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
            if(StringUtil.isEmpty(fileBasicURL)){
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileBasicURL is null", "manage_img", "", "closeCurrent", ""));
            }
//            String realPath = request.getSession().getServletContext().getRealPath("/upload/picture/parkProgramDetail/");//项目绝对路径
            String realPath = fileBasicURL + "/upload/picture/parkProgramDetail/";
            if (ImageTool.isImageAllowType(file.getOriginalFilename()))//刷选格式
            {
                if (file.getSize() > 2 * 1024 * 1024)//文件大小2M
                {
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileSize big than 500KB", "manage_img", "", "closeCurrent", ""));
                }
                else
                {
                    String newFileName = ImageTool.upload(file, realPath);//图片上传--返回上传成功后图片的新名字（包括后缀）
                    if(StringUtil.isNotEmpty(newFileName)){//不为空代表上传成功
                        BFile bFile = new BFile();
                        bFile.setCategory("parkProgramDetail");
                        bFile.setFileType("picture");
                        bFile.setUrl("parkProgramDetail/" + newFileName);
                        int result = bFileService.save(bFile);
                        if (result > 0)
                        {
                            project = projectService.queryById(project.getId());
                            String contentImageId = "";
                            if (project != null)
                            {
                                contentImageId = project.getContentImageId() == null ? "" : project.getContentImageId();
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
                                project.setContentImageId(contentImageId);
                                projectService.update(project);
                                model.put("project", project);
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
    public String delImgAjax(Project project, @RequestParam("imgId")Integer imgId, ModelMap model)
    {
        if (project != null && project.getId() != null && imgId != null)
        {
            project = projectService.queryById(project.getId());
            String contentImageId = "";
            if (project != null)
            {
                contentImageId = project.getContentImageId() == null ? "" : project.getContentImageId();
                if (contentImageId.indexOf(imgId + "") > 0)
                {
                    contentImageId = contentImageId.replaceAll("," + imgId, "");
                    contentImageId = contentImageId.replaceAll(imgId + ",", "");
                    contentImageId = contentImageId.replaceAll(imgId + "", "");
                }
                project.setContentImageId(contentImageId);
                projectService.update(project);
                
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
                model.put("project", project);
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "manage_img", "", "", ""));
            }else{
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "manage_img", "", "", ""));
            }
        }else{
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "manage_img", "", "", ""));
        }
    }
    
    /**
     * 设为标题图片
     */
    @RequestMapping(value = "/setLogoAjax")
    @ActionLog(content = "设为标题图片")
    @ResponseBody
    public String setLogoAjax(Project project, @RequestParam("imgId")Integer imgId, ModelMap model)
    {
        if (project != null && project.getId() != null && imgId != null)
        {
            project = projectService.queryById(project.getId());
            if (project != null)
            {
                project.setCoverImageId(imgId);
                projectService.update(project);
                model.put("project", project);
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "set logo success", "manage_img", "", "", ""));
            }
            else
            {
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "manage_img", "", "", ""));
            }
        }else{
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "manage_img", "", "", ""));
        }
    }
    /**
     * 获取审核初始页面
     */
    @RequestMapping(value = "/initCheckProject")
    public String initCheckProject(HttpServletRequest req, Project project, ModelMap model)
    {
        /*ActionUserRole actionUserRole = new ActionUserRole();
        actionUserRole.setUserId(super.getActionUser(req).getId());
        actionUserRole = actionUserRoleService.queryUserRole(actionUserRole);*/
       // project = projectService.queryById(project.getId());
        model.put("project", project);
       // model.put("roleId", actionUserRole.getRoleId());
        return "project/project_check";
    }
    /**
     * 审核处理，更改项目状态
     */
    @RequestMapping(value = "/checkProject")
    @ActionLog(content = "审核项目")
    @ResponseBody
    public String checkProject(HttpServletRequest req,Project pro, @RequestParam("description")String description,  ModelMap model)
    {
    	Project project = projectService.queryById(pro.getId());
        if (project != null && project.getId() != null && project.getState() != null)
        {
        	project.setState(pro.getState());
            SystemNotify sNotify = new SystemNotify();//站内信
            sNotify.setState(0);
            sNotify.setIsShow(1);
            sNotify.setCreateTime(new Date());
            StringBuffer content = new StringBuffer();
            sNotify.setSender("系统消息");
            sNotify.setSubject("项目审核结果");
            sNotify.setUserid(project.getUserId());

            /*取消判断"请先添加善管家或客服"的功能*/
           /* LoveGroupMentQueryVO vo=new LoveGroupMentQueryVO();
            vo.setProjectId(project.getId());
            List<LoveGroupMent> list = loveGroupMentService.select(vo);
            if(list==null||list.size()==0){
                if (project.getState() == 220 || project.getState() == 240)
                {
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "审核失败 ,请先添加善管家或客服!", "project_list", "", "closeCurrent", ""));
                }
            }*/
            ProjectSchedule projectSchedule=new ProjectSchedule();
            projectSchedule.setDescription(description);
            projectSchedule.setOperator(super.getActionUser(req).getId());
            projectSchedule.setOperatorTime(new Date());
            projectSchedule.setProjectId(project.getId());
            projectSchedule.setState( project.getState());
            project.setLastUpdateTime(new Date());
            projectService.update(project);
            projectScheduleService.save(projectSchedule);
            
            /*更新流程没有待复审环节*/
            /*if (project.getState() == 220)
            {
                content.append("审核结果：审核为待复审。原因：");
            }*/
            if (project.getState() == 230)
            {
                content.append("审核结果：审核未通过。原因：");
            }
            if (project.getState() == 220)
            {
                content.append("审核结果：审核通过待发布。原因：");
            }
            sNotify.setContent(content.toString() + description);
            syNotifyService.notifyAdd(sNotify);
            model.put("project", project);
            saveLogDetail("审核项目ID:" + project.getId());
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "审核成功", "project_list", "", "closeCurrent", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "", "", "", ""));
        }
    }
    /**
     * 将审核通过待发布的项目发布
     * @param project
     * @param model
     * @param req
     * @return
     */
    @RequestMapping(value="/projectSender")
    @ResponseBody
    public String projectSender(Project project, ModelMap model,HttpServletRequest req){
    	project = projectService.queryById(project.getId());
    	project.setState(State.donations);
    	if (project != null && project.getId() != null && project.getState() != null)
        {
            SystemNotify sNotify = new SystemNotify();//站内信
            sNotify.setState(0);
            sNotify.setIsShow(1);
            sNotify.setCreateTime(new Date());
            sNotify.setSender("系统消息");
            sNotify.setSubject("项目审核结果");
            sNotify.setUserid(project.getUserId());
            
            ProjectSchedule projectSchedule=new ProjectSchedule();
          //  projectSchedule.setDescription("项目发布");
            projectSchedule.setOperator(super.getActionUser(req).getId());
            projectSchedule.setOperatorTime(new Date());
            projectSchedule.setProjectId(project.getId());
            projectSchedule.setState( project.getState());
            project.setLastUpdateTime(new Date());
            projectService.update(project);
            projectScheduleService.save(projectSchedule);
            
            sNotify.setContent("您的项目已发布！");
            syNotifyService.notifyAdd(sNotify);
            return responseSuccess("project_list", "项目发布成功！", "");
        }else{
        	return responseFaild("project_list", "faild for error", "");
        }
    }
    @RequestMapping(value = "/openProject")
    @ActionLog(content = "重启项目")
    @ResponseBody
    public String openProject(HttpServletRequest req, Project project, ModelMap model)
    {
        if (project != null && project.getId() != null && project.getState() != null)
        {
            project.setLastUpdateTime(new Date());
            projectService.update(project);
            model.put("project", project);
            saveLogDetail(super.getActionUser(req).getRealName() + "重启项目ID:" + project.getId());
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "重启成功", "project_list", "", "", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "", "", "", ""));
        }
    }
    
   /**
    * 隐藏项目
    * @param pro
    * @param model
    * @return
    */
    @RequestMapping(value="/projectHide")
    @ResponseBody
    public String projectHide(Project pro,ModelMap model){
    	Project project = projectService.queryById(pro.getId());
    	if(project.getIsHide() != null){
    		if(project.getIsHide() ==0){
    			project.setIsHide(1);
    		}else{
    			project.setIsHide(0);
    		}
    	}
    	projectService.update(project);
    	return responseSuccess("project_list", "操作成功！", "");
    }
}

