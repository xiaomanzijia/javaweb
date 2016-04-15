<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css" href="../../css/manageimg1.css">
<div>
	<div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
        	<tr>
	        	<td width="75" height="30" valign="top">
	        		<a class="button" href="project/uploadImg.do?id=${project.id}"
	 				rel="project_upload_img" target="dialog" title="图片上传" width="500" height="500" mask="true" maxable="false">
	 				<span>图片上传</span></a>
	 			</td>
	 			<td align="left" valign="center">
	 				<span> 注：图片大小每张请控制在2M以内，最多可上传10张图片</span>
	 			</td>
        	</tr>
    	</table>
	</div>
	<div class="pageContent" style="height:500px; width:100%; float: center; overflow: auto;">
		<ul class="goodsarea">
  			<c:forEach var="item" items="${imgList}" varStatus="status">
				<li>
		        	<div class="goodsimage">
						<%-- <a
							href="bfile/showDetail.do?id=${item.id}"
							target="dialog" width="820" height="680" style="color:blue;"
							rel="show_img" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true"> --%>
						<a
							href="${item.url}"
							target="_bank">
		        		<c:if test="${project.coverImageId==item.id}"><img class="logo" src="images/logo_flag.png"/></c:if>
		        		<div class="prev">
		        			
							<img src="${item.url}" />
						</div>
						</a>
						<div>	
							<!-- 删除图片 -->
							<input type="button" onclick="delImgAjax(this)" class="rb" style="float: left;" value="删除" target="ajaxtodo"
							href="project/delImgAjax.do?id=${project.id}&imgId=${item.id}">
							<!-- 控制前天显示或隐藏 0：显示 1：隐藏 -->
							<c:if test="${item.isHide==0 }">
							<input type="button" onclick="imgHideOrShow(this)" class="rb" style="float:center;" value="隐藏"
							href="project/hideOrShowImg.do?imgId=${item.id }&isHide=1" >
							</c:if>
							<c:if test="${item.isHide==1 }">
							<input type="button" onclick="imgHideOrShow(this)" class="rb" style="float:center;" value="显示"
							href="project/hideOrShowImg.do?imgId=${item.id }&isHide=0" >
							</c:if>
							<!-- 设置图片为logo -->
							<c:if test="${project.coverImageId!=item.id}">
								<input type="button" onclick="setLogoAjax(this)" class="rb" style="float: right;" value="设为logo" 
								href="project/setLogoAjax.do?id=${project.id}&imgId=${item.id}">
							</c:if>
							<!-- 查看图片的说明信息  -->
							<label class="rb" style="height:">
						 	<a style="text-decoration:none" target="dialog" width="500" height="300" style="color:blue;"
						 	title="说明"  resizable="true" mask="true" maxable="false" drawable="true"
						 	href="project/imgDetail.do?imgId=${item.id}"><font color="#FFFFFF" size="6">说明</font></a>
						 	</label>
						</div>
      				</div>
        		</li>
        		<c:if test="${status.count%5==0}"><br/></c:if>
    		</c:forEach>
		</ul>
	</div>
	<div> <img id="pt" style="display:none"/></div>
	<div class="formBar">
		<ul>
			<li>
				<div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div>
			</li>
		</ul>
	</div>
</div>
<script type="text/javascript">

function delImgAjax(obj){
	var $obj=$(obj);
	$.ajax({
		type:"post",
		url:$obj.attr('href'),
		dataType:"json",
		async:true,
		data:{
		},
		success:function(json){
			DWZ.ajaxDone(json);
			if(json.statusCode == '200'){
				$obj.closest('table').find('img').attr('src','${ctx }/common/images/no-pic.jpg');
				$obj.remove();
				refreshImgManage();
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
		}
		
	});
}

function imgHideOrShow(obj){
	var $obj=$(obj);
	$.ajax({
		type:"post",
		url:$obj.attr('href'),
		dataType:"json",
		async:true,
		data:{
		},
		success:function(json){
			DWZ.ajaxDone(json);
			if(json.statusCode == '200'){
				$obj.remove();
				refreshImgManage();
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
		}
		
	});
}

function setLogoAjax(obj){
	var $obj=$(obj);
	$.ajax({
		type:"post",
		url:$obj.attr('href'),
		dataType:"json",
		async:true,
		data:{
		},
		success:function(json){
			DWZ.ajaxDone(json);
			if(json.statusCode == '200'){
				$obj.remove();
				refreshImgManage();
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
		}
		
	});
}
function refreshImgManage(){
	$.pdialog.reload('project/manageImg.do?id=${project.id}',{dialogId:'manage_img'});
}
</script>	
