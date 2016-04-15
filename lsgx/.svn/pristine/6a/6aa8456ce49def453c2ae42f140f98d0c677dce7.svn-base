<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="customerService/customerDispose.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	  <input type="hidden" name="id" value="${cInfo.id }" />
	  <input type="hidden" name="isShow" value="${cInfo.isShow }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>项目id:</label>
				<input name="userId" type="text" size="30" value="" class="required" remote="act_Master_validateName.html" />
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">提交</button>
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

