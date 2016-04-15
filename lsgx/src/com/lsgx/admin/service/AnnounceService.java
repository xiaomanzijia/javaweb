package com.lsgx.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.AnnounceMapper;
import com.lsgx.admin.model.Announce;
import com.lsgx.admin.model.vo.AnnounceVO;

@Service
public class AnnounceService
{
    
    @Autowired
    private AnnounceMapper announceMapper;
    
    public List<Announce> select(AnnounceVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return announceMapper.select(vo);
    }

    /**
     * @param announce
     * @param isDelay 是否延迟发送
     * @return
     * @throws BaseException 
     */
    public int update(Announce announce)
    {
        int n = 0;
        try
        {
            n = announceMapper.update(announce);
        }
        catch (Exception e)
        {
            //            logger.error("update database error.", e);
            //            throw new BaseException(ResultCode.Error);
        }
        return n;
    }
    
    public void save(Announce announce){
    	announceMapper.save(announce);
    }
}
