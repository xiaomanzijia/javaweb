package com.lsgx.admin.controller.company;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.constants.State;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.controller.company.vo.CompanyExcel;
import com.lsgx.admin.controller.company.vo.ExcelInfo;
import com.lsgx.admin.model.Announce;
import com.lsgx.admin.model.AuditStaff;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Company;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.MessageModel;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.CompanyVO;
import com.lsgx.admin.service.AnnounceService;
import com.lsgx.admin.service.AuditStaffService;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.CompanyService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.MessageModelService;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.DateUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.ImportExecl;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.MD5;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController
{
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuditStaffService auditStaffService;

    @Autowired
    private BFileService bFileService;

    @Autowired
    private ConfigService configService;
    
    @Autowired
    private SystemNotifyService syNotifyService;
    
    @Autowired
    private MessageModelService messageModelService;
    
    @Autowired
    private AnnounceService announceService;

    @RequestMapping(value = "/companyList")
    @ActionLog(content = "查询企业列表")
    public String companyList(CompanyVO vo, ModelMap model)
    {
        List<Company> list = companyService.queryCompanyList(vo);
        //企业管理中业务范围的简略显示处理，
       /* List<Company> list12 = new ArrayList<Company>();
        for (Company company : list)
        {
            if (StringUtil.isNotEmpty(company.getServiceField()))
            {
                if (company.getServiceField().length() > 12)
                {
                    company.setServiceFieldShort(company.getServiceField().substring(0, 12) + "...");
                }
                else
                {
                    company.setServiceFieldShort(company.getServiceField());
                }
            }
            list12.add(company);
        }*/
        PageInfo<Company> page = new PageInfo<Company>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("company", vo);
        return "company/company_list";
    }
    
    @RequestMapping(value = "/initCompanyAudit", method = RequestMethod.GET)
    public String initCompanyAudit(@RequestParam("id") int id,@RequestParam("userId") int userId, ModelMap model)
    {
        model.put("id", id);
        model.put("userId", userId);
        return "company/company_audit";
    }
    
    @RequestMapping(value = "/companyAudit", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "企业审核")
    public String companyAudit(AuditStaff auditStaff, HttpServletRequest req, ModelMap model)
    {

        StringBuffer content = new StringBuffer();//站内信内容
        SystemNotify sNotify = new SystemNotify();//站内信
        sNotify.setState(0);
        sNotify.setIsShow(1);
        sNotify.setCreateTime(new Date());
        sNotify.setSender("系统消息");
        sNotify.setSubject("企业审核");
        sNotify.setUserid(auditStaff.getUserId());
        //企业认证短息发送功能
        Announce announce = new Announce();
        announce.setCause("企业认证");
        announce.setUserId(auditStaff.getUserId());
        MessageModel mesmodel = messageModelService.queryByModelName("企业认证模板");
        if(mesmodel ==null){
           return responseFaild("user_audit_list", "请先添加企业认证短息消息模板","closeCurrent");
        }
        Company company1 = new Company();
        company1.setUserId(auditStaff.getUserId());
        company1 = companyService.queryByCompany(company1);
        if(company1.getMobile() != null){
        announce.setDestination(company1.getMobile());
        }
        saveLogDetail("审核记录ID:" + auditStaff.getId());
        auditStaff.setReviewPerson(super.getActionUser(req).getId());
        auditStaff.setReviewTime(new Date());
        auditStaffService.updateAuditStaff(auditStaff);
        Company company = new Company();
        company.setUserId(auditStaff.getUserId());
        if (auditStaff.getState() == State.pass)
        {//通过
        	FrontUser frontUser = userService.queryById(auditStaff.getUserId());
        	if(frontUser != null && frontUser.getRealState() != State.pass){
        		frontUser.setRealState(State.pass);
        		userService.updateFrontUser(frontUser);
        	}
            company.setState(State.pass);
            content.append("审核通过。原因：");
            content.append(auditStaff.getReviewContent());
        }
        else
        {
            company.setState(State.notPass);
            content.append("审核不通过。原因：");
            content.append(auditStaff.getReviewContent());
        }
        
        String old_content = mesmodel.getModelContext();
        String new_content = old_content.replace("name",company1.getName());
        new_content= new_content.replace("result", content);
        announce.setContent(new_content);
        announce.setType(1);
        announce.setPriority(1);
        announce.setState(100);
        announce.setTryCount(0);
        announce.setCreateTime(new Date());
        announceService.save(announce);
        
        companyService.updateCompany(company);
        
        sNotify.setContent(content.toString());
        syNotifyService.notifyAdd(sNotify);

        return responseSuccess("user_audit_list", "企业审核成功", "closeCurrent");
    }
    
    @RequestMapping(value = "/showDetail")
    public String showDetail(Company company, ModelMap model)
    {
        company = companyService.queryByCompany(company);

        String realPath = "http://res.17xs.org/picture/";
        List<BFile> contentImgList = new ArrayList<BFile>();//企业认证图片,多个用逗号分隔
        BFile coverImage = null;//头像
        BFile conpanyImage = null;//企业Logo

        if (company != null && StringUtil.isNotEmpty(company.getContentImageId()))
        {
            String[] image_ids = company.getContentImageId().split("\\,");
            for (String image_id : image_ids)
            {
                if (StringUtil.isNotEmpty(image_id))
                {
                    BFile bFile = bFileService.queryById(Integer.parseInt(image_id));
                    if (bFile != null)
                    {
                        bFile.setUrl(realPath + bFile.getUrl());
                        contentImgList.add(bFile);
                    }
                }
            }
        }
        if (company.getCoverImageId() != null)
        {
            coverImage = bFileService.queryById(company.getCoverImageId());
            if(coverImage != null &&coverImage.getUrl() !=null){
            	coverImage.setUrl(realPath+coverImage.getUrl());
            }
        }

        if (company.getConpanyImageId() != null)
        {
            conpanyImage = bFileService.queryById(company.getConpanyImageId());
            if(conpanyImage != null && conpanyImage.getUrl() != null){
            	conpanyImage.setUrl(realPath+conpanyImage.getUrl());
            }
        }

        model.put("contentImgList", contentImgList);
        model.put("company", company);
        model.put("coverImage", coverImage);
        model.put("conpanyImage", conpanyImage);
        return "company/company_detail";
    }
    
    @RequestMapping(value = "/companyExcel")
    @ActionLog(content = "查看企业excel文件列表")
    public String companyExcel(HttpServletRequest req, ModelMap model)
    {
        List<ExcelInfo> list = new ArrayList<ExcelInfo>();
        DecimalFormat df = new DecimalFormat("0.00");
        Config config = new Config();
        config.setConfigKey("fileBasicURL");
        String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
        String relativeUrl="upload" + File.separator + "excel" + File.separator + "companyImport"+ File.separator;
        //        String realPath = req.getSession().getServletContext().getRealPath(File.separator + relativeUrl);//项目绝对路径
        String realPath = fileBasicURL + File.separator + relativeUrl;
        File f = new File(realPath);
        File[] fileArray = f.listFiles();
        if (fileArray != null)
        {
            for (int i = fileArray.length - 1; i >= 0; i--)
            {
                ExcelInfo excelInfo = new ExcelInfo();
                excelInfo.setRealUrl(fileArray[i].getPath());
                excelInfo.setRelativeUrl(relativeUrl + fileArray[i].getName());
                excelInfo.setLastUpdateTime(DateUtil.transferLongToDate("yyyy-MM-dd HH:mm:ss",fileArray[i].lastModified()));
                excelInfo.setSize(df.format(fileArray[i].length() / 1024.0) + "KB");
                list.add(excelInfo);
            }
        }
        model.put("list", list);
        return "company/companyExcel_list";
    }
    
    @RequestMapping(value = "/excelModel")
    public String excelModel(HttpServletRequest req, ModelMap model)
    {
        return "company/company_excelModel";
    }

    @RequestMapping(value = "/lookExcel")
    @ActionLog(content = "查看企业excel文件")
    public String lookExcel(String realUrl, HttpServletRequest req, ModelMap model)
    {
        if (StringUtil.isNotEmpty(realUrl))
        {
            //excel工具类
            ImportExecl poi = new ImportExecl();
            List listCompany = new ArrayList<CompanyExcel>();
            listCompany = poi.read(realUrl, CompanyExcel.class);
            model.put("errorInfo", poi.getErrorInfo());
            model.put("list", listCompany);
        }
        else
        {
            JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "上传失败", "companyExcel", "", "", ""));
        }
        
        return "company/company_import";
    }

    /**
     * 
     */
    @RequestMapping(value = "/deleteExcel")
    @ActionLog(content = "删除excel文件")
    @ResponseBody
    public String deleteExcel(HttpServletRequest request, String realUrl, ModelMap model)
    {
        if (StringUtil.isNotEmpty(realUrl))
        {
            ImageTool.deletePicture(realUrl);
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "删除成功", "companyExcel", "", "", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "删除失败。文件名为空", "", "", "", ""));
        }
    }
    
    /**
     * 
     */
    @RequestMapping(value = "/companyImport")
    @ActionLog(content = "上传excel文件")
    @ResponseBody
    public String companyImport(HttpServletRequest request, @RequestParam("file") MultipartFile file, ModelMap model)
    {
        //excel工具类
        ImportExecl poi = new ImportExecl();
        // 得到上传服务器的路径
        Config config = new Config();
        config.setConfigKey("fileBasicURL");
        String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
        if(StringUtil.isEmpty(fileBasicURL)){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "系统参数里无文件上传基本路径", "", "", "", ""));
        }
        String relativeUrl = "upload" + File.separator + "excel" + File.separator + "companyImport" + File.separator;
        String realPath = fileBasicURL + File.separator + relativeUrl;
        //        String realPath = request.getSession().getServletContext().getRealPath(File.separator + relativeUrl);//项目绝对路径
        if (poi.validateExcel(file.getOriginalFilename()))//刷选格式
        {
            String newFileName = ImageTool.upload(file, realPath);//图片上传--返回上传成功后图片的新名字（包括后缀）
            if (StringUtil.isNotEmpty(newFileName))
            {//不为空代表上传成功
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "文件上传成功", "companyExcel", "", "closeCurrent", ""));
            }
            else
            {
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "上传失败", "companyExcel", "", "", ""));
            }
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", poi.getErrorInfo(), "companyExcel", "", "", ""));
        }
    }
    
    @RequestMapping(value = "/importExcel")
    @ActionLog(content = "导入企业excel文件到数据库")
    @ResponseBody
    public String importExcel(String realUrl, HttpServletRequest req, ModelMap model)
    {
        if (StringUtil.isNotEmpty(realUrl))
        {
            try
            {
                StringBuffer resultBuffer = new StringBuffer();
                //excel工具类
                ImportExecl poi = new ImportExecl();
                List<CompanyExcel> listCompany = new ArrayList<CompanyExcel>();
                listCompany = poi.read(realUrl, CompanyExcel.class);
                if(StringUtil.isNotEmpty(poi.getErrorInfo())){
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败:"+poi.getErrorInfo(), "", "", "", ""));
                }
                if (listCompany != null && listCompany.size() > 0)
                {
                    for (CompanyExcel item : listCompany)
                    {
                        FrontUser user = new FrontUser();
                        user.setUserName(item.getName());
                        FrontUser frontUserTest = userService.getUserByUserName(item.getName());
                        if (frontUserTest != null)
                        {
                            resultBuffer.append("企业：【" + item.getName() + "】已存在，不能导入！");
                            continue;
                        }
                        user.setUserType("enterpriseUsers");//企业用户
                        user.setRealState(State.uncommitted);
                        user.setRegistrTime(new Date());
                        user.setUseState(State.enable);
                        user.setErrorNum(0);
                        user.setLastLoginTime(new Date());
                        user.setLoveGroupMent(0);
                        user.setMobileState(State.submitAudit);
                        user.setNickName(user.getUserName());
                        if(StringUtil.isNotEmpty(item.getIdentity())&&item.getIdentity().trim().length()==18){
                            user.setUserPass(MD5.encodeString(item.getIdentity().substring(item.getIdentity().length()-7,item.getIdentity().length())));
                        }
                        else
                        {
                            user.setUserPass(MD5.encodeString("123456"));
                        }
                        userService.saveFrontUser(user);
                        
                        FrontUser frontUser = userService.getUserByUserName(user.getUserName());
                        if (frontUser != null)//用户表保存成功后导入企业表
                        {
                            Company companyTest = companyService.queryByCompanyName(item.getName());
                            if (companyTest != null)
                            {
                                resultBuffer.append("企业：【" + item.getName() + "】已存在，不能导入！");
                                userService.delete(frontUser.getId());//回滚删除
                                continue;
                            }
                            Company company = new Company();
                            BeanUtils.copyProperties(company, item);
                            if (company.getMobileState() == null || StringUtil.isEmpty(company.getMobile()))
                            {
                                resultBuffer.append("企业：【" + item.getName() + "】不能导入！手机号或手机验证状态为空！");
                                userService.delete(frontUser.getId());//回滚删除
                                continue;
                            }
                            company.setUserId(frontUser.getId());
                            company.setRegisterTime(new Date());
                            company.setLastUpdateTime(new Date());
                            try
                            {
                                companyService.save(company);
                            }
                            catch (Exception e)
                            {
                                resultBuffer.append("导入企业：【" + item.getName() + "】出错！");
                                userService.delete(frontUser.getId());//回滚删除
                                e.printStackTrace();
                                continue;
                            }
                            
                            companyTest = companyService.queryByCompanyName(item.getName());
                            if (companyTest != null && companyTest.getMobileState() != null)//导入成功，用户表字段作相应修改
                            {
                                frontUser.setMobileNum(companyTest.getMobile());
                                frontUser.setMobileState(companyTest.getMobileState());
                                frontUser.setCompanyId(companyTest.getId());
                                userService.updateFrontUser(frontUser);
                            }
                        }
                    }
                }
                model.put("errorInfo", poi.getErrorInfo());
    
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200","操作完成</br>"+ resultBuffer.toString(), "company_list", "", "closeCurrent", ""));
                
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败", "companyExcel", "", "", ""));
            }
            catch (InvocationTargetException e)
            {
                e.printStackTrace();
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败", "companyExcel", "", "", ""));
            }
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败", "companyExcel", "", "", ""));
        }
    }
    
    /**
     * 获取修改企业信息页面
     * @param vo
     * @param model
     */
    @RequestMapping(value="/companyEdit")
    public String companyEdit(CompanyVO vo, ModelMap model){
    	Company company = companyService.queryByCompany(vo);
    	model.put("company", company);
    	return "company/company_edit";
    }
    
    /**
     * 保存修改企业信息
     * @param company
     * @param model
     */
    @RequestMapping(value="/editCompany")
    @ResponseBody
    @ActionLog(content="修改企业信息")
    public String editCompany(Company company,ModelMap model){
    	saveLogDetail("修改企业信息"+company.toString());
    	companyService.updateCompany(company);
    	return responseSuccess("company_list", "修改企业信息", "closeCurrent");
    }
}
