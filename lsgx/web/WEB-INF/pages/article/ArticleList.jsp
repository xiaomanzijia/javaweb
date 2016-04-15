<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetQuery()
{
	$("#name").val("");
}
</script>
<div class="pageHeader">
<form id="pagerForm" method="post" action="/article/showArticleList.do">
	<input type="hidden" name="pageNum" value="${page.pageNum }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
	<input type="hidden" name="title" value="${title}" />
	<input type="hidden" name="category" value="${category}" />
</form>
	<div class="searchBar">
		<form method="post" action="/article/showArticleList.do" onsubmit="return navTabSearch(this);">
			<input type="hidden" name="category" value="${category}" />
			<table class="searchContent">
				<tr>
					<td>
						标题:
						<input type="text" class="textInput" style="width:100px" id="name" name="title" value="${article.title}"></td>
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

				<li><a class="add" href="/article/ArticleAddGET.do?category=${category}" target="dialog" rel="addArticleOne" title="添加文章" mask=true  width="780" height="580"><span>添加文章</span></a></li>

				<li><a class="edit" href="/article/articleEditGET.do?id={list_item_id}" target="dialog" rel="articleEditOne" title="编辑文章" mask=true width="780" height="580"><span>编辑文章</span></a></li>


		</ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr >
				<th width="80">标题</th>
				<th width="80">创建日期</th>
				<th width="80">描述</th>
				<th width="80">是否发布</th>

				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articleList}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>
						<a
							href="/article/articleDetail.do?id=${bean.id}"
							target="dialog" width="680" height="480" style="color:blue;"
							rel="show_detail" title="文章详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${bean.title }
							<c:if test="${bean.title == ''}">点击查看详情</c:if>
						</a>
					</td>

				    <td>
						<fmt:formatDate value="${bean.createtime}" pattern="yyyy-MM-dd HH:mm"/>
				    </td>
				    <td>${bean.description }</td>
				    <td>
						<c:if test="${bean.valid==1}">已发布</c:if>
						<c:if test="${bean.valid==0}">未发布</c:if>
				    </td>

					<td>
						<c:if test="${bean.valid==0}">
						<a href="article/articleRelease.do?id=${bean.id}"  target="ajaxTodo"  rel="articleList" title="是否发布？发布后的文章可在网站上查看">发布</a>
						</c:if>
						&nbsp;
						&nbsp;
						&nbsp;
						&nbsp;
						<c:if test="${bean.valid==1}">
							<a href="article/articleUnRelease.do?id=${bean.id}"  target="ajaxTodo"  rel="articleList" title="是否取消发布，取消后文章在网站上不可见">取消发布</a>
						</c:if>
						&nbsp;
						&nbsp;
						&nbsp;
						&nbsp;
						<a href="article/articleDelete.do?id=${bean.id}"  target="ajaxTodo"  rel="articleList" title="是否删除？删除后文章不可恢复">删除</a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
