package com.lsgx.admin.tag;

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.lsgx.admin.model.ActionFunction;

public class PrivilegeTag extends TagSupport
{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 按钮编码
     */
    private String buttonCode;
    
    public int doStartTag()
        throws JspException
    {
        @SuppressWarnings("unchecked")
        Map<String, ActionFunction> map =
            (Map<String, ActionFunction>)pageContext.getSession().getAttribute("funListSession");
        
        if (null != map && !map.isEmpty() && null != map.get(buttonCode))
        {
            return EVAL_PAGE;
        }
        return SKIP_BODY;
    }
    
    public String getButtonCode()
    {
        return buttonCode;
    }
    
    public void setButtonCode(String buttonCode)
    {
        this.buttonCode = buttonCode;
    }
}
