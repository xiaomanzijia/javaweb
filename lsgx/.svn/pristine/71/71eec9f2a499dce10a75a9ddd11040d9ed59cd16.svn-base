package com.lsgx.admin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lsgx.admin.model.DonateRecord;

@Repository
public interface DonateRecordMapper extends BaseMapper<DonateRecord>
{

    /**
     * 捐赠排行榜
     * @param donateRecord
     * @return
     */
    List<DonateRecord> queryByDonate(DonateRecord donateRecord);
    
    /**
     * 信息统计
     *      1、捐助次数，捐助总额
     *          2、企业助善号召网友数，企业助善总额
     * @param donateRecord
     * @return
     */
    DonateRecord countByParam(DonateRecord donateRecord);
    
    /**
     * 保存捐款记录
     * @param donateRecord
     * @return
     */
    int save(DonateRecord donateRecord);
}
