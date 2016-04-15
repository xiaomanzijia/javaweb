<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<div class="pageHeader">
	<div class="searchBar">
		<form onsubmit="return iframeCallback(this, dialogAjax);"
			class="pageForm" enctype="multipart/form-data"
			action="employee/employeeImport.do" method="post">
			<table class="searchContent">
				<tr align="left">
					<td>企业员工excel文档：</td>
					<td><input type="file" id="picPath" name="file"/></td>
					<td style="float:right;">
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">上传</button>
							</div>
						</div>
						<div class="buttonActive">
							<div class="buttonContent">
								<button class="close" type="button">取消</button>
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
			<li><a class="export" href="employee/excelModel.do" target="dialog" rel="employeeExcelModel" 
					title="企业员工excel模版" mask=true width="1000" height="300"><span>企业员工excel模版</span></a>
			</li>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="90">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="400">文件绝对路径</th>
				<th width="60">文件大小</th>
				<th width="120">文件最新更新时间</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="excel"  varStatus="status">
				<tr target="list_item_id" ">
					<td >${status.count}</td>
					<td >${excel.realUrl }</td>
					<td >${excel.size }</td>
					<td>${excel.lastUpdateTime }</td>
					<td >
						<a class="btnDel" 
							href="employee/deleteExcel.do?realUrl=${excel.realUrl}"  callback="dialogAjax" fresh="true" 
							target="ajaxTodo"  title="删除" mask="true">删除
						</a>
						<!-- 更新后去掉下载的功能 -->
						<%-- <a class="btnAttach" 
							href="${excel.relativeUrl }" target="_blank" title="下载" mask="true">下载
						</a> --%>
						<a class="btnUspic" 
							href="employee/importExcel.do?realUrl=${excel.realUrl}&company_userId=${company_userId}"  callback="importExcelAjax" fresh="true" 
							target="ajaxTodo"  title="导入企业数据库" mask="true">导入企业数据库
						</a>
						<a class="btnInfo" 
							href="employee/lookExcel.do?realUrl=${excel.realUrl}"
							width="1000" height="620" target="dialog" rel="employeegoodhelp_list" title="excel企业员工导入预览" mask="true" maxable="true">excel企业员工导入预览
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	
</div>
	<script type="text/javascript">
		function dialogAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('employee/employeeExcel.do?company_userId=${company_userId}',{dialogId:'employeeExcel'});
		}
		
		function importExcelAjax(json) {
			DWZ.ajaxDone(json);
			$.pdialog.reload('employee/employeeList.do?company_userId=${company_userId}',{dialogId:'employee_list'});
			if ("closeCurrent" == json.callbackType) {
				$.pdialog.close('employeeExcel');
			}
		}
	</script>
