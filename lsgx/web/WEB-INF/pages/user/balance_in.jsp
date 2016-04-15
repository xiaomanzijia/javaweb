<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="user/saveBalance.do" class="pageForm required-validate"
	 rel="" onsubmit="return iframeCallback(this, dialogAjax);">
		<input type="hidden" id="userId" name="userId" value="${userId }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>存入类型:</label>
				<select name="payType" id="payType" class="required " style="width:82px">
					<option value="alipay">支付宝</option>
					<option value="lianlian" >连连支付</option>
					<option value="freezType" >冻结支付</option >
					<option value="bankpay" >网上银行</option >
					<option value="yinhanghuikuan" >银行汇款</option >
					<option value="back" >系统退款</option >
					<option value="otherpay" >其他存入</option >
				</select>
			</div>
			<div class="unit">
				<label>存入金额:</label>
				<input class="textInput number required"  style="width:76px" id="money" name="money"  type="text">
			</div>
			<div class="unit">
				<label>详细说明:</label>
				<textarea name="payNum" rows="5" cols="20"></textarea>
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
		$.pdialog.reload('user/showDetail.do?id=${userId}',{dialogId:'show_user${userId}'});
		if ("closeCurrent" == json.callbackType) {
			$.pdialog.close('balanceIn');
		}
	}
</script>
