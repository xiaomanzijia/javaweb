<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#state option:first").attr("selected","selected"); 
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
	<form id="pagerForm" method="post" action="paymoneyrecord/payMoneyRecordList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="capitalinoutId" value="${payMoneyRecord.capitalinoutId}" />
		<input type="hidden" name="projectId" value="${payMoneyRecord.projectId}" />
		<input type="hidden" name="userId" value="${payMoneyRecord.userId}" />
		<input type="hidden" name="recipientName" value="${payMoneyRecord.recipientName}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${payMoneyRecord.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${payMoneyRecord.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="account" value="${payMoneyRecord.account}" />
		<input type="hidden" name="state" value="${payMoneyRecord.state}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="paymoneyrecord/payMoneyRecordList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td><label for="name" style="width:50px">项目ID：</label>
						<input class="textInput" value="${payMoneyRecord.projectId }" style="width:114px" id="projectId" name="projectId"  type="text" onkeypress="onlyNumber()">
					</td>
					<td><label for="name" style="width:50px">申请金额：</label>
						<input class="textInput" value="${payMoneyRecord.applyMoney }" style="width:114px" id="applyMoney" name="applyMoney"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">接收帐号：</label>
						<input class="textInput" value="${payMoneyRecord.account }" style="width:114px" id="account" name="account"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">打款银行：</label>
						<input class="textInput" value="${payMoneyRecord.recipientName }" style="width:114px" id="recipientName" name="recipientName"  type="text">
					</td>
				</tr>
				<tr>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="state" name="state"  style="width: 120px">
							<option value=""  >全部</option>
							<option value="300"  <c:if test="${payMoneyRecord.state==300}">selected="selected"</c:if>>未打款</option>
							<option value="301"  <c:if test="${payMoneyRecord.state==301}">selected="selected"</c:if>>失败</option>
							<option value="302"  <c:if test="${payMoneyRecord.state==302}">selected="selected"</c:if>>成功</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:50px;">打款时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${payMoneyRecord.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${payMoneyRecord.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
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
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th width="40">序号</th>
				<th width="100">申请人</th>
				<th width="140">申请时间</th>
				<th width="80">项目ID</th>
				<th width="100">申请金额</th>
				<th width="100">开户名</th>
				<th width="180">打款帐号</th>
				<th width="160">打款银行</th>
				<th width="140">打款时间</th>
				<th width="100">打款金额</th>
				<th width="80">状态</th>
				<th width="90">操作人</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="payMoneyRecord"  varStatus="status">
				<tr target="list_item_id" rel="${payMoneyRecord.id }">
					<td>${status.count}</td>
					<td >${payMoneyRecord.userName }</td>
					<td ><fmt:formatDate value="${payMoneyRecord.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td >${payMoneyRecord.projectId }</td>
					<td >${payMoneyRecord.applyMoney }</td>
					<td >${payMoneyRecord.accountName }</td>
					<td >${payMoneyRecord.account }</td>
					<td >${payMoneyRecord.recipientName }</td>
					<td >
						<c:if test="${payMoneyRecord.state !=300 }">
							<fmt:formatDate value="${payMoneyRecord.payMoneyTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</c:if>
					</td>
					<td >${payMoneyRecord.panMoney }</td>
					<td >
						<c:if test="${payMoneyRecord.state == 300}">未打款</c:if>
						<c:if test="${payMoneyRecord.state == 301}">失败</c:if>
						<c:if test="${payMoneyRecord.state == 302}">成功</c:if>
					</td>
					<td >${payMoneyRecord.operatorName}
						<%-- <a
							href="action/actionUserDetail.do?id=${payMoneyRecord.operator}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${payMoneyRecord.operator }
						</a> --%>
					</td>
					<td>
						<priveliege:enable buttonCode="payMoney">
							<a class="btnView" href="paymoneyrecord/showReceipt.do?id=${payMoneyRecord.id}" 
							target="dialog" width="650" height="480" rel="payMoney" title="查看收据"><span>查看收据</span></a>
					    </priveliege:enable>
						<c:if test="${payMoneyRecord.state==300}">
					    	<priveliege:enable buttonCode="payMoney">
					    		<a class="btnSelect" href="paymoneyrecord/successPay.do?id=${payMoneyRecord.id}&state=302&capitalinoutId=${payMoneyRecord.capitalinoutId}&projectId=${payMoneyRecord.projectId }&userId=${payMoneyRecord.userId}" 
					    			target="dialog" rel="payMoney" title="确认打款" mask="true" maxable="false" resizable="false" drawable="true"  width="450" height="150"><span>确认打款</span></a>
					    		<a class="btnCancel" href="paymoneyrecord/payMoney.do?id=${payMoneyRecord.id}&state=301&capitalinoutId=${payMoneyRecord.capitalinoutId}&projectId=${payMoneyRecord.projectId }&userId=${payMoneyRecord.userId}" 
					    			target="ajaxTodo" rel="payMoney" title="取消打款"><span>取消打款</span></a>
					    	</priveliege:enable>
					    </c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	