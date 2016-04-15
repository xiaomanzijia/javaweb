<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#projectName").val("");
	$("#ip").val("");
	//$("#operateType option:first").attr("selected","selected"); 
	$("#startDate").val("");
	$("#endDate").val("");
}

function onlyNumber(){
  	var keyCode = event.keyCode;
  	if(keyCode >=48 && keyCode <=57){
  		event.returnValue = true;
  	}else{
  		event.returnValue = false;
  	}
  }
</script>

<div class="pageHeader">
	<form id="pagerForm" method="post" action="project/projectList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="field" value="${project.field}" />
		<input type="hidden" name="information" value="${project.information}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="title" value="${project.title}" />
		<input type="hidden" name="type" value="${project.type}" />
		<input type="hidden" name="state" value="${project.state}" />
		
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="project/projectList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td>
						<label for="name" style="width:50px">领域：</label>
						<select id="field" name="field"  style="width: 120px" >
							<option value=""  >全部</option>
							<!-- 新版是根据category类目来取值 -->
							<c:forEach var="category" items="${categorys }">
							<option value="${category.typeName_e }" <c:if test="${project.field == category.typeName_e}">selected="selected"</c:if>>${category.typeName }</option>
							</c:forEach>
							<!-- 原版写死的 -->
							<%-- <option value="disease" <c:if test="${project.field == 'disease'}">selected="selected"</c:if>>疾病</option>
							<option value="education" <c:if test="${project.field == 'education'}">selected="selected"</c:if>>助学</option>
							<option value="disasterRelief" <c:if test="${project.field == 'disasterRelief'}">selected="selected"</c:if>>救灾</option>
							<option value="povertyAlleviation" <c:if test="${project.field == 'povertyAlleviation'}">selected="selected"</c:if>>扶贫</option>
							<option value="environmentalProtection" <c:if test="${project.field == 'environmentalProtection'}">selected="selected"</c:if>>环保</option>
							<option value="animalProtection" <c:if test="${project.field == 'animalProtection'}">selected="selected"</c:if>>动物保护</option>
							<option value="agricultureRuralAreas" <c:if test="${project.field == 'agricultureRuralAreas'}">selected="selected"</c:if>>农业农村</option>
							<option value="worker" <c:if test="${project.field == 'worker'}">selected="selected"</c:if>>劳工</option>
							<option value="elderly" <c:if test="${project.field == 'elderly'}">selected="selected"</c:if>>老人</option>
							<option value="religiousBelief" <c:if test="${project.field == 'religiousBelief'}">selected="selected"</c:if>>宗教信仰</option>
							<option value="artFile" <c:if test="${project.field == 'artFile'}">selected="selected"</c:if>>文件艺术</option>
							<option value="disabled" <c:if test="${project.field == 'disabled'}">selected="selected"</c:if>>残障</option> --%>
							<option value="garden" <c:if test="${project.field == 'garden'}">selected="selected"</c:if>>善园</option>
						</select>
					</td>
					<%-- <td>
						<label for="name" style="width:80px">求救人信息：</label>
						<input class="textInput" value="${project.information }" style="width:114px" id="title" name="information"  type="text">
					</td> --%>
					<td>
						<label for="name" style="width:80px">标题：</label>
						<input class="textInput" value="${project.title }" style="width:114px" id="title" name="title"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">项目类型：</label>
						<select id="type" name="type"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="enterpriseProject"  <c:if test="${project.type == 'enterpriseProject'}">selected="selected"</c:if> >企业捐项目</option>
							<option value="personalItems"  <c:if test="${project.type == 'personalItems'}">selected="selected"</c:if> >个人捐项目</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:50px">ID：</label>
						<input class="textInput" value="${project.id }" style="width:114px" id="id" name="id"  type="text" onkeypress="onlyNumber()">
					</td>
				</tr> 
				<tr>
					<td>
						<label for="name" style="width:50px">状态：</label>
						<select id="state" name="state"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="200"  <c:if test="${project.state==200}">selected="selected"</c:if>>保存</option>
							<option value="210"  <c:if test="${project.state==210}">selected="selected"</c:if>>审核中</option>
							<option value="220"  <c:if test="${project.state==220}">selected="selected"</c:if>>待发布</option>
							<option value="230"  <c:if test="${project.state==230}">selected="selected"</c:if>>审核未通过</option>
							<option value="240"  <c:if test="${project.state==240}">selected="selected"</c:if>>募捐中</option>
							<option value="260"  <c:if test="${project.state==260}">selected="selected"</c:if>>结束</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:80px;">注册时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>&nbsp;</td>
					<td >
						<div class="subBar">
							<ul>
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
								<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="resetSysLogQuery()">重置</button></div></div></li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<priveliege:enable buttonCode="projectAdd">
			<li><a class="add" href="project/initSave.do" target="dialog" rel="projectAdd" title="添加项目" mask=true width="600" height="620"><span>添加项目</span></a></li>
			</priveliege:enable>
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="30">ID</th>
				<th width="180">标题</th>
				<th width="40">领域</th>
				<th width="80">项目类型</th>
				<th width="80">求救金额</th>
				<th width="60">已募捐金额</th>
				<th width="60">状态</th>
				<th width="50">是否隐藏</th>
				<th width="140">注册时间</th>
				<th width="210">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="project"  varStatus="status">
				<tr target="list_item_id" rel="${project.id }">
					<td>${status.count}</td>
					<td>${project.id }</td>
					<td ><a
							href="project/showDetail.do?id=${project.id}"
							target="dialog" width="680" height="600" style="color:blue;"
							rel="show_project" title="项目详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${project.title }
							<c:if test="${project.title == ''}">点击查看详情</c:if>
						</a>
					</td>
					<td >
							<!-- 新版是根据category类目来取值 -->
							<c:forEach var="category" items="${categorys }">
							<c:if test="${project.field == category.typeName_e}">${category.typeName }</c:if>
							</c:forEach>
							<!-- 原版写死的 -->
							<%-- <c:if test="${project.field == 'disease'}">疾病</c:if>
							<c:if test="${project.field == 'education'}">助学</c:if>
							<c:if test="${project.field == 'disasterRelief'}">救灾</c:if>
							<c:if test="${project.field == 'povertyAlleviation'}">扶贫</c:if>
							<c:if test="${project.field == 'environmentalProtection'}">环保</c:if>
							<c:if test="${project.field == 'animalProtection'}">动物保护</c:if>
							<c:if test="${project.field == 'agricultureRuralAreas'}">农业农村</c:if>
							<c:if test="${project.field == 'worker'}">劳工</c:if>
							<c:if test="${project.field == 'elderly'}">老人</c:if>
							<c:if test="${project.field == 'religiousBelief'}">宗教信仰</c:if>
							<c:if test="${project.field == 'artFile'}">文件艺术</c:if>
							<c:if test="${project.field == 'disabled'}">残障</c:if>--%>
							<c:if test="${project.field == 'garden'}">善园</c:if> 
					</td>
					<td >
						<c:if test="${project.type == 'enterpriseProject'}">企业捐项目</c:if>
						<c:if test="${project.type == 'personalItems'}">个人捐项目</c:if>
					</td>
					<td >${project.cryMoney }</td>
					<td >${project.donatAmount }</td>
					<td >
						<c:if test="${project.state == 200}">保存</c:if>
						<c:if test="${project.state == 210}">审核中</c:if>
						<c:if test="${project.state == 220}">待发布</c:if>
						<c:if test="${project.state == 230}">审核未通过</c:if>
						<c:if test="${project.state == 240}">募捐中</c:if>
						<c:if test="${project.state == 260}">结束</c:if>
					</td>
					<td >
						<c:if test="${project.isHide == 0}">已显示</c:if>
						<c:if test="${project.isHide == 1}">已隐藏</c:if>
					</td>
					<td ><fmt:formatDate value="${project.registrTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					
					<td >
						<priveliege:enable buttonCode="project_edit">
						<a class="btnEdit" 
							href="project/initEdit.do?id=${project.id}"
							 target="dialog" rel="projectAdd" title="修改项目" mask=true width="600" height="620">修改项目
						</a>
						</priveliege:enable>
						<priveliege:enable buttonCode="lovegroupment_list">
							<a class="btnAssign" 
								href="lovegroupment/loveGroupMentList.do?projectId=${project.id}&userType=1"
								width="700" height="420" target="dialog" rel="lovegroupment_list" title="查看善管家成员" mask="true" maxable="false">查看善管家成员
							</a>
							<a class="btnAssign" 
								href="lovegroupment/loveGroupMentList.do?projectId=${project.id}&userType=2"
								width="700" height="420" target="dialog" rel="lovegroupment_list" title="查看项目客服" mask="true" maxable="false">查看项目客服
							</a>
						</priveliege:enable>
						<priveliege:enable buttonCode="report_list">
							<a class="btnLook" 
								href="report/reportList.do?projectId=${project.id}"
								width="780" height="420" target="dialog" rel="report_list" title="查看报告" mask="true" maxable="false">查看报告
							</a>
						</priveliege:enable>
						<a class="btnView" 
							href="projectSchedule/projectScheduleList.do?projectId=${project.id}"
							width="660" height="420" target="dialog" rel="projectSchedule_list" title="项目进度" mask="true" maxable="false">项目进度</a>
						
						<priveliege:enable buttonCode="manage_img">
						<a class="btnPicmage" href="project/manageImg.do?id=${project.id}"
							rel="manage_img" target="dialog" title="管理工程 [${project.title }] 的图片" height="600" width="1080" 
							maxable="true" resizable="true" mask="true">图片管理 </a>
						</priveliege:enable>
						
						<c:if test="${project.state == 210}">
							<priveliege:enable buttonCode="initCheckProject">
							<a class="btnSelect" href="project/initCheckProject.do?id=${project.id}" target="dialog" height="360" width="420" rel="initCheckProject" title="项目审核">项目审核</a>
							</priveliege:enable>
						</c:if>
						
						<c:if test="${project.state == 220}">
							<priveliege:enable buttonCode="projectSender">
								<a class="btnPub" href="project/projectSender.do?id=${project.id}" target="ajaxTodo" rel="projectSender" title="项目发布">项目发布</a>
							</priveliege:enable>
						</c:if>
						<c:if test="${project.state == 260}">
							<priveliege:enable buttonCode="openProject">
							<a class="btnPub" 
								href="project/openProject.do?id=${project.id}&state=240"  fresh="true" 
								target="ajaxTodo"  title="重启项目" mask="true">重启项目
							</a>
							</priveliege:enable>
						</c:if>
						<a class="btnInfo" href="projectfeedback/projectFeedBackList.do?projectId=${project.id}" width="860" height="520" rel="projectfeedback_list"
							target="dialog"  title="【${project.title }】的项目反馈">项目反馈</a>
						<c:if test="${project.isHide == 0 }">
						<a class="btnView" href="project/projectHide.do?id=${project.id }" target="ajaxTodo" rel="projectSender" title="隐藏项目">隐藏项目</a>
						</c:if>
						<c:if test="${project.isHide == 1 }">
						<a class="btnView" href="project/projectHide.do?id=${project.id }" target="ajaxTodo" rel="projectSender" title="显示项目">显示项目</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	