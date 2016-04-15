package com.lsgx.admin.controller.capital;

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
import com.lsgx.admin.constants.State;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.ActionUserRole;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.PayMoneyRecord;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.UserCard;
import com.lsgx.admin.model.vo.PayMoneyRecordVO;
import com.lsgx.admin.service.ActionUserRoleService;
import com.lsgx.admin.service.ActionUserService;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.CapitalinoutService;
import com.lsgx.admin.service.PayMoneyRecordService;
import com.lsgx.admin.service.ProjectService;
import com.lsgx.admin.service.UserCardService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.Constant;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/paymoneyrecord")
public class PayMoneyRecordController extends BaseController
{
    @Autowired
    private PayMoneyRecordService payMoneyRecordService;
    
    @Autowired
    //用户角色
    private ActionUserRoleService actionUserRoleService;

    @Autowired
    private CapitalinoutService capitalinoutService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserCardService userCardService;
    
    @Autowired
    private BFileService bFileService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private ActionUserService actionUserService;

    @RequestMapping(value = "/payMoneyRecordList")
    @ActionLog(content = "查询打款记录列表")
    public String payMoneyRecordList(HttpServletRequest req, PayMoneyRecordVO vo, ModelMap model)
    {
        ActionUserRole actionUserRole = new ActionUserRole();
        actionUserRole.setUserId(super.getActionUser(req).getId());
        actionUserRole = actionUserRoleService.queryUserRole(actionUserRole);
        model.put("roleId", actionUserRole.getRoleId());
        
        List<PayMoneyRecord> list = payMoneyRecordService.select(vo);
        List<PayMoneyRecord> payMoneyRecords = new ArrayList<PayMoneyRecord>();
        for(PayMoneyRecord payMoneyRecord : list){
        	if(payMoneyRecord != null){
        		FrontUser frontUser = userService.queryById(payMoneyRecord.getUserId());
        		if(frontUser != null){
        			payMoneyRecord.setUserName(frontUser.getUserName());
        		}
        		UserCard userCard = userCardService.selectByCard(payMoneyRecord.getAccount(),payMoneyRecord.getUserId());
        		if(userCard != null){
        			payMoneyRecord.setAccountName(userCard.getAccountName());
        		}
        		if(payMoneyRecord.getOperator() !=null && payMoneyRecord.getOperator() != 0){
        			ActionUser actionUser = actionUserService.queryById(payMoneyRecord.getOperator());
        			if(actionUser != null){
        				payMoneyRecord.setOperatorName(actionUser.getRealName());
        			}
        		}
        		payMoneyRecords.add(payMoneyRecord);
        	}
        }
        
        PageInfo<PayMoneyRecord> page = new PageInfo<PayMoneyRecord>(list);
        model.put("list", payMoneyRecords);
        model.put("page", page);
        model.put("payMoneyRecord", vo);
        return "capital/payMoneyRecord_list";
    }
    /**
     * 打款成功时输入打款金额页面
     */
    @RequestMapping(value="/successPay")
    public String successPay(PayMoneyRecord payMoneyRecord,ModelMap model){
    	model.put("payMoneyRecord", payMoneyRecord);
    	return "capital/payMoneyRecord_confirm";
    }
   /**
    * 打款成功和失败处理
    */
    @RequestMapping(value = "/payMoney")
    @ResponseBody
    @ActionLog(content = "打款处理")
    public String payMoney(HttpServletRequest req, PayMoneyRecord payMoneyRecord, ModelMap model)
    {
        if (payMoneyRecord != null && payMoneyRecord.getId() != null && payMoneyRecord.getState() != null
            && payMoneyRecord.getCapitalinoutId() != null && payMoneyRecord.getUserId() != null)
        {
            Capitalinout capitalout = capitalinoutService.queryByLock(payMoneyRecord.getCapitalinoutId());
            FrontUser frontUser = userService.queryByLock(payMoneyRecord.getUserId());
            if (capitalout == null)
            {
                return super.responseFaild("payMoneyRecord_list", "无此资金出入Id信息", "closeCurrent");
            }
            if (frontUser == null)
            {
                return super.responseFaild("payMoneyRecord_list", "无此用户Id信息", "closeCurrent");
            }

            String msg="";
            if (payMoneyRecord.getState() == 301)//打款失败，钱返还给用户
            {
            	msg = "打款失败";
            	capitalout.setPayState(State.Failure);
            	capitalinoutService.update(capitalout);
            	//原来打款失败时有资金明细处理，新版需要更改，原版注释
            	
              /*  msg="打款失败";

                Double balance = frontUser.getBalance() == null ? 0 : frontUser.getBalance();
                Double availableBalance = frontUser.getAvailableBalance() == null ? 0 : frontUser.getAvailableBalance();
                
                Double newBalance = balance + capitalout.getMoney();
                Double newAvailableBalance = availableBalance + capitalout.getMoney();
                frontUser.setBalance(newBalance);
                frontUser.setAvailableBalance(newAvailableBalance);
                
                // 资金进
                Capitalinout capitalout2 = new Capitalinout();
                capitalout2.setUserId(payMoneyRecord.getUserId());
                capitalout2.setType(Constant.CAPITAL_IN);
                capitalout2.setMoney(capitalout.getMoney());
                capitalout2.setPayState(Constant.PAY_STATE_300);
                capitalout2.setTranNum(StringUtil.uniqueCode());
                capitalout2.setPayNum("提款审核失败退还给客户余额");
                capitalout2.setSource("PC");
                capitalout2.setPayType("back");
                capitalout2.setInType(4);//  募捐 : 0  充值 : 1   退款：4   出>> 助善 ： 2  提款：3
                capitalout2.setBalance(newAvailableBalance);
                
                int capitalSet = capitalinoutService.save(capitalout2);
                if (capitalSet > 0)
                {
                    int updateSet = userService.updateFrontUser(frontUser);
                    if (updateSet > 0)
                    {
                        Capitalinout capitalin2 = capitalinoutService.queryByTranNum(capitalout2.getTranNum());
                        capitalin2.setPayState(Constant.PAY_STATE_302);
                        capitalinoutService.update(capitalin2);
                        return super.responseSuccess("payMoneyRecord_list", "资金退款成功", null);
                    }
                    else
                    {
                        return super.responseFaild("payMoneyRecord_list", "资金退款失败", null);
                    }
                }*/
            	
            	
            }else{
                msg="打款成功";
                capitalout.setPayState(State.success);
            	capitalinoutService.update(capitalout);
                payMoneyRecord.setPayMoneyTime(new Date());
                Project project = projectService.queryById(payMoneyRecord.getProjectId());
                Double panyAmount = project.getPanyAmount() == null ? 0 :project.getPanyAmount();
                project.setPanyAmount(panyAmount+payMoneyRecord.getPanMoney());
                projectService.update(project);
            }
            payMoneyRecord.setOperator(super.getActionUser(req).getId());
            payMoneyRecordService.update(payMoneyRecord);

            model.put("payMoneyRecord", payMoneyRecord);
            saveLogDetail("打款记录状态修改ID:" + payMoneyRecord.getId()+msg);
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", msg, "payMoneyRecord_list", "", "closeCurrent", ""));
        }else{
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "参数错误", "payMoneyRecord_list", "", "closeCurrent", ""));
        }
    }
    
    /**
     * 查看收据
     */
    @RequestMapping(value="/showReceipt")
    public String showReceipt(PayMoneyRecord pMoneyRecord,ModelMap model){
    	
    	PayMoneyRecord payMoneyRecord = payMoneyRecordService.queryById(pMoneyRecord.getId());
    	String realPath = "http://res.17xs.org/picture/"; // 线上存储图片的绝对路径
    	List<BFile> imgList = new ArrayList<BFile>();
    	if(payMoneyRecord != null && StringUtil.isNotEmpty(payMoneyRecord.getReceiptImageId())){
    		String[] imageIds = payMoneyRecord.getReceiptImageId().split(",");
    		for(String imageid : imageIds){
    			if(StringUtil.isNotEmpty(imageid)){
    				BFile bFile = bFileService.queryById(Integer.parseInt(imageid));
    				if(bFile != null){
    					bFile.setUrl(realPath+bFile.getUrl());
    					imgList.add(bFile);
    				}
    			}
    		}
    	}
    	model.put("imgList", imgList);
    	return "bfile/bfile_list";
    }
}
