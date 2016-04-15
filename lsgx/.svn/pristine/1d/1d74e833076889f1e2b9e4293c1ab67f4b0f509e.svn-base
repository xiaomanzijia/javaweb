package com.lsgx.admin.cache;

import java.io.Serializable;

import net.sf.ehcache.Element;

import com.lsgx.admin.util.EncacheUtil;

public class ConfigCache extends EncacheUtil
{
    public ConfigCache()
    {
        super.setCacheName("configCache");
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
    }
}
