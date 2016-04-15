package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.cache.ConfigCache;
import com.lsgx.admin.mapper.ConfigMapper;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.vo.ConfigQueryVO;

@Service("configService")
public class  ConfigService{
	
	@Autowired
	private ConfigMapper configMapper;
    
    private ConfigCache configCache = new ConfigCache();
	//更新系统参数信息
	public void update(Config config) {
		if(null != config)
		{
			configMapper.update(config);
            configCache.setValue(config.getConfigKey(), config.getConfigValue());
		}
		
	}
	
	    /**
     * 获取单个参数的信息
     * */
    public String selectByKey(String key)
    {
        String value = (String)configCache.getValue(key);
        if (value == null)
        {
            value = configMapper.selectByKey(key) == null ? null : configMapper.selectByKey(key).getConfigValue();
            if (value != null)
            {
                configCache.setValue(key, value);
            }
        }
        return value;
    }
    
    /**
     * 获取单个参数的信息
     * */
	public Config selectById(int id){
		return configMapper.selectById(id);
	}

	//查询体统参数信息
	public List<Config> queryAll() {
		return configMapper.queryAll();
	}

	/**
	 *  通过字段查询系统参数信息
	 *  @param config
	 * */
    public List<Config> queryByParam(Config config)
    {
        return configMapper.queryByParam(config);
    }
    
    /**
	 *  通过字段查询系统参数信息
	 *  @param configVO
	 * */
    public List<Config> queryByParam(ConfigQueryVO configVO)
    {
    	PageHelper.startPage(configVO.getPageNum(), configVO.getNumPerPage());
        return configMapper.queryByParam(configVO);
    }
    
    /**
     * 添加系统参数信息
     * @param configQueryVO
     * */
    public void configAdd(Config config){
    	configMapper.configAdd(config);
        configCache.setValue(config.getConfigKey(), config.getConfigValue());
    }
    
    /**
     * 删除参数信息
     * */
    public void configDelete(int id){
        Config config = selectById(id);
        if (config != null)
        {
            configMapper.configDelete(id);
            configCache.remove(config.getConfigKey());
        }
    }
    
    /**
     * 修改参数信息
     * */
    public void configEdit(Config config){
    	configMapper.configEdit(config);
        configCache.setValue(config.getConfigKey(), config.getConfigValue());
    }
    
}
