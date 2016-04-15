<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#announceType option:first").attr("selected","selected"); 
	$("#loveGroupMent option:first").attr("selected","selected"); 
	$("#realState option:first").attr("selected","selected"); 
	$("#loveGroupMent option:first").attr("selected","selected"); 
}
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="announce/announceList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userId" value="${announce.userId}" />
		<input type="hidden" name="destination" value="${announce.destination}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${announce.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${announce.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="type" value="${announce.type}" />
		<input type="hidden" name="state" value="${announce.state}" />
		
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="announce/announceList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<%-- <td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="textInput" value="${announce.userId }" style="width:114px" id="userId" name="userId"  type="text">
					</td> --%>
					<td>
						<label for="name" style="width:50px">类别：</label>
						<select id="type" name="type"  style="width: 120px" >
							<option value="" >全部</option>
							<option value="1"  <c:if test="${announce.type==1}">selected="selected"</c:if>>短信</option>
							<option value="2"  <c:if test="${announce.type==2}">selected="selected"</c:if>>邮箱</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:60px;">发送时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${announce.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${announce.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td style="float:right;">&nbsp;</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">发送地址：</label>
						<input class="textInput" value="${announce.destination }" style="width:114px" id="destination" name="destination"  type="text">
					</td>
					<td>
						<label for="name" style="width:60px">状态：</label>
						<select id="state" name="state"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="100"  <c:if test="${announce.state==100}">selected="selected"</c:if>>待发送</option>
							<option value="200"  <c:if test="${announce.state==200}">selected="selected"</c:if>>发送成功</option>
							<option value="300"  <c:if test="${announce.state==300}">selected="selected"</c:if>>发送失败</option>
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
				<th width="30">短信ID</th>
				<!-- <th width="30">用户ID</th> -->
				<th width="80">发送地址</th>
				<th width="100">标题</th>
				<th width="30">类型</th>
				<th width="30">优先级</th>
				<th width="80">发送原因</th>
				<th width="180">内容</th>
				<th width="40">发送状态</th>
				<th width="30">次数</th>
				<th width="100">发送时间</th>
				<th width="100">创建时间</th>
				<th width="40">发送类型</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="announce">
				<tr target="list_item_id" rel="${announce.id }">
					<td >${announce.id }</td>
					<%-- <td >
						<a
							href="announce/showDetail.do?id=${announce.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${announce.userId }
							<c:if test="${announce.userId == ''}">点击查看详情</c:if>
						</a>
					</td> --%>
					<td >${announce.destination }</td>
					<td title="${announce.title }">${announce.titleShort }</td>
					<td >
						<c:if test="${announce.type==1}">短信</c:if>
						<c:if test="${announce.type==2}">邮箱</c:if>
					</td>
					<td >${announce.priority }</td>
					<td title="${announce.cause }">${announce.causeShort }</td>
					<td title="${announce.content }">${announce.contentShort }</td>
					<td >
						<c:if test="${announce.state == 100}">待发送</c:if>
						<c:if test="${announce.state == 200}">发送成功</c:if>
						<c:if test="${announce.state == 300}">发送失败</c:if>
					</td>
					<td >${announce.tryCount }</td>
					<td ><fmt:formatDate value="${announce.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td ><fmt:formatDate value="${announce.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td >${announce.sendType }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	