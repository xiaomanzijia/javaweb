<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="js/location.js"></script>
<script type="text/javascript" src="js/YlChinaArea.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<div class="pageContent">
	<form method="post" action="/loveStory/studyHelpSend.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">	
		<div class="pageFormContent nowrap" layoutH="57">
			<div class="unit">
				<label style="width:50px">标题</label>
				<input class="required" value="" style="width:355px" id="title" name="title"  type="text" maxlength="26"><a>不超过26个字</a>
			</div>
			<div class="unit">
				<label style="width:50px">摘要</label>
				<input class="textInput" value="" style="width:150px" id="abstracts" name="abstracts"  type="text">
				<label style="width:40px">关键字</label>
                <input class="textInput" value="" style="width:150px" id="keywords" name="keywords"  type="text">		
			</div>
            <div class="unit">
			    <label style="width:50px">一级栏目</label>
                <input class="textInput" value="${main_column }" readonly="readonly" style="width:150px" id="news_column" name="news_column"  type="text">
                <label style="width:50px">二级栏目</label>
                <input class="textInput" value="${sub_column }" readonly="readonly" style="width:140px" id="sub_column" name="sub_column"  type="text">		
            </div>
            <div class="unit">
				<label style="width:50px">来源</label>
				<select id="source" name="source"  style="width:80px" >
				<option value="" >请选择...</option>
				<option value="0" >pc</option>
				<option value="1" >3G</option>
				<option value="2" >android</option>
				</select>
				<label style="width:50px">是否置顶</label>
				<select id="top" name="top"  style="width:80px" >
				<option value="0" selected="selected">不置顶</option>
				<option value="1" >置顶</option>
				</select>
				<label style="width:60px">是否为草稿</label>
				<select id="type" name="type"  style="width:70px" >
				<option value="0" >是</option>
				<option value="1" selected="selected">否</option>
				</select>
                </div>
			<div class="unit">
				<label style="width:30px">内容</label>
                <textarea name="content"  value="" class="editor required" rows="12" cols="100"></textarea>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">发布</button>
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
