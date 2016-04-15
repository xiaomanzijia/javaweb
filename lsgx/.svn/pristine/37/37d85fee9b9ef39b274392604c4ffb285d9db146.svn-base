<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="5">
		<table class="list"  height="95%" width="100%" >
			<tbody align="center">
				<tr >
					<td width="120">ID:</td>
					<td>${employee.id}</td>
				</tr>
				<tr >
					<td >所属公司发起人id:</td>
					<td>${employee.company_userId}</td>
				</tr>
				<tr >
					<td >员工用户id:</td>
					<td>${employee.userId}</td>
				</tr>
				<tr >
					<td >员工账号:</td>
					<td>${employee.nickName}</td>
				</tr>
				<tr >
					<td >员工姓名:</td>
					<td>${employee.realName}</td>
				</tr>
				<tr >
					<td >公司名:</td>
					<td>${employee.companyName}</td>
				</tr>
				<tr >
					<td >公司所在省市:</td>
					<td>${employee.province}&nbsp;${employee.city}</td>
				</tr>
				<tr >
					<td >地址:</td>
					<td>${employee.address}</td>
				</tr>
				<tr >
					<td >职位:</td>
					<td>${employee.position}</td>
				</tr>
				<tr >
					<td >审核状态:</td>
					<td >
						<c:if test="${employee.state == 201}">未审核</c:if>
						<c:if test="${employee.state == 202}">未通过</c:if>
						<c:if test="${employee.state == 203}">通过</c:if>
					</td>
				</tr>
				<tr >
					<td >善级:</td>
					<td>${employee.level}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>	
