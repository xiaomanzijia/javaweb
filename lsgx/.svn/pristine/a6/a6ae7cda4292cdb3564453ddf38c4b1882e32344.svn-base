package com.lsgx.admin.util;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EncacheUtil
{
    
    //    public static final String FILE_PATH = "ehcache.xml";
    
    protected CacheManager cacheManager;
    
    protected Cache sample;
    
    protected Element element;
    
    private String cacheName = "configCache";
    
    public String getCacheName()
    {
        return cacheName;
    }
    
    public void setCacheName(String cacheName)
    {
        this.cacheName = cacheName;
    }

    public void init()
    {
        cacheManager = CacheManager.create();
        // 获取ehcache配置文件中的一个cache
        sample = cacheManager.getCache(cacheName);
    }
    
    public Object getValue(String key)
    {
        init();
        element = sample.get(key);
        if (element == null)
        {
            return null;
        }
        return element.getValue();
    }
    
    public void setValue(String key, Object value)
    {
        init();
        element = new Element(key, (Serializable)value);
        sample.put(element);
        //        cacheManager.shutdown();
    }
    
    public void remove(String key)
    {
        init();
        if (sample.isKeyInCache(key))
        {
            sample.remove(key);
        }
    }
    
    public static void main(String[] args)
    {
        EncacheUtil encacheUtil = new EncacheUtil();
        String teString = (String)encacheUtil.getValue("test");
        if (teString == null)
        {
            encacheUtil.setValue("test", "helloworld");
        }
        teString = (String)encacheUtil.getValue("test");
        System.out.println(teString);
    }
}
