<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#userName").val("");
	$("#ip").val("");
	//$("#operateType option:first").attr("selected","selected"); 
	$("#startDate").val("");
	$("#endDate").val("");
}

function setRole(role,user_id){
	var love=$("#love_"+user_id).val()+"";
	var splitstr= new Array();
	splitstr=love.split('@');
	var newUserId=splitstr[0]+"@"+role+"@"+splitstr[2];
	$("#love_"+user_id).val(newUserId);
	$("#checkbox_"+user_id).val(newUserId);
}

function setUserType(userType,user_id){
	var love=$("#love_"+user_id).val()+"";
	var splitstr= new Array();
	splitstr=love.split('@');
	var newUserId=splitstr[0]+"@"+splitstr[1]+"@"+userType;
	$("#love_"+user_id).val(newUserId);
	$("#checkbox_"+user_id).val(newUserId);
}
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="lovegroupment/initAddLoveGroupMent.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userName" value="${user.userName}" />
		<input type="hidden" name="userType" value="${user.userType}" />
		<input type="hidden" name="realName" value="${user.realName}" />
		<input type="hidden" name="loveGroupMent" value="${user.loveGroupMent}" />
		<input type="hidden" name="loveState" value="${user.loveState}" />
		<input type="hidden" name="projectId" value="${projectId}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="lovegroupment/initAddLoveGroupMent.do" onsubmit="return dwzSearch(this,'dialog')">
		<input type="hidden" name="projectId" value="${projectId}" />
		<input type="hidden" name="loveGroupMent" value="${user.loveGroupMent}" />
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
					<td>
						<label for="name" style="width:50px">用户类别：</label>
						<select id="userType1" name="userType"  style="width: 120px" class="combox">
							<option value="" >全部</option>
							<option value="individualUsers"  <c:if test="${user.userType=='individualUsers'}">selected="selected"</c:if>>个人用户</option>
							<option value="enterpriseUsers"  <c:if test="${user.userType=='enterpriseUsers'}">selected="selected"</c:if>>企业用户</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px">善管家审核状态：</label>
						<select id="loveState" name="loveState"  style="width: 120px">
							<!-- <option value=""  >全部</option> -->
							<%-- <option value="200"  <c:if test="${user.state==200}">selected="selected"</c:if>>未填写实名验证信息</option>
							<option value="201"  <c:if test="${user.state==201}">selected="selected"</c:if>>实名验证未审核</option>
							<option value="202"  <c:if test="${user.state==202}">selected="selected"</c:if>>实名验证审核未通过</option> --%>
							<option value="203"  <c:if test="${user.loveState==203}">selected="selected"</c:if>>善管家审核通过</option>
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
		<ul class="toolBar">
			<a class="icon" posttype="string" target="selectedTodo" rel="user_ids" targetType="dialog" callback="dialogAjax" fresh="true" 
				href="lovegroupment/addLoveGroupMent.do?projectId=${projectId }" title="保存善管家"><span>保存善管家</span>
			</a>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th><input class="checkboxCtrl" type="checkbox" group="user_ids"></th>
				<th>用户名</th>
				<th>真实姓名</th>
				<th>用户类别</th>
				<th>善管家审核状态</th>
				<!-- <th>爱心团员</th>
				<th>角色</th>
				<th>用户类别</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="user">
				<tr target="list_item_id" rel="${user.id }">
					<input type="hidden" value="${user.id}@1@1" id="love_${user.id}">
					<td><input type="checkbox" value="${user.id}@1@1" name="user_ids" id="checkbox_${user.id}"></td>
					<td >
						<a
							href="user/showDetail.do?id=${user.id}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${user.userName }
							<c:if test="${user.userName == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >${user.realName }</td>
					<td >
						<c:if test="${user.userType == 'individualUsers'}">个人用户</c:if>
						<c:if test="${user.userType == 'enterpriseUsers'}">企业用户</c:if>
					</td>
					<td >
						<c:if test="${user.loveState == 200}">未填写善管家信息</c:if>
						<c:if test="${user.loveState == 201}">善管家未审核</c:if>
						<c:if test="${user.loveState == 202}">善管家审核未通过</c:if>
						<c:if test="${user.loveState == 203}">善管家审核通过</c:if>
					</td>
					<%-- <td >
						<c:if test="${user.loveGroupMent == 0}">否</c:if>
						<c:if test="${user.loveGroupMent == 1}">是</c:if>
					</td> --%>
					<%-- <td>
						<input type="radio" name="role${user.id }" id="role${user.id }" value="0" onclick="setRole(this.value,${user.id})">非团长
						<input type="radio" name="role${user.id }" id="role${user.id }" value="1" onclick="setRole(this.value,${user.id})" checked="checked">团长
					</td>
					<td>
						<input type="radio" name="userType${user.id }" id="userType${user.id }" value="0" onclick="setUserType(this.value,${user.id})">领域专家
						<input type="radio" name="userType${user.id }" id="userType${user.id }" value="1" onclick="setUserType(this.value,${user.id})" checked="checked" >成员
						<input type="radio" name="userType${user.id }" id="userType${user.id }" value="2" onclick="setUserType(this.value,${user.id})">客服
					</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('lovegroupment/loveGroupMentList.do?projectId=${projectId}&userType=1',{dialogId:'lovegroupment_list'});
			if ("closeCurrent" == json.callbackType) {
				$.pdialog.close('initaddlovegroupment');
			}
		}
	</script>
</div>
	