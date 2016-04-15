<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#projectName").val("");
	$("#ip").val("");
	//$("#operateType option:first").attr("selected","selected"); 
	$("#startDate").val("");
	$("#endDate").val("");
}
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="projectSchedule/projectScheduleList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="operator" value="${projectSchedule.operator}" />
		<input type="hidden" name="type" value="${projectSchedule.state}" />
		<input type="hidden" name="projectId" value="${projectSchedule.projectId}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="projectSchedule/projectScheduleList.do" onsubmit="return dwzSearch(this,'dialog')" class="pageForm required-validate">
		<input type="hidden" name="projectId" value="${projectSchedule.projectId}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">操作人ID：</label>
						<input class="digits textInput" value="${projectSchedule.operator }" style="width:114px" id="operator" name="operator"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="state" name="state" >
							<option value="">全部</option>
							<option value="220"  <c:if test="${projectSchedule.state==220}">selected="selected"</c:if>>待复审</option>
							<option value="230"  <c:if test="${projectSchedule.state==230}">selected="selected"</c:if>>审核未通过</option>
							<option value="240"  <c:if test="${projectSchedule.state==240}">selected="selected"</c:if>>审核通过</option>
						</select>
					</td>
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
			<%-- <li>
				<a class="add" target="dialog" rel="initAddProjectSchedule" 
					href="projectSchedule/initAddProjectSchedule.do?projectId=${projectSchedule.projectId}" title="添加执行进度" width="650" height="300"  mask="true" maxable="false"  resizable="false" drawable="true"><span>添加执行进度</span>
				</a>
			</li> --%>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">ID</th>
				<th width="30">操作人ID</th>
				<th width="60">状态</th>
				<th width="120">描述</th>
				<th width="80">操作时间</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="item" varStatus="status">
				<tr target="list_item_id" >
					<td>${status.count}</td>
					<td >${item.id }</td>
					<td >
						<a
							href="action/actionUserDetail.do?id=${item.operator}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.operator }
							<c:if test="${item.operator == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >
						<c:if test="${item.state==220}">待复审</c:if>
						<c:if test="${item.state ==230}">审核未通过</c:if>
						<c:if test="${item.state ==240}">审核通过</c:if>
					</td>
					<td title="${item.description }">
						${item.descriptionShort }
					</td>
					<td ><fmt:formatDate value="${item.operatorTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<%-- <td>
						<a class="btnEdit" href="projectSchedule/initUpdateProjectSchedule.do?projectId=${projectSchedule.projectId}&id=${item.id}" callback="dialogAjax" fresh="true" 
							target="dialog" title="编辑" mask="true" width="650" height="300" rel="initUpdateProjectSchedule">编辑</a>
					</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('projectSchedule/projectScheduleList.do?projectId=${projectSchedule.projectId}',{dialogId:'projectSchedule_list'});
		}
	</script>
</div>
	