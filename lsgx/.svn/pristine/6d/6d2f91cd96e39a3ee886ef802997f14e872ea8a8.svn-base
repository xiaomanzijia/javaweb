<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<div class="pageContent">
	
	<form method="post" action="projectSchedule/addProjectSchedule.do" class="pageForm required-validate"  
		rel="" onsubmit="return iframeCallback(this, dialogAjax);">
		<input type="hidden" name="projectId" value="${projectSchedule.projectId}" />	
		<input type="hidden" name="state" value="203" />		
		<div class="pageFormContent" layoutH="57">
				<div class="unit">
					<label>内容:</label>
					<textarea name="description"  value="" class="required" rows="12" cols="60"></textarea>
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
		$.pdialog.reload('projectSchedule/projectScheduleList.do?projectId=${projectSchedule.projectId}',{dialogId:'projectSchedule_list'});
		if ("closeCurrent" == json.callbackType) {
			$.pdialog.close('initAddProjectSchedule');
		}
	}
</script>