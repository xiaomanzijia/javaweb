<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="paymoneyrecord/payMoney.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	  <input type="hidden" name="id" value="${payMoneyRecord.id }" />
	  <input type="hidden" name="state" value="${payMoneyRecord.state }" />
	  <input type="hidden" name="userId" value="${payMoneyRecord.userId }" />
	  <input type="hidden" name="capitalinoutId" value="${payMoneyRecord.capitalinoutId }" />
	   <input type="hidden" name="projectId" value="${payMoneyRecord.projectId }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>请输入打款金额:</label>
				<input name="panMoney" type="text" size="30" value="" class="required" remote="act_Master_validateName.html" />
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

