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
	<form id="pagerForm" method="post" action="employee/employeeList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="company_userId" value="${employee.company_userId}" />
		<input type="hidden" name="userId" value="${employee.userId}" />
		<input type="hidden" name="nickName" value="${employee.nickName}" />
		<input type="hidden" name="realName" value="${employee.realName}" />
		<input type="hidden" name="state" value="${employee.state}" />
	</form>
	<div class="searchBar">
		<form method="post" action="employee/employeeList.do" onsubmit="return dwzSearch(this,'dialog')" 
			class="pageForm required-validate">
			<input type="hidden" name="company_userId" value="${employee.company_userId}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="digits textInput " value="${employee.userId }" style="width:114px"  name="userId"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">员工账号：</label>
						<input class="digits textInput " value="${employee.nickName }" style="width:114px"  name="nickName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">员工姓名：</label>
						<input class="digits textInput " value="${employee.realName }" style="width:114px"  name="realName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="state" name="state" >
							<option value=""  >全部</option>
							<option value="201"  <c:if test="${employee.state==201}">selected="selected"</c:if>>未审核</option>
							<option value="202"  <c:if test="${employee.state==202}">selected="selected"</c:if>>未通过</option>
							<option value="203"  <c:if test="${employee.state==203}">selected="selected"</c:if>>通过</option>
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
			<priveliege:enable buttonCode="employeeExcel">
				<li><a class="export" href="employee/employeeExcel.do?company_userId=${employee.company_userId}" target="dialog" rel="employeeExcel" 
					title="企业员工excel文件上传列表"  mask="true" maxable="false"  resizable="false" drawable="true"
					width="800" height="420" ><span>excel企业员工导入</span></a>
				</li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="60">员工ID</th>
				<th>员工账号</th>
				<th width="100">员工姓名</th>
				<th>公司名</th>
				<th>职位</th>
				<th width="100">审核状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="employee" varStatus="status">
				<tr target="list_item_id" rel="${employee.id }">
					<td>${status.count}</td>
					<td>
						<a
							href="user/showDetail.do?id=${employee.userId }"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${employee.userId }
						</a>
					</td>
					<td >
						<a
							href="employee/employeeDetail.do?id=${employee.id}"
							target="dialog" width="400" height="520" style="color:blue;"
							rel="show_employee" title="企业员工详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${employee.nickName }
							<c:if test="${employee.nickName == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >${employee.realName }</td>
					<td >${employee.companyName}</td>
					<td >${employee.position}</td>
					<td >
						<c:if test="${employee.state == 201}">未审核</c:if>
						<c:if test="${employee.state == 202}">未通过</c:if>
						<c:if test="${employee.state == 203}">通过</c:if>
					</td>
					<td >
						<c:if test="${employee.state == 201}">
							<a class="btnEdit" href="employee/initUpdateEmployee.do?id=${employee.id}&company_userId=${employee.company_userId}" callback="dialogAjax" fresh="true" 
								target="dialog" title="审核" mask="true" width="360" height="360" rel="initUpdateEmployee">审核</a>
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
			$.pdialog.reload('employee/employeeList.do?company_userId=${company_userId}',{dialogId:'employee_list'});
		}
	</script>
</div>
	