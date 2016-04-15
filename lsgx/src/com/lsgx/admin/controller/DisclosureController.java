package com.lsgx.admin.controller;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.constants.SystemConstants;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.vo.ArticleVO;
import com.lsgx.admin.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Anonymous
public class DisclosureController extends BaseController
{
    @Autowired
    private ArticleService articleService;

    /**
     *  跳转修改页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/disclosuredetails.do")
    public String webDetail(Article article, HttpServletRequest req,
                            ModelMap model) {
        if (article != null && article.getId() != null)
        {

            Article dbArticle = articleService.selectByPrimaryKey(article.getId());
            ArticleVO vo= new ArticleVO();
            BeanUtils.copyProperties(dbArticle,vo);
            model.put("article", vo);
            if (SystemConstants.Article_volunteers.equals(dbArticle.getCategory())) {
                return "web/disclosuredetailsV";//志愿者界面和普通新闻界面不一样
            }else if(SystemConstants.Article_gyhd.equals(dbArticle.getCategory())){
                return "web/disclosuredetailsG";//公益活动
            }else if(SystemConstants.Article_zrfp.equals(dbArticle.getCategory())){
                return "web/disclosuredetailsZ";//致瑞扶贫基金
            }else if(SystemConstants.Article_lsqt.equals(dbArticle.getCategory())){
                return "web/disclosuredetailsZ";//绿色青藤残疾儿童艺术培训专项基金
            }else if(SystemConstants.Article_zqkm.equals(dbArticle.getCategory())){
                return "web/disclosuredetailsZ";//智骐抗霾基金
            }else{
                return "web/disclosuredetails";
            }

        }
        return "web/disclosuredetails";


    }

    /**
     *  项目动态  列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/disclosure.do")
    public String disclosure(HttpServletRequest req,ArticleVO vo,
                              ModelMap model){
        String category = SystemConstants.Article_project;
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);
        saveLogDetail(null);

        return "web/disclosure";

    }
    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/disclosuremedia.do")
    public String disclosuremedia(ArticleVO vo,
                              ModelMap model){
        String category = SystemConstants.Article_media;
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);
        saveLogDetail(null);
        return "web/disclosuremedia";

    }
    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/disclosurereport.do")
    public String disclosurereport(ArticleVO vo,
                              ModelMap model){
        String category = SystemConstants.Article_report;
        vo.setCategory(category);
        //调用sql查询方法
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);
        model.put("page", page);
        model.put("articleList", articleList);
        saveLogDetail(null);
        return "web/disclosurereport";

    }


    

}
