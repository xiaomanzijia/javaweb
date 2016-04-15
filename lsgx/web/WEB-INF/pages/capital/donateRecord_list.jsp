<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#donorType option:first").attr("selected","selected"); 
	$("#donatType option:first").attr("selected","selected"); 
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
	<form id="pagerForm" method="post" action="capital/donateRecordList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userId" value="${donateRecord.userId}" />
		<input type="hidden" name="capitalinoutId" value="${donateRecord.capitalinoutId}" />
		<input type="hidden" name="projectId" value="${donateRecord.projectId}" />
		<input type="hidden" name="donorType" value="${donateRecord.donorType}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${donateRecord.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${donateRecord.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="donatType" value="${donateRecord.donatType}" />
		<input type="hidden" name="userName" value="${donateRecord.userName}" />
		<input type="hidden" name="state" value="${donateRecord.state}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="capital/donateRecordList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td><label for="name" style="width:80px">用户ID：</label>
						<input class="textInput" value="${donateRecord.userId }" style="width:114px" id="userId" name="userId"  type="text" onkeypress="onlyNumber()">
					</td>
					<td><label for="name" style="width:50px">用户名：</label>
						<input class="textInput" value="${donateRecord.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td><label for="name" style="width:60px">项目ID：</label>
						<input class="textInput" value="${donateRecord.projectId }" style="width:114px" id="projectId" name="projectId"  type="text" onkeypress="onlyNumber()">
					</td>
					<td>
						<label for="name" style="width:80px">捐款人类别：</label>
						<select id="donorType" name="donorType"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="externalPers" <c:if test="${donateRecord.donorType == 'externalPers'}">selected="selected"</c:if>>外部人员</option>
							<option value="enterprisePers" <c:if test="${donateRecord.donorType == 'enterprisePers'}">selected="selected"</c:if>>企业人员</option>
							<option value="InternalPers" <c:if test="${donateRecord.donorType == 'InternalPers'}">selected="selected"</c:if>>内部人员</option>
							<option value="touristPers" <c:if test="${donateRecord.donorType == 'touristPers'}">selected="selected"</c:if>>游客人员</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:50px">捐款类型：</label>
						<select id="source" name="donatType"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="IndividualDonation"  <c:if test="${donateRecord.donatType == 'IndividualDonation'|| donateRecord.donatType == 'IndividualUsers' }">selected="selected"</c:if> >个人捐</option>
							<option value="corporateDonation"  <c:if test="${donateRecord.donatType == 'enterpriseUsers'}">selected="selected"</c:if> >企业捐</option>
							<option value="monthlyDonation"  <c:if test="${donateRecord.donatType == 'monthlyDonation'}">selected="selected"</c:if> >月捐</option>
							<option value="donateTogether"  <c:if test="${donateRecord.donatType == 'donateTogether'}">selected="selected"</c:if> >一起捐</option>
							<option value="enterpriseDonation"  <c:if test="${donateRecord.donatType == 'enterpriseDonation'}">selected="selected"</c:if> >企业助捐</option>
							<option value="goodHelpBack"  <c:if test="${donateRecord.donatType == 'goodHelpBack'}">selected="selected"</c:if> >助善款退回</option>
						</select>
					</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:80px">资金进出ID：</label>
						<input class="textInput" value="${donateRecord.capitalinoutId }" style="width:114px" id="capitalinoutId" name="capitalinoutId"  type="text" onkeypress="onlyNumber()">
					</td>
					<td>
						<label for="name" style="width:50px">捐款状态：</label>
						<select id="state" name="state"  style="width: 120px">
							<option value=""  >全部</option>
							<option value="300"  <c:if test="${donateRecord.state==300}">selected="selected"</c:if>>未捐</option>
							<option value="301"  <c:if test="${donateRecord.state==301}">selected="selected"</c:if>>失败</option>
							<option value="302"  <c:if test="${donateRecord.state==302}">selected="selected"</c:if>>成功</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:60px;">捐款时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${donateRecord.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${donateRecord.endDate}" pattern="yyyy-MM-dd"/>"
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
				<th width="30">序号</th>
				<th>用户ID</th>
				<th width="160">用户名</th>
				<th width="70">姓名</th>
				<th width="70">电话</th>
				<th width="70">资金进出ID</th>
				<th>项目ID</th>
				<th width="70">捐款人类别</th>
				<th>认捐金额</th>
				<th>认捐份数</th>
				<th>状态</th>
				<th>捐款类型</th>
				<th width="200">留言</th>
				<th>捐款时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="donateRecord"  varStatus="status">
				<tr target="list_item_id" rel="${donateRecord.id }">
					<td>${status.count}</td>
					<td >
						<a
							href="user/showDetail.do?id=${donateRecord.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${donateRecord.userId }
						</a>
					</td>
					<td >${donateRecord.userName }</td>
					<td >${donateRecord.name }</td>
					<td >${donateRecord.mobile }</td>
					<td >${donateRecord.capitalinoutId }</td>
					<td ><a
							href="project/showDetail.do?id=${donateRecord.projectId}"
							target="dialog" width="680" height="600" style="color:blue;"
							rel="show_project" title="点击查看项目详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${donateRecord.projectId}
						</a>
					</td>
					<td >
						<c:if test="${donateRecord.donorType == 'externalPers'}">外部人员</c:if>
						<c:if test="${donateRecord.donorType == 'InternalPers'}">内部人员</c:if>
						<c:if test="${donateRecord.donorType == 'touristPers'}">游客人员</c:if>
						<c:if test="${donateRecord.donorType == 'enterprisePers'}">企业人员</c:if>
					</td>
					<td >${donateRecord.donatAmount }</td>
					<td >${donateRecord.donateCopies }</td>
					<td >
						<c:if test="${donateRecord.state == 300}">未捐</c:if>
						<c:if test="${donateRecord.state == 301}">失败</c:if>
						<c:if test="${donateRecord.state == 302}">成功</c:if>
					</td>
					<td >
						<c:if test="${donateRecord.donatType == 'IndividualDonation'}">个人捐</c:if>
						<c:if test="${donateRecord.donatType == 'corporateDonation'}">企业捐</c:if>
						<c:if test="${donateRecord.donatType == 'monthlyDonation'}">月捐</c:if>
						<c:if test="${donateRecord.donatType == 'donateTogether'}">一起捐</c:if>
						<c:if test="${donateRecord.donatType == 'enterpriseDonation'}">企业助捐</c:if>
						<c:if test="${donateRecord.donatType == 'goodHelpBack'}">助善款退回</c:if>
					</td>
					<td >${donateRecord.leaveWord }</td>
					<td ><fmt:formatDate value="${donateRecord.donatTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	