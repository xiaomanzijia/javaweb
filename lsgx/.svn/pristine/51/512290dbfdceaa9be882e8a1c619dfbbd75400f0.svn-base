<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#userId").val("");
	$("#content").val("");
}
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="projectfeedback/projectFeedBackList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="projectFeedback_id" value="${leaveWord.projectFeedback_id}" />
		<input type="hidden" name="userId" value="${leaveWord.userId}" />
		<input type="hidden" name="userName" value="${leaveWord.userName}" />
		<input type="hidden" name="content" value="${leaveWord.content}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="projectfeedback/projectFeedBackList.do" onsubmit="return dwzSearch(this,'dialog')" class="pageForm required-validate">
			<input type="hidden" name="projectFeedback_id" value="${leaveWord.projectFeedback_id}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">用户ID：</label>
						<input class="digits textInput" value="${leaveWord.userId }" style="width:114px" id="userId" name="userId"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">用户名：</label>
						<input class="digits textInput" value="${leaveWord.userName }" style="width:114px" id="userName" name="userName"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">留言内容：</label>
						<input class="textInput" value="${leaveWord.content }" style="width:114px" id="content" name="content"  type="text">
					</td>
					<td >
						<div class="subBar">
							<ul>
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
								<li><div class="buttonActive"><div class="buttonContent"><button type="reset" onclick="resetSysLogQuery()">重置</button></div></div></li>
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
			</li>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">ID</th>
				<th width="80">用户名</th>
				<th width="180">留言内容</th>
				<th width="120">留言时间</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="leaveWord" varStatus="status">
				<tr target="list_item_id" rel="${leaveWord.id }">
					<td>${status.count}</td>
					<td >${leaveWord.id }</td>
					<td >
						<a
							href="user/showDetail.do?id=${leaveWord.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${leaveWord.userName }
						</a>
					</td>
					<td title="${leaveWord.content }">${leaveWord.contentShort }</td>
					<td ><fmt:formatDate value="${leaveWord.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					
					<td>
						<a class="btnDel" href="leaveword/delete.do?id=${leaveWord.id}"  callback="dialogAjax"
			    			target="ajaxTodo" rel="payMoney" title="删除"><span>删除</span></a>
			    		<a class="btnLookpj" 
							href="leaveword/leaveWordList.do?pid=${leaveWord.id}"
							width="760" height="460" target="dialog" rel="leaveword_list${leaveWord.id}" title="【${leaveWord.contentShort }】留言回复" mask="true" maxable="false">留言回复
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('leaveword/leaveWordList.do?projectFeedback_id=${leaveWord.projectFeedback_id}&pid=${leaveWord.pid}',{dialogId:'leaveWord_list${leaveWord.pid}'});
		}
	</script>
</div>
	