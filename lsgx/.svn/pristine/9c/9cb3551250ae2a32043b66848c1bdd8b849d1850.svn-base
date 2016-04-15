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

function onlyNumber(){
  	var keyCode = event.keyCode;
  	if(keyCode >=48 && keyCode <=57){
  		event.returnValue = true;
  	}else{
  		event.returnValue = false;
  	}
  }
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="companygoodhelp/companygoodhelpList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="company_id" value="${companyGoodHelp.company_id}" />
		<input type="hidden" name="project_id" value="${companyGoodHelp.project_id}" />
		<input type="hidden" name="state" value="${companyGoodHelp.state}" />
		<input type="hidden" name="dialog" value="${companyGoodHelp.dialog}" />
	</form>
	<div class="searchBar">
		<c:choose>
			<c:when test="${companyGoodHelp.dialog == 1}"><form method="post" rel="pagerForm" action="companygoodhelp/companygoodhelpList.do" onsubmit="return dwzSearch(this,'dialog')" class="pageForm required-validate"></c:when>
			<c:otherwise><form method="post" rel="pagerForm" action="companygoodhelp/companygoodhelpList.do" onsubmit="return navTabSearch(this)"></c:otherwise>
		</c:choose>
		<c:if test="${companyGoodHelp.dialog == 1}">
			<input type="hidden" name="company_id" value="${companyGoodHelp.company_id}" />
		</c:if>
		<input type="hidden" name="dialog" value="${companyGoodHelp.dialog}" />
			<table class="searchContent">
				<tr>
					<c:if test="${companyGoodHelp.dialog != 1}">
					<td>
						<label for="name" style="width:50px">企业ID：</label>
						<input class="digits textInput" value="${companyGoodHelp.company_id }" style="width:114px" id="company_id" name="company_id"  type="text" onkeypress="onlyNumber()">
					</td>
					</c:if>
					<td>
						<label for="name" style="width:50px">项目ID：</label>
						<input class="digits textInput" value="${companyGoodHelp.project_id }" style="width:114px" id="project_id" name="project_id"  type="text" onkeypress="onlyNumber()">
					</td>
					<td>
						<label for="name" style="width:50px">审核状态：</label>
						<select id="state" name="state" >
							<option value="">全部</option>
							<option value="200" <c:if test="${companyGoodHelp.state == 200}">selected="selected"</c:if>>保存未提交</option>
							<option value="201" <c:if test="${companyGoodHelp.state == 201}">selected="selected"</c:if>>提交未审核</option>
							<option value="202" <c:if test="${companyGoodHelp.state == 202}">selected="selected"</c:if>>审核未通过</option>
							<option value="203" <c:if test="${companyGoodHelp.state == 203}">selected="selected"</c:if>>审核通过</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:50px">支付状态：</label>
						<select id="payState" name="payState"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="300"  <c:if test="${companyGoodHelp.payState==300}">selected="selected"</c:if>>未支付</option>
							<option value="301"  <c:if test="${companyGoodHelp.payState==301}">selected="selected"</c:if>>支付失败</option>
							<option value="302"  <c:if test="${companyGoodHelp.payState==302}">selected="selected"</c:if>>支付成功</option>
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
			<li>
			</li>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">ID</th>
				<th width="60">企业ID</th>
				<th width="80">资金明细ID</th>
				<th width="80">助善发起人ID</th>
				<th width="60">剩余份数</th>
				<th width="60">支付状态</th>
				<th width="60">项目ID</th>
				<th width="100">项目标题</th>
				<th width="80">助善金额</th>
				<th width="80">冻结金额</th>
				<th width="80">号召的网友数</th>
				<th width="160">助善发起时间</th>
				<th width="120">终止原因/审核原因</th>
				<th width="80">审核状态</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="item" varStatus="status">
				<tr target="list_item_id" rel="${companyGoodHelp.id }">
					<td>${status.count}</td>
					<td >${item.id }</td>
					<td >
						<a
							href="company/showDetail.do?id=${item.company_id}"
							target="dialog" width="670" height="600" style="color:blue;"
							rel="show_company" title="企业详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.company_id }
						</a>
					</td>
					<td>${item.capitalinoutId }</td>
					<td >
						<a
							href="user/showDetail.do?id=${item.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.userId }
						</a>
					</td>
					<td >${item.leaveAmount }</td>
					<td >
						<c:if test="${item.payState == 300}">未支付</c:if>
						<c:if test="${item.payState == 301}">支付失败</c:if>
						<c:if test="${item.payState == 302}">支付成功</c:if>
					</td>
					<td >${item.project_id }</td>
					<td title="${item.projectName }"><a
							href="project/showDetail.do?id=${item.project_id}"
							target="dialog" width="680" height="600" style="color:blue;"
							rel="show_project" title="点击查看项目：${item.projectName } 详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.projectName }
							<c:if test="${item.projectName == ''}">点击项目详情</c:if>
						</a>
					</td>
					<td >${item.perMoney }</td>
					<td >${item.freezAmount }</td>
					<td >${item.callNumber }</td>
					<td ><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td title="${item.stopReason }">${item.stopReason }</td>
					
					<td >
						<c:if test="${item.state == 200}">保存未提交</c:if>
						<c:if test="${item.state == 201}">提交未审核</c:if>
						<c:if test="${item.state == 202}">审核未通过</c:if>
						<c:if test="${item.state == 203}">审核通过</c:if>
					</td>
					<td>
						<c:if test="${item.state==201}">
						<a class="btnCancel" href="companygoodhelp/initAuditState.do?id=${item.id}&dialog=${companyGoodHelp.dialog}"  maxable="false" resizable="false" mask="true"
							target="dialog" rel="initAuditGoodHelp" title="审核未通过"><span>审核未通过</span></a>
			    		<a class="btnSelect" href="companygoodhelp/auditState.do?id=${item.id}&state=203&company_id=${item.company_id}&userId=${item.userId}&dialog=${companyGoodHelp.dialog}" 
			    			<c:if test="${companyGoodHelp.dialog == 1}"> callback="dialogAjax" </c:if> target="ajaxTodo" rel="auditGoodHelpPass" title="审核通过"><span>审核通过</span></a>	
			    		</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:choose>
		<c:when test="${companyGoodHelp.dialog == 1}"><c:import url="../common/dialogPanelBar.jsp" /></c:when>
		<c:otherwise><c:import url="../common/panelBar.jsp" /></c:otherwise>
	</c:choose>
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('companygoodhelp/companygoodhelpList.do?company_id=${companyGoodHelp.company_id}&dialog=${companyGoodHelp.dialog}',{dialogId:json.navTabId});
		}
	</script>
</div>
	