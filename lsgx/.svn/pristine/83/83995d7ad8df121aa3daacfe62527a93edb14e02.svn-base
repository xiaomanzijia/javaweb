package com.lsgx.admin.controller.link;

import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.FriendlylinkExample;
import com.lsgx.admin.service.FriendlyLinkService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/link")
@Anonymous
public class LinkController extends BaseController
{
    @Autowired
    private FriendlyLinkService friendlyLinkService;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/friendlylink")
    public String footer(FriendlylinkExample link,
                              ModelMap model){
        List<Friendlylink> links = friendlyLinkService.queryFriendlyLink(link);
        model.put("links",links);
        return "link/link_list";
    }


    /**
     * 添加友情链接  get
     * */
    @RequestMapping(value = "/friendlylinkAdd",method=RequestMethod.GET)
    public String newsSend(HttpSession session){
        session.setAttribute("friendlylinkAdd", "添加友情链接");
        return "/link/link_add";
    }

    /**
     * 添加友情链接  post
     */
    @RequestMapping(value = "/friendlylinkAdd",method= RequestMethod.POST)
    @ResponseBody
    @ActionLog(content="添加友情链接")
    public String friendlyLinkAdd(Friendlylink link,ModelMap model){
        friendlyLinkService.addFriendlyLink(link);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add success", "friendlylink", "", "closeCurrent", ""));
    }

    /**
     * 删除友情链接
     */
    @RequestMapping(value = "/friendlylinkDelete",method= RequestMethod.POST)
    @ResponseBody
    @ActionLog(content="删除友情链接")
    public String friendlyLinkDelete(@RequestParam("id") int id,ModelMap model){
        friendlyLinkService.deleteFriendlyLink(id);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "friendlylink", "", "", ""));
    }

    /**
     * 获取编辑友情链接界面  get
     */
    @RequestMapping(value = "/friendlylinkEdit",method= RequestMethod.GET)
    public String friendlyLinkEdit(@RequestParam("id") int id,ModelMap model){
            Friendlylink link = friendlyLinkService.queryFriendlyLinkById(id);
            model.put("link",link);
        return "/link/link_editor";
    }


    /**
     * 获取编辑友情链接  post
     */
    @RequestMapping(value = "/friendlylinkEdit",method= RequestMethod.POST)
    @ResponseBody
    @ActionLog(content="编辑友情链接")
    public String editFriendlyLink(Friendlylink link,ModelMap model){
        if(link!=null && link.getId()!=null){
            friendlyLinkService.editFriendlyLink(link);
        }
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit success", "friendlylink", "", "closeCurrent", ""));
    }
}
