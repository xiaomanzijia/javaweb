<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/viewimg1.css">
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
	document.onkeydown=banBackSpace;
	function resetQuery()
	{
		$("#name").val("");
	}
</script>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="/bfile/queryList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
	</form>
	<div class="searchBar">
		<form method="post" action="/bfile/queryList.do" onsubmit="return navTabSearch(this);">
			<table class="searchContent">
				<tr>
					<td><td>
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

				<li><a class="add" href="/bfile/addBfile.do" target="dialog" rel="uploadBFile" title="上传图片" mask=true width="550" height="340"><span>上传图片</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
		<tr >
			<th width="80">图片说明</th>
			<th width="80">URL</th>
			<th width="80">图片预览</th>
			<th width="100">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${bfileList}" var="bean">
			<tr target="list_item_id" rel="${bean.id}" >
				<td>
						${bean.description }
				</td>
				<td>${bean.url }</td>
				<td >
				<a href="${bean.url}" target="_blank">预览</a>
				</td>
				<td>
					<a class="btnDel" href="/bfile/delete.do?id=${bean.id}" target="ajaxTodo" rel="newsDelete" title="删除"><span>删除</span></a></li>


				</td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
