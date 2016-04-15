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
	<form id="pagerForm" method="post" action="thirdUser/thirdUserList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userId" value="${thirdUser.userId}" />
		<input type="hidden" name="type" value="${thirdUser.type}" />
		<input type="hidden" name="accountNum" value="${thirdUser.accountNum}" />
	</form>
	<div class="searchBar">
		<form method="post" action="thirdUser/thirdUserList.do" onsubmit="return dwzSearch(this,'dialog')" 
			class="pageForm required-validate">
			<input type="hidden" name="userId" value="${thirdUser.userId}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">类型：</label>
						<input class="digits textInput " value="${thirdUser.type }" style="width:114px"  name="type"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">帐号：</label>
						<input class="digits textInput " value="${thirdUser.accountNum }" style="width:114px"  name="accountNum"  type="text">
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
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="60">用户ID</th>
				<th width="120">帐号</th>
				<th width="80">类型</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="thirdUser" varStatus="status">
				<tr target="list_item_id" rel="${thirdUser.id }">
					<td>${status.count}</td>
					<td >
						<a
							href="user/showDetail.do?id=${thirdUser.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${thirdUser.userId }
						</a>
					</td>
					<td >${thirdUser.accountNum }</td>
					<td >${thirdUser.type }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('thirdUser/thirdUserList.do?userId=${thirdUser.userId}',{dialogId:'thirdUser_list'});
		}
	</script>
</div>
	