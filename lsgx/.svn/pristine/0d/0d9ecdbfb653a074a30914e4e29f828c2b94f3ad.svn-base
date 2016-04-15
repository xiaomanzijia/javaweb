package com.lsgx.admin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtil
{
    /**
     * Email正则表达式
     */
    private static final String EMAIL_REGEX = "^([a-z0-9]+[-|\\.]?)+[a-z0-9]@([a-z0-9]+(-[a-z0-9]+)?\\.)+[a-z]{2,}$";

    public static final String MOBILE_REGEX = "^1(3|5|8){1}[0-9]{1}[0-9]{8}$";
    
    public static final String NUMBER_REGEX = "[0-9]+";

    /**
     * 验证数据的有效性
     *
     * @param valContent 验证的内容
     * @param regex      验证表达式
     * @return boolean
     */
    public static boolean validate(String content, String regex)
    {
        if (StringUtil.isEmpty(content) || StringUtil.isEmpty(regex))
        {
            return false;
        }

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        return matcher.matches();
    }

    /**
     * 验证Email的有效性
     *
     * @param email 验证的内容
     * @return boolean  验证是否通过
     */
    public static boolean valEmail(String email)
    {
        return validate(email, EMAIL_REGEX);
    }

    /**
     * 验证手机号码的有效性
     *
     * @param phone 验证的内容
     * @return boolean  验证是否通过
     */
    public static boolean valPhone(String phone)
    {
        return validate(phone, MOBILE_REGEX);
    }
    
    public static boolean isNumber(String str)
    {
        return validate(str, NUMBER_REGEX);
    }
}
