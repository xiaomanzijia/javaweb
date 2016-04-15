package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.Capitalinout;
@Repository
public interface CapitalinoutMapper extends BaseMapper<Capitalinout>
{

    public List<Capitalinout> queryByParam(Capitalinout capitalinout);
    
    public List<Capitalinout> queryUnPayAndTimeout();
    
    public Capitalinout queryByTranNum(String tranNum);
    
    public Capitalinout selectByuserId(Integer userId);
}
