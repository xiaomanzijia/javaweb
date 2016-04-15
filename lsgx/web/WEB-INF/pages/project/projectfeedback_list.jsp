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
	<form id="pagerForm" method="post" action="projectfeedback/projectFeedBackList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="projectId" value="${projectFeedback.projectId}" />
		<input type="hidden" name="feedbackPeople" value="${projectFeedback.feedbackPeople}" />
		<input type="hidden" name="content" value="${projectFeedback.content}" />
		<input type="hidden" name="auditState" value="${projectFeedback.auditState}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="projectfeedback/projectFeedBackList.do" onsubmit="return dwzSearch(this,'dialog')" class="pageForm required-validate">
		<input type="hidden" name="projectId" value="${projectFeedback.projectId}" />
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">反馈人ID：</label>
						<input class="digits textInput" value="${projectFeedback.feedbackPeople }" style="width:114px" id="feedbackPeople" name="feedbackPeople"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">反馈内容：</label>
						<input class="textInput" value="${projectFeedback.content }" style="width:114px" id="content" name="content"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">审核状态：</label>
						<select id="auditState" name="auditState" >
							<option value="">全部</option>
							<option value="200" <c:if test="${projectFeedback.auditState == 200}">selected="selected"</c:if>>保存未提交</option>
							<option value="201" <c:if test="${projectFeedback.auditState == 201}">selected="selected"</c:if>>保存未审核</option>
							<option value="202" <c:if test="${projectFeedback.auditState == 202}">selected="selected"</c:if>>审核未通过</option>
							<option value="203" <c:if test="${projectFeedback.auditState == 203}">selected="selected"</c:if>>审核通过</option>
						</select>
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
				<th width="50">反馈人</th>
				<th width="120">图片ID</th>
				<th width="120">反馈内容</th>
				<th width="120">反馈时间</th>
				<th width="50">审核人</th>
				<th width="60">审核状态</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="projectFeedback" varStatus="status">
				<tr target="list_item_id" rel="${projectFeedback.id }">
					<td>${status.count}</td>
					<td >${projectFeedback.id }</td>
					<td >
						<a
							href="user/showDetail.do?id=${projectFeedback.feedbackPeople}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${projectFeedback.feedbackPeople }
						</a>
					</td>
					<td >
						<a
							href="bfile/showList.do?ids=${projectFeedback.contentImageId}"
							target="dialog" width="660" height="480" style="color:blue;"
							rel="show_img_list" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true">${projectFeedback.contentImageId}</a>
					</td>
					<td title="${projectFeedback.content }">${projectFeedback.contentShort }</td>
					<td ><fmt:formatDate value="${projectFeedback.feedbackTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<a
							href="action/actionUserDetail.do?id=${projectFeedback.audit}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${projectFeedback.audit}
						</a>
					</td>
					
					<td >
						<c:if test="${projectFeedback.auditState == 200}">保存未提交</c:if>
						<c:if test="${projectFeedback.auditState == 201}">保存未审核</c:if>
						<c:if test="${projectFeedback.auditState == 202}">审核未通过</c:if>
						<c:if test="${projectFeedback.auditState == 203}">审核通过</c:if>
					</td>
					<td>
						<c:if test="${projectFeedback.auditState==201}">
						<a class="btnCancel" href="projectfeedback/auditState.do?id=${projectFeedback.id}&auditState=202&projectId=${projectFeedback.projectId}"  callback="dialogAjax"
			    			target="ajaxTodo" rel="payMoney" title="审核未通过"><span>审核未通过</span></a>
			    		<a class="btnSelect" href="projectfeedback/auditState.do?id=${projectFeedback.id}&auditState=203&projectId=${projectFeedback.projectId}"  callback="dialogAjax"
			    			target="ajaxTodo" rel="payMoney" title="审核通过"><span>审核通过</span></a>	
			    		</c:if>
			    		<a class="btnLookpj" 
							href="leaveword/leaveWordList.do?projectFeedback_id=${projectFeedback.id}"
							width="760" height="520" target="dialog" rel="leaveword_list" title="反馈留言" mask="true" maxable="false">反馈留言
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/dialogPanelBar.jsp" />
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('projectfeedback/projectFeedBackList.do?projectId=${projectFeedback.projectId}',{dialogId:'projectFeedback_list'});
		}
	</script>
</div>
	