<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="dialogPageBreak({numPerPage:this.value})">
			<c:forEach begin="20" end="100" step="20" varStatus="s">
				<option value="${s.index}" ${page.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
			</select><span>条，共${page.total}条</span>
		</div>
	<div class="pagination" targetType="dialog" totalCount="${page.total}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.pageNum}"></div>
</div>