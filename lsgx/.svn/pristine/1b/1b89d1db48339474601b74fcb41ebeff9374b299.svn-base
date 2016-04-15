package com.lsgx.admin.util;

public enum ResultCode
{
    
    Success(1, "成功"), Error(10001, "失败"),

    illegalError(10002, "包含非法字符"), tooManyCard(10003, "银行卡超限制"), hasBingding(10004, "银行卡已绑定"), companyExist(10005, "该企业已发起过认证"),

    buy_not_enough_copies(90001, "剩余份数不足"), buy_pay_num_error(90002, "支付号错误"), buy_donate_not_found(90003, "找不到认捐记录"), buy_not_enough_amount(90004, "剩余金额不足"),

    drawMoney_not_found(90005, "找不到提款记录"), CompanyGoodHelp_not_found(90006, "找不企业助善记录"), project_is_end(90007, "项目募捐已结束"), goodHelpProject_is_stop(90008, "企业助善已终止"), goodHelpProject_is_full(90009,
        "企业助善已满"), goodHelpProjectExist(90010, "企业对此项目已发起过助善"),

    ParameterError(-1, "参数错误"), UserNotExist(-2, "用户不存在"), WrongPassword(-3, "密码错误"), Disable(-101, "此用户已停用"), Pause(-102, "此用户已暂停"), Lock(-103, "此用户已锁定"), UserExist(-4, "用户名已经存在"), SystemError(-5,
        "系统错误"), FileNotExist(-6, "文件不存在");
    
    private int code;
    
    private String description;
    
    private ResultCode(int code, String description)
    {
        this.code = code;
        this.description = description;
    }
    
    public int getCode()
    {
        return code;
    }
    
    public String getDescription()
    {
        return description;
    }
}
