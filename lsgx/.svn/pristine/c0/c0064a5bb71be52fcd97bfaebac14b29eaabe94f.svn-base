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
import com.lsgx.admin.controller.company.vo.EmployeeExcel;
import com.lsgx.admin.controller.company.vo.ExcelInfo;
import com.lsgx.admin.model.Company;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.Employee;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.vo.EmployeeVO;
import com.lsgx.admin.service.CompanyService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.EmployeeService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.DateUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.ImportExecl;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.MD5;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController
{
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/employeeList")
    @ActionLog(content = "查询企业员工列表")
    public String employeeList(EmployeeVO vo, ModelMap model)
    {
        List<Employee> list = employeeService.select(vo);
        
        PageInfo<Employee> page = new PageInfo<Employee>(list);
        model.put("list", list);
        model.put("page", page);
        model.put("employee", vo);
        return "employee/employee_list";
    }
    
    @RequestMapping(value = "/employeeDetail")
    @ActionLog(content = "查询企业员工详情")
    public String employeeDetail(@RequestParam("id") int id,ModelMap model)
    {
        Employee employee=employeeService.queryEmployeeById(id);
        model.put("employee", employee);
        return "employee/employee_detail";
    }
    
    @RequestMapping(value = "/initUpdateEmployee", method = RequestMethod.GET)
    public String initUpdateEmployee(@RequestParam("id") int id,@RequestParam("company_userId") int company_userId, ModelMap model)
    {
        model.put("id", id);
        model.put("company_userId", company_userId);
        return "employee/employee_audit";
    }
    
    @RequestMapping(value = "/employeeAudit")
    @ResponseBody
    @ActionLog(content = "企业员工审核")
    public String employeeAudit(Employee employee, ModelMap model)
    {
        if(employee!=null&&employee.getId()!=null&&employee.getCompany_userId()!=null){
            employeeService.updateEmployee(employee);
            
            employee = employeeService.queryEmployeeById(employee.getId());
            if (employee.getState() == State.pass && employee.getUserId() != null)//审核通过企业员工用户表关联企业Id
            {
                Company company = new Company();
                company.setUserId(employee.getCompany_userId());
                company = companyService.queryByCompany(company);
                if (company.getId() != null)
                {
                    FrontUser user = userService.queryByLock(employee.getUserId());
                    user.setCompanyId(company.getId());
                    userService.updateFrontUser(user);
                }
            }
            model.put("company_userId", employee.getCompany_userId());
            saveLogDetail("审核记录ID:" + employee.getId());
            return responseSuccess("employee_list", "企业员工审核成功", "closeCurrent");
        }else{
            return responseFaild("employee_list", "参数错误", "closeCurrent");
        }
    }
    
    @RequestMapping(value = "/employeeExcel")
    @ActionLog(content = "查看企业员工excel文件列表")
    public String employeeExcel(@RequestParam("company_userId") int company_userId,HttpServletRequest req, ModelMap model)
    {
        List<ExcelInfo> list = new ArrayList<ExcelInfo>();
        DecimalFormat df = new DecimalFormat("0.00");
        Config config = new Config();
        config.setConfigKey("fileBasicURL");
        String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
        String relativeUrl = "upload" + File.separator + "excel" + File.separator + "employeeImport" + File.separator;
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
                excelInfo.setLastUpdateTime(DateUtil.transferLongToDate("yyyy-MM-dd HH:mm:ss",
                    fileArray[i].lastModified()));
                excelInfo.setSize(df.format(fileArray[i].length() / 1024.0) + "KB");
                list.add(excelInfo);
            }
        }
        model.put("list", list);
        model.put("company_userId", company_userId);
        return "employee/employeeExcel_list";
    }
    
    @RequestMapping(value = "/employeeImport")
    @ActionLog(content = "上传excel文件")
    @ResponseBody
    public String employeeImport(HttpServletRequest request, @RequestParam("file") MultipartFile file, ModelMap model)
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
        String relativeUrl = "upload" + File.separator + "excel" + File.separator + "employeeImport" + File.separator;
        String realPath = fileBasicURL + File.separator + relativeUrl;
        //        String realPath = request.getSession().getServletContext().getRealPath(File.separator + relativeUrl);//项目绝对路径
        if (poi.validateExcel(file.getOriginalFilename()))//刷选格式
        {
            String newFileName = ImageTool.upload(file, realPath);//图片上传--返回上传成功后图片的新名字（包括后缀）
            if (StringUtil.isNotEmpty(newFileName))
            {//不为空代表上传成功
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "文件上传成功", "employeeExcel", "", "closeCurrent", ""));
            }
            else
            {
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "上传失败", "employeeExcel", "", "", ""));
            }
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", poi.getErrorInfo(), "employeeExcel", "", "", ""));
        }
    }
    
    @RequestMapping(value = "/deleteExcel")
    @ActionLog(content = "删除excel文件")
    @ResponseBody
    public String deleteExcel(HttpServletRequest request, String realUrl, ModelMap model)
    {
        if (StringUtil.isNotEmpty(realUrl))
        {
            ImageTool.deletePicture(realUrl);
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "删除成功", "employeeExcel", "", "", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "删除失败。文件名为空", "", "", "", ""));
        }
    }
    
    @RequestMapping(value = "/lookExcel")
    @ActionLog(content = "查看企业员工excel文件")
    public String lookExcel(String realUrl, HttpServletRequest req, ModelMap model)
    {
        if (StringUtil.isNotEmpty(realUrl))
        {
            //excel工具类
            ImportExecl poi = new ImportExecl();
            List listCompany = new ArrayList<EmployeeExcel>();
            listCompany = poi.read(realUrl, EmployeeExcel.class);
            model.put("errorInfo", poi.getErrorInfo());
            model.put("list", listCompany);
        }
        else
        {
            JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "上传失败", "employeeExcel", "", "", ""));
        }
        
        return "employee/employee_import";
    }
    
    @RequestMapping(value = "/importExcel")
    @ActionLog(content = "导入企业员工excel文件到数据库")
    @ResponseBody
    public String importExcel(@RequestParam("company_userId") int company_userId,String realUrl, HttpServletRequest req, ModelMap model)
    {
        if (StringUtil.isNotEmpty(realUrl))
        {
            try
            {
                Company company = new Company();
                company.setUserId(company_userId);
                company = companyService.queryByCompany(company);
                if (company.getId() == null)
                {
                    return super.responseFaild("employee_list", "导入失败:查询企业信息失败", "");
                }
                StringBuffer resultBuffer = new StringBuffer();
                //excel工具类
                ImportExecl poi = new ImportExecl();
                List<EmployeeExcel> listEmployee = new ArrayList<EmployeeExcel>();
                listEmployee = poi.read(realUrl, EmployeeExcel.class);
                if(StringUtil.isNotEmpty(poi.getErrorInfo())){
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败:"+poi.getErrorInfo(), "", "", "", ""));
                }
                if (listEmployee != null && listEmployee.size() > 0)
                {
                    for (EmployeeExcel item : listEmployee)
                    {
                        FrontUser user = new FrontUser();
                        user.setUserName(item.getNickName());
                        FrontUser frontUserTest = userService.getUserByUserName(item.getNickName());
                        if (frontUserTest != null)
                        {
                            resultBuffer.append("企业员工：【" + item.getNickName() + "】已存在，不能导入！");
                            continue;
                        }
                        user.setUserType("individualUsers");//个人用户
                        user.setRealState(State.uncommitted);
                        user.setRegistrTime(new Date());
                        user.setUseState(State.enable);
                        user.setErrorNum(0);
                        user.setLastLoginTime(new Date());
                        user.setLoveGroupMent(0);
                        user.setMobileState(State.submitAudit);
                        user.setNickName(item.getNickName());
                        user.setCompanyId(company.getId());
                        if(StringUtil.isNotEmpty(item.getIdCard())&&item.getIdCard().trim().length()==18){
                            user.setUserPass(MD5.encodeString(item.getIdCard().substring(item.getIdCard().length()-7,item.getIdCard().length())));
                        }
                        else
                        {
                            user.setUserPass(MD5.encodeString("123456"));
                        }
                        userService.saveFrontUser(user);
                        
                        FrontUser frontUser = userService.getUserByUserName(user.getUserName());
                        if (frontUser != null)//用户表保存成功后导入企业表
                        {
                            Employee employee = new Employee();
                            BeanUtils.copyProperties(employee, item);
                            employee.setUserId(frontUser.getId());
                            employee.setCompany_userId(company_userId);
                            try
                            {
                                employeeService.saveEmployee(employee);
                            }
                            catch (Exception e)
                            {
                                resultBuffer.append("导入企业员工：【" + item.getNickName() + "】出错！");
                                userService.delete(frontUser.getId());//回滚删除
                                e.printStackTrace();
                                continue;
                            }
                        }
                    }
                }
                model.put("errorInfo", poi.getErrorInfo());
                model.put("company_userId", company_userId);
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200","操作完成</br>"+ resultBuffer.toString(), "employee_list", "", "closeCurrent", ""));
                
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败", "employeeExcel", "", "", ""));
            }
            catch (InvocationTargetException e)
            {
                e.printStackTrace();
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败", "employeeExcel", "", "", ""));
            }
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "导入失败", "employeeExcel", "", "", ""));
        }
    }
    
    @RequestMapping(value = "/excelModel")
    public String excelModel(HttpServletRequest req, ModelMap model)
    {
        return "employee/employee_excelModel";
    }
}
