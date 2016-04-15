<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#companyType option:first").attr("selected","selected"); 
	$("#loveGroupMent option:first").attr("selected","selected"); 
	$("#realState option:first").attr("selected","selected"); 
	$("#loveGroupMent option:first").attr("selected","selected"); 
}
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="company/companyList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="name" value="${company.name}" />
		<input type="hidden" name="registerNo" value="${company.registerNo}" />
		<input type="hidden" name="head" value="${company.head}" />
		<input type="hidden" name="useState" value="${company.useState}" />
		<input type="hidden" name="legalName" value="${company.legalName}" />
		<input type="hidden" name="serviceField" value="${company.serviceField}" />
		<input type="hidden" name="mobile" value="${company.mobile}" />
		<input type="hidden" name="state" value="${company.state}" />
		<input type="hidden" name="type" value="${company.type}" />
		<input type="hidden" name="mobileState" value="${company.mobileState}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="company/companyList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">企业名称：</label>
						<input class="textInput" value="${company.name }" style="width:100px" id="name" name="name"  type="text">
					</td>
					<td>
						<label for="name" style="width:90px;">企业注册号：</label>
						<input class="textInput" value="${company.registerNo }" style="width:114px" id="registerNo" name="registerNo"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">负责人：</label>
						<input class="textInput" value="${company.head }" style="width:100px" id="head" name="head"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">使用状态：</label>
						<select id="useState" name="useState"  style="width: 120px" >
							<option value="" >全部</option>
							<option value="100"  <c:if test="${company.useState==100}">selected="selected"</c:if>>正常</option>
							<option value="101"  <c:if test="${company.useState==101}">selected="selected"</c:if>>信用</option>
							<option value="102"  <c:if test="${company.useState==102}">selected="selected"</c:if>>暂停</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:75px">企业认证状态：</label>
						<select id="state" name="state"  style="width: 110px" >
							<option value=""  >全部</option>
							<option value="201"  <c:if test="${company.state==201}">selected="selected"</c:if>>未认证</option>
							<option value="202"  <c:if test="${company.state==202}">selected="selected"</c:if>>认证失败</option>
							<option value="203"  <c:if test="${company.state==203}">selected="selected"</c:if>>认证通过</option>
						</select>
					</td>
					<td></td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">联系电话：</label>
						<input class="textInput" value="${company.mobile }" style="width:100px" id="mobile" name="mobile"  type="text">
					</td>
					<td>
						<label for="name" style="width:90px">法定代表人姓名：</label>
						<input class="textInput" value="${company.legalName }" style="width:114px" id="legalName" name="legalName"  type="text">
					</td>
					<td >
						<label for="name" style="width:50px">助善口令：</label>
						<input class="textInput" value="${company.goodPassWord }" style="width:100px" id="goodPassWord" name="goodPassWord"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">单位类型：</label>
						<select id="type" name="type"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="0"  <c:if test="${company.type==0}">selected="selected"</c:if>>企业</option>
							<option value="1"  <c:if test="${company.type==1}">selected="selected"</c:if>>事业单位</option>
							<option value="2"  <c:if test="${company.type==2}">selected="selected"</c:if>>社会团体</option>
							<option value="3"  <c:if test="${company.type==3}">selected="selected"</c:if>>党政及国家机关</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:75px">手机验证状态：</label>
						<select id="mobileState" name="mobileState"  style="width: 110px" >
							<option value=""  >全部</option>
							<option value="201"  <c:if test="${company.mobileState==201}">selected="selected"</c:if>>未审核</option>
							<option value="202"  <c:if test="${company.mobileState==202}">selected="selected"</c:if>>审核未通过</option>
							<option value="203"  <c:if test="${company.mobileState==203}">selected="selected"</c:if>>验证审核通过</option>
						</select>
					</td>
					<td style="float:right;">
						<div class="buttonActive">
							<div class="buttonContent"><button type="submit">查询</button></div>
						</div>
						<div class="buttonActive">
							<div class="buttonContent"><button type="reset" onclick="resetSysLogQuery()">重置</button></div>
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
			<priveliege:enable buttonCode="companyExcel">
				<li><a class="export" href="company/companyExcel.do" target="dialog" rel="companyExcel" 
					title="企业excel文件上传列表" width="1000" height="420" ><span>excel企业导入</span></a>
				</li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th width="60">企业ID</th>
				<th width="160">企业名称</th>
				<th width="100">助善口令</th>
				<th width="100">负责人</th>
				<th width="120">企业使用状态</th>
				<th width="100">法定代表人姓名</th>
				<!-- <th width="180">业务范围</th> -->
				<th width="100">联系电话</th>
				<th width="120">企业认证状态</th>
				<th width="120">单位类型</th>
				<th width="120">手机验证状态</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="company">
				<tr target="list_item_id" rel="${company.id }">
					<td >${company.id }</td>
					<td >
						<a
							href="company/showDetail.do?id=${company.id}"
							target="dialog" width="670" height="600" style="color:blue;"
							rel="show_company" title="企业详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${company.name }
							<c:if test="${company.name == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >${company.goodPassWord }</td>
					<td >${company.head }</td>
					<td >
						<c:if test="${company.useState==100}">正常</c:if>
						<c:if test="${company.useState==101}">信用</c:if>
						<c:if test="${company.useState==102}">暂停</c:if>
					</td>
					<td>${company.legalName }</td>
					<%-- <td title="${company.serviceField }">${company.serviceFieldShort }</td> --%>
					<td>${company.mobile }</td>
					<td>
						<c:if test="${company.state==201}">未认证</c:if>
						<c:if test="${company.state==202}">认证失败</c:if>
						<c:if test="${company.state==203}">认证通过</c:if>
					</td>
					<td >
						<c:if test="${company.type==0}">企业</c:if>
						<c:if test="${company.type==1}">事业单位</c:if>
						<c:if test="${company.type==2}">社会团体</c:if>
						<c:if test="${company.type==3}">党政及国家机关</c:if>
					</td>
					<td >
						<c:if test="${company.mobileState==201}">未审核</c:if>
						<c:if test="${company.mobileState==202}">审核未通过</c:if>
						<c:if test="${company.mobileState==203}">验证审核通过</c:if>
					</td>
					<td>
						<priveliege:enable buttonCode="configEdit">
							<a class="btnEdit" 
								href="company/companyEdit.do?id=${company.id}&dialog=1"
								width="670" height="600" target="dialog" rel="configEdit" title="修改企业信息" mask="true" maxable="false">修改企业信息
							</a>
						</priveliege:enable>
						<priveliege:enable buttonCode="employee_list">
							<a class="btnAssign" 
								href="employee/employeeList.do?company_userId=${company.userId}"
								width="900" height="420" target="dialog" rel="employee_list" title="员工管理" mask="true" maxable="false">员工管理
							</a>
						</priveliege:enable>
						<a class="btnManage" 
							href="companygoodhelp/companygoodhelpList.do?company_id=${company.id}&dialog=1"
							width="1200" height="420" target="dialog" rel="companygoodhelp_list_dialog" title="企业助善项目" mask="true" maxable="false">企业助善项目
						</a>
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	