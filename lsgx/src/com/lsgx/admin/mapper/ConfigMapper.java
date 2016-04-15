package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.vo.ConfigQueryVO;
@Repository
public interface ConfigMapper extends BaseMapper<Config>
{
	//更新系统参数
    int update(Config config);
    //获取单个参数的信息
    Config selectById(int id);
    //查询系统参数
	List<Config> queryAll();
	//通过字段查询系统参数
	List<Config> queryByParam(ConfigQueryVO configQueryVO);
	//新增系统参数
	void configAdd(Config config);
	//删除参数
	void configDelete(int id);
	//修改参数信息
	void configEdit(Config config);
	
    public Config selectByKey(String configKey);
}
