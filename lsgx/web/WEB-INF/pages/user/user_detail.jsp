<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
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
			<div style="width:100%;height:500px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="150">用户类型:</td>
							<td>
								<c:if test="${user.userType=='individualUsers'}">个人用户</c:if>
								<c:if test="${user.userType=='enterpriseUsers'}">企业用户</c:if>
							</td>
						</tr>
						<tr >
							<td>用户名:</td>
							<td>${user.userName}</td>
						</tr>
						<tr >
							<td>昵称:</td>
							<td>${user.nickName}</td>
						</tr>
						<tr >
							<td>真实姓名:</td>
							<td>${user.realName}</td>
						</tr>
						<tr >
							<td>账户余额:</td>
							<td>${user.balance}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${user.userType =='enterpriseUsers'}"><priveliege:enable buttonCode="balanceIn">
								<a 
									href="user/balanceIn.do?id=${user.id}"
									target="dialog" width="360" height="320" style="color:blue;"
									rel="balanceIn" title="资金存入"  resizable="true" mask="true"
									maxable="false" drawable="true">存入
								</a>
								</priveliege:enable></c:if>
							</td>
						</tr>
						<tr >
							<td>身份证号:</td>
							<td>${user.idCard}</td>
						</tr>
						<tr >
							<td>手机号码:</td>
							<td>${user.mobileNum}</td>
						</tr>
						<tr >
							<td>企业ID:</td>
							<td>
								<a
									href="company/showDetail.do?id=${user.companyId}"
									target="dialog" width="670" height="600" style="color:blue;"
									rel="show_company" title="企业详情"  resizable="true" mask="true"
									maxable="false" drawable="true">${user.companyId }
								</a>
							</td>
						</tr>
						<tr >
							<td>最后一次实名验证时间:</td>
							<td><fmt:formatDate value="${user.lastAutoTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>注册时间:</td>
							<td><fmt:formatDate value="${user.registrTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>用户使用状态:</td>
							<td>
								<c:if test="${user.useState == 100}">正常</c:if>
								<c:if test="${user.useState == 102}">停用</c:if>
								<c:if test="${user.useState == 103}">锁定</c:if>
							</td>
						</div>
						<tr >
							<td>锁定开始时间:</td>
							<td><fmt:formatDate value="${user.lockStartTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>锁定结束时间:</td>
							<td><fmt:formatDate value="${user.lockEndTIme}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						
						<tr >
							<td>最后一次锁定停用原因:</td>
							<td>${user.lockReason}</td>
						</tr>
						<tr >
							<td>错误次数:</td>
							<td>${user.errorNum}</td>
						</tr>
						<tr >
							<td>实名验证状态:</td>
							<td >
								<c:if test="${user.realState == 200}">未填写实名验证信息</c:if>
								<c:if test="${user.realState == 201}">实名验证未审核</c:if>
								<c:if test="${user.realState == 202}">实名验证审核未通过</c:if>
								<c:if test="${user.realState == 203}">实名验证审核通过</c:if>
							</td>
						</tr>
						<tr >
							<td>善管家审核状态:</td>
							<td >
								<c:if test="${user.loveState == 200}">未填写善管家审核信息</c:if>
								<c:if test="${user.loveState == 201}">善管家未审核</c:if>
								<c:if test="${user.loveState == 202}">善管家审核未通过</c:if>
								<c:if test="${user.loveState == 203}">善管家审核通过</c:if>
							</td>
						</tr>
						<tr >
							<td>手机号验证状态:</td>
							<td >
								<c:if test="${user.mobileState == 200}">未填写手机号验证信息</c:if>
								<c:if test="${user.mobileState == 201}">手机号验证未审核</c:if>
								<c:if test="${user.mobileState == 202}">手机号验证未通过</c:if>
								<c:if test="${user.mobileState == 203}">手机号验证通过</c:if>
							</td>
						</tr>
						<tr >
							<td>注册时间:</td>
							<td><fmt:formatDate value="${user.registrTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>最后一次登陆时间:</td>
							<td >
								<fmt:formatDate value="${user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
						</tr>
						<tr >
							<td>捐款总金额:</td>
							<td>${user.totalAmount}</td>
						</tr>
						<tr >
							<td>注册用户类型:</td>
							<td><c:if test="${user.regUsersType == 'donors'}">捐款人</c:if>
								<c:if test="${user.regUsersType == 'helpPeople'}">求助人</c:if>
							</td>
						</tr>
						<tr >
							<td>爱心团成员:</td>
							<td>
								<c:if test="${user.loveGroupMent == 0}">否</c:if>
								<c:if test="${user.loveGroupMent == 1}">是</c:if>
							</td>
						</tr>
						<tr >
							<td>注册来源:</td>
							<td>
								<c:if test="${user.registrSoure == 'PC'}">PC</c:if>
								<c:if test="${user.registrSoure == 'Andrews'}">安卓</c:if>
								<c:if test="${user.registrSoure == 'iPhone'}">苹果</c:if>
								<c:if test="${user.registrSoure == 'H5'}">H5</c:if>
								<c:if test="${user.registrSoure == 'iPad'}">iPad</c:if>
							</td>
						</tr>
						<tr >
							<td>推广人:</td>
							<td>${user.extensionPeople}</td>
						</tr>
						<tr >
							<td>领域专家:</td>
							<td>${user.fieldExpert}</td>
						</tr>
						<tr >
							<td>说明:</td>
							<td>${user.description}</td>
						</tr>
						<tr >
							<td>用户参与的项目数:</td>
							<td>${user.countProject}</td>
						</tr>
						<tr >
							<td>省:</td>
							<td>${user.province}${user.hj_province}</td>
						</tr>
						<tr >
							<td>市:</td>
							<td>${user.city}${user.hj_city}</td>
						</tr>
						<tr >
							<td>地区:</td>
							<td>${user.area}${user.hj_area}</td>
						</tr>
						<tr >
							<td>IP:</td>
							<td>
								<c:if test="${user.registerIP != null && user.registerIP !=''}">${user.registerIP }&nbsp;&nbsp;&nbsp;
								<a
									href="/user/showIPBelongs.do?registerIP=${user.registerIP }"
									target="dialog" width="300" height="200" style="color:blue;"
									rel="show_ip_belongs" title="查看ip归属地"  resizable="true" mask="true"
									maxable="false" drawable="true">查看ip归属地</a></c:if>
							</td>
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
