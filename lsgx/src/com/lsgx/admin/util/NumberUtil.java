package com.lsgx.admin.util;

public final class NumberUtil
{
    public static int intValue(String value)
    {
        return intValue(value, 0);
    }
    
    public static int intValue(String value, int defaultValue)
    {
        if (!RegexUtil.isNumber(value))
        {
            return defaultValue;
        }

        try
        {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            return defaultValue;
        }
    }
    
    public static int intValue(boolean value)
    {
        return value == true ? 1 : 0;
    }

    
    public static void main(String[] args)
    {
        System.out.println(NumberUtil.intValue("098", 1));
        
    }
}

