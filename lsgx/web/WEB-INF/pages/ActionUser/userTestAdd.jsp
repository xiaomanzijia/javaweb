<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/userTestAdd.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>账号名:</label>
				<input name="username" type="text" size="30" value="" class="required" />
			</div>
			<div class="unit">
				<label>地址:</label>
				<input name="address" type="text" size="30" value="" class="required" />
			</div>
			<div class="unit">
				<label>生日:</label>
				<input name="birthday" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
					   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
					   id="startDate"
					   value="" pattern="yyyy-MM-dd"/>
			</div>
			<div class="unit">
				<label>性别:</label>
					<select name="sex" id="actionUser.sex" >
						<option value="1" selected="selected">男</option>
						<option value="2">女</option>
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
