package com.lsgx.admin.mapper;

import com.github.pagehelper.Page;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.ArticleExample;
import com.lsgx.admin.model.vo.ArticleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleQueryMapper {

    List<ArticleVO> queryArticleList(ArticleVO vo);

    public int queryArticleListCount(Page<Article> page);
    //查询前7条数据
    List<Article> queryTOP7ArticleList();
}