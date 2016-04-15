<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetQuery()
{
	$("#funName").val("");
	$("#action").val("");
}
</script>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="action/actionFunctionList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="funName" value="${actionFunction.funName}" />
		<input type="hidden" name="action" value="${actionFunction.action}" />
	</form>
	<div class="searchBar">
		<form method="post" action="action/actionFunctionList.do" onsubmit="return navTabSearch(this);">
			<table class="searchContent">
				<tr>
					<td>
						名称:
						<input type="text" class="textInput" style="width:100px" id="funName" name="funName" value="${actionFunction.funName}" />
					</td>
					<td>
						action:
						<input type="text" class="textInput" style="width:100px" id="action" name="action" value="${actionFunction.action}" />
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="button" onclick="resetQuery()">重置</button>
							</div>
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
			<!-- 权限 -->
			<priveliege:enable buttonCode="addFunction">
				<li><a class="add" href="action/actionFunctionAdd.do" target="dialog" rel="addFunction" title="添加菜单" mask=true width="550" height="340"><span>添加菜单</span></a></li>
			</priveliege:enable>
			<priveliege:enable buttonCode="editFunction">
				<li><a class="edit" href="action/actionFunctionEdit.do?id={list_item_id}" target="dialog" rel="editFunction" title="修改菜单"><span>修改菜单</span></a></li>
			</priveliege:enable>
			<priveliege:enable buttonCode="deleteFunction">
				<li><a class="delete" href="action/actionFunctionDelete.do?id={list_item_id}" target="ajaxTodo" rel="deleteFunction" title="删除菜单"><span>删除菜单</span></a></li>
			</priveliege:enable>
			<%--<li><a class="edit" href="act_Master_assign.html?id={list_item_id}" target="navTab" rel="act_Master_assign" title="分配角色"><span>分配角色</span></a></li>
		--%></ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr>
				<th width="80">菜单id</th>
				<th width="80">名称</th>
				<th width="80">action</th>
				<th width="80">显示形式</th>
				<th width="80">父类id</th>
				<th width="80">target</th>
				<th width="80">rel</th>
				<th width="80">编号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${functionList}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>${bean.id }</td>
					<td>${bean.funName }</td>
				    <td>${bean.action }</td>
				    <td>
				    	<c:if test="${bean.displayMode==1}">菜单</c:if>
				    	<c:if test="${bean.displayMode==2}">按钮</c:if>
				    	<c:if test="${bean.displayMode==3}">提交</c:if>
				    </td>
				    <td>${bean.parentFun }</td>
				    <td>${bean.target }</td>
				    <td>${bean.rel }</td>
				    <td>${bean.code }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
