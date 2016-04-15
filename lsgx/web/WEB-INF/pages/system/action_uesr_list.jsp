<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/taglibs.jsp" %>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetQuery()
{
	$("#name").val("");
}
</script>
<div class="pageHeader">

userlist
<%-- 	<div class="searchBar">
		<form id="pagerForm" method="post" action="action/actionUserList.do" onsubmit="return navTabSearch(this);">
			<input type="hidden" name="pageNum" value="${page.pageNo}" />
			<input type="hidden" name="numPerPage" value="${page.pageSize}" />
			<table class="searchContent">
				<tr>
					<td>
						登录名:
						<input type="text" class="textInput" style="width:100px" id="name" name="name" value="${page.params.username}"></td>
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
	</div> --%>
</div>

<div class="pageContent">
	<%-- <div class="panelBar">
		<ul class="toolBar">
			<!-- 权限 -->
			<priveliege:enable buttonCode="addUser">
				<li><a class="add" href="action/actionUserAdd.do" target="dialog" rel="actionUserAdd" title="添加用户" mask=true width="550" height="340"><span>添加用户</span></a></li>
			</priveliege:enable>
			<priveliege:enable buttonCode="editUser">
				<li><a class="edit" href="action/actionUserEditit.do?id={list_item_id}" target="dialog" rel="actionUserEditit" title="修改用户" mask=true width="480" height="245"><span>修改用户</span></a></li>
			</priveliege:enable>
			<priveliege:enable buttonCode="deleteUser">
				<li><a class="delete" href="action/actionUserDelete.do?id={list_item_id}" target="ajaxTodo" rel="actionUserDelete" title="删除用户"><span>删除用户</span></a></li>
			</priveliege:enable>
			<priveliege:enable buttonCode="resetUserPwd">
				<li><a class="edit" href="action/actionUserInit.do?id={list_item_id}" target="ajaxTodo" rel="actionUserInit" title="初始化密码"><span>初始化密码</span></a></li>
			</priveliege:enable>
			<priveliege:enable buttonCode="disRole">
				<li><a class="edit" href="action/actionUserRole.do?id={list_item_id}" target="navTab" rel="actionUserRole" title="分配角色"><span>分配角色</span></a></li>
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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>${bean.username }</td>
					<td>${bean.realName }</td>
				    <td>
				    	<c:if test="${bean.sex==0}">男</c:if>
				    	<c:if test="${bean.sex==1}">女</c:if>
				    </td>
				    <td>${bean.mobile }</td>
				    <td>
				    	<c:if test="${bean.status==1}">
				    		<a href="action/actionUserStats.do?id=${bean.id}" target="ajaxTodo" rel="actionUserStats"><span style="color:#90EE90;">启用</span></a>
				    	</c:if>
				    	<c:if test="${bean.status==2}">
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20" <c:if test="${page.pageSize==20}">selected="selected"</c:if>>20</option>
				<option value="30" <c:if test="${page.pageSize==30}">selected="selected"</c:if>>30</option>
				<option value="50" <c:if test="${page.pageSize==50}">selected="selected"</c:if>>50</option>
				<option value="100" <c:if test="${page.pageSize==100}">selected="selected"</c:if>>100</option>	
			</select><span>条，共${page.total}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${page.total}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.pageNo}"></div>
	</div>	 --%>
</div>
