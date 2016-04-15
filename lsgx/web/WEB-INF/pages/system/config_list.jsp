<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	  <form id="pagerForm" method="post" action="system/configList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="configKey" value="${param.configKey}" />
		<input type="hidden" name="configValue" value="${param.configValue}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="system/configList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:60px">关键字：</label>
						<input class="textInput" value="${param.configKey }" style="width:114px" id="configKey" name="configKey"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">值：</label>
						<input class="textInput" value="${param.configValue }" style="width:114px" id="configValue" name="configValue"  type="text">
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
<div class="panelBar">
		<ul class="toolBar">
			<!-- 权限 -->
			<priveliege:enable buttonCode="configAdd">
				<li><a class="add" href="system/addConfig.do" target="dialog" rel="actionRoleAdd" title="配置参数" mask=true width="510" height="280"><span>配置参数</span></a></li>
			</priveliege:enable>
		</ul>
</div>
<div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th>关键字</th>
				<th>值</th>
				<th>是否多值</th>
				<th>正则验证</th>
				<th>提示语</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="config">
				<tr target="list_item_id" rel="${config.id }">
					<td style="width:200px">${config.configKey }</td>
					<td style="width:400px">${config.configValue }</td>
					 <c:choose>
					   <c:when test="${config.multiValue==0 }"><td style="width:100px">否</td></c:when>
					   <c:otherwise><td style="width:100px">是</td></c:otherwise>
					</c:choose>
					<td>${config.regular}</td>
					<td>${config.prompt}</td>
					<td>
					   <priveliege:enable buttonCode="configEdit">
				    	<a class="btnEdit" href="system/configEdit.do?id=${config.id}" target="dialog" rel="configEdit" title="修改配置" mask="true" maxable="false" resizable="false" drawable="true"  width="510" height="280"><span>修改配置</span></a>
					    </priveliege:enable>
					    <priveliege:enable buttonCode="configDelete">
					    <a class="btnDel" href="system/configDelete.do?id=${config.id}" target="ajaxTodo" rel="configDelete" title="删除配置"><span>删除配置</span></a></li>
					    </priveliege:enable>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	