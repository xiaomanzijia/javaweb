<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<div class="pageContent">
	<form method="post" action="/category/saveCategory.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
				<div class="unit">
					<label>排序值:</label>
					<input name="sort" type="text" size="50" maxlength="70" value="" />
				</div>
				<div class="unit">
					<label>类目名称:</label>
					<input name="typeName" type="text" size="50" maxlength="40" class="required"  value=""/>
				</div>
				<div class="unit">
					<label>类目英文名称:</label>
					<input name="typeName_e" type="text" size="50" maxlength="40" class="required"  value=""/>
				</div>
				<div class="unit">
					<label>所需材料:</label>
					<input name="configIds" type="text" class="required" size="50" value="${configIds }"/>
					<span class="inputInfo" ><a class="btnLook" mask="true" resizable="false" maxable="false" target="dialog" 
						title="" height="500" width="800" lookupgroup=""  href="category/bringBacklist.do?configIds=${configIds }"></a></span>
				</div>
				<div class="unit">
					<label>模板:</label>
					<textarea name="model"  value="" class="required" rows="16" cols="52"></textarea>
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
