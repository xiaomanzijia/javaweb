package com.lsgx.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.lsgx.admin.constants.SessionConstants;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;

@Controller
public class BaseController
{
    protected transient final Logger logger = Logger.getLogger(getClass());
    
    private String detail;

    public void saveLogDetail(String detail)
    {
        this.detail = detail;
    }
    
    public String getDetail()
    {
        return detail;
    }

    public void saveAdmin(HttpServletRequest req, ActionUser user)
    {
        setAttribute(req, SessionConstants.SESSION_OPERATOR_USER, user);
    }
    
    public void removeAdmin(HttpServletRequest req)
    {
        req.getSession().removeAttribute(SessionConstants.SESSION_OPERATOR_USER);
    }

    public ActionUser getActionUser(HttpServletRequest req)
    {
        return (ActionUser)req.getSession().getAttribute(SessionConstants.SESSION_OPERATOR_USER);
    }

    public void setAttribute(HttpServletRequest request, String key, Object object)
    {
        request.getSession().setAttribute(key, object);
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    
    /**
     * 
     * @param rel
     * @param msg
     * @param callbackType callbackType如果是closeCurrent就会关闭当前tab 或是dialog
     * @return
     */
    public String responseSuccess(String rel, String msg, String callbackType)
    {
        if (callbackType == null)
        {
            callbackType = "";
        }
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", msg, rel, "", callbackType, ""));
    }
    
    /**
     * 
     * @param rel
     * @param msg
     * @param callbackType callbackType如果是closeCurrent就会关闭当前tab 或是dialog
     * @return
     */
    public String responseFaild(String rel, String msg, String callbackType)
    {
        if (callbackType == null)
        {
            callbackType = "";
        }
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", msg, rel, "", callbackType, ""));
    }
}

