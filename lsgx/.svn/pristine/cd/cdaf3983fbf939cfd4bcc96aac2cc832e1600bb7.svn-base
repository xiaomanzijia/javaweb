<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="/helpStudy/buildSchoolList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="title" value="${nVo.title}" />
		<input type="hidden" name="abstracts" value="${nVo.abstracts}" />
		<input type="hidden" name="keywords" value="${nVo.keywords}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="/helpStudy/buildSchoolList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">标题：</label>
						<input class="textInput" value="${nVo.title }" style="width:114px" id="title" name="title" type="text">
					</td>
					<td>
						<label for="name" style="width:80px;">发布时间：</label>
					    <input id="startDate"  type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   name="startDate"
		                   value="<fmt:formatDate value="${nVo.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19"/>
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input id="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                    name="endDate"
		                   value="<fmt:formatDate value="${nVo.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19"/>
					</td>
					<td style="float:right;">&nbsp;</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">摘要：</label>
						<input class="textInput" value="${nVo.abstracts }" style="width:114px" id="abstracts"  name="abstracts" type="text">
					</td>
					<td>
						<label for="name" style="width:50px">关键字：</label>
						<input class="textInput" value="${nVo.keywords }" style="width:114px" id="keywords" name="keywords"  type="text">
					</td> 
					<td style="float:right;">
						<div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div>
						<div class="buttonActive"><div class="buttonContent"><button type="reset" >重置</button></div></div>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<!-- 权限 -->
			<priveliege:enable buttonCode="studyHelpAdd">
				<li><a class="add" href="/helpStudy/buildSchoolSend.do" target="dialog" rel="studyHelpAdd" title="建学校信息发布" mask=true width="680" height="480"><span>建学校信息发布</span></a></li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th>标题</th>
				<th>摘要</th>
				<th>关键字</th>
				<th>内容</th>
				<th>发布时间</th>
				<th>一级栏目</th>
				<th>二级栏目</th>
				<th>三级栏目</th>
				<th>资源</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${news}" var="news">
				<tr target="list_item_id" rel="${news.id }">
					<td style="width:100px">${news.title }</td>
					<td style="width:100px">${news.abstracts }</td>
					<td style="width:100px">${news.keywords }</td>
					<td >${news.content }</td>
					<td style="width:150px"><fmt:formatDate value="${news.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td style="width:100px">${news.news_column }</td>
					<td style="width:100px">${news.sub_column }</td>
					<td style="width:100px">${news.third_column }</td>
					<td >
					<c:if test="${news.source==0 }">pc</c:if>  
					<c:if test="${news.source==1 }">3G</c:if> 
					<c:if test="${news.source==2 }">android</c:if> 
					</td>
					<td style="width:100px">
					<priveliege:enable buttonCode="studyHelpEdit">
				    <a class="btnEdit" href="/helpStudy/buildSchoolEdit.do?id=${news.id}" target="dialog" rel="studyHelpEdit" title="修改"mask="true" maxable="false" resizable="false" drawable="true"  width="680" height="480"><span>修改</span></a>
					</priveliege:enable>
					<priveliege:enable buttonCode="studyHelpDelete">
					<a class="btnDel" href="/helpStudy/buildSchoolDelete.do?id=${news.id}" target="ajaxTodo" rel="studyHelpDelete" title="删除"><span>删除</span></a></li>
					</priveliege:enable>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
