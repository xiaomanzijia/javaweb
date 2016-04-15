package com.lsgx.admin.scheduling;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsgx.admin.constants.State;
import com.lsgx.admin.model.CompanyGoodHelp;
import com.lsgx.admin.service.CompanyGoodHelpService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.util.StringUtil;

/**
 * 定时任务取消未付款的助善
 * @author yangc
 *
 */

public class CancelHelpGoodSchedule {
	
	protected transient final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private CompanyGoodHelpService companyGoodHelpService;
	
	@Autowired
    private ConfigService configService;
	
	private String runState = null;
	
	public void task(){
		
		runState = configService.selectByKey("cancel_noPay_helpGood_schedule");
		if(StringUtil.isNotEmpty(runState)&& ("true").equals(runState.trim())){
		  try{
			  List<CompanyGoodHelp> companyGoodHelps = companyGoodHelpService.queryUnPayAndTimeout();
			  if(companyGoodHelps !=null && companyGoodHelps.size() > 0){
				  for(CompanyGoodHelp companyGoodHelp : companyGoodHelps){
					  companyGoodHelp.setPayState(State.notPay);
					  companyGoodHelp.setState(State.notPass);
					  companyGoodHelpService.updateCompanyGoodHelp(companyGoodHelp);
					  logger.info("超时未支付助善金额："+companyGoodHelp.getId());
				  }
			  }
		  }catch(Exception e){
			  e.printStackTrace();
              logger.error(e.getCause());
		  }
			
		}
		
	}
	
	
}
