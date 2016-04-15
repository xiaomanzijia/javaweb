<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>


<div class="pageHeader">
	<form id="pagerForm" method="post" action="category/bringBacklist.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="configKey" value="${config.configKey}" />
		<input type="hidden" name="configValue" value="${config.configValue}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="category/bringBacklist.do" onsubmit="return dwzSearch(this,'dialog')">
			<table class="searchContent">
			<input type="hidden" name="configIds" value="" />
				<tr>
					<td>
						<label for="name" style="width:50px">所属类目：</label>
						<input class="textInput" value="${config.configKey }" style="width:114px" id="configKey" name="configKey"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">资料内容：</label>
						<input class="textInput" value="${config.configValue }" style="width:114px" id="configValue" name="configValue"  type="text">
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
		<div class="button">
					<div class="buttonContent">
						<button warn="请选择所需材料" multlookup="configIds"  type="button">选择带回</button>
					</div>
				</div>
			
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30"><input type="checkbox" group="configIds" class="checkboxCtrl"></th>
				<th width="80">所需材料ID</th>
				<th width="160">所属类目</th>
				<th>所需材料内容</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="config">
				<tr target="list_item_id" rel="${config.id }">
					<td>
						<c:choose>
						<c:when test="${configIds != null && configIds[0]!=0}">
						<c:forEach items="${configIds}" var="config_id" varStatus="status">
						<c:if test="${config.id == configIds[status.index]}">
						<input name="configIds" type="checkbox" checked="true" value="{configIds:'${config.id}'}">
						</c:if></c:forEach>
						<input name="configIds" type="checkbox" value="{configIds:'${config.id}'}">
						</c:when>
						<c:otherwise>
						<input name="configIds" type="checkbox" value="{configIds:'${config.id}'}">
						</c:otherwise>
						</c:choose>
					</td>
					<td>${config.id }</td>
					<td >${config.configKey }</td>
					<td >${config.configValue }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
</div>
	