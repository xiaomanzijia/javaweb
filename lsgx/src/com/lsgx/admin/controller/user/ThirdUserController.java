package com.lsgx.admin.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ThirdUser;
import com.lsgx.admin.model.vo.ThirdUserVO;
import com.lsgx.admin.service.ThirdUserService;

@Controller
@RequestMapping("/thirduser")
public class ThirdUserController extends BaseController
{
    @Autowired
    private ThirdUserService thirdUserService;
    
    @RequestMapping(value = "/thirdUserList")
    @ActionLog(content = "查询第三方登陆用户列表")
    public String thirdUserList(ThirdUserVO vo, ModelMap model)
    {
        List<ThirdUser> list = thirdUserService.findByCondition(vo);
        
        PageInfo<ThirdUser> page = new PageInfo<ThirdUser>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("thirdUser", vo);
        return "user/thirdUser_list";
    }
}
