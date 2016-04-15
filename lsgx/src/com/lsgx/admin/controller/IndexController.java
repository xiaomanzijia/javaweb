package com.lsgx.admin.controller;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.vo.ArticleVO;
import com.lsgx.admin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Anonymous
public class IndexController extends BaseController
{
    @Autowired
    private ArticleService articleService;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index.do")
    public String index(ArticleVO vo,
                              ModelMap model){
        //调用sql查询方法
        List<Article> topList = articleService.queryTOP7ArticleList();

        model.put("toplist", topList);

        return "web/index";

    }
}
