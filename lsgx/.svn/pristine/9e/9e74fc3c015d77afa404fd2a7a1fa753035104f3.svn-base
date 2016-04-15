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
<form id="pagerForm" method="post" action="action/actionUserList.do">
	<input type="hidden" name="pageNum" value="${page.pageNum }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
	<input type="hidden" name="userName" value="${actionUser.userName}" />
</form>
	<div class="searchBar">
		<form method="post" action="action/actionUserList.do" onsubmit="return navTabSearch(this);">
			<table class="searchContent">
				<tr>
					<td>
						登录名:
						<input type="text" class="textInput" style="width:100px" id="name" name="userName" value="${actionUser.userName}"></td>
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
			<priveliege:enable buttonCode="addActionUser">
				<li><a class="add" href="action/actionUserAdd.do" target="dialog" rel="addActionUser" title="添加用户" mask=true width="550" height="340"><span>添加用户</span></a></li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr>
				<th width="80">登录名</th>
				<th width="80">真实姓名</th>
				<th width="80">性别</th>
				<th width="80">联系方式</th>
				<th width="80">状态</th>
				<th width="80">创建者</th>
				<th width="100">创建时间</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>
						<a
							href="action/actionUserDetail.do?id=${bean.id}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${bean.userName }
							<c:if test="${bean.userName == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td>${bean.realName }</td>
				    <td>
				    	<c:if test="${bean.sex==0}">男</c:if>
				    	<c:if test="${bean.sex==1}">女</c:if>
				    </td>
				    <td>${bean.mobile }</td>
				    <td>
				    	<c:if test="${bean.status==100}">
				    		<a href="action/actionUserStats.do?id=${bean.id}" target="ajaxTodo" rel="actionUserStats"><span style="color:#90EE90;">启用</span></a>
				    	</c:if>
				    	<c:if test="${bean.status==101}">
				    		<a href="action/actionUserStats.do?id=${bean.id}" target="ajaxTodo" rel="actionUserStats"><span style="color:red;">禁用</span></a>
				    	</c:if>
				    </td>
				    <td>
				    	<c:if test="${bean.createname==0 }">超管</c:if>
				    	<c:if test="${bean.createname==1 }">admin</c:if>
				    </td>
				    <td>
				    	<fmt:formatDate value="${bean.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				    </td>
				    <td>
				    	<priveliege:enable buttonCode="editActionUser">
				    	<a class="btnEdit" href="action/actionUserEditGET.do?id=${bean.id}" target="dialog" rel="editActionUser" title="修改用户"mask="true" maxable="false" resizable="false" drawable="true" width="480" height="245"><span>修改用户</span></a>
					 	</priveliege:enable>
					    <c:if test="${bean.status==101}">
					    	<priveliege:enable buttonCode="actionUserDelete">
					    	<a class="btnDel" href="action/actionUserDelete.do?id=${bean.id}" target="ajaxTodo" rel="actionUserDelete" title="删除用户"><span>删除用户</span></a>
					    	</priveliege:enable>
					    </c:if>
					    <priveliege:enable buttonCode="actionUserInit">
					    <a class="btnUlogo" href="action/actionUserInit.do?id=${bean.id}" target="ajaxTodo" rel="actionUserInit" title="初始化密码"><span>初始化密码</span></a>
				    	</priveliege:enable>
				    	<priveliege:enable buttonCode="actionUserRole">
				    	<a class="btnThaw" href="action/actionUserRole.do?id=${bean.id}" 
								target="navTab" rel="actionUserRole" title="分配角色">分配角色</a>
						</priveliege:enable>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
