<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="/usercard/saveUserCardEdit.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	  <input type="hidden" name="id" value="${userCard.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>银行名:</label>
				<input name="bankName" type="text" size="25" value="${userCard.bankName }" class="required" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>卡号:</label>
				<input name="card" type="text" size="25" value="${userCard.card }" class="required" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>银行卡类型:</label>
					<select name="bankType" class="combox" style="width:300px;">
						<option value="2" <c:if test="${userCard.bankType==2 }">selected="selected"</c:if>>借记卡</option>
						<option value="3" <c:if test="${userCard.bankType==3 }">selected="selected"</c:if>>信用卡</option>
					</select>
			</div>
			<div class="unit">
				<label>使用状态:</label>
				<select name="useState" class="combox" style="width:300px;">
						<option value="100" <c:if test="${userCard.useState==100 }">selected="selected"</c:if>>启用</option>
						<option value="101" <c:if test="${userCard.useState==101 }">selected="selected"</c:if>>停用</option>
						<option value="101" <c:if test="${userCard.useState==102 }">selected="selected"</c:if>>暂停</option>
					</select>
			</div>
			<div class="unit">
				<label>账户类型:</label>
				<select name="accountType" class="combox" style="width:300px;">
						<option value="0" <c:if test="${userCard.accountType==0 }">selected="selected"</c:if>>对公</option>
						<option value="1" <c:if test="${userCard.accountType==1 }">selected="selected"</c:if>>对私</option>
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

