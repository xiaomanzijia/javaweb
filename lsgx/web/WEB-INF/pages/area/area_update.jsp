<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="area/update.do" class="pageForm required-validate" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	      
		<input type="hidden" id="area.id" name="id" value="${area.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>地区名:</label>
				<input name="areaName" type="text" size="30" value="${area.areaName}" class="required"  />
			</div>
			<div class="unit">
				<label>地区编码:</label>
				<input id="areaCode" name="areaCode" size="31" class="required" type="text" value="${area.areaCode}" class="required " />
			</div>
			<div class="unit">
				<label>父地区编码:</label>
				<input type="text"  name="upperCode" size="30" class="required" value="${area.upperCode }"/>
			</div>
			<div class="unit">
				<label>状态:</label>
				<select name="state" id="state" class="required">
					<option value="100" <c:if test="${area.state=='100'}">selected="selected"</c:if>>启用</option>
					<option value="101" <c:if test="${area.state=='101'}">selected="selected"</c:if>>停用</option>
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
