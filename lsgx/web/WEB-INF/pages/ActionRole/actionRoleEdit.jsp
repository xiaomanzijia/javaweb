<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/actionRoleEdit.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input type="hidden" id="role.id" name="id" value="${role.id }"/>
		<input type="hidden" id="role.isAdmin" name="isAdmin" value="${role.isAdmin }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>角色组名称:</label>
				<input name="roleName" type="text" size="30" value="${role.roleName }" class="required" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>角色组信息:</label>
				<input name="description" type="text" size="30" value="${role.description }" class="required" remote="act_Master_validateName.html" />
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
