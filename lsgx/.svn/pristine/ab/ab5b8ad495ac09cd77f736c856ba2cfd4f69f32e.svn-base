package com.lsgx.admin.scheduling;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsgx.admin.constants.State;
import com.lsgx.admin.model.Capitalinout;
import com.lsgx.admin.model.CompanyGoodHelp;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.Project;
import com.lsgx.admin.model.vo.CompanyGoodHelpVO;
import com.lsgx.admin.service.CapitalinoutService;
import com.lsgx.admin.service.CompanyGoodHelpService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.DonateRecordService;
import com.lsgx.admin.service.ProjectService;
import com.lsgx.admin.service.UserService;
import com.lsgx.admin.util.Constant;
import com.lsgx.admin.util.StringUtil;

/**
 * 定时任务
 * 终止善管家手动终止的项目的助善
 * @author yangc
 */
public class FinishHelpGoodOfEndProject {
	
	protected transient final Logger logger = Logger.getLogger(getClass());
	
	//项目service
	@Autowired
	private ProjectService prService;
	//配置信息service
	@Autowired
    private ConfigService configService;
	//前台用户service
	@Autowired
    private UserService userService;
	//资金进出service
	@Autowired
	private CapitalinoutService capitalinoutService;
	//企业助善service
	@Autowired
	private CompanyGoodHelpService companyGoodHelpService;
	
	@Autowired
	private DonateRecordService donateRecordService;
	
	private String runState =null;
	
	public void job(){
		runState = configService.selectByKey("finish_helpgood_endproject");
		if(StringUtil.isNotEmpty(runState)&&("true").equals(runState.trim())){
			try {
				List<Project> projects = prService.selectEndProject();
				if(projects != null && projects.size()>0){
					for(Project project :projects){
						CompanyGoodHelpVO cGoodHelpVO = new CompanyGoodHelpVO();
						cGoodHelpVO.setProject_id(project.getId());
						 //通过项目id得到企业的助善信息
						List<CompanyGoodHelp> cGoodHelps = companyGoodHelpService.queryByParam(cGoodHelpVO); 
						if(cGoodHelps != null && cGoodHelps.size() >0){
							for(CompanyGoodHelp cGoodHelp:cGoodHelps){
								  if(cGoodHelp !=null && cGoodHelp.getLeaveAmount()!= null){
									  //助善企业状态为201或203的企业终止助善
									if(cGoodHelp.getState() == State.submitAudit || cGoodHelp.getState() == State.pass){
											if(cGoodHelp.getLeaveAmount()!=0){
												//设置用户的账户余额
												FrontUser frontUser = userService.queryById(cGoodHelp.getUserId());
												Double balance = frontUser.getBalance() == null ? 0 : frontUser.getBalance();
							                    Double availableBalance = frontUser.getAvailableBalance() == null ? 0 : frontUser.getAvailableBalance();
												//设置用户资金流动情况
												Capitalinout capitalinout = new Capitalinout();
												capitalinout.setUserId(cGoodHelp.getUserId());
												capitalinout.setType(0); //0：资金进 1：资金出
												capitalinout.setInType(State.early_end);
												capitalinout.setMoney(cGoodHelp.getLeaveAmount());
												capitalinout.setSource("PC");
												capitalinout.setTranNum(StringUtil.uniqueCode());
												capitalinout.setPayState(State.success);
												capitalinout.setBalance(balance+cGoodHelp.getLeaveAmount());
												capitalinout.setPayType("back");
												capitalinout.setCreateTime(new Date());

												int capital_flag = capitalinoutService.save(capitalinout);	
												logger.info("资金流动更新"+capitalinout.getId());
												
												if(capital_flag > 0){
													//记录捐款记录
													DonateRecord donate = new DonateRecord();
									                donate.setCapitalinoutId(capitalinout.getId());
									                donate.setUserId(cGoodHelp.getUserId());
									                donate.setProjectId(cGoodHelp.getProject_id());
									                donate.setDonorType(cGoodHelp.getUserId() != null ? Constant.DONOR_TYPE_IN : Constant.DONOR_TYPE_OUT);
									                donate.setState(Constant.PAY_STATE_302);
									                donate.setDonatTime(new Date());
									                donate.setDonatAmount(cGoodHelp.getLeaveAmount());
									                donate.setDonatType("goodHelpBack");
									                donateRecordService.save(donate);
													//更新用户余额
									                frontUser.setBalance(balance+cGoodHelp.getLeaveAmount());
													frontUser.setAvailableBalance(availableBalance+cGoodHelp.getLeaveAmount());
													userService.updateFrontUser(frontUser);
													logger.info("变动用户余额"+frontUser.getId());
												}
												
												//助善结束
												cGoodHelp.setStopReason("您助善的项目已被终止！");
												cGoodHelp.setLeaveAmount(0.0);
												logger.info(cGoodHelp.getId()+"助善状态更改之前"+cGoodHelp.getState());
												cGoodHelp.setState(State.end);
												logger.info(cGoodHelp.getId()+"助善状态更改之后"+cGoodHelp.getState());
												companyGoodHelpService.updateCompanyGoodHelp(cGoodHelp);
												logger.info("企业助善结束"+cGoodHelp.getId());
											}
											//助善结束
											cGoodHelp.setStopReason("您助善的项目已被终止！");
											logger.info(cGoodHelp.getId()+"助善状态更改之前"+cGoodHelp.getState());
											cGoodHelp.setState(State.end);
											logger.info(cGoodHelp.getId()+"助善状态更改之后"+cGoodHelp.getState());
											companyGoodHelpService.updateCompanyGoodHelp(cGoodHelp);
											logger.info("企业助善结束"+cGoodHelp.getId());
										}
									}
								}
						}
					}
				}
			} catch (Exception e) {
				e.getStackTrace();
				logger.error(e.getCause());
			}
		}
	}

}
