package com.lsgx.admin.controller;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.constants.SystemConstants;
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
public class PovertyController extends BaseController
{
    @Autowired
    private ArticleService articleService;

    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/poverty.do")
    public String index(ArticleVO vo,
                              ModelMap model){
        String category = SystemConstants.Article_zrfp;
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);

        return "web/poverty";

    }

    /**
     *  智骐抗霾基金信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/povertyzqkm.do")
    public String indexzqkm(ArticleVO vo,
                              ModelMap model){
        String category = SystemConstants.Article_zqkm;
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);

        return "web/povertyzqkm";

    }

    /**
     *  智骐抗霾基金信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/povertylsqt.do")
    public String indexlsqt(ArticleVO vo,
                              ModelMap model){
        String category = SystemConstants.Article_lsqt;
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);

        return "web/povertylsqt";

    }


    

}
