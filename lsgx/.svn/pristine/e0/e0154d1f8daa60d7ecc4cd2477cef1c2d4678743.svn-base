package com.lsgx.admin.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.SystemLog;
import com.lsgx.admin.model.vo.LogQueryVO;
import com.lsgx.admin.service.SystemLogService;

@Controller
@RequestMapping("/system")
public class LogController extends BaseController
{
    @Autowired
    private SystemLogService systemLogService;
    
    @RequestMapping("/logList")
    public String showLogList(LogQueryVO vo, ModelMap model)
    {
        List<SystemLog> list = systemLogService.findByCondition(vo);

        PageInfo<SystemLog> page = new PageInfo<SystemLog>(list);

        model.put("list", list);
        model.put("page", page);
        model.put("param", vo);
        return "system/sys_log_list";

    }
}

