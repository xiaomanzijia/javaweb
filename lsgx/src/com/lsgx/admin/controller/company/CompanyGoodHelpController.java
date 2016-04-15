package com.lsgx.admin.controller.company;

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
import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.CompanyGoodHelp;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.SystemNotify;
import com.lsgx.admin.model.vo.CompanyGoodHelpVO;
import com.lsgx.admin.service.CapitalinoutService;
import com.lsgx.admin.service.CompanyGoodHelpService;
import com.lsgx.admin.service.DonateRecordService;
import com.lsgx.admin.service.ProjectService;
import com.lsgx.admin.service.SystemNotifyService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.Constant;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/companygoodhelp")
public class CompanyGoodHelpController extends BaseController
{
    @Autowired
    private CapitalinoutService capitalinoutService;

    @Autowired
    private CompanyGoodHelpService companyGoodHelpService;

    @Autowired
    private UserService userService;
    
    @Autowired
	private DonateRecordService donateRecordService;
    
    /*@Autowired
    private CompanyService companyService;*/

    @Autowired
    private SystemNotifyService syNotifyService;

    @RequestMapping(value = "/companygoodhelpList")
    @ActionLog(content = "查询企业助善列表")
    public String companyList(CompanyGoodHelpVO vo, ModelMap model)
    {
        List<CompanyGoodHelp> list = companyGoodHelpService.queryCompanyGoodHelpList(vo);
        
        PageInfo<CompanyGoodHelp> page = new PageInfo<CompanyGoodHelp>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("companyGoodHelp", vo);
        return "company/companygoodhelp_list";
    }
    
    @RequestMapping(value = "/initAuditState", method = RequestMethod.GET)
    public String initAuditState(@RequestParam("id")
    int id, int dialog, ModelMap model)
    {
        CompanyGoodHelp companyGoodHelp = companyGoodHelpService.queryById(id);
        model.put("companyGoodHelp", companyGoodHelp);
        model.put("dialog", dialog);
        return "company/companygoodhelp_audit";
    }
    
