<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;

	function u_dialogAjaxDone(json) {
			DWZ.ajaxDone(json);
			if (json.statusCode == DWZ.statusCode.ok) {
				if (json.navTabId) { //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
					$.pdialog
							.reload(
									'lovegroupment/loveGroupMentList.do?projectId=${projectId}',
									{
										dialogId : json.navTabId
									});
				}
				if ("closeCurrent" == json.callbackType) {
					$.pdialog.close('initUpdateLoveGroupMent');
				}
			}
		}
</script>
<div class="pageContent">
	<form method="post" action="lovegroupment/updateLoveGroupMent.do" class="pageForm required-validate" rel="" 
	onsubmit="return iframeCallback(this, u_dialogAjaxDone);" >
		<input type="hidden" id="id" name="id" value="${loveGroupMent.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>用户类别:</label>
				<select name="userType" id="userType" class="required ">
					<option value="0" <c:if test="${loveGroupMent.userType== 0}"> selected="selected"</c:if>>领域专家</option>
					<option value="1" <c:if test="${loveGroupMent.userType== 1}"> selected="selected"</c:if>>成员</option>
					<option value="2" <c:if test="${loveGroupMent.userType== 2}"> selected="selected"</c:if>>客服</option>
				</select>
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
