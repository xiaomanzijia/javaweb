<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<form method="post" action="/helpStudy/editbuildSchool.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	  <input type="hidden" name=id value="${newsVO.id }" />
		<div class="pageFormContent" layoutH="57">
			<div class="unit">
				<label style="width:50px">标题</label>
				<input name="title" type="text" size="64" value="${newsVO.title}" maxlength="30" class="required" remote="act_Master_validateName.html" />不超过30个字
			</div>
			<div class="unit">
				<label style="width:50px">摘要</label>
				<input name="abstracts" type="text" size="25" value="${newsVO.abstracts }" maxlength="30" remote="act_Master_validateName.html" />
				<label style="width:40px">关键字</label>
				<input name="keywords" type="text" size="25" value="${newsVO.keywords }" maxlength="30" remote="act_Master_validateName.html" />
			</div>
            <div class="unit">
				<label style="width:50px">来源</label>
				<select id="source" name="source"  style="width: 120px" >
				<option value="0" <c:if test="${newsVO.source==0 }">selected="selected"</c:if>>pc</option>
				<option value="1" <c:if test="${newsVO.source==1 }">selected="selected"</c:if>>3G</option>
				<option value="2" <c:if test="${newsVO.source==2 }">selected="selected"</c:if>>android</option>
				</select>
				<label style="width:50px">是否置顶</label>
				<select id="top" name="top"  style="width:80px" >
				<option value="0" <c:if test="${newsVO.top==0 }">selected="selected"</c:if>>不置顶</option>
				<option value="1" <c:if test="${newsVO.top==1 }">selected="selected"</c:if>>置顶</option>
				</select>
				<label style="width:60px">是否为草稿</label>
				<select id="type" name="type"  style="width:75px" >
				<option value="0" <c:if test="${newsVO.type==0 }">selected="selected"</c:if>>是</option>
				<option value="1" <c:if test="${newsVO.type==1 }">selected="selected"</c:if>>否</option>
				</select>
            </div>
			<div class="unit">
				<label>内容</label>
                <textarea id="content" name="content" class="editor required" rows="12" cols="100">${newsVO.content }</textarea>
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