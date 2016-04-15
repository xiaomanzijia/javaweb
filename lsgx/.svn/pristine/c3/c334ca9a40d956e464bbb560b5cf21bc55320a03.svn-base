<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
<form id="pagerForm" method="post" area="area/areaList.do">
	<input type="hidden" name="pageNum" value="${page.pageNum }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
	<input type="hidden" name="areaName" value="${area.areaName}" />
	<input type="hidden" name="areaCode" value="${area.areaCode}" />
	<input type="hidden" name="state" value="${area.state}" />
</form>
	<div class="searchBar">
		<form method="post" area="area/areaList.do" onsubmit="return navTabSearch(this);">
			<table class="searchContent">
				<tr>
					<td>
						地区名:
						<input type="text" class="textInput" style="width:100px" id="name" name="areaName" value="${area.areaName}"></td>
					<td>
					<td>
						地区编码:
						<input type="text" class="textInput" style="width:100px" id="areaCode" name="areaCode" value="${area.areaCode}"></td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="reset" >重置</button>
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
		<priveliege:enable buttonCode="areaAdd">
			<li><a class="add" href="area/initSave.do" target="dialog" rel="areaAdd" title="添加地区" mask=true width="300" height="200"><span>添加地区</span></a></li>
		</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr>
				<th width="80">地区名</th>
				<th width="80">地区编码</th>
				<th width="80">父地区编码</th>
				<th width="80">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>${bean.areaName }</td>
					<td>${bean.areaCode }</td>
				    <td>${bean.upperCode }</td>
				    <td>
				    	<priveliege:enable buttonCode="areaUpdate">
				    	<c:if test="${bean.state==100}">
				    		<a href="area/update.do?id=${bean.id}&state=101" target="ajaxTodo" rel="areaUpdate" title="点击禁用"><span style="color:#90EE90;">启用</span></a>
				    	</c:if>
				    	<c:if test="${bean.state==101}">
				    		<a href="area/update.do?id=${bean.id}&state=100" target="ajaxTodo" rel="areaUpdate" title="点击启用"><span style="color:#F03C35;">禁用</span></a>
				    	</c:if>
				    	</priveliege:enable>
				    </td>
				    <td>
				    	<%-- <a class="btnEdit" href="area/initUpdate.do?id=${bean.id}" target="dialog" rel="areaEditit" title="修改地区"mask="true" maxable="false" resizable="false" drawable="true" width="480" height="245"><span>修改地区</span></a> --%>
					    
					    <c:if test="${bean.state==101}">
					    <priveliege:enable buttonCode="areaDelete">
					    	<a class="btnDel" href="area/delete.do?id=${bean.id}" target="ajaxTodo" rel="areaDelete" title="删除地区"><span>删除地区</span></a></li>
					    </priveliege:enable>
					    </c:if>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
