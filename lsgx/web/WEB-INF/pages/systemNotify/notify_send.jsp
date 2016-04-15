<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<div class="pageContent">
	<form method="post" action="user/notifySend.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">	
		<div class="pageFormContent nowrap" layoutH="57">
				<div class="unit">
					<label>用户:</label>
					<textarea name="userIds"  value="${userIds}" class="required" rows="3" cols="50"></textarea>
					<span class="inputInfo" ><a class="btnLook" mask="true" resizable="false" maxable="false" target="dialog" 
						title="查找带回用户ID" height="500" width="800" lookupgroup=""  href="user/bringBacklist.do"></a></span>
				</div>
				<div class="unit">
					<label>发件类型：</label>
					<select id="sender" name="sender"  style="width: 120px" >
						<option value="系统消息" >系统消息</option>
						<option value="客服消息" >客服消息</option>
					</select>
				</div>
				<div class="unit">
					<label>主题:</label>
                    <input class="textInput" value="" style="width:114px" id="subject" name="subject"  type="text">	
                </div>
				<div class="unit">
					<label>内容:</label>
					<textarea name="content"  value="" class="required" rows="10" cols="50"></textarea>
				</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">发送</button>
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

