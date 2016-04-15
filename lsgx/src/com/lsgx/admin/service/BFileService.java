package com.lsgx.admin.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsgx.admin.model.vo.BFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsgx.admin.mapper.BFileMapper;
import com.lsgx.admin.model.BFile;


@Service("bFileService")
public class BFileService
{
    
    @Autowired
    private BFileMapper bFileMapper;
    
    public BFile queryById(Integer id)
    {
        return bFileMapper.queryById(id);
    }
    
    public int save(BFile data)
    {
        return bFileMapper.save(data);
    }
    
    public List<BFile> queryByParam(BFile param)
    {
        return bFileMapper.queryByParam(param);
    }
    
    public void delete(int id)
    {
        bFileMapper.delete(id);
    }
    /**
     * 更新图片信息
     */
    public int update(BFile bFile){
    	return bFileMapper.update(bFile);
    }


    public  List<BFile> queryBFileList(BFileVO vo){
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return bFileMapper.queryBFileList(vo);
    }

    public  int queryBFileListCount(Page page){
        return bFileMapper.queryBFileListCount(page);
    }
}
