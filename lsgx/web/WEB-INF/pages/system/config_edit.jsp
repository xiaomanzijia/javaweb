<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="system/configEdit.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	  <input type="hidden" name="id" value="${config.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>关键字:</label>
				<input name="configKey" type="text" size="30" value="${config.configKey }" class="required" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>值:</label>
				<input name="configValue" type="text" size="30" value="${config.configValue }" class="required" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>是否多值:</label>
					<select name="multiValue" class="combox">
					    <c:if test="${config.multiValue==0 }">
						<option value="0" selected="selected">否</option>
						<option value="1">是</option>
						</c:if>
						<c:if test="${config.multiValue==1 }">
						<option value="0">否</option>
						<option value="1" selected="selected">是</option>
						</c:if>
					</select>
			</div>
			<div class="unit">
				<label>正则验证:</label>
				<input name="regular" type="text" size="30" value="${config.regular }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>提示语:</label>
				<input name="prompt" type="text" size="30" value="${config.prompt }" remote="act_Master_validateName.html" />
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

