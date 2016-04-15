<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>


<div class="pageHeader">
	<form id="pagerForm" method="post" action="user/bringBacklist.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userName" value="${user.userName}" />
		<input type="hidden" name="userType" value="${user.userType}" />
		<input type="hidden" name="id" value="${user.id}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="user/bringBacklist.do" onsubmit="return dwzSearch(this,'dialog')">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="textInput" value="${user.id }" style="width:114px" id="id" name="id"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">用户名：</label>
						<input class="textInput" value="${user.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">用户类别：</label>
						<select id="userType1" name="userType"  style="width: 120px" class="combox">
							<option value="" >全部</option>
							<option value="individualUsers"  <c:if test="${user.userType=='individualUsers'}">selected="selected"</c:if>>个人用户</option>
							<option value="enterpriseUsers"  <c:if test="${user.userType=='enterpriseUsers'}">selected="selected"</c:if>>企业用户</option>
						</select>
					</td>
					<td >
						<div class="subBar">
							<ul>
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
								<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="resetSysLogQuery()">重置</button></div></div></li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>

<div class="pageContent">
	<div class="panelBar">
		<div class="button">
					<div class="buttonContent">
						<button warn="请选择发送的用户" multlookup="userIds"  type="button">选择带回</button>
					</div>
				</div>
			
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30"><input type="checkbox" group="userIds" class="checkboxCtrl"></th>
				<th width="80">用户ID</th>
				<th width="160">用户名</th>
				<th>用户类别</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="user">
				<tr target="list_item_id" rel="${user.id }">
					<td>
						<input name="userIds" type="checkbox" value="{userIds:'${user.id}'}">
					</td>
					<td>${user.id }</td>
					<td >
						<a
							href="user/showDetail.do?id=${user.id}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${user.userName }
							<c:if test="${user.userName == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >
						<c:if test="${user.userType == 'individualUsers'}">个人用户</c:if>
						<c:if test="${user.userType == 'enterpriseUsers'}">企业用户</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
</div>
	