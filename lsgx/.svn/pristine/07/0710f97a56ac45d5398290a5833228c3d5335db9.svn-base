<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="lovegroupment/initAddLoveGroupMentKF.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userName" value="${user.userName}" />
		<input type="hidden" name="realName" value="${user.realName}" />
		<input type="hidden" name="status" value="${user.status}" />
		<input type="hidden" name="projectId" value="${projectId}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="lovegroupment/initAddLoveGroupMentKF.do" onsubmit="return dwzSearch(this,'dialog')">
		<input type="hidden" name="projectId" value="${projectId}" />
		<input type="hidden" name="status" value="${user.status}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户名：</label>
						<input class="textInput" value="${user.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">真实姓名：</label>
						<input class="textInput" value="${user.realName }" style="width:114px" id="realName" name="realName"  type="text">
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
		<ul class="toolBar">
			<a class="icon" posttype="string" target="selectedTodo" rel="user_ids" targetType="dialog" callback="dialogAjax" fresh="true" 
				href="lovegroupment/addLoveGroupMent.do?projectId=${projectId }" title="保存客服"><span>保存客服</span>
			</a>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th><input class="checkboxCtrl" type="checkbox" group="user_ids"></th>
				<th>登录名</th>
				<th >真实姓名</th>
				<th >性别</th>
				<th >联系方式</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${userList}" var="user">
				<tr target="list_item_id" rel="${user.id }">
					<input type="hidden" value="${user.id}@0@2" id="love_${user.id}">
					<td><input type="checkbox" value="${user.id}@0@2" name="user_ids" id="checkbox_${user.id}"></td>
					<td>
						<a
							href="action/actionUserDetail.do?id=${user.id}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${user.userName }
							<c:if test="${user.userName == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td>${user.realName }</td>
				    <td>
				    	<c:if test="${user.sex==0}">男</c:if>
				    	<c:if test="${user.sex==1}">女</c:if>
				    </td>
				    <td>${user.mobile }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('lovegroupment/loveGroupMentList.do?projectId=${projectId}&userType=2',{dialogId:'lovegroupment_list'});
			if ("closeCurrent" == json.callbackType) {
				$.pdialog.close('initaddlovegroupment');
			}
		}
	</script>
</div>
	