<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#userType option:first").attr("selected","selected"); 
	$("#loveGroupMent option:first").attr("selected","selected"); 
	$("#realState option:first").attr("selected","selected"); 
	$("#loveGroupMent option:first").attr("selected","selected"); 
}
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="user/userIndex.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userName" value="${user.userName}" />
		<input type="hidden" name="userType" value="${user.userType}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${user.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${user.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="realName" value="${user.realName}" />
		<input type="hidden" name="loveGroupMent" value="${user.loveGroupMent}" />
		<input type="hidden" name="realState" value="${user.realState}" />
		
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="user/userIndex.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户名：</label>
						<input class="textInput" value="${user.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">用户类别：</label>
						<select id="userType" name="userType"  style="width: 120px" >
							<option value="" >全部</option>
							<option value="individualUsers"  <c:if test="${user.userType=='individualUsers'}">selected="selected"</c:if>>个人用户</option>
							<option value="enterpriseUsers"  <c:if test="${user.userType=='enterpriseUsers'}">selected="selected"</c:if>>企业用户</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px;">注册时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${user.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${user.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td style="float:right;">&nbsp;</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">真实姓名：</label>
						<input class="textInput" value="${user.realName }" style="width:114px" id="realName" name="realName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">善管家：</label>
						<select id="loveGroupMent" name="loveGroupMent"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="0"  <c:if test="${user.loveGroupMent==0}">selected="selected"</c:if>>否</option>
							<option value="1"  <c:if test="${user.loveGroupMent==1}">selected="selected"</c:if>>是</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px">实名验证状态：</label>
						<select id="realState" name="realState"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="200"  <c:if test="${user.realState==200}">selected="selected"</c:if>>未填写实名验证信息</option>
							<option value="201"  <c:if test="${user.realState==201}">selected="selected"</c:if>>实名验证未审核</option>
							<option value="202"  <c:if test="${user.realState==202}">selected="selected"</c:if>>实名验证审核未通过</option>
							<option value="203"  <c:if test="${user.realState==203}">selected="selected"</c:if>>实名验证审核通过</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px">善管家审核状态：</label>
						<select id="loveState" name="loveState"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="200"  <c:if test="${user.loveState==200}">selected="selected"</c:if>>未填写善管家审核信息</option>
							<option value="201"  <c:if test="${user.loveState==201}">selected="selected"</c:if>>善管家未审核</option>
							<option value="202"  <c:if test="${user.loveState==202}">selected="selected"</c:if>>善管家审核未通过</option>
							<option value="203"  <c:if test="${user.loveState==203}">selected="selected"</c:if>>善管家审核通过</option>
						</select>
					</td>
					<td style="float:right;">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div>
						<div class="buttonActive"><div class="buttonContent"><button type="reset" onclick="resetSysLogQuery()">重置</button></div></div>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th>用户ID</th>
				<th>用户名</th>
				<th>真实姓名</th>
				<th>用户类别</th>
				<th>实名验证状态</th>
				<th>善管家审核状态</th>
				<th>善管家员</th>
				<th>最后登录</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="user">
				<tr target="list_item_id" rel="${user.id }">
					<td >${user.id }</td>
					<td >
						<a
							href="user/showDetail.do?id=${user.id}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_user${user.id}" title="前端用户详情"  resizable="true" mask="true"
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
						<c:if test="${user.realState == 200}">未填写实名验证信息</c:if>
						<c:if test="${user.realState == 201}">实名验证未审核</c:if>
						<c:if test="${user.realState == 202}">实名验证审核未通过</c:if>
						<c:if test="${user.realState == 203}">实名验证审核通过</c:if>
					</td>
					<td >
						<c:if test="${user.loveState == 200}">未填写善管家审核信息</c:if>
						<c:if test="${user.loveState == 201}">善管家未审核</c:if>
						<c:if test="${user.loveState == 202}">善管家审核未通过</c:if>
						<c:if test="${user.loveState == 203}">善管家审核通过</c:if>
					</td>
					<td >
						<c:if test="${user.loveGroupMent == 0}">否</c:if>
						<c:if test="${user.loveGroupMent == 1}">是</c:if>
					</td>
					<td ><fmt:formatDate value="${user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<a class="btnLook" 
							href="usercard/queryUserCardRecord.do?userId=${user.id}"
							width="880" height="420" target="dialog" rel="userCard_list" title="查看银行卡" mask="true" maxable="false">查看银行卡
						</a>
						<a class="btnAssign" 
							href="thirduser/thirdUserList.do?userId=${user.id}"
							width="680" height="420" target="dialog" rel="userCard_list" title="查看第三方登陆账户" mask="true" maxable="false">查看第三方登陆账户
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	