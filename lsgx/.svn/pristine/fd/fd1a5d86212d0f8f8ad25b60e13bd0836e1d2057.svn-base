<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="user/loveGroupAudit.do" class="pageForm required-validate"
	 rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input type="hidden" id="auditStaff.id" name="id" value="${id }" />
		<input type="hidden" id="auditStaff.userId" name="userId" value="${userId }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>审核状态:</label>
				<select name="state" id="auditStaffQueryVO.state" class="required ">
					<option value="203" >通过</option>
					<option value="202" >未通过</option>
				</select>
			</div>
			<div class="unit">
				<label>审核内容:</label>
				<textarea name="reviewContent" rows="9" cols="80"></textarea>
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
