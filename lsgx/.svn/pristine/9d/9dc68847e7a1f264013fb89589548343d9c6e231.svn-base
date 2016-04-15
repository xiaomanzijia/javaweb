<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
  function resetNotifyQuery(){
  		document.getElementById("userid").value="";
  		document.getElementById("sender").value="";
  		document.getElementById("startDate").value="";
  		document.getElementById("endDate").value="";
  		document.getElementById("subject").value="";
  		document.getElementById("state").value="";
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
	<form id="pagerForm" method="post" action="user/notifyList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="userid" value="${snv.userid}" />
		<input type="hidden" name="sender" value="${snv.sender}" />
		<input type="hidden" name="subject" value="${snv.subject}" />
		<input type="hidden" name="content" value="${snv.content}" />
		<input type="hidden" name="state" value="${snv.state}" />
		<input type="hidden" name="isShow" value="${snv.isShow}" />
		<input type="hidden" name="createTime" value="${snv.createTime}" />
		<input type="hidden" name="startDate" value="${snv.startDate}" />
		<input type="hidden" name="endDate" value="${snv.endDate}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="user/notifyList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="textInput" value="${snv.userid }" style="width:114px" id="userid" name="userid"  type="text" onkeypress="onlyNumber()">
					</td>
					<td>
						<label for="name" style="width:50px">发件类型：</label>
						<select id="sender" name="sender"  style="width: 120px" >
							<option value="" >全部</option>
							<option value="系统消息"  <c:if test="${snv.sender=='系统消息'}">selected="selected"</c:if>>系统消息</option>
							<option value="客服消息"  <c:if test="${snv.sender=='客服消息'}">selected="selected"</c:if>>客服消息</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px;">发送时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${snv.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${snv.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td style="float:right;">&nbsp;</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">主题：</label>
						<input class="textInput" value="${snv.subject }" style="width:114px" id="subject" name="subject"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="state" name="state"  style="width: 120px" >
							<option value="" >全部</option>
							<option value="0" <c:if test="${snv.state==0 }">selected="selected"</c:if>>未读</option>
							<option value="1" <c:if test="${snv.state==1 }">selected="selected"</c:if>>已读</option>
						</select>
					</td>
					<td style="float:right;">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div>
						<div class="buttonActive"><div class="buttonContent"><button type="reset" onclick="resetNotifyQuery()">重置</button></div></div>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<!-- 权限 -->
			<priveliege:enable buttonCode="notifyAdd">
				<li><a class="add" href="user/notifySend.do" target="dialog" rel="notifyAdd" title="发送通告" mask=true width="610" height="420"><span>发送通告</span></a></li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th>用户名</th>
				<th>发件类型</th>
				<th>主题</th>
				<th>内容</th>
				<th>状态</th>
				<th>前台显示状态</th>
				<th>发送时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${snVos}" var="notify">
				<tr target="list_item_id" rel="${notify.id }">
					<td >${notify.userName }</td>
					<td >${notify.sender }</td>
					<td >${notify.subject }</td>
					<td title="${notify.content }">${notify.contentShort }</td>
					<td >
						<c:if test="${notify.state == 0}">未读</c:if>
						<c:if test="${notify.state == 1}">已读</c:if>
					</td>
					<td >
						<c:if test="${notify.isShow == 0}">不显示</c:if>
						<c:if test="${notify.isShow == 1}">显示</c:if>
					</td>
					<td ><fmt:formatDate value="${notify.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>