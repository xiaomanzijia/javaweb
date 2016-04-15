package com.lsgx.admin.model;

import java.io.Serializable;

/**
 * 类目配置表
 */

public class Category extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -744742875828789390L;
	
	private Integer id;
	
	/**
	 * 排序号
	 */
	private Integer sort;
	
	/**
	 * 类目名称
	 */
	private String typeName;
	/**
	 * 类目名称对应的英文名
	 */
	private String typeName_e;
	
	/**
	 * 所需要的资料
	 */
	private String needdata;
	
	/**
	 * 模板
	 */
	private String model;
	
	private String modelShort;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName_e() {
		return typeName_e;
	}

	public void setTypeName_e(String typeName_e) {
		this.typeName_e = typeName_e;
	}

	public String getNeeddata() {
		return needdata;
	}

	public void setNeeddata(String needdata) {
		this.needdata = needdata;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelShort() {
		return modelShort;
	}

	public void setModelShort(String modelShort) {
		this.modelShort = modelShort;
	}
	
	
	
}
