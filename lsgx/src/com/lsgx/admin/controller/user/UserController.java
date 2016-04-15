package com.lsgx.admin.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.constants.State;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.controller.user.vo.LoveGroupFile;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.AuditStaff;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.AuditStaffQueryVO;
import com.lsgx.admin.model.vo.UserQueryVO;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.service.AuditStaffService;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.CapitalinoutService;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.Constant;
import com.lsgx.admin.util.IPAddressUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
    @Autowired
    private UserService userService;
    @Autowired
    private BFileService bFileService;
    
    @Autowired
    private AuditStaffService auditStaffService;

    @Autowired
    private SystemNotifyService syNotifyService;

    @Autowired
    private CapitalinoutService capitalinoutService;
    
    @Autowired
	private ActionUserService aUserService;

    @RequestMapping(value = "/userIndex")
    @ActionLog(content = "查询用户列表")
    public String userIndex(UserQueryVO vo, ModelMap model)
    {
        List<FrontUser> list = userService.findByCondition(vo);
        
        PageInfo<FrontUser> page = new PageInfo<FrontUser>(list);

        model.put("list", list);
        model.put("page", page);
        model.put("user", vo);
        return "user/user_list";
    }
    
    @RequestMapping(value = "/showDetail")
    public String userdetail(@RequestParam("id")int id, ModelMap model)
    {
        FrontUser user = userService.queryById(id);
        String realPath = "http://res.17xs.org/picture/";
        List<BFile> imgList = new ArrayList<BFile>();
        if (user != null && StringUtil.isNotEmpty(user.getContentImageId()))
        {
            String[] image_ids = user.getContentImageId().split("\\,");
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
        model.put("user", user);
        return "user/user_detail";
    }
    
    /**
     * 显示ip归属地
     */
    @RequestMapping(value="/showIPBelongs")
    public String showIPAddress(@RequestParam("registerIP") String registerIP,ModelMap model){
    	String addr="";
    	try {
    		addr= IPAddressUtil.getAddress("ip="+registerIP, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String address = addr.replaceAll(",","");
    	model.put("ip", registerIP);
    	model.put("address", address);
    	return "user/show_ip_belongs";
    }

    @RequestMapping(value = "/userAuditList")
    @ActionLog(content = "查询人员审核列表")
    public String userAuditList(AuditStaffQueryVO vo, ModelMap model)
    {
        List<AuditStaff> list = auditStaffService.findByCondition(vo);
        List<AuditStaff> list12 = new ArrayList<AuditStaff>();
        for (AuditStaff auditStaff : list)
        {
            if (StringUtil.isNotEmpty(auditStaff.getReviewContent()))
            {
                if (auditStaff.getReviewContent().length() > 12)
                {
                    auditStaff.setReviewContentShort(auditStaff.getReviewContent().substring(0, 12) + "...");
                }
                else
                {
                    auditStaff.setReviewContentShort(auditStaff.getReviewContent());
                }
            }
            if(auditStaff.getReviewPerson() !=null){
            	ActionUser actionUser = aUserService.queryById(auditStaff.getReviewPerson());
            	if(actionUser != null){
            		auditStaff.setReviewPersonName(actionUser.getRealName());
            	}
            }
            list12.add(auditStaff);
        }
        PageInfo<AuditStaff> page = new PageInfo<AuditStaff>(list);
        model.put("list", list12);
        model.put("page", page);
        model.put("auditStaff", vo);
        return "user/user_audit_list";
    }
    
    @RequestMapping(value = "/loveGroupFile")
    public String loveGroupFile(@RequestParam("id")int id, ModelMap model)
    {
        LoveGroupFile loveGroupFile =null;
        AuditStaff auditStaff = auditStaffService.findById(id);
        if (auditStaff.getPersonType().equals("loveGroup"))
        {
            loveGroupFile =
                (LoveGroupFile)JsonUtil.getObject4JsonString(auditStaff.getFileId(), LoveGroupFile.class);
        }
        String realPath = "http://res.17xs.org/picture/";
        List<BFile> imgList = new ArrayList<BFile>();
        if (loveGroupFile != null && StringUtil.isNotEmpty(loveGroupFile.getFileId()))
        {
            String[] image_ids = loveGroupFile.getFileId().split("\\,");
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
        model.put("loveGroupFile", loveGroupFile);
        return "user/loveGroupFile";
    }

    /**
     * 得到善管家审核页面
     */
    @RequestMapping(value = "/initloveGroupAudit")
    public String initloveGroupAudit(@RequestParam("id") int id,@RequestParam("userId") int userId, ModelMap model)
    {
        model.put("id", id);
        model.put("userId", userId);
        return "user/user_audit_dialog";
    }
    /**
     * 处理善管家审核
     */
    @RequestMapping(value = "/loveGroupAudit", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "善管家审核")
    public String loveGroupAudit(AuditStaff auditStaff,HttpServletRequest req, ModelMap model)
    {
        StringBuffer content = new StringBuffer();//站内信内容
        SystemNotify sNotify = new SystemNotify();//站内信
        sNotify.setState(0);
        sNotify.setIsShow(1);
        sNotify.setCreateTime(new Date());
        sNotify.setSender("系统消息");
        sNotify.setSubject("善管家审核");
        sNotify.setUserid(auditStaff.getUserId());
        
        AuditStaff auditStaff1 = auditStaffService.findById(auditStaff.getId());
        auditStaff1.setState(auditStaff.getState());
        auditStaff1.setReviewPerson(super.getActionUser(req).getId());
        auditStaff1.setReviewContent(auditStaff.getReviewContent());
        if (auditStaff1.getPersonType().equals("loveGroup"))
        {
            FrontUser user = new FrontUser();
            user.setId(auditStaff1.getUserId());
            if (auditStaff1.getState() == 203)
            {//通过
                FrontUser frontUser = userService.queryById(auditStaff1.getUserId());
                if(frontUser.getRealState()==null||frontUser.getRealState()!=State.pass){//未实名审核通过
                	return responseFaild("user_audit_list", "请先申请实名通过！", "closeCurrent");
                }
                saveLogDetail("善管家审核记录ID:" + auditStaff1.getId());
                auditStaffService.updateAuditStaff(auditStaff1);
                user.setLoveGroupMent(1);
                user.setLoveState(State.pass);
                content.append("审核结果：审核通过。原因：");
                content.append(auditStaff1.getReviewContent());
            }
            else
            {
            	saveLogDetail("善管家审核记录ID:" + auditStaff1.getId());
                auditStaffService.updateAuditStaff(auditStaff1);
                user.setLoveGroupMent(0);
                user.setLoveState(State.notPass);
                content.append("审核结果：审核不通过。原因：");
                content.append(auditStaff1.getReviewContent());
            }
            userService.updateFrontUser(user);

            sNotify.setContent(content.toString());
            syNotifyService.notifyAdd(sNotify);

        }
        return responseSuccess("user_audit_list", "善管家审核成功", "closeCurrent");
    }
    
    /**
     * 得到实名审核页面
     */
    @RequestMapping(value = "/initRealNameAudit", method = RequestMethod.GET)
    public String initRealNameAudit(@RequestParam("id") int id,@RequestParam("userId") int userId, ModelMap model)
    {
        model.put("id", id);
        model.put("userId", userId);
        return "user/real_name_audit";
    }
    
    /**
     * 处理实名审核
     */
    @RequestMapping(value = "/realNameAudit", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "实名审核")
    public String realNameAudit(AuditStaff auditStaff, HttpServletRequest req, ModelMap model)
    {
        StringBuffer content = new StringBuffer();//站内信内容
        saveLogDetail("审核记录ID:" + auditStaff.getId());
        auditStaff.setReviewPerson(super.getActionUser(req).getId());
        auditStaff.setReviewTime(new Date());
        auditStaffService.updateAuditStaff(auditStaff);
        FrontUser user = new FrontUser();
        user.setId(auditStaff.getUserId());
        if (auditStaff.getState() == 203)
        {//通过
        	user.setMobileState(State.pass);
            user.setRealState(State.pass);
            content.append("审核结果：审核通过。原因：");
            content.append(auditStaff.getReviewContent());
        }
        else
        {
        	
            user.setRealState(202);
            content.append("审核结果：审核不通过。原因：");
            content.append(auditStaff.getReviewContent());
        }
        userService.updateFrontUser(user);
        
        SystemNotify sNotify = new SystemNotify();//站内信
        sNotify.setState(0);
        sNotify.setIsShow(1);
        sNotify.setCreateTime(new Date());
        sNotify.setSender("系统消息");
        sNotify.setSubject("实名审核");
        sNotify.setUserid(auditStaff.getUserId());
        sNotify.setContent(content.toString());
        syNotifyService.notifyAdd(sNotify);

        return responseSuccess("user_audit_list", "实名审核成功", "closeCurrent");
    }
    
    @RequestMapping(value = "/balanceIn", method = RequestMethod.GET)
    public String balanceIn(@RequestParam("id") int id, ModelMap model)
    {
        model.put("userId", id);
        return "user/balance_in";
    }
    
    @RequestMapping(value = "/saveBalance")
    @ResponseBody
    @ActionLog(content = "修改用户资金")
    public String saveBalance(HttpServletRequest req, Capitalinout capitalinout, ModelMap model)
    {
        if (capitalinout.getUserId() != null && capitalinout.getPayType() != null && capitalinout.getMoney() != null)
        {
            FrontUser frontUser = userService.queryByLock(capitalinout.getUserId());
            if (frontUser == null)
            {
                return super.responseFaild("balanceIn", "参数错误", "closeCurrent");
            }
            //账户余额
            Double balance = frontUser.getBalance() == null ? 0 : frontUser.getBalance();
            Double availableBalance = frontUser.getAvailableBalance() == null ? 0 : frontUser.getAvailableBalance();
            
            Double newBalance = balance + capitalinout.getMoney();
            Double newAvailableBalance = availableBalance + capitalinout.getMoney();
            frontUser.setBalance(newBalance);
            frontUser.setAvailableBalance(newAvailableBalance);
            
            capitalinout.setPayState(Constant.PAY_STATE_300);//未支付
            capitalinout.setTranNum(StringUtil.uniqueCode());
            capitalinout.setSource("PC");
            capitalinout.setBalance(newAvailableBalance);
            capitalinout.setType(Constant.CAPITAL_IN);
            capitalinout.setInType(1);//  募捐 : 0  充值 : 1   退款：4   出>> 助善 ： 2  提款：3
            int capitalSet = capitalinoutService.save(capitalinout);
            
            if (capitalSet > 0)
            {
                int updateSet = userService.updateFrontUser(frontUser);
                if (updateSet > 0)
                {
                    Capitalinout capitalin = capitalinoutService.queryByTranNum(capitalinout.getTranNum());
                    capitalin.setPayState(Constant.PAY_STATE_302);
                    capitalinoutService.update(capitalin);
                    return super.responseSuccess("balanceIn", "修改成功", "closeCurrent");
                }
                else
                {
                    return super.responseFaild("balanceIn", "存入失败", "closeCurrent");
                }
            }
            saveLogDetail("修改用户:" + capitalinout.getUserId() + " 资金");
            model.put("userId", capitalinout.getUserId());
            return super.responseFaild("balanceIn", "存入失败", "closeCurrent");
        }
        else
        {
            return super.responseFaild("balanceIn", "参数错误", "closeCurrent");
        }
    }
    
    @RequestMapping(value = "/bringBacklist")
    @ActionLog(content = "查找带回用户列表")
    public String bringBacklist(UserQueryVO vo, ModelMap model)
    {
        List<FrontUser> list = userService.findByCondition(vo);
        
        PageInfo<FrontUser> page = new PageInfo<FrontUser>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("user", vo);
        return "user/bringback_list";
    }
}

