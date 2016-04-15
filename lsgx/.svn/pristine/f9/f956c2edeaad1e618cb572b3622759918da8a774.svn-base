package com.lsgx.admin.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.github.pagehelper.Page;


public final class StrUtil {
	private static Logger log = Logger.getLogger(StrUtil.class);

	private StrUtil() {

	}


	/**
	 * 
	 * @param Str
	 * @return true 整数，false非整数
	 */
	public static boolean isInt(String str) {

        if (StringUtil.isEmpty(str))
        {
			return false;
		}

		try {
			Integer.parseInt(str);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param str
	 * @return true正整数 false 非正整数
	 */
	public static boolean isPosInt(String str) {

        if (StringUtil.isEmpty(str))
        {
			return false;
		}

		boolean isNum = str.matches("[0-9]+");

		return isNum && isInt(str);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPosLong(String str) {
        if (StringUtil.isEmpty(str))
        {
			return false;
		}
		try {
			return Long.parseLong(str) > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isLong(String str) {
        if (StringUtil.isEmpty(str))
        {
			return false;
		}
		try {
			Long.parseLong(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isDouble(String str) {
        if (StringUtil.isEmpty(str))
        {
			return false;
		}
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}

	}


	/**
	 * 取得北京标准时间
	 * 
	 * @return
	 */
	public static Date getBeiJinTime() {
		try {

			// /取得资源对象
			URL url = new URL("http://www.bjtime.cn");
			// 生成连接对象
			URLConnection uc = url.openConnection();
			// 发出连接
			uc.connect();
			// 取得网站日期时间
			long ld = uc.getDate();
			// 转换为标准时间对象
			return new Date(ld);

		} catch (MalformedURLException e) {
			return new Date();
		} catch (IOException e) {
			return new Date();
		}

	}

	/**
	 * 创建page对象
	 * 
	 * @param req
	 * @return
	 */
	public static <T> Page<T> createPage(HttpServletRequest req) {
		Page<T> page = new Page<T>();
		String pageNo = req.getParameter("pageNum");
		String pageSize = req.getParameter("numPerPage");
		if (!StrUtil.isPosInt(pageNo) || "0".equals(pageNo)) {
            page.setPageNum(1);
		} else {
            page.setPageNum(Integer.parseInt(pageNo));
		}

        if (StringUtil.isEmpty(pageSize) || !StrUtil.isPosInt(pageSize))
        {
			page.setPageSize(20);
		} else {
			page.setPageSize(Integer.parseInt(pageSize));
		}
		return page;
	}

	
}
