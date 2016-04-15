<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="/link/friendlylinkEdit.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input type="hidden" name=id value="${link.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label style="width:50px">网站标题</label>
				<input name="webtitle" type="text" size="25" value="${link.webtitle }" maxlength="30" remote="act_Master_validateName.html" />
				<label style="width:40px">网站链接</label>
				<input name="linkurl" type="text" size="25" value="${link.linkurl }" maxlength="30" remote="act_Master_validateName.html" />
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