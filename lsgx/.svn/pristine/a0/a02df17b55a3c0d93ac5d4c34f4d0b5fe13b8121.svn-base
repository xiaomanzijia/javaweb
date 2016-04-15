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
	<form id="pagerForm" method="post" action="report/reportList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="projectId" value="${projectId}" />
		<input type="hidden" name="reportPeople" value="${report.reportPeople}" />
		<input type="hidden" name="type" value="${report.type}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="report/reportList.do" onsubmit="return dwzSearch(this,'dialog')" class="pageForm required-validate">
		<input type="hidden" name="projectId" value="${projectId}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="digits textInput" value="${report.reportPeople }" style="width:114px" id="reportPeople" name="reportPeople"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">类型：</label>
						<select id="type" name="type" >
							<option value="">全部</option>
							<option value="1" <c:if test="${report.type == 1}">selected="selected"</c:if>>调查报告</option>
							<option value="2" <c:if test="${report.type == 2}">selected="selected"</c:if>>打款报告</option>
							<option value="3" <c:if test="${report.type == 3}">selected="selected"</c:if>>考察报告</option>
							<option value="4" <c:if test="${report.type == 4}">selected="selected"</c:if>>执行报告</option>
							<option value="5" <c:if test="${report.type == 5}">selected="selected"</c:if>>关闭报告</option>
							<option value="6" <c:if test="${report.type == 6}">selected="selected"</c:if>>执行进度</option>
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
			<li>
				<a class="add" target="dialog" rel="initAddReport" 
					href="report/initAddReport.do?projectId=${projectId}" title="添加执行进度" 
					width="650" height="300"  mask="true" maxable="false"  resizable="false" drawable="true"><span>添加执行进度</span>
				</a>
			</li>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">ID</th>
				<th width="50">类型</th>
				<th width="120">内容</th>
				<th width="120">图片ID</th>
				<th width="50">填写报告人</th>
				<th width="80">操作时间</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="item" varStatus="status">
				<tr target="list_item_id" rel="${project.id }">
					<td>${status.count}</td>
					<td >${item.id }</td>
					<td >
						<c:if test="${item.type == 1}">调查报告</c:if>
						<c:if test="${item.type == 2}">打款报告</c:if>
						<c:if test="${item.type == 3}">考察报告</c:if>
						<c:if test="${item.type == 4}">执行报告</c:if>
						<c:if test="${item.type == 5}">关闭报告</c:if>
						<c:if test="${item.type == 6}">执行进度</c:if>
					</td>
					<td title="${item.content }">${item.contentShort }</td>
					<td >
						<a
							href="bfile/showList.do?ids=${item.contentImageId}"
							target="dialog" width="660" height="480" style="color:blue;"
							rel="show_img_list" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.contentImageId}</a>
					</td>
					<td >${item.reportPeopleName}
					<%-- <c:if test="${item.type != 6}">
						<a
							href="user/showDetail.do?id=${item.reportPeople}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.reportPeople }
						</a>
					</c:if>
					<c:if test="${item.type == 6}">
						<a
							href="action/actionUserDetail.do?id=${item.reportPeople}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.reportPeople }
							<c:if test="${item.reportPeople == ''}">点击查看详情</c:if>
						</a>
						
					</c:if> --%>
					</td>
					<td ><fmt:formatDate value="${item.operatorTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<c:if test="${item.type == 6}">
						<a class="btnEdit" href="report/initUpdateReport.do?projectId=${item.projectId}&id=${item.id}" callback="dialogAjax" fresh="true" 
							target="dialog" title="编辑" mask="true" width="650" height="300" rel="initUpdateReport">编辑</a>
							
						<a class="btnPicmage" href="report/manageImg.do?id=${item.id}&projectId=${item.projectId}"
							rel="manage_img" target="dialog" title="管理报告[${item.id }] 的图片" height="600" width="1080" 
							maxable="false" resizable="false" mask="true">图片管理 </a>	
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('report/reportList.do?projectId=${report.projectId}',{dialogId:'report_list'});
		}
	</script>
</div>
	