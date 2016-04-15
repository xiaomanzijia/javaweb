package com.lsgx.admin.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionUtil
{
    /**
     * session中用户名
     */
    //	public static final String SESSION_USERNAME = "session_username";
    /**
     * action中返回值
     */
    public static final class Result
    {
        /**成功*/
        public static final String SUCCESS = "success";
        
        /**返回输入页面*/
        public static final String INPUT = "input";
        
        /**重定向到登录页面*/
        public static final String LOGIN = "login";
        
        public static final String LOGIN_DIALOG = "login_dialog";
        
        /**内部转向到action属性中url值对应的jsp页面*/
        public static final String FORWARD = "forward";
        
        /**重定向到action属性中url值对应的地址*/
        public static final String REDIRECT = "redirect";
        
        /**内部转向到action属性中url值对应的action*/
        public static final String CHAIN = "chain";
    }
    
    /**
     * 是否ajax请求
     */
    public static boolean isAjaxRequest(HttpServletRequest request)
    {
        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * 得到分页的页数
     * @param total
     * @param pageSize
     * @return
     */
    public static int getNumOfPages(int totalCount, int pageSize)
    {
        if (totalCount <= 0)
        {
            return 0;
        }
        if (pageSize <= 0)
        {
            pageSize = 20;
        }
        if (totalCount % pageSize == 0)
        {
            return totalCount / pageSize;
        }
        else
        {
            return totalCount / pageSize + 1;
        }
    }
    
    /**
     * 得到dwz ajax返回的字符串
      "statusCode":"200", 
      "message":"操作成功", 
      "navTabId":"", 
      "rel":"", 
      "callbackType":"closeCurrent",
      "forwardUrl":""
     * 服务器转回navTabId可以把那个navTab标记为reloadFlag=1, 下次切换到那个navTab时会重新载入内容. 
     * callbackType如果是closeCurrent就会关闭当前tab
     * 只有callbackType="forward"时需要forwardUrl值
     * @return  Map<String,Object>
     */
    public static Map<String, Object> getAjaxToMap(String code, String msg, String navTabId, String rel, String callbackType, String forwardUrl)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("statusCode", code);
        map.put("message", msg);
        map.put("navTabId", navTabId);
        map.put("rel", rel);
        map.put("callbackType", callbackType);
        map.put("forwardUrl", forwardUrl);
        return map;
    }
    
    /**
     * 上传文件工具
     * @param src
     * @param dst
     */
    // 上传文件/复制文件。src本地文件路径，dst服务器文件路径
    public static void copyFile(File src, File dst)
    {
        try
        {
            int BUFFER_SIZE = 16 * 1024;
            InputStream in = null;
            OutputStream out = null;
            try
            {
                in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                for (int byteRead = 0; (byteRead = in.read(buffer)) > 0;)
                {
                    out.write(buffer, 0, byteRead);
                }
                
            }
            finally
            {
                if (null != in)
                {
                    in.close();
                }
                if (null != out)
                {
                    out.close();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     *  分页处理函数
     * @param totalPage
     * @param numPerPage
     * @param pageNum
     * @return
     */
    public static List<String> getPages(int totalPage, int numPerPage, int pageNum)
    {
        
        List<String> pages = new ArrayList<String>();
        int minNext = pageNum / numPerPage < 1 ? numPerPage * (pageNum / numPerPage) + 1 : numPerPage * (pageNum / numPerPage);
        int maxNext = numPerPage * (pageNum / numPerPage) + numPerPage - 1 >= totalPage ? totalPage : numPerPage * (pageNum / numPerPage) + numPerPage - 1;
        for (int j = minNext; j <= maxNext; j++)
        {
            pages.add(j + "");
        }
        if (maxNext < totalPage)
        {
            pages.add("0");
            pages.add(totalPage + "");
        }
        return pages;
        
    }
    
    /**
     * 判断字符串是否为空或空串
     * @param str
     * @return
     */
    public static boolean isEmpty(String... strs)
    {
        for (int i = 0; i < strs.length; i++)
        {
            if (strs[i] == null || strs[i].trim().length() <= 0)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * public static boolean isEmpty(String str){
    	return str==null||str.trim().length()==0;
    }
     */
    
    /**
     * 替换需要放入json属性值中的回车、单引号、双引号
     * @param msg
     * @return
     */
    public static String replaceSpecialCharactersForJson(String msg)
    {
        return msg.replace("\n", "\\n").replace("'", "\\'").replace("\"", "\\\"");
    }
    
    /**
     * 接口获取数据时，为空字符串处理
     * 
     */
    public static String urlencoders(String mess)
    {
        if (mess == null || mess.trim().length() <= 0)
        {
            mess = "";
            
        }
        else
        {
            
            try
            {
                mess = URLEncoder.encode(mess, "UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
                mess = "";
                //e.printStackTrace();
            }
        }
        return mess;

    }
    
    /**
     * 接口传参数中文解码处理
     * 
     */
    public static String urldecoders(String message)
    {
        if (message == null || message.trim().length() <= 0)
        {
            message = "";
        }
        else
        {
            try
            {
                message = URLDecoder.decode(message, "UTF-8");
            }
            catch (UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                message = "";
                
                //e.printStackTrace();
            }
        }
        return message;
    }
}