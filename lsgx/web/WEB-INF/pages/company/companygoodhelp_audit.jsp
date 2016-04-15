<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>

<div class="pageContent">
	<c:choose>
		<c:when test="${dialog == 1}"><form method="post" action="companygoodhelp/auditState.do" class="pageForm required-validate" 
										rel="" onsubmit="return iframeCallback(this, dialogAjax);"></c:when>
		<c:otherwise><form method="post" action="companygoodhelp/auditState.do" class="pageForm required-validate" 
										rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);"></c:otherwise>
	</c:choose>
		<input type="hidden" id="companyGoodHelp.id" name="id" value="${companyGoodHelp.id }" />
		<input type="hidden" id="companyGoodHelp.company_id" name="company_id" value="${companyGoodHelp.company_id}" />
		<input type="hidden" id="companyGoodHelp.userId" name="userId" value="${companyGoodHelp.userId}" />
		<input type="hidden" id="companyGoodHelp.state" name="state" value="202" />
		<input type="hidden" name="dialog" value="${dialog}" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>审核不通过原因:</label>
				<textarea rows="9" cols="80" name="stopReason"></textarea>
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
<script type="text/javascript">
	function dialogAjax(json) {
		DWZ.ajaxDone(json);
		$.pdialog.reload('companygoodhelp/companygoodhelpList.do?company_id=${companyGoodHelp.company_id}&dialog=${companyGoodHelp.dialog}',{dialogId:json.navTabId});
		if ("closeCurrent" == json.callbackType) {
			$.pdialog.close('initAuditGoodHelp');
		}
	}
</script>
