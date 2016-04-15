<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#bankName").val("");
	$("#card").val("");
	$("#useState option:first").attr("selected","selected"); 
}

</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="/usercard/userCardList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userId" value="${userCard.userId}" />
		<input type="hidden" name="bankName" value="${userCard.bankName}" />
		<input type="hidden" name="card" value="${userCard.card}" />
		<input type="hidden" name="useState" value="${userCard.useState}" />
	</form>
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
				<th width="120">银行名</th>
				<th width="80">银行卡类型</th>
				<th width="180">卡号</th>
				<th width="160">所在地</th>
				<th width="60">使用状态</th>
				<th width="60">账户类型</th>
				<th width="160">绑定时间</th>
				<th width="60">是否默认</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="userCard" varStatus="status">
				<tr target="list_item_id" rel="${userCard.id }">
					<td>${status.count}</td>
					<td >
						<a
							href="user/showDetail.do?id=${userCard.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${userCard.userId }
						</a>
					</td>
					<td >${userCard.bankName }</td>
					<td >
						<c:if test="${userCard.bankType==2}">借记卡</c:if>
						<c:if test="${userCard.bankType==3}">信用卡</c:if>
					</td>
					<td >${userCard.card}</td>
					<td >${userCard.province} ${userCard.city} ${userCard.area}</td>
					<td >
						<c:if test="${userCard.useState == 100}">启用</c:if>
						<c:if test="${userCard.useState == 101}">停用</c:if>
						<c:if test="${userCard.useState == 102}">暂停</c:if>
					</td>
					<td >
						<c:if test="${userCard.accountType == 0}">对公</c:if>
						<c:if test="${userCard.accountType == 1}">对私</c:if>
					</td>
					<td ><fmt:formatDate value="${userCard.bindingTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td >
						<c:if test="${userCard.isSelected == 0}">否</c:if>
						<c:if test="${userCard.isSelected == 1}">是</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('usercard/userCardList.do?userId=${userCard.userId}',{dialogId:'userCard_list'});
		}
	</script>
</div>
	