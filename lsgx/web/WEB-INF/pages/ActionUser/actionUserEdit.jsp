<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/actionUserEdit.do" class="pageForm required-validate" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	      
		<input type="hidden" id="actionUser.id" name="id" value="${actionUser.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>账号名:</label>
				<input name="userName" type="text" size="30" value="${actionUser.userName}" class="required"  />
			</div>
			<div class="unit">
				<label>真实姓名:</label>
				<input type="text" name="realName" size="30" class="required" value="${actionUser.realName}"/>
			</div>
			<div class="unit">
				<label>手机号:</label>
				<input type="text" name="mobile" size="30" value="${actionUser.mobile }"/>
			</div>
			<div class="unit">
				<label>性别:</label>
				<select name="sex" id="actionUser.sex" class="required">
					<option value="0" <c:if test="${actionUser.sex=='0'}">selected="selected"</c:if>>男</option>
					<option value="1" <c:if test="${actionUser.sex=='1'}">selected="selected"</c:if>>女</option>
				</select>
			</div>
			<div class="unit">
				<!--<label>部门:</label>
				 <select class="combox" name="master.ele_code">
					<option value="">请选择</option>
					<c:forEach items="${elelist}" var="bean" varStatus="s">
						<option value="${bean.ele_code}" >${bean.ele_name}</option>
					</c:forEach>
				</select>
				-->
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
