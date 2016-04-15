<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<div class="pageContent">
	<form method="post" action="messagemodel/update.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input id="id" name="id" type="hidden" value="${messageModel.id}" />
		
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>模板名称:</label>
				<input type="text" class="textInput requery" style="width:325px" id="modelName" name="modelName" value="${messageModel.modelName}">
			</div>
			<div class="unit">
				<label>模板内容:</label>
				<textarea type="text" class="textInput requery" rows="5" cols="50" id="modelContext" name="modelContext" >${messageModel.modelContext}</textarea>
			</div>
			<div class="unit">
				<label>模板类型:</label>
				<select id="modelType" name="modelType"  style="width: 120px" >
					<option value="1"  <c:if test="${messageModel.modelType==1}">selected="selected"</c:if>>短信模版</option>
					<option value="2"  <c:if test="${messageModel.modelType==2}">selected="selected"</c:if>>站内信模版</option>
				</select>
			</div>
			<div class="unit">
				<label >状态：</label>
				<select id="status" name="status"  style="width: 120px" >
					<option value="100"  <c:if test="${messageModel.status==100}">selected="selected"</c:if>>启用</option>
					<option value="101"  <c:if test="${messageModel.status==101}">selected="selected"</c:if>>禁用</option>
				</select>
			</div>
			<div class="unit">
				<label>备注:</label>
				<input type="text" class="textInput " style="width:325px" id="note" name="note" value="${messageModel.note}">
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
