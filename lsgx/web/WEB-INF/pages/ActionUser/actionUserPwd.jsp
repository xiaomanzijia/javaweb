<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/actionUserPwd.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input type="hidden" id="actionUser.id" name="actionUser.id" value="${actionUser.id }" />
		<div class="pageFormContent" layoutH="50">
			<div class="unit">
				<label>旧密码:</label>
				<input id="actionUser.pwd" name="actionUser.pwd" type="password" size="30" value="" class="required" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>新密码:</label>
				<input id="w_validation_pwd" name="actionUser.password" size="31" class="required" type="password" value="" class="required alphanumeric" minlength="5" maxlength="20" />
			</div>
			<div class="unit">
				<label>确认密码:</label>
				<input type="password" name="password2" size="31" class="required" equalto="#w_validation_pwd" value=""/>
			</div>
			<div class="divider"></div>
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
