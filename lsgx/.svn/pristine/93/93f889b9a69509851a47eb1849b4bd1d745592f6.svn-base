<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<div class="pageContent">
	<table class="table" width="1200"   layoutH="20">
		<thead>
			<tr>
				<th width="100">员工账号</th>
				<th width="100">员工姓名</th>
				<th width="120">身份证号</th>
				<th width="100">手机号</th>
				<th width="160">公司名</th>
				<th width="80">公司所在省</th>
				<th width="80">所在市</th>
				<th width="120">地址</th>
				<th width="120">职位</th>
				<th width="80">审核状态</th>
				<th width="80">善级</th>
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
			<c:forEach  items="${list}" var="employee">
				<tr target="list_item_id">
					<td >${employee.nickName }</td>
					<td title="${employee.realName }">${employee.realName }</td>
					<td >${employee.idCard }</td>
					<td>${employee.mobileNum }</td>
					<td title="${employee.companyName }">${employee.companyName }</td>
					<td>${employee.province }</td>
					<td title="${employee.city }">${employee.city }</td>
					<td>${employee.address }</td>
					<td>${employee.position }</td>
					<td >
						<c:if test="${employee.state==201}">未审核</c:if>
						<c:if test="${employee.state==202}">审核未通过</c:if>
						<c:if test="${employee.state==203}">验证审核通过</c:if>
					</td>
					<td>${employee.level }</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	
</div>