    @RequestMapping(value = "/auditState")
    @ResponseBody
    @ActionLog(content = "审核助善项目")
    public String auditState(HttpServletRequest req, CompanyGoodHelp companyGoodHelp, ModelMap model)
    {
        String rel = null;
        String callbackType = null;
        if (companyGoodHelp.getDialog() == 1)
        {
            rel = "companygoodhelp_list_dialog";
            callbackType = "closeCurrent";
        }
        else
        {
            rel = "companygoodhelp_list";
        }
        //通过助善id查询该助善的状态，判断助善是否已经结束
        CompanyGoodHelp companyGoodHelp_oldInfo = companyGoodHelpService.queryById(companyGoodHelp.getId());
        if(companyGoodHelp_oldInfo.getState() == State.end){
        	return super.responseFaild(rel, "该助善已被终止！", "");
        }
        if (companyGoodHelp != null && companyGoodHelp.getId() != null && companyGoodHelp.getState() != null
            && companyGoodHelp.getCompany_id() != null && companyGoodHelp_oldInfo.getState() == State.submitAudit)
        {
            StringBuffer content = new StringBuffer();//站内信内容
            SystemNotify sNotify = new SystemNotify();//站内信
            sNotify.setState(0);
            sNotify.setIsShow(1);
            sNotify.setCreateTime(new Date());
            sNotify.setSender("系统消息");
            sNotify.setSubject("助善项目审核");
            sNotify.setUserid(companyGoodHelp.getUserId());

            String msg = "";
            if (companyGoodHelp.getState() == State.notPass)
            {
                msg = "审核未通过";
                callbackType = "closeCurrent";
                content.append("审核结果：审核未通过，原因是：" + companyGoodHelp.getStopReason());
            }
            else
            {
                msg = "审核通过";
                content.append("审核结果：审核通过");
            }
            companyGoodHelpService.updateCompanyGoodHelp(companyGoodHelp);
            CompanyGoodHelp companyGoodHelpTest = companyGoodHelpService.queryById(companyGoodHelp.getId());
            //审核未通过把助捐金额返还给企业账户余额
            if (companyGoodHelpTest != null && companyGoodHelpTest.getCapitalinoutId() != null
                && companyGoodHelpTest.getState() != null && companyGoodHelpTest.getState() == State.notPass
                && companyGoodHelpTest.getPayState() == Constant.PAY_STATE_302)
            {
                FrontUser frontUser = userService.queryByLock(companyGoodHelp.getUserId());
                if (frontUser == null)
                {
                    return super.responseFaild("companygoodhelp_list", "参数错误", callbackType);
                }
                    //账户余额
                    Double balance = frontUser.getBalance() == null ? 0 : frontUser.getBalance();
                    Double availableBalance =
                    frontUser.getAvailableBalance() == null ? 0 : frontUser.getAvailableBalance();
                    
                    Double newBalance = balance + companyGoodHelpTest.getLeaveAmount();
                    Double newAvailableBalance = availableBalance + companyGoodHelpTest.getLeaveAmount();
                    
                    
                    // 资金进
                    Capitalinout capitalout = new Capitalinout();
                    capitalout.setUserId(companyGoodHelpTest.getUserId());
                    capitalout.setType(Constant.CAPITAL_IN);
                    capitalout.setMoney(companyGoodHelpTest.getLeaveAmount());
                    capitalout.setPayState(Constant.PAY_STATE_300);
                    capitalout.setTranNum(StringUtil.uniqueCode());
                    capitalout.setPayNum("");
                    capitalout.setSource("PC");
                    capitalout.setPayType("back");
                    capitalout.setInType(State.verify_fail_refund);
                    capitalout.setBalance(newAvailableBalance);
                    int capitalSet = capitalinoutService.save(capitalout);
                    
                    if (capitalSet > 0)
                    {
                    	//记录捐款记录
    					DonateRecord donate = new DonateRecord();
    	                donate.setCapitalinoutId(capitalout.getId());
    	                donate.setUserId(companyGoodHelpTest.getUserId());
    	                donate.setProjectId(companyGoodHelpTest.getProject_id());
    	                donate.setDonorType(companyGoodHelpTest.getUserId() != null ? Constant.DONOR_TYPE_IN : Constant.DONOR_TYPE_OUT);
    	                donate.setState(Constant.PAY_STATE_302);
    	                donate.setDonatTime(new Date());
    	                donate.setDonatAmount(companyGoodHelpTest.getLeaveAmount());
    	                donate.setDonatType("goodHelpBack");
    	                donateRecordService.save(donate);
    	                //更新账户余额
    	                frontUser.setBalance(newBalance);
                        frontUser.setAvailableBalance(newAvailableBalance);
                        int updateSet = userService.updateFrontUser(frontUser);
                        if (updateSet > 0)
                        {
                            Capitalinout capitalin2 = capitalinoutService.queryByTranNum(capitalout.getTranNum());
                            capitalin2.setPayState(Constant.PAY_STATE_302);
                            capitalinoutService.update(capitalin2);
                            model.put("companyGoodHelp", companyGoodHelp);
                            saveLogDetail("审核助善项目ID:" + companyGoodHelp.getId() + msg);
                            
                            sNotify.setContent(content.toString());
                            logger.info("审核失败系统消息内容"+sNotify.getContent());
                            syNotifyService.notifyAdd(sNotify);
                            logger.info("发送系统消息"+sNotify.toString());
                            return super.responseSuccess(rel, "资金退款成功", callbackType);
                        }
                        else
                        {
                        	model.put("companyGoodHelp", companyGoodHelp);
                            saveLogDetail("审核助善项目ID:" + companyGoodHelp.getId() + msg);
                            
                            sNotify.setContent(content.toString());
                            logger.info("审核失败系统消息内容"+sNotify.getContent());
                            syNotifyService.notifyAdd(sNotify);
                            logger.info("发送系统消息"+sNotify.toString());
                            return super.responseFaild(rel, "资金退款失败", callbackType);
                        }
                    }
            }
            model.put("companyGoodHelp", companyGoodHelp);
            saveLogDetail("审核助善项目ID:" + companyGoodHelp.getId() + msg);
            
            sNotify.setContent(content.toString());
            logger.info("审核失败系统消息内容"+sNotify.getContent());
            syNotifyService.notifyAdd(sNotify);
            logger.info("发送系统消息"+sNotify.toString());
            return super.responseSuccess(rel, msg, callbackType);
        }
        else
        {
            return super.responseFaild(rel, "参数错误", callbackType);
        }
    }
}
