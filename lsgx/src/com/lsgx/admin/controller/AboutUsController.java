package com.lsgx.admin.controller;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.vo.ArticleVO;
import com.lsgx.admin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Anonymous
public class AboutUsController extends BaseController
{
    @Autowired
    private ArticleService articleService;

    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/aboutus.do")
    public String index(ArticleVO vo,
                              ModelMap model){

        return "web/aboutus";

    }

    @RequestMapping(value = "/aboutarticles.do")
    public String aboutarticles(ArticleVO vo,
                              ModelMap model){

        return "web/aboutarticles";

    }


    @RequestMapping(value = "/aboutboard.do")
    public String aboutboard(ArticleVO vo,
                              ModelMap model){

        return "web/aboutboard";

    }


    @RequestMapping(value = "/aboutstructur.do")
    public String aboutstructur(ArticleVO vo,
                              ModelMap model){

        return "web/aboutstructur";

    }


    @RequestMapping(value = "/aboutcontact.do")
    public String aboutcontact(ArticleVO vo,
                              ModelMap model){

        return "web/aboutcontact";

    }


    @RequestMapping(value = "/aboutintroduc.do")
    public String aboutintroduc(ArticleVO vo,
                              ModelMap model){

        return "web/aboutintroduc";

    }


    @RequestMapping(value = "/aboutsponsors.do")
    public String aboutsponsors(ArticleVO vo,
                              ModelMap model){

        return "web/aboutsponsors";

    }


    

}
