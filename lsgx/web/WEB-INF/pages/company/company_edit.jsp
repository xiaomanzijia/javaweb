<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="/company/editCompany.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	  <input type="hidden" name=id value="${company.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>企业名称:</label>
				<input name="name" type="text" size="30" value="${company.name }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>地址:</label>
				<input name="address" type="text" size="30" value="${company.address }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>负责人:</label>
				<input name="head" type="text" size="30" value="${company.head }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>企业简介:</label>
				<textarea name="introduction"  value="" rows="5" cols="50">${company.introduction }</textarea>
			</div>
			<div class="unit">
				<label>手机:</label>
				<input name="mobile" type="text" size="30" value="${company.mobile }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>企业注册号:</label>
				<input name="registerNo" type="text" size="30" value="${company.registerNo }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>组织机构代码:</label>
				<input name="groupCode" type="text" size="30" value="${company.groupCode }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>法定代表人姓名:</label>
				<input name="legalName" type="text" size="30" value="${company.legalName }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>身份证:</label>
				<input name="identity" type="text" size="30" value="${company.identity }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>公司网址:</label>
				<input name="url" type="text" size="30" value="${company.url }" remote="act_Master_validateName.html" />
			</div>
			<div class="unit">
				<label>企业信息:</label>
				<textarea name="infomation"  value="" rows="5" cols="50">${company.infomation }</textarea>
			</div>
			<div class="unit">
				<label>业务范围:</label>
				<textarea name="serviceField"  value="" rows="5" cols="50">${company.serviceField }</textarea>
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