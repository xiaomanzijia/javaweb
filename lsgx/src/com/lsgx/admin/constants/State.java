package com.lsgx.admin.constants;

public interface State {
	
	/**
	 * 启用
	 */
	int enable = 100;
	
	/**
	 * 停用
	 */
	int disable = 101;
	
	/**
	 * 暂停
	 */
	int pause = 102;
	
	/**
	 * 锁定
	 */
	int lock = 103;
	
	/**
	 * 保存未提交
	 */
	int uncommitted = 200;
	
	/**
	 * 提交未审核
	 */
	int submitAudit = 201;
	
	/**
	 * 审核未通过
	 */
	int notPass = 202;
	
	/**
	 * 审核通过
	 */
	int pass = 203;
	
	/**
	 * 募捐中 
	 */
	int donationing = 204;
	
	/**
	 *  募捐结束
	 */
	int donationed = 205;
	
	/**
	 * 执行中
	 */
	int  implementing  = 206;
	
	/**
	 * 结束
	 */
	int end = 207;
	
	/**
	 * 审核中 项目中的状态使用
	 */
	int  not_interview= 210;
	
	/**
	 * 待发布 项目中的状态使用
	 */
	int not_audit = 220;
	
	/**
	 * 审核未通过 项目中的状态使用
	 */
	int verify_not_pass = 230;
	
	/**
	 * 募捐中 项目中的状态使用
	 */
	int donations = 240;
	
	/**
	 * 执行中 项目中的状态使用
	 */
	int  implementation  = 250;
	
	/**
	 * 结束 项目中的状态使用
	 */
	int projectEnd = 260;
	
	/**
	 * 未捐款、未打款、未支付
	 */
	int notPay=  300;
	
	/**
	 * 失败 301
	 */
	int Failure = 301;
	
	/**
	 * 成功
	 */
	int success = 302;
	
	/**
	 * 资金进类型,募捐 : 0  
	 */
	int  donation= 0;
	
	   
	/**
	 * 资金进类型,充值 : 1
	 */
	int  charge= 1;
	   
	/**
     * 资金进类型,终止退款：4        
	*/
    int  end_refund= 4;
    
    /**
     * 资金进类型，审核不通过退款：5
     */
    int verify_fail_refund=5;
    
    /**
     * 资金进类型，募捐已完成退款 ： 6
     */
    int donation_end_refund=6;
    
    /**
     * 资金进类型，募捐项目提前终止退款 ： 7
     */
    int early_end=7;
    
    /**
     * 资金出类型，助善 ： 2
     */
    int help_charty=2;
    
    /**
     * 资金出类型，提款：3
     */
    int draw=3;
	
			
}
