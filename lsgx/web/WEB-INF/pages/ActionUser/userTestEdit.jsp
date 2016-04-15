<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="action/userTestEdit.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
<input type="hidden" name="id" value="${userTest.id }" />
<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>账号名:</label>
				<input name="username" type="text" size="30" value="${userTest.username }" class="required" />
			</div>
			<div class="unit">
				<label>地址:</label>
				<input name="address" type="text" size="30" value="${userTest.address }" class="required" />
			</div>
			<div class="unit">
				<label>生日:</label>
				<input name="birthday" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
					   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
					   id="startDate"
					   value="<fmt:formatDate value="${userTest.birthday }" pattern="yyyy-MM-dd"/>" pattern="yyyy-MM-dd"/>
			</div>
			<div class="unit">
				<label>性别:</label>
					<select name="sex" id="actionUser.sex" >
						<option value="1" <c:if test="${userTest.sex=='1'}">selected="selected"</c:if>>男</option>
						<option value="2" <c:if test="${userTest.sex=='2'}">selected="selected"</c:if>>女</option>
					</select>
			</div>
	<div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
			<tr>
				<td width="75" height="30" valign="top">
					<a class="button" href="action/usertestUploadImg.do?id=${userTest.id}"
					   rel="usertest_upload_img" target="dialog" title="图片上传" width="500" height="500" mask="true" maxable="false">
						<span>图片上传</span></a>
				</td>

				<td align="left" valign="center">
					<span>注：图片大小每张请控制在2M以内，最多可上传10张图片</span>
				</td>
			</tr>
			<tr>
				<c:if test="${fileVO!=null}">
					<td width="75" height="30" valign="top" colspan="2">
						<img src="${fileVO.img_path}">
					</td>
				</c:if>

			</tr>

		</table>
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
