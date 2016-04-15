<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/actionFunctionAdd.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent nowrap" layoutH="57">
			<div class="unit">
				<label>权限名称:</label>
				<input type="text" name="funName" size="30" value="" class="required" />
			</div>
			<div class="unit">
				<label>action:</label>
				<input type="text" name="action" size="30" value=""  />
			</div>
			<div class="unit">
				<label>显示形式:</label>
					<select name="displayMode" class="combox">
						<option value="1" selected="selected">菜单</option>
						<option value="2">按钮</option>
						<option value="3">提交</option>
					</select>
			</div>
			<div class="unit">
				<label>选择父类:</label>
					<input type="hidden" name="parentFun" value="${function.parentFun }" />
					<input type="text" name="parentName" value="${function.parentName }" readonly="readonly" size="30" disabled="disabled" />
					<a class="btnLook" href="action/parentId.do" lookupGroup="" lookupPk="parentId">查找带回</a>
					可不填，即没有父类
			</div>
			<div class="unit">
				<label>target:</label>
					<select name="target" class="combox">
						<option value="navTab" selected="selected">navTab（标签）</option>
						<option value="dialog">dialog（弹出框）</option>
						<option value="ajaxTodo">ajaxTodo（刷新）</option>
					</select>
			</div>
			<div class="unit">
				<label>rel:</label>
					<input type="text" name="rel" size="30" value="" />
			</div>
			<div class="unit">
				<label>编号:</label>
					<input type="text" name="code" size="30" value="" class="required"/>
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
