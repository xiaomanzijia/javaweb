package com.lsgx.admin.exception;

import com.lsgx.admin.util.ResultCode;

public class BaseException extends Exception
{
    
    /**
    * 注释内容
    */
    
    private static final long serialVersionUID = 3988874950233746140L;
    
    private ResultCode resultCode;

    public BaseException()
    {
        super();
    }
    
    public BaseException(ResultCode resultCode)
    {
        super(resultCode.getDescription());
        this.resultCode = resultCode;
    }

    public BaseException(ResultCode resultCode, Throwable t)
    {
        super(resultCode.getDescription(), t);
        this.resultCode = resultCode;
    }

    @Override
    public String toString()
    {
        return "errorCode:" + resultCode.getCode() + ", msg:" + getMessage();
    }
    
    public ResultCode getResultCode()
    {
        return resultCode;
    }
    
}

