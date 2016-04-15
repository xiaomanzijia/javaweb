package com.lsgx.admin.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.lsgx.admin.model.vo.BFileVO;
import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.BFile;

@Repository
public interface BFileMapper extends BaseMapper<BFile>
{
    List<BFile> queryByIdList(List<Integer> list);

    List<BFile> queryBFileList(BFileVO vo);

    int queryBFileListCount(Page page);
}
