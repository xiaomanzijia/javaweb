<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#projectName").val("");
	$("#ip").val("");
	//$("#operateType option:first").attr("selected","selected"); 
	$("#startDate").val("");
	$("#endDate").val("");
}

</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="lovegroupment/loveGroupMentList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="projectId" value="${projectId}" />
		<input type="hidden" name="userId" value="${loveGroupMent.userId}" />
		<input type="hidden" name="role" value="${loveGroupMent.role}" />
		<input type="hidden" name="userType" value="${loveGroupMent.userType}" />
	</form>
	<div class="searchBar">
		<form method="post" action="lovegroupment/loveGroupMentList.do" onsubmit="return dwzSearch(this,'dialog')" 
			class="pageForm required-validate">
		<input type="hidden" name="projectId" value="${projectId}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="digits textInput " value="${loveGroupMent.userId }" style="width:114px"  name="userId"  type="text">
					</td>
					<%-- <td>
						<label for="name" style="width:50px">角色：</label>
						<select id="role" name="role" >
							<option value="">全部</option>
							<option value="-1" <c:if test="${loveGroupMent.role == -1}">selected="selected"</c:if>>成员被删除</option>
							<option value="0" <c:if test="${loveGroupMent.role == 0}">selected="selected"</c:if>>非团长</option>
							<option value="1" <c:if test="${loveGroupMent.role == 1}">selected="selected"</c:if>>团长</option>
						</select>
					</td> --%>
					
					<%-- <td>
						<label for="name" style="width:50px">用户类别：</label>
						<select id="userType" name="userType" >
							<option value="">全部</option>
							<option value="0" <c:if test="${loveGroupMent.userType == 0}">selected="selected"</c:if>>领域专家</option>
							<option value="1" <c:if test="${loveGroupMent.userType == 1}">selected="selected"</c:if>>成员</option>
							<option value="2" <c:if test="${loveGroupMent.userType == 2}">selected="selected"</c:if>>客服</option>
						</select>
					</td> --%>
					<td >
						<div class="subBar">
							<ul>
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
								<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="resetSysLogQuery()">重置</button></div></div></li>
							</ul>
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
			<li>
				<c:if test="${loveGroupMent.userType==1 }">
					<a class="add" target="dialog" rel="initaddlovegroupment"
						href="lovegroupment/initAddLoveGroupMent.do?loveGroupMent=1&projectId=${projectId }&loveState=203" title="添加善管家" width="950" height="600"  mask="true" maxable="false"  resizable="false" drawable="true"><span>添加善管家</span>
					</a>
				</c:if>
				<c:if test="${loveGroupMent.userType==2 }">
					<a class="add" target="dialog" rel="initaddlovegroupment"
						href="lovegroupment/initAddLoveGroupMentKF.do?projectId=${projectId }&status=100" title="添加客服" width="650" height="560"  mask="true" maxable="false"  resizable="false" drawable="true"><span>添加客服</span>
					</a>
				</c:if>
			</li>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th>用户ID</th>
				<!-- <th>角色</th>
				<th>用户类别</th> -->
				<th>负责的项目</th>
				<th>创建时间</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="item" varStatus="status">
				<tr target="list_item_id" rel="${project.id }">
					<td>${status.count}</td>
					<td >
						<c:if test="${item.userType==1 }">
						<a
							href="user/showDetail.do?id=${item.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.userId }
						</a>
						</c:if>
						<c:if test="${item.userType==2 }">
						<a
							href="action/actionUserDetail.do?id=${item.userId}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${item.userId }
							<c:if test="${item.userId == ''}">点击查看详情</c:if>
						</a>
						</c:if>
					</td>
					<%-- <td >
						<c:if test="${item.role == -1}">成员被删除</c:if>
						<c:if test="${item.role == 0}">非团长</c:if>
						<c:if test="${item.role == 1}">团长</c:if>
					</td>
					<td >
						<c:if test="${item.userType == 0}">领域专家</c:if>
						<c:if test="${item.userType == 1}">成员</c:if>
						<c:if test="${item.userType == 2}">客服</c:if>
					</td> --%>
					<td >${item.projectId }</td>
					<td ><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td >
						<c:if test="${item.role != -1}">
							<a class="btnDel" 
								href="lovegroupment/updateLoveGroupMent.do?id=${item.id}&role=-1"  callback="dialogAjax" fresh="true" 
								<c:if test="${item.userType==1 }"> title="删除善管家" </c:if> <c:if test="${item.userType==2 }"> title="删除客服" </c:if>
								target="ajaxTodo" mask="true" maxable="false">删除
							</a>
							<%-- <a class="btnEdit" href="lovegroupment/initUpdateLoveGroupMent.do?id=${item.id}&userType=${item.userType}&projectId=${projectId }" callback="dialogAjax" fresh="true" 
								target="dialog" title="编辑" mask="true" width="260" height="160" rel="initUpdateLoveGroupMent">编辑</a> --%>
						</c:if>
						<%-- <c:if test="${item.role == 1}">
							<a class="btnFreeze" 
								href="lovegroupment/updateLoveGroupMent.do?id=${item.id}&role=0"  callback="dialogAjax" fresh="true" 
								target="ajaxTodo"  title="取消团长" mask="true">取消团长
							</a>
						</c:if>
						<c:if test="${item.role == 0}">
							<a class="btnThaw" 
								href="lovegroupment/updateLoveGroupMent.do?id=${item.id}&role=1"  callback="dialogAjax" fresh="true" 
								target="ajaxTodo"  title="设为团长" mask="true">设为团长
							</a>
						</c:if> --%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('lovegroupment/loveGroupMentList.do?projectId=${projectId}&userType=${loveGroupMent.userType}',{dialogId:'lovegroupment_list'});
		}
	</script>
</div>
	