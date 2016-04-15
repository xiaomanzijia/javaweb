package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

public class News extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1418873132685031721L;
	
	private Integer id;
	/**
	 * 标题 不能为空
	 */
	private String title;
	/**
	 * 摘要
	 */
	private String abstracts;
	/**
	 * 新闻关键字
	 */
	private String keywords;
	/**
	 * 新闻内容
	 */
	private String content;
	/**
	 * 新闻访问量
	 */
	private Integer visits;
	/**
	 * 新闻时间
	 */
	private Date createTime;
	/**
	 * 是否置顶  0：不置顶 1：置顶
	 */
	private Integer top;
	/**
	 * 新闻栏目
	 */
	private String news_column;
	/**
	 * 新闻子栏目
	 */
	private String sub_column;
	/**
	 * 新闻三级栏目
	 */
	private String third_column;
	/**
	 * 新闻来源 0：pc 1：3G 2：Android
	 */
	private Integer source;
	/**
	 * 排序时间
	 */
	private Date orderTime;
	/**
	 * 是否显示 0：显示 1：不显示，草稿
	 */
	private Integer type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getVisits() {
		return visits;
	}
	public void setVisits(Integer visits) {
		this.visits = visits;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public String getNews_column() {
		return news_column;
	}
	public void setNews_column(String news_column) {
		this.news_column = news_column;
	}
	public String getSub_column() {
		return sub_column;
	}
	public void setSub_column(String sub_column) {
		this.sub_column = sub_column;
	}
	public String getThird_column() {
		return third_column;
	}
	public void setThird_column(String third_column) {
		this.third_column = third_column;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	

}
