<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/actionUserAdd.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>账号名:</label>
				<input name="userName" type="text" size="31" value="" class="required" />
			</div>
			<div class="unit">
				<label>密码:</label>
				<input id="w_validation_pwd" name="password" size="31" class="required" type="password" value="" class="required alphanumeric" minlength="5" maxlength="20" />
			</div>
			<div class="unit">
				<label>确认密码:</label>
				<input type="password" name="password2" size="31" class="required" equalto="#w_validation_pwd" value=""/>
			</div>
			<div class="unit">
				<label>真实姓名:</label>
				<input type="text" value="" name="realName" size="31" class="required" value="a"/>
			</div>
			<div class="unit">
				<label>手机号:</label>
				<input type="text" name="mobile" size="31"class="phone"/>
			</div>
			<div class="unit">
				<label>性别:</label>
					<select name="sex" id="actionUser.sex" >
						<option value="0" selected="selected">男</option>
						<option value="1">女</option>
					</select>
			</div>
			<div class="unit">
				<label>是否启用:</label>
					<select name="status" id="actionUser.status">
						<option value="100" selected="selected">启用 </option>
						<option value="101">停用</option>
					</select>
			</div>
			<div class="unit">
				<!--<label>部门:</label>
				 <select class="combox" name="master.ele_code">
					<option value="">请选择</option>
					<c:forEach items="${elelist}" var="bean" varStatus="s">
						<option value="${bean.ele_code}" >${bean.ele_name}</option>
					</c:forEach>
				</select>
				-->
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
