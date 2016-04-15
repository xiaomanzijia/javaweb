<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<div class="pageContent">
	<form method="" action="" class="pageForm required-validate"
	 rel="" onsubmit="return iframeCallback(this, dialogAjax);">
		<input type="hidden" id="id" name="id" value="${news.id }" />
		<div class="pageFormContent" layoutH="57">
			<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="180">标题:</td>
							<td>${news.title }</td>
						</tr>
						<tr >
							<td>发布时间:</td>
							<td><fmt:formatDate value="${news.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>摘要:</td>
							<td>${news.abstracts }</td>
						</tr>
						<tr >
							<td>关键字:</td>
							<td>${news.keywords }</td>
						</tr>
						<tr >
							<td>内容:</td>
							<td><textarea class="editor readonly" readonly="readonly" rows="15" cols="80">${news.content }</textarea></td>
						</tr>
					</tbody>
				</table>
		</div>
		<div class="formBar">
			<ul>
				<li>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">返回</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>

