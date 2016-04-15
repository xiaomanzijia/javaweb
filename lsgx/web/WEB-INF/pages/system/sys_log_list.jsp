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
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="system/logList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userName" value="${param.userName}" />
		<input type="hidden" name="IP" value="${param.IP}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${param.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${param.endDate}" pattern="yyyy-MM-dd"/>" />
	</form>
	<div class="searchBar">
		<form method="post"  action="system/logList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户名：</label>
						<input class="textInput" value="${param.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">IP：</label>
						<input class="textInput" value="${param.IP }" style="width:114px" id="ip" name="IP"  type="text">
					</td>
					<%-- <td>
						<label for="name" style="width:80px;">时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${param.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${param.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td> --%>
					<td >
						<div class="subBar">
							<ul>
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
								<li><div class="buttonActive"><div class="buttonContent"><button type="reset" onclick="resetSysLogQuery()">重置</button></div></div></li>
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
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th>用户名</th>
				<th>真实姓名</th>
				<th>IP</th>
				<th>URL</th>
				<th>类型</th>
				<th>内容</th>
				<th>详情</th>
				<th>时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="log">
				<tr target="list_item_id" rel="${log.id }">
					<td >${log.userName }</td>
					<td >${log.realName }</td>
					<td >${log.IP }</td>
					<td >${log.url }</td>
					<td >${log.operateType }</td>
					<td >${log.content }</td>
					<td title="${log.details }">${log.showDetails }</td>
					<td ><fmt:formatDate value="${log.operateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	