package com.lsgx.admin.service;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.ArticleExample;
import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.FriendlylinkExample;
import com.lsgx.admin.model.vo.ArticleVO;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import test.BaseTest;

import javax.annotation.Resource;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lin on 2015/12/29.
 */
public class ArticleServiceTest extends BaseTest {

    @Resource
    private ArticleService articleService;


    @Resource FriendlyLinkService friendlyLinkService;



    @Test
    public void testInsert()
    {
        for (int i = 0; i < 20; i++) {
            Article article=new Article();
            article.setCategory("project");
            article.setContent("abc");
            article.setTitle("testtitle");
            article.setValid(1);
           articleService.insert(article);
        }




      //  assertEquals(dbArticle.getCategory(),article.getCategory());


    }

    @Test
    public void testInsertvolunteers()
    {
        for (int i = 0; i < 20; i++) {
            Article article=new Article();
            article.setCategory("volunteers");
            article.setContent("abc");
            article.setTitle("testtitle");
            article.setValid(1);
           articleService.insert(article);
        }




      //  assertEquals(dbArticle.getCategory(),article.getCategory());


    }

    @Test
    public void testInsertYY()
    {
        ArticleVO vo = new ArticleVO();
        List<ArticleVO> articleList = articleService.queryArticleList(vo);
        PageInfo<ArticleVO> page = new PageInfo<ArticleVO>(articleList);

        System.out.println("articleList = " + articleList.size());
        for (int i = 0; i < articleList.size(); i++) {
            ArticleVO articleVO = articleList.get(i);
            System.out.println("articleVO = " + articleVO.getUrl());
        }
    }

    @Test
    public void testLink()
    {
        System.out.println("测试链接数据");

        FriendlylinkExample link = new FriendlylinkExample();
        List<Friendlylink> links = friendlyLinkService.queryFriendlyLink(link);

        System.out.println("测试链接数据:"+links.get(0).getWebtitle()+links.get(0).getLinkurl());
    }


    @Test
    @Transactional
    @Rollback(true)
    public void testSelect()
    {
        Article article=new Article();
        article.setCategory("new");
        article.setContent("abc");
        article.setTitle("testtitle");

        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andCategoryEqualTo("new").andTitleLike("%test%");
        List<Article> result= articleService.selectByExample(articleExample);
       // List<Article> result2= articleService.selectByExampleWithBLOBs(articleExample);

        System.out.println("result.size() = " + result.size());
        for (int i = 0; i < result.size(); i++) {
            Article article1 = result.get(i);
            System.out.println("article1.getTitle() = " + article1.getTitle());
        }
      //  assertEquals(dbArticle.getCategory(),article.getCategory());


    }
}
