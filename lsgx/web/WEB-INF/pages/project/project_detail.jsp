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
					<li><a href="javascript:;"><span>项目图片</span></a></li>
					<li><a href="javascript:;"><span>发起人信息</span></a></li>
					<li><a href="javascript:;"><span>受助人信息</span></a></li>
					<li><a href="javascript:;"><span>证明人信息</span></a></li>
				</ul>
			</div>
		</div>
		<!-- 项目基本信息 -->
		<div class="tabsContent">
			<div style="width:100%;height:520px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="150">领域:</td>
							<td>
								<c:if test="${project.field == 'disease'}">疾病</c:if>
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
								<c:if test="${project.field == 'disabled'}">残障</c:if>
								<c:if test="${project.field == 'garden'}">善园</c:if>
							</td>
						</tr>
						
						<tr >
							<td>标题:</td>
							<td>${project.title}</td>
						</tr>
						<tr >
							<td>子标题:</td>
							<td>${project.subTitle}</td>
						</tr>
						<tr >
							<td>求助原因:</td>
							<td>${project.cryCause}</td>
						</tr>
						<tr >
							<td>求救人信息:</td>
							<td>${project.information}</td>
						</tr>
						<tr >
							<td>项目发起人:</td>
							<td>${user.userName }
								<%-- <a
									href="user/showDetail.do?id=${project.userId}"
									target="dialog" width="680" height="580" style="color:blue;"
									rel="show_project11" title="前端用户详情"  resizable="true" mask="true"
									maxable="false" drawable="true">${project.userId }</a> --%>
							</td>
						</tr>
						<tr>
							<td width="150">你的身份:</td>
							<td>
								<c:if test="${project.identity == 'callerI'}">求助者本人</c:if>
								<c:if test="${project.identity == 'callerFather'}">求助者父亲</c:if>
								<c:if test="${project.identity == 'callerMother'}">求助者母亲</c:if>
								<c:if test="${project.identity == 'otherCaller'}">其它</c:if>
								<c:if test="${project.identity == 'volunteers'}">爱心志愿者</c:if>
							</td>
						</tr>
						<tr >
							<td>内容:</td>
							<td><textarea class="readonly" readonly="readonly" rows="12" cols="80">${project.content}</textarea></td>
						</tr>
						<tr >
							<td>所在地区:</td>
							<td>${project.location}</td>
						</tr>
						<tr >
							<td>详细地址:</td>
							<td>${project.detailAddress}</td>
						</tr>
						<tr >
							<td>求救金额:</td>
							<td>${project.cryMoney}</td>
						</tr>
						<tr >
							<td>总份数:</td>
							<td>${project.totalCopies}</td>
						</tr>
						<tr >
							<td>项目截止时间:</td>
							<td><fmt:formatDate value="${project.deadline}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>开户单位:</td>
							<td>${project.accountName}</td>
						</div>
						<tr >
							<td>银行名:</td>
							<td>${project.accountBank}</td>
						</tr>
						<tr >
							<td>收款号码:</td>
							<td>${project.collectNum}</td>
						</tr>
						
						<tr >
							<td>已募捐金额:</td>
							<td>${project.donatAmount}</td>
						</tr>
						<tr >
							<td>已打款金额:</td>
							<td>${project.panyAmount}</td>
						</tr>
						<tr >
							<td>状态:</td>
							<td >
								<c:if test="${project.state == 200}">保存</c:if>
								<c:if test="${project.state == 210}">审核中</c:if>
								<c:if test="${project.state == 220}">待发布</c:if>
								<c:if test="${project.state == 230}">审核未通过</c:if>
								<c:if test="${project.state == 240}">募捐中</c:if>
								<c:if test="${project.state == 260}">结束</c:if>
							</td>
						</tr>
						<tr >
							<td>注册时间:</td>
							<td><fmt:formatDate value="${project.registrTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>是否热门:</td>
							<td >
								<c:if test="${project.hot == 0}">非热门</c:if>
								<c:if test="${project.hot == 1}">热门</c:if>
							</td>
						</tr>
						<tr >
							<td>最后一次更新时间:</td>
							<td><fmt:formatDate value="${project.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
						<tr >
							<td>点击率:</td>
							<td>${project.clickRate}</td>
						</tr>
						<tr >
							<td>捐款笔数:</td>
							<td>${project.donationNum}</td>
						</tr>
						<tr >
							<td>剩余认购份数:</td>
							<td>${project.leaveCopies}</td>
						</tr>
						<tr >
							<td>善管家角色:</td>
							<td>${project.role}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 项目图片 -->
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
				        		<c:if test="${project.coverImageId==item.id}"><img class="logo" src="images/logo_flag.png"/></c:if>
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
			<!-- 发起人信息 -->
			<div style="width:100%;height:520px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="150">姓名:</td>
							<td>${issuer.realName }</td>
						</tr>
						<tr >
							<td>身份证:</td>
							<td>${issuer.indetity}</td>
						</tr>
						<tr >
							<td>家庭住址:</td>
							<td>${issuer.familyAddress}</td>
						</tr>
						<tr >
							<td>工作单位:</td>
							<td>${issuer.workUnit }</td>
						</tr>
						<tr >
							<td>职业:</td>
							<td>${issuer.vocation}</td>
						</tr>
						<tr >
							<td>与受助人关系:</td>
							<td>${issuer.relation}</td>
						</tr>
						<tr >
							<td>联系电话:</td>
							<td>${issuer.linkMobile}</td>
						</tr>
						<tr >
							<td>QQ或微信:</td>
							<td>${issuer.qqOrWx}</td>
						</tr>
					</tbody>
				</table>
			</div>	
			<!-- 受助人信息 -->
			<div style="width:100%;height:520px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="150">姓名:</td>
							<td>${recipient.realName }</td>
						</tr>
						<tr >
							<td>性别:</td>
							<td>${recipient.sex}</td>
						</tr>
						<tr >
							<td>年龄:</td>
							<td>${recipient.age}</td>
						</tr>
						<tr >
							<td>身份证:</td>
							<td>${recipient.indetity}</td>
						</tr>
						<tr >
							<td>家庭住址:</td>
							<td>${recipient.familyAddress}</td>
						</tr>
						<tr >
							<td>工作单位:</td>
							<td>${recipient.workUnit }</td>
						</tr>
						<tr >
							<td>职业:</td>
							<td>${recipient.vocation}</td>
						</tr>
						<tr >
							<td>联系电话:</td>
							<td>${recipient.linkMobile}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 证明人信息 -->
			<div style="width:100%;height:520px;background: white;overflow: auto;">
				<table class="list"  height="100%" width="100%" >
					<tbody align="center">
						<tr >
							<td width="150">姓名:</td>
							<td>${reference.realName}</td>
						</tr>
						<tr >
							<td>联系电话:</td>
							<td>${reference.linkMobile}</td>
						</tr>
						<tr >
							<td>工作单位:</td>
							<td>${reference.workUnit }</td>
						</tr>
						<tr >
							<td>担任职务:</td>
							<td>${reference.persition}</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</div>
