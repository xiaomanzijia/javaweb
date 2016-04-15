package com.lsgx.admin.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class HttpUtil
{
    private static Logger logger = Logger.getLogger(HttpUtil.class);

    public static String getUserIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }

        if (ip != null && ip.contains(","))
        {
            // 因为有时中间代理太多，获取到的IP不止一个，这里取第一个
            ip = ip.substring(0, ip.indexOf(','));
        }
        
        logger.debug("ipaddress:" + ip);

        return ip;
    }
    
}
