<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
function u_dialogAjaxDone(json) {
			DWZ.ajaxDone(json);
			if (json.statusCode == 200) {
				if (json.navTabId) { //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
					$.pdialog
							.reload(
									'employee/employeeList.do?company_userId=${company_userId}',
									{
										dialogId : json.navTabId
									});
				}
				if ("closeCurrent" == json.callbackType) {
					$.pdialog.close('initUpdateEmployee');
				}
			}
		}
</script>
<div class="pageContent">
	<form method="post" action="employee/employeeAudit.do" class="pageForm required-validate" 
	rel="user_audit_list" onsubmit="return iframeCallback(this, u_dialogAjaxDone);">
		<input type="hidden" id="id" name=id value="${id }" />
		<input type="hidden" id="company_userId" name=company_userId value="${company_userId }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>审核结果:</label>
					<select name="state" id="employee.state" >
						<option value="203" selected="selected">通过</option>
						<option value="202">不通过</option>
					</select>
			</div>
			<div class="unit">
				<label>审核内容:</label>
				<textarea rows="9" cols="40" name=reviewContent></textarea>
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
