<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="action/parentId.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="funName" value="${actionFunction.funName}" />
		<input type="hidden" name="action" value="${actionFunction.action}" />
	</form>
	<div class="searchBar">
		<form method="post" action="action/parentId.do" onsubmit="return dialogSearch(this);">
			<div class="subBar">
				<table class="searchContent">
					<tr>
						<td>
							权限名：
							<input type="text" class="textInput" style="width:100px" name="funName" value="${actionFunction.funName}" />
						</td>
						<td>
							action：
							<input type="text" class="textInput" style="width:100px" name="action" value="${actionFunction.action}" />
						</td>
						<td>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
<div class="pageContent">
	<table class="table" targetType="dialog" width="100%" layoutH="87">
		<thead>
			<tr>
				<th orderfield="id">权限ID</th>
				<th orderfield="funName">权限名</th>
				<th orderfield="action">action</th>
				<th width="80">查找带回</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>${bean.id }</td>
					<td>${bean.funName }</td>
					<td>${bean.action }</td>
					<td><a class="btnSelect" title="查找带回" href="javascript:$.bringBack({parentFun:'${bean.id }',parentName:'${bean.funName }'})">查找带回</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/dialogPanelBar.jsp" />
</div>