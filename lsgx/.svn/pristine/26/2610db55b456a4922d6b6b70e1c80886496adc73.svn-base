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
	<div class="searchBar">
		<form method="post" action="/usercard/userCardList.do" onsubmit="return navTabSearch(this)" 
			class="pageForm required-validate">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">银行名：</label>
						<input class="textInput " value="${userCard.bankName }" style="width:114px"  name="bankName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">卡号：</label>
						<input class="textInput " value="${userCard.card }" style="width:114px"  name="card"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="useState" name="useState" >
							<option value=""  >全部</option>
							<option value="100"  <c:if test="${userCard.useState==100}">selected="selected"</c:if>>启用</option>
							<option value="101"  <c:if test="${userCard.useState==101}">selected="selected"</c:if>>停用</option>
							<option value="102"  <c:if test="${userCard.useState==102}">selected="selected"</c:if>>暂停</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:50px">账户类型：</label>
						<select id="accountType" name="accountType" >
							<option value=""  >全部</option>
							<option value="0"  <c:if test="${userCard.accountType==0}">selected="selected"</c:if>>对公</option>
							<option value="1"  <c:if test="${userCard.accountType==1}">selected="selected"</c:if>>对私</option>
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
				<th width="80">操作</th>
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
					<td>
						<a class="btnEdit" href="usercard/userCardEdit.do?id=${userCard.id}" target="dialog" rel="" title="修改银行卡" 
							mask="true" maxable="false" resizable="false" drawable="true"  width="450" height="280"><span>修改银行卡</span></a>
			    		<a class="btnDel" href="usercard/deleteUserCard.do?id=${userCard.id}" target="ajaxTodo" 
			    			rel="" title="删除银行卡"><span>删除银行卡</span></a></li>
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
	