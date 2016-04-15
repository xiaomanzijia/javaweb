package com.lsgx.admin.controller;

import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.mapper.FriendlylinkMapper;
import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.FriendlylinkExample;
import com.lsgx.admin.service.ArticleService;
import com.lsgx.admin.service.FriendlyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Anonymous
public class FooterController extends BaseController
{
    @Autowired
    private FriendlyLinkService friendlyLinkService;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/footer.do")
    public String footer(FriendlylinkExample link,
                              ModelMap model){
        List<Friendlylink> links = friendlyLinkService.queryFriendlyLink(link);
        model.put("links",links);
        return "web/footer";
    }
}
