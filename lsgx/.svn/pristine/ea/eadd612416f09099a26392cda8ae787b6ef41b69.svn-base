<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
<form id="pagerForm" method="post" action="messagemodel/messageModelList.do">
	<input type="hidden" name="pageNum" value="${page.pageNum }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${orderField}" />
	<input type="hidden" name="orderDirection" value="${orderDirection}" />
	<input type="hidden" name="modelName" value="${messagemodel.modelName}" />
	<input type="hidden" name="modelType" value="${messagemodel.modelType}" />
	<input type="hidden" name="status" value="${messagemodel.status}" />
</form>
	<div class="searchBar">
		<form method="post" action="messagemodel/messageModelList.do" onsubmit="return navTabSearch(this);">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">模板名称:</label>
						<input type="text" class="textInput" style="width:100px" id="modelName" name="modelName" value="${messagemodel.modelName}"></td>
					<td>
					<td>
						<label for="name" style="width:50px">模板类型:</label>
						<select id="modelType" name="modelType"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="1"  <c:if test="${messagemodel.modelType==1}">selected="selected"</c:if>>短信模版</option>
							<option value="2"  <c:if test="${messagemodel.modelType==2}">selected="selected"</c:if>>站内信模版</option>
						</select>
					</td>
					<td>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="status" name="status"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="100"  <c:if test="${messagemodel.status==100}">selected="selected"</c:if>>启用</option>
							<option value="101"  <c:if test="${messagemodel.status==101}">selected="selected"</c:if>>禁用</option>
						</select>
					</td>
					<td>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="reset" >重置</button>
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
		<priveliege:enable buttonCode="messageModelAdd">
			<li><a class="add" href="messagemodel/initSave.do" target="dialog" rel="messagemodelAdd" title="添加模版" mask=true width="500" height="300"><span>添加模版</span></a></li>
		</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="115">
		<thead>
			<tr>
				<th width="120">模板名称</th>
				<th width="160">模板内容</th>
				<th width="80">模板类型</th>
				<th width="80">状态</th>
				<th width="120">创建时间</th>
				<th width="120">备注</th>
				<th width="60">操作人</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bean">
				<tr target="list_item_id" rel="${bean.id}">
					<td>${bean.modelName }</td>
					<td title="${bean.modelContext }">${bean.modelContext }</td>
				    <td>
				    	<c:if test="${bean.modelType==1}">
				    		短信模版
				    	</c:if>
				    	<c:if test="${bean.modelType==2}">
				    		站内信模版
				    	</c:if>
				    </td>
				    <td>
				    	<c:if test="${bean.status==100}">
				    		启用
				    	</c:if>
				    	<c:if test="${bean.status==101}">
				    		禁用
				    	</c:if>
				    </td>
				    <td><fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    <td title="${bean.note }">${bean.note }</td>
				    <td>${bean.operatorName }
				    	<%-- <a
							href="action/actionUserDetail.do?id=${bean.operator}"
							target="dialog" width="280" height="260" style="color:blue;"
							rel="show_project" title="管理员详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${bean.operator }
						</a> --%>
				    </td>
				    <td>
				    	<priveliege:enable buttonCode="messagemodelUpdate">
				    	<a class="btnEdit" href="messagemodel/initUpdate.do?id=${bean.id}" target="dialog" rel="messagemodelEditit" title="修改模版" 
				    	mask="true" maxable="false" resizable="false" drawable="true" width="500" height="300"><span>修改模版</span></a>
					    </priveliege:enable>
					    <c:if test="${bean.status==101}">
					    <priveliege:enable buttonCode="messagemodelDelete">
					    	<a class="btnDel" href="messagemodel/delete.do?id=${bean.id}" target="ajaxTodo" rel="messagemodelDelete" title="删除模版"><span>删除模版</span></a></li>
					    </priveliege:enable>
					    </c:if>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../common/panelBar.jsp" />
</div>
