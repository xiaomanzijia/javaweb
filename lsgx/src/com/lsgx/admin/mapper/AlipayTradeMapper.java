package com.lsgx.admin.mapper;

import com.lsgx.admin.model.AlipayTrade;
import com.lsgx.admin.model.AlipayTradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlipayTradeMapper {
    int countByExample(AlipayTradeExample example);

    int deleteByExample(AlipayTradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlipayTrade record);

    int insertSelective(AlipayTrade record);

    List<AlipayTrade> selectByExample(AlipayTradeExample example);

    AlipayTrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlipayTrade record, @Param("example") AlipayTradeExample example);

    int updateByExample(@Param("record") AlipayTrade record, @Param("example") AlipayTradeExample example);

    int updateByPrimaryKeySelective(AlipayTrade record);

    int updateByPrimaryKey(AlipayTrade record);
}