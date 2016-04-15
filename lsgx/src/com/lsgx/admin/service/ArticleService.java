package com.lsgx.admin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ArticleMapper;
import com.lsgx.admin.mapper.ArticleQueryMapper;
import com.lsgx.admin.mapper.FriendlylinkMapper;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.ArticleExample;
import com.lsgx.admin.model.Friendlylink;
import com.lsgx.admin.model.FriendlylinkExample;
import com.lsgx.admin.model.vo.ArticleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by lin on 2015/12/29.
 */
@Service
public class ArticleService  {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleQueryMapper articleQueryMapper;


    //查询前7条数据
    public List<Article> queryTOP7ArticleList(){
        return articleQueryMapper.queryTOP7ArticleList();
    }
    /**
     * 用户列表查询
     * @return 用户列表信息
     */
    public List<ArticleVO> queryArticleList(ArticleVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return articleQueryMapper.queryArticleList(vo);
    }

    /**
     * 用户列表总数查询
     * @return 用户列表总条数
     */
    public int queryArticleListCount(Page<Article> page){
        return articleQueryMapper.queryArticleListCount(page);
    }
    
    public int countByExample(ArticleExample example) {
        return articleMapper.countByExample(example);
    }

    
    public int deleteByExample(ArticleExample example) {
        return articleMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Article record) {
        return articleMapper.insert(record);
    }

    
    public int insertSelective(Article record) {
        return articleMapper.insertSelective(record);
    }

    
    public List<Article> selectByExampleWithBLOBs(ArticleExample example) {
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    
    public List<Article> selectByExample(ArticleExample example) {
        return articleMapper.selectByExample(example);
    }

    
    public Article selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example) {
        return articleMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example) {
        return articleMapper.updateByExampleWithBLOBs(record,example);
    }

    
    public int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example) {
        return articleMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKeyWithBLOBs(Article record) {
        return articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    
    public int updateByPrimaryKey(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }
}
