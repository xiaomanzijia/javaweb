<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/viewimg1.css">

<div class="pageContent">
	<div class="tabs" currentIndex="0" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>基本信息</span></a></li>
					<li><a href="javascript:;"><span>图片信息</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div style="width:100%;height:420px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="100">省:</td>
							<td>${loveGroupFile.province}</td>
						</tr>
						<tr >
							<td>市:</td>
							<td>${loveGroupFile.city}</td>
						</tr>
						<tr >
							<td>地区:</td>
							<td>${loveGroupFile.area}</td>
						</tr>
						<tr >
							<td>领域:</td>
							<td>${loveGroupFile.fieldExpert}</td>
						</tr>
						<tr >
							<td>详情:</td>
							<td>${loveGroupFile.description}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="width:100%;height:520px;float: center; overflow: auto;">
				<ul class="goodsarea">
		  			<c:forEach var="item" items="${imgList}" varStatus="status">
						<li>
						<%-- <a
							href="bfile/showDetail.do?id=${item.id}"
							target="dialog" width="820" height="680" style="color:blue;"
							rel="show_img" title="文件图片"  resizable="true" mask="true"
							maxable="false" drawable="true"> --%>
						<a
							href="${item.url}"
							target="_bank">
				        	<div class="goodsimage">
				        		<div class="prev">
									<img src="${item.url}" />
								</div>
		      				</div>
		      			</a>
		        		</li>
		        		<c:if test="${status.count%3==0}"><br/></c:if>
		    		</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
