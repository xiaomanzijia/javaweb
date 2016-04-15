<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<div class="pageContent">
	<table class="table" width="1800"   layoutH="20">
		<thead>
			<tr>
				<th width="160">企业名称</th>
				<th width="160">企业地址</th>
				<th width="100">负责人</th>
				<th width="100">手机号</th>
				<th width="160">企业简介</th>
				<th width="120">余额</th>
				<th width="120">企业注册号</th>
				<th width="180">组织机构代码</th>
				<th width="120">法定代表人姓名</th>
				<th width="120">身份证</th>
				<th width="120">手机验证状态</th>
				<th width="120">公司网址</th>
				<th width="120">企业类型</th>
				<th width="120">企业信息</th>
				<th width="120">企业使用状态</th>
				<th width="120">企业认证状态</th>
				<th width="120">业务范围</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${errorInfo!=null&&errorInfo!=''}">
				<tr>
					<td colspan="9" rowspan="3" align="center">
						<h1><font color="#F03C35">${errorInfo}</font></h1>
					</td>
				</tr>
			</c:if>
			<c:forEach  items="${list}" var="company">
				<tr target="list_item_id">
					<td >${company.name }</td>
					<td title="${company.address }">${company.address }</td>
					<td >${company.head }</td>
					<td>${company.mobile }</td>
					<td title="${company.introduction }">${company.introduction }</td>
					<td>${company.balance }</td>
					<td title="${company.registerNo }">${company.registerNo }</td>
					<td>${company.groupCode }</td>
					<td>${company.legalName }</td>
					<td title="${company.identity }">${company.identity }</td>
					<td >
						<c:if test="${company.mobileState==201}">未审核</c:if>
						<c:if test="${company.mobileState==202}">审核未通过</c:if>
						<c:if test="${company.mobileState==203}">验证审核通过</c:if>
					</td>
					<td>${company.url }</td>
					<td >
						<c:if test="${company.type==0}">企业</c:if>
						<c:if test="${company.type==1}">事业单位</c:if>
						<c:if test="${company.type==2}">社会团体</c:if>
						<c:if test="${company.type==3}">党政及国家机关</c:if>
					</td>
					<td title="${company.infomation }">${company.infomation }</td>
					<td >
						<c:if test="${company.useState==100}">正常</c:if>
						<c:if test="${company.useState==101}">信用</c:if>
						<c:if test="${company.useState==102}">暂停</c:if>
					</td>
					<td>
						<c:if test="${company.state==201}">未认证</c:if>
						<c:if test="${company.state==202}">认证失败</c:if>
						<c:if test="${company.state==203}">认证通过</c:if>
					</td>
					<td title="${company.serviceField }">${company.serviceField }</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	
</div>
