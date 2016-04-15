<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="project/checkProject.do" class="pageForm required-validate" 
		rel="project_list" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		 <input type="hidden" id="project.id" name="id" value="${project.id }" /> 
		<%--<input type="hidden" id="userId" name="userId" value="${project.userId }" />--%>
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label>审核结果:</label>
				<!-- 原版代码 -->
				<%-- <select name="state" id="project.state" >
					<option value="230" selected="selected">审核未通过</option>
					<c:if test="${project.state == 210 && roleId==1}">
						<option value="220">待复审</option>
					</c:if>
					<c:if test="${project.state == 220}">
						<option value="240">募捐中</option>
					</c:if>
				</select> --%>
				
				<!-- 更新代码 -->
				<select name="state" id="project.state">
					<option value="230" selected="selected">审核未通过</option>
					<option value="220">审核通过待发布</option>
				</select>
			</div>
			<div class="unit">
				<label>审核内容:</label>
				<textarea rows="9" cols="60" name=description></textarea>
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
