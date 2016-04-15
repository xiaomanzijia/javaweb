package com.lsgx.admin.controller.capital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.DonateRecord;
import com.lsgx.admin.model.vo.DonateRecordVO;
import com.lsgx.admin.service.DonateRecordService;
import com.lsgx.admin.util.JsonUtil;

@Controller
@RequestMapping("/capital")
public class DonateRecordController extends BaseController
{
    @Autowired
    private DonateRecordService donateRecordService;
    
    @RequestMapping(value = "/donateRecordList")
    @ActionLog(content = "查询项目列表")
    public String donateRecordList(DonateRecordVO vo, ModelMap model)
    {
        List<DonateRecord> list = donateRecordService.select(vo);
        List<DonateRecord> donateRecords = new ArrayList<DonateRecord>();
        for(DonateRecord donateRecord:list){
        	if(donateRecord.getTouristMessage() !=null){
        		List<String> info = JsonUtil.jsonToList(donateRecord.getTouristMessage());
        		donateRecord.setName(info.get(0));
        		donateRecord.setMobile(info.get(1));
        	}
        	donateRecords.add(donateRecord);
        }
        
        PageInfo<DonateRecord> page = new PageInfo<DonateRecord>(list);
        model.put("list", donateRecords);
        model.put("page", page);
        model.put("donateRecord", vo);
        return "capital/donateRecord_list";
    }
    
}
