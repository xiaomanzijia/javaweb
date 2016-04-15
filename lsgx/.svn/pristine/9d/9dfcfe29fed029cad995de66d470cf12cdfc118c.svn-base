<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
 <div class="pageHeader">
	  <form id="pagerForm" method="post" action="/customerService/showCustomerServiceInfo.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="/customerService/showCustomerServiceInfo.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:60px">姓名：</label>
						<input class="textInput" value="${cInfo.name }" style="width:114px" id="name" name="name"  type="text">
					</td>
					<td>
						<label for="name" style="width:60px;">时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${cInfo.startDate }" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${cInfo.endDate }" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:60px">状态：</label>
						<select id="stateString" name="stateString"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="0,0" <c:if test="${cInfo.stateString =='0,0'}">selected="selected"</c:if>>待接手</option>
							<option value="1,0" <c:if test="${cInfo.stateString =='1,0'}">selected="selected"</c:if>>已接手</option>
							<option value="1,1" <c:if test="${cInfo.stateString =='1,1'}">selected="selected"</c:if>>已发布</option>
							<option value="1,2" <c:if test="${cInfo.stateString =='1,2'}">selected="selected"</c:if>>已取消</option>
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

<div class="panelBar">
		
</div>
<div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>联系电话</th>
				<th>qq</th>
				<th>时间</th>
				<th>状态</th>
				<th>接手客服</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${csInfos}" var="csInfo" varStatus="status">
				<tr target="list_item_id" rel="${csInfo.id }">
				 	<td style="width:35px">${status.count}</td>
					<td>${csInfo.name }</td>
					<td>${csInfo.phone }</td>
					<td>${csInfo.qq }</td>
					<td><fmt:formatDate value="${csInfo.time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<c:if test="${csInfo.state==0 }">待接手</c:if>
						<c:if test="${csInfo.state==1 && csInfo.isShow==0}">已接手</c:if>
						<c:if test="${csInfo.state==1 && csInfo.isShow==1}">已发布</c:if>
						<c:if test="${csInfo.state==1 && csInfo.isShow==2}">已取消</c:if>
					</td>
					<td>${csInfo.subjectName }</td>
					<td>
						<c:if test="${csInfo.state==0 }">
						    <priveliege:enable buttonCode="customerReceipt">
					    	<a class="btnSelect" href="/customerService/customerReceive.do?state=1&id=${csInfo.id }" target="ajaxTodo" rel="customerReceipt" title="客服接手" ><span>客服接手</span></a>
						    </priveliege:enable>
					    </c:if>
					    <c:if test="${csInfo.state==1 && csInfo.isShow==1 }">
						    <priveliege:enable buttonCode="customerQueryInfo">
					    	<a class="btnView" href="project/showDetail.do?id=${csInfo.userId }" target="dialog" rel="customerQueryInfo" title="查看求助信息" mask="true" maxable="false" resizable="false" drawable="true"  width="680" height="600"><span>查看求助信息</span></a>
						    </priveliege:enable>
					    </c:if>
					    <c:if test="${csInfo.state==1 && csInfo.isShow==0 && user_id == csInfo.subject}">
						    <priveliege:enable buttonCode="customerDone">
						    <a class="btnSelect" href="/customerService/customerdo.do?isShow=1&id=${csInfo.id }" target="dialog" rel="customerDone" title="处理完成" mask="true" maxable="false" resizable="false" drawable="true"  width="450" height="150"><span>处理完成</span></a>
							</priveliege:enable>
						    <priveliege:enable buttonCode="customerConcel">
						    <a class="btnDel" href="/customerService/customerDispose.do?isShow=2&id=${csInfo.id }" target="ajaxTodo" rel="customerConcel" title="取消"><span>取消</span></a></li>
						    </priveliege:enable>
					    </c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	
