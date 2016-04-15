<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
<form id="pagerForm" method="post" action="action/actionRoleList.do">
	<input type="hidden" name="pageNum" value="${page.pageNum }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>
	<div class="panelBar">
		<ul class="toolBar">
			<!-- 权限 -->
			<priveliege:enable buttonCode="actionRoleAdd">
				<li><a class="add" href="action/actionRoleAdd.do" target="dialog" rel="actionRoleAdd" title="添加角色" mask=true width="510" height="170"><span>添加角色</span></a></li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="78">
		<thead>
			<tr>
				<th width="200">角色组名称</th>
				<th width="80">群组信息</th>
				<th width="80">是否超管</th>
				<th width="80">创建时间</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roleList}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>${bean.roleName }</td>
					<td>${bean.description }</td>
				    <td>
				    	<c:if test="${bean.isAdmin==0 }">是</c:if>
				    	<c:if test="${bean.isAdmin==1 }">否</c:if>
				    </td>
				    <td>
				    	<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				    </td>
				    <td>
				    	<priveliege:enable buttonCode="actionRoleEdit">
				    	<a class="btnEdit" href="action/actionRoleEdit.do?id=${bean.id}" target="dialog" rel="actionRoleEdit" title="修改角色"mask="true" maxable="false" resizable="false" drawable="true"  width="510" height="170"><span>修改角色</span></a>
					    </priveliege:enable>
					    <priveliege:enable buttonCode="actionRoleDelete">
					    <a class="btnDel" href="action/actionRoleDelete.do?id=${bean.id}" target="ajaxTodo" rel="actionRoleDelete" title="删除角色"><span>删除角色</span></a></li>
					    </priveliege:enable>
					    <priveliege:enable buttonCode="disFunction">
					    <a class="btnUlogo" href="action/actionRoleFun.do?id=${bean.id}"  target="navTab"  rel="actionRoleFun" title="分配权限"><span>分配权限</span></a>
				    	</priveliege:enable>
				    	<%-- <priveliege:enable buttonCode="disUser">
				    	<a class="btnAssign" href="action/actionRoleUser.do?id=${bean.id}" target="navTab" rel="actionRoleUser" title="分配用户">分配用户</a>
				    	</priveliege:enable> --%>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
