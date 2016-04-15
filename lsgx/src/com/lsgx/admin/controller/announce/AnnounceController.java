package com.lsgx.admin.controller.announce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.Announce;
import com.lsgx.admin.model.vo.AnnounceVO;
import com.lsgx.admin.service.AnnounceService;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/announce")
public class AnnounceController extends BaseController
{
    @Autowired
    private AnnounceService announceService;
    
    @RequestMapping(value = "/announceList")
    @ActionLog(content = "查询短信列表")
    public String announceList(AnnounceVO vo, ModelMap model)
    {
        List<Announce> list = announceService.select(vo);
        List<Announce> list12 = new ArrayList<Announce>();
        for (Announce announce : list)
        {
            if (StringUtil.isNotEmpty(announce.getTitle()))
            {
                if (announce.getTitle().length() > 13)
                {
                    announce.setTitleShort(announce.getTitle().substring(0, 12) + "...");
                }
                else
                {
                    announce.setTitleShort(announce.getTitle());
                }
            }
            if (StringUtil.isNotEmpty(announce.getCause()))
            {
                if (announce.getCause().length() > 13)
                {
                    announce.setCauseShort(announce.getCause().substring(0, 12) + "...");
                }
                else
                {
                    announce.setCauseShort(announce.getCause());
                }
            }
            if (StringUtil.isNotEmpty(announce.getContent()))
            {
                if (announce.getContent().length() > 25)
                {
                    announce.setContentShort(announce.getContent().substring(0, 24) + "...");
                }
                else
                {
                    announce.setContentShort(announce.getContent());
                }
            }
            list12.add(announce);
        }
        PageInfo<Announce> page = new PageInfo<Announce>(list);
        
        model.put("list", list12);
        model.put("page", page);
        model.put("announce", vo);
        return "announce/announce_list";
    }
}
