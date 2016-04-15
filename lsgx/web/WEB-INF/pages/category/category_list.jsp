<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	  <form id="pagerForm" method="post" action="/category/categoryList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="configId" value="${param.configId}" />
		<input type="hidden" name="sort" value="${param.sort}" />
		<input type="hidden" name="typeName" value="${param.typeName}" />
		<input type="hidden" name="needdata" value="${param.needdata}" />
		<input type="hidden" name="model" value="${param.model}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="/category/categoryList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:60px">类目名称：</label>
						<input class="textInput" value="${param.typeName }" style="width:114px" id="typeName" name="typeName"  type="text">
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
			<priveliege:enable buttonCode="categoryAdd">
				<li><a class="add" href="/category/categoryAdd.do" target="dialog" rel="categoryAdd" title="配置类目" mask=true width="550" height="500"><span>配置类目</span></a></li>
			</priveliege:enable>
		</ul>
</div>
<div>
	<table class="table" width="100%"   layoutH="115">
		<thead>
			<tr>
				<th>序号</th>
				<th>排序</th>
				<th>类目名称</th>
				<th>类目英文名称</th>
				<th>类目所需材料</th>
				<th>模板</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${categorys}" var="category" varStatus="status">
				<tr target="list_item_id" rel="${category.id }">
				 	<td style="width:30px">${status.count}</td>
					<td style="width:60px">${category.sort }</td>
					<td style="width:80px">${category.typeName }</td>
					<td style="width:100px">${category.typeName_e }</td>
					<td style="width:350px">${category.needdata }</td>
					<td style="width:450px" title="${category.model }">${category.modelShort }</td>
					<td>
					   <priveliege:enable buttonCode="categoryEdit">
				    	<a class="btnEdit" href="category/editCategory.do?id=${category.id}" target="dialog" rel="categoryEdit" title="修改类目"mask="true" maxable="false" resizable="false" drawable="true"  width="550" height="500"><span>修改类目</span></a>
					    </priveliege:enable>
					    <priveliege:enable buttonCode="categoryDelete">
					    <a class="btnDel" href="category/deleteCategory.do?id=${category.id}" target="ajaxTodo" rel="categoryDelete" title="删除类目"><span>删除类目</span></a></li>
					    </priveliege:enable>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	
