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
public class VolunteersController extends BaseController
{
    @Autowired
    private ArticleService articleService;

    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/volunteers.do")
    public String volunteers(ArticleVO vo,
                              ModelMap model){

        return "web/volunteers";

    }
    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/volunteersactiv.do")
    public String volunteersactiv(ArticleVO vo,
                              ModelMap model){
        String category = "volunteers";
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);
        saveLogDetail(null);
        return "web/volunteersactiv";

    }


    

}
