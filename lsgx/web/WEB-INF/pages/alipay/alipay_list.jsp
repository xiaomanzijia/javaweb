<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="/alipaytradelist.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	</form>
</div>
<div class="pageContent">
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th>订单号</th>
				<th>状态</th>
				<th>类型</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注</th>
				<th>金额</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${trade}" var="trade">
				<tr target="list_item_id" rel="${trade.id }">
					<td style="width:100px" title="${trade.tradeno }">${trade.tradeno }</td>
					<td style="width:100px" title="${trade.state }">${trade.state }</td>
					<td style="width:100px" title="${trade.dtype }">${trade.dtype }</td>
					<td style="width:100px" title="${trade.createtime }">${trade.createtime }</td>
					<td style="width:100px" title="${trade.updatetime }">${trade.updatetime }</td>
					<td style="width:100px" title="${trade.remark }">${trade.remark }</td>
					<td style="width:100px" title="${trade.amount }">${trade.amount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:import url="../common/panelBar.jsp" />

</div>
