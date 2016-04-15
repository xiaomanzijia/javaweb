package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

public class ProjectUserInfo extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6221610408022979221L;
	private Integer id;
	/**
	 * 项目id
	 */
	private Integer projectId;
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 家庭住址
	 */
	private String familyAddress;
	/**
	 * 工作单位
	 */
	private String workUnit;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系电话
	 */
	private String linkMobile;
	/**
	 * 与受助人关系
	 */
	private String relation;
	/**
	 * 职位
	 */
	private String persition;
	/**
	 * 人物类型 0：受助人 1：证明人 2:发布人
	 */
	private Integer personType;
	/**
	 * 职业
	 */
	private String vocation;
	/**
	 * qq或微信号
	 */
	private String qqOrWx;
	/**
	 * 身份证号
	 */
	private String indetity;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFamilyAddress() {
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkMobile() {
		return linkMobile;
	}
	public void setLinkMobile(String linkMobile) {
		this.linkMobile = linkMobile;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getPersition() {
		return persition;
	}
	public void setPersition(String persition) {
		this.persition = persition;
	}
	public Integer getPersonType() {
		return personType;
	}
	public void setPersonType(Integer personType) {
		this.personType = personType;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getQqOrWx() {
		return qqOrWx;
	}
	public void setQqOrWx(String qqOrWx) {
		this.qqOrWx = qqOrWx;
	}
	public String getIndetity() {
		return indetity;
	}
	public void setIndetity(String indetity) {
		this.indetity = indetity;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
