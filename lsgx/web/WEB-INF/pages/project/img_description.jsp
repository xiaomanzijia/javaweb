<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<div class="pageContent">
	<form method="post" action="/project/editImgDescription.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">	
		<div class="pageFormContent nowrap" layoutH="57">
		<input type="hidden" name="id" value="${bFile.id }">
				<div class="unit">
					<label>图片说明:</label>
					<textarea id="description" name="description"  value="" rows="10" cols="75" disabled="disabled">${bFile.description }</textarea>
				</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="buttonid" onclick="editTextarea()">修改</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="submit" >保存</button>
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
function editTextarea(){
	document.getElementById("description").disabled=false;
	document.getElementById("description").focus();
}
</script>
