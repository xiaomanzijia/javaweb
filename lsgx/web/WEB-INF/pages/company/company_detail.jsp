<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/viewimg1.css">

<div class="pageContent">
	<div class="tabs" currentIndex="0" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>基本信息</span></a></li>
					<li><a href="javascript:;"><span>企业认证图片</span></a></li>
					<li><a href="javascript:;"><span>头像</span></a></li>
					<li><a href="javascript:;"><span>企业Logo</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div style="width:100%;height:530px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td>发起人:</td>
							<td >
								<a
									href="user/showDetail.do?id=${company.userId }"
									target="dialog" width="680" height="580" style="color:blue;"
									rel="show_project" title="前端用户详情"  resizable="true" mask="true"
									maxable="false" drawable="true">${company.userId }
								</a>
							</td>
						</tr>
						<tr >
							<td width="180">企业名称:</td>
							<td>${company.name}</td>
						</tr>
						<tr >
							<td>地址:</td>
							<td>${company.address}</td>
						</tr>
						<tr >
							<td>负责人:</td>
							<td>${company.head}</td>
						</tr>
						<tr >
							<td>企业简介:</td>
							<td><textarea class="readonly" readonly="readonly" rows="5" cols="80">${company.introduction}</textarea></td>
						</tr>
						<tr >
							<td>手机号码:</td>
							<td>${company.mobile}</td>
						</tr>
						<tr >
							<td>企业注册号:</td>
							<td>${company.registerNo}</td>
						</tr>
						<tr >
							<td>组织机构代码:</td>
							<td>${company.groupCode}</td>
						</tr>
						<tr >
							<td>法定代表人姓名:</td>
							<td>${company.legalName}</td>
						</tr>
						<tr >
							<td>身份证:</td>
							<td>${company.identity}</td>
						</tr>
						<tr >
							<td>最后一次修改时间:</td>
							<td><fmt:formatDate value="${company.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>注册时间:</td>
							<td><fmt:formatDate value="${company.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>手机验证状态:</td>
							<td>
								<c:if test="${company.mobileState==201}">未审核</c:if>
								<c:if test="${company.mobileState==202}">审核未通过</c:if>
								<c:if test="${company.mobileState==203}">验证审核通过</c:if>
							</td>
						<tr >
							<td>公司网址:</td>
							<td>${company.url}</td>
						</tr>
						<tr >
							<td>企业类型:</td>
							<td>
								<c:if test="${company.type==0}">企业</c:if>
								<c:if test="${company.type==1}">事业单位</c:if>
								<c:if test="${company.type==2}">社会团体</c:if>
								<c:if test="${company.type==3}">党政及国家机关</c:if>
							</td>
						</tr>
						
						<tr >
							<td>企业信息:</td>
							<td><textarea class="readonly" readonly="readonly" rows="5" cols="80" >${company.infomation}</textarea></td>
						</tr>
						<tr >
							<td>企业使用状态:</td>
							<td>
								<c:if test="${company.useState==100}">正常</c:if>
								<c:if test="${company.useState==101}">信用</c:if>
								<c:if test="${company.useState==102}">暂停</c:if>
							</td>
						</tr>
						<tr >
							<td>企业认证状态:</td>
							<td >
								<c:if test="${company.state==201}">未认证</c:if>
								<c:if test="${company.state==202}">认证失败</c:if>
								<c:if test="${company.state==203}">认证通过</c:if>
							</td>
						</tr>
						<tr >
							<td>手机号验证状态:</td>
							<td >
								<c:if test="${company.mobileState == 200}">未填写手机号验证信息</c:if>
								<c:if test="${company.mobileState == 201}">手机号验证未审核</c:if>
								<c:if test="${company.mobileState == 202}">手机号验证未通过</c:if>
								<c:if test="${company.mobileState == 203}">手机号验证通过</c:if>
							</td>
						</tr>
						<tr >
							<td>业务范围:</td>
							<td><textarea class="readonly" readonly="readonly" rows="2" cols="80" >${company.serviceField}</textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div style="width:100%;height:530px;background: white;overflow: auto;">
				<ul class="goodsarea">
		  			<c:forEach var="item" items="${contentImgList}" varStatus="status">
						<li>
						<%-- <a
							href="bfile/showDetail.do?id=${item.id}"
							target="dialog" width="820" height="680" style="color:blue;"
							rel="show_img" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true"> --%>
						<a
							href="${item.url}"
							target="_bank">
				        	<div class="goodsimage">
				        		<div class="prev">
				        			<c:if test="${item.url==''}">无图片</c:if>
				        			<c:if test="${item.url!=''}"><img src="${item.url}" /></c:if>
								</div>
		      				</div>
		      			</a>
		        		</li>
		        		<c:if test="${status.count%3==0}"><br/></c:if>
		    		</c:forEach>
				</ul>
			</div>
			
			<div style="width:100%;height:530px;background: white;overflow: auto;">
		       	<div class="goodsimage" style="width:630px;height:520px;float: center; overflow: auto;margin-top: 3px;">
		       		<div class="prev" style="width:620px;height:500px;float: center; overflow: auto;">
		       			<c:if test="${coverImage.url==''}">无图片</c:if>
				        <c:if test="${coverImage.url!=''}"><img src="${coverImage.url}" style="max-width:580px;max-height:480px;"/></c:if>
					</div>
		   		</div>
			</div>
		
			<div style="width:100%;height:530px;background: white;overflow: auto;">
		       	<div class="goodsimage" style="width:630px;height:520px;float: center; overflow: auto;margin-top: 3px;">
		       		<div class="prev" style="width:620px;height:500px;float: center; overflow: auto;">
		       			<c:if test="${conpanyImage.url==''}">无图片</c:if>
				        <c:if test="${conpanyImage.url!=''}"><img src="${conpanyImage.url}" style="max-width:580px;max-height:480px;"/></c:if>
					</div>
		   		</div>
			</div>
			
		</div>
	</div>
</div>
