package com.lsgx.admin.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsgx.admin.annotation.Anonymous;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.constants.SessionConstants;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.SystemLog;
import com.lsgx.admin.service.SystemLogService;
import com.lsgx.admin.util.HttpUtil;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter
{

    @Resource
    private SystemLogService systemLogService;
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception
    {
        if (!(handler instanceof BaseController))
        {
            return;
        }

        ActionUser user = (ActionUser)request.getSession().getAttribute(SessionConstants.SESSION_OPERATOR_USER);

        if (null == user)
        {
            return;
        }

        //        if(!req.getMethod().toUpperCase().equals("POST"))
        //        {
        //            return;
        //        }
        
        Method[] methods = handler.getClass().getMethods();
        for (Method method : methods)
        {
            RequestMapping anno = method.getAnnotation(RequestMapping.class);
            ActionLog actionLog = method.getAnnotation(ActionLog.class);
            
            if (null != anno && null != actionLog)
            {
                String[] values = anno.value();
                if (request.getRequestURI().contains(values[0]))
                {
                    saveSystemLog(request, (BaseController)handler, actionLog, user, values[0]);
                    return;
                }
            }
        }
    }
    
    private void saveSystemLog(HttpServletRequest request, BaseController baseController, ActionLog actionLog, ActionUser user, String url)
    {
        String content = actionLog.content();
        String detail = baseController.getDetail();
        
        SystemLog log = new SystemLog();
        log.setUserName(user.getUserName());
        log.setRealName(user.getRealName());
        log.setOperateTime(new Date());
        log.setIP(HttpUtil.getUserIp(request));
        log.setUrl(url);
        log.setContent(content);
        log.setOperateType("");
        log.setDetails(detail == null ? "" : detail);
        baseController.saveLogDetail("");
        
        try
        {
            systemLogService.save(log);
        }
        catch (Exception e)
        {
        }
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        Anonymous anonymous = handler.getClass().getAnnotation(Anonymous.class);
        if(anonymous!=null){
            System.out.println("发现匿名controller" );
            return true;
        }
        ActionUser user = (ActionUser)request.getSession().getAttribute(SessionConstants.SESSION_OPERATOR_USER);
        String returnUrl = request.getRequestURI();
        
        if (null == user)
        {
            if (returnUrl.indexOf("adminlogin.do") > 0 || returnUrl.indexOf("login.do") > 0)
            {
                return true;
            }
            else
            {
                response.setContentType("text/html");
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
                StringBuilder builder = new StringBuilder();
                builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
                builder.append("alert(\"登录超时,请重新登陆！\");");
                builder.append("window.location.href=\"/login.do\";");
                builder.append("</script>");
                out.print(builder.toString());
                out.close();
                return false;
            }
        }
        return true;
    }
    
}
