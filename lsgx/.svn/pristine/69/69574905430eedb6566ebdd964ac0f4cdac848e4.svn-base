<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="../common/common.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" method="post" action="/loveStory/loveStoryList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="title" value="${nVo.title}" />
		<input type="hidden" name="abstracts" value="${nVo.abstracts}" />
		<input type="hidden" name="keywords" value="${nVo.keywords}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="/loveStory/loveStoryList.do" onsubmit="return navTabSearch(this)">
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
			<priveliege:enable buttonCode="loveStoryAdd">
				<li><a class="add" href="/loveStory/loveStorySend.do" target="dialog" rel="loveStoryAdd" title="爱心故事发布" mask=true width="680" height="480"><span>爱心故事发布</span></a></li>
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
				<th>资源</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${news}" var="news">
				<tr target="list_item_id" rel="${news.id }">
					<td style="width:100px" title="${news.title }">${news.titleShort }</td>
					<td style="width:100px" title="${news.abstracts }">${news.abstractsShort }</td>
					<td style="width:100px" title="${news.keywords }" >${news.keywordsShort }</td>
					<td style="width:300px">
						<a
							href="/news/showContent.do?id=${news.id}" target="dialog" width="650" height="480" style="color:blue;"
							rel="show_detail_content" title="显示详细内容"  resizable="true" mask="true"
							maxable="false" drawable="true">点击查看详细内容</a>
					</td>
					<td style="width:150px"><fmt:formatDate value="${news.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td style="width:100px">${news.news_column }</td>
					<td style="width:100px">
					<c:if test="${news.source==0 }">pc</c:if>  
					<c:if test="${news.source==1 }">3G</c:if> 
					<c:if test="${news.source==2 }">android</c:if> 
					</td>
					<td style="width:100px">
					<priveliege:enable buttonCode="loveStoryEdit">
				    <a class="btnEdit" href="/loveStory/loveStoryEdit.do?id=${news.id}" target="dialog" rel="loveStoryEdit" title="修改"mask="true" maxable="false" resizable="false" drawable="true"  width="680" height="480"><span>修改</span></a>
					</priveliege:enable>
					<priveliege:enable buttonCode="loveStoryDelete">
					<a class="btnDel" href="/loveStory/loveStoryDelete.do?id=${news.id}" target="ajaxTodo" rel="loveStoryDelete" title="删除"><span>删除</span></a></li>
					</priveliege:enable>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
