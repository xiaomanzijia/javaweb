<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#state option:first").attr("selected","selected"); 
	$("#personType option:first").attr("selected","selected"); 
}
function keyPress(){    
     var keyCode = event.keyCode;    
     if ((keyCode >= 48 && keyCode <= 57))    
    {    
         event.returnValue = true;    
     } else {    
         event.returnValue = false;    
    }    
 }  
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="user/userAuditList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="userName" value="${auditStaff.userName}" />
		<input type="hidden" name="userId" value="${auditStaff.userId}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${auditStaff.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${auditStaff.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="realName" value="${auditStaff.realName}" />
		<input type="hidden" name="personType" value="${auditStaff.personType}" />
		<input type="hidden" name="state" value="${auditStaff.state}" />
		
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="user/userAuditList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="textInput" value="${auditStaff.userId }" style="width:114px" id="userId" name="userId"  type="text" onkeypress="keyPress()">
					</td>
					<td>
						<label for="name" style="width:50px">用户名：</label>
						<input class="textInput" value="${auditStaff.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td>
						<label for="name" style="width:80px;">审核时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${auditStaff.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${auditStaff.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>&nbsp;</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">真实姓名：</label>
						<input class="textInput" value="${auditStaff.realName }" style="width:114px" id="realName" name="realName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">审核状态：</label>
						<select id="state" name="state"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="200"  <c:if test="${auditStaff.state==200}">selected="selected"</c:if>>未提交</option>
							<option value="201"  <c:if test="${auditStaff.state==201}">selected="selected"</c:if>>未审核</option>
							<option value="202"  <c:if test="${auditStaff.state==202}">selected="selected"</c:if>>未通过</option>
							<option value="203"  <c:if test="${auditStaff.state==203}">selected="selected"</c:if>>通过</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px">审核人员类型：</label>
						<select id="personType" name="personType"  style="width: 120px" >
							<option value="" >全部</option>
							<option value="helpPeople"  <c:if test="${auditStaff.personType=='helpPeople'}">selected="selected"</c:if>>实名审核</option>
							<option value="loveGroup"  <c:if test="${auditStaff.personType=='loveGroup'}">selected="selected"</c:if>>善管家审核</option>
							<option value="company"  <c:if test="${auditStaff.personType=='company'}">selected="selected"</c:if>>企业审核</option>
						</select>
					</td>
					<td>&nbsp;</td>
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
	<table class="table" width="100%"  layoutH="140">
		<thead>
			<tr>
				<th>ID</th>
				<th>用户ID</th>
				<th>用户名</th>
				<th>真实姓名</th>
				<th>审核状态</th>
				<th>审核资料(文件 ID)</th>
				<th>审核内容</th>
				<th>审核人员类型</th>
				<th>审核时间</th>
				<th>审核人</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="astaff">
				<tr target="list_item_id" rel="${astaff.id }">
					<td >${astaff.id }</td>
					<td >${astaff.userId }</td>
					<td >
						<a
							href="user/showDetail.do?id=${astaff.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${astaff.userName }
							<c:if test="${astaff.userName == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >${astaff.realName }</td>
					<td >
						<c:if test="${astaff.state == 200}">未提交</c:if>
						<c:if test="${astaff.state == 201}">未审核</c:if>
						<c:if test="${astaff.state == 202}">未通过</c:if>
						<c:if test="${astaff.state == 203}">通过</c:if>
					</td>
					<td>
						<c:if test="${astaff.personType=='helpPeople'}">
						<a
							href="bfile/showList.do?ids=${astaff.fileId}"
							target="dialog" width="650" height="480" style="color:blue;"
							rel="show_img_list" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true">审核资料详情</a>
						</c:if>
						<c:if test="${astaff.personType=='loveGroup'}">
							<a
							href="user/loveGroupFile.do?id=${astaff.id}"
							target="dialog" width="650" height="480" style="color:blue;"
							rel="show_img_list" title="善管家审核资料详情"  resizable="true" mask="true"
							maxable="false" drawable="true">审核资料详情</a>
						</c:if>
						<c:if test="${astaff.personType=='company'}">
							<a
							href="company/showDetail.do?userId=${astaff.userId}"
							target="dialog" width="670" height="600"  style="color:blue;"
							rel="show_company" title="企业详情"  resizable="true" mask="true"
							maxable="false" drawable="true">点击查看详情</a>
						</c:if>
					</td>
					<td title="${astaff.reviewContent }">${astaff.reviewContentShort }</td>
					<td >
						<c:if test="${astaff.personType == 'helpPeople'}">实名审核</c:if>
						<c:if test="${astaff.personType == 'loveGroup'}">善管家审核</c:if>
						<c:if test="${astaff.personType == 'company'}">企业审核</c:if>
					</td>
					<td ><fmt:formatDate value="${astaff.reviewTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td >${astaff.reviewPersonName }
						<%-- <a
							href="action/actionUserDetail.do?id=${astaff.reviewPerson}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${astaff.reviewPerson }
							<c:if test="${astaff.reviewPersonName == ''}">点击查看详情</c:if>
						</a> --%>
					</td>
					<td >
						<c:if test="${astaff.state==201&&astaff.personType == 'helpPeople'}">
						<priveliege:enable buttonCode="initRealNameAudit">
							<a class="btnEdit" href="user/initRealNameAudit.do?id=${astaff.id}&userId=${astaff.userId }" target="dialog" rel="initRealNameAudit" title="实名审核">实名审核</a>
						</priveliege:enable>
						</c:if>
						<c:if test="${astaff.state==201&&astaff.personType == 'loveGroup'}">
						<priveliege:enable buttonCode="initloveGroupAudit">
							<a class="btnEdit" href="user/initloveGroupAudit.do?id=${astaff.id}&userId=${astaff.userId }" target="dialog" rel="initloveGroupAudit" title="善管家审核">善管家审核</a>
						</priveliege:enable>
						</c:if>
						<c:if test="${astaff.state==201&&astaff.personType == 'company'}">
						<priveliege:enable buttonCode="initCompanyAudit">
							<a class="btnEdit" href="company/initCompanyAudit.do?id=${astaff.id}&userId=${astaff.userId }" target="dialog" rel="initCompanyAudit" title="企业审核">企业审核</a>
						</priveliege:enable>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	