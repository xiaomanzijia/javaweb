<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<!--  
			
			-->
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20" <c:if test="${page.pageSize==20}">selected="selected"</c:if>>20</option>
				<option value="50" <c:if test="${page.pageSize==50}">selected="selected"</c:if>>50</option>
				<option value="100" <c:if test="${page.pageSize==100}">selected="selected"</c:if>>100</option>	
			</select><span>条，共${page.total}条</span>
		</div>
	<div class="pagination" targetType="navTab" totalCount="${page.total}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.pageNum}"></div>
</div>