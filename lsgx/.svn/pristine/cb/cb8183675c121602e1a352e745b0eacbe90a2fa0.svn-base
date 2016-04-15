package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.MessageModel;
import com.lsgx.admin.model.vo.MessageModelVO;

@Repository
public interface MessageModelMapper extends BaseMapper<MessageModel>
{
    List<MessageModel> findByCondition(MessageModelVO vo);
    
    MessageModel queryByModelName(String modelName);
}
