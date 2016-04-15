package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.PayMoneyRecord;
import com.lsgx.admin.model.vo.PayMoneyRecordVO;

@Repository
public interface PayMoneyRecordMapper extends BaseMapper<PayMoneyRecord>
{
    List<PayMoneyRecord> select(PayMoneyRecordVO vo);
}
