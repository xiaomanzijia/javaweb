package com.lsgx.admin.controller.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.LeaveWord;
import com.lsgx.admin.model.vo.LeaveWordVO;
import com.lsgx.admin.service.LeaveWordService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/leaveword")
public class LeaveWordController extends BaseController
{
    @Autowired
    private LeaveWordService leaveWordService;
    
    @RequestMapping(value = "/leaveWordList")
    @ActionLog(content = "查询留言列表")
    public String leaveWordList(LeaveWordVO vo, ModelMap model)
    {
        List<LeaveWord> list = leaveWordService.select(vo);
        List<LeaveWord> list12 = new ArrayList<LeaveWord>();
        for (LeaveWord lWord : list)
        {
            if (StringUtil.isNotEmpty(lWord.getContent()))
            {
                if (lWord.getContent().length() > 22)
                {
                    lWord.setContentShort(lWord.getContent().substring(0, 21) + "...");
                }
                else
                {
                    lWord.setContentShort(lWord.getContent());
                }
            }
            list12.add(lWord);
        }
        PageInfo<LeaveWord> page = new PageInfo<LeaveWord>(list);
        model.put("list", list12);
        model.put("page", page);
        model.put("leaveWord", vo);
        return "leaveword/leaveword_list";
    }
    
    @RequestMapping(value = "/delete")
    @ResponseBody
    @ActionLog(content = "查询留言列表")
    public String delete(@RequestParam("id")int id, ModelMap model)
    {
        if (id != 0)
        {
            leaveWordService.delete(id);
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "删除成功", "leaveword_list", "", "", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "删除失败", "leaveword_list", "", "", ""));
        }
    }
}
