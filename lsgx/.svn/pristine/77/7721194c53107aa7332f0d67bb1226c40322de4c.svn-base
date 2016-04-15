<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="js/location.js"></script>
<script type="text/javascript" src="js/YlChinaArea.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css" media="screen"/>

<script type="text/javascript">
$(document).ready(function(){
	$("#ChinaArea").jChinaArea({aspnet:false,s1:"浙江省",s2:"",s3:""});
	$("#procinceName").val("浙江省");
	setLocation();
});

function setProcinceName(){
	var procinceName=jQuery("#province  option:selected").text();
	$("#procinceName").val(procinceName);
	setLocation();
}

function setCityName(){
	var cityName=jQuery("#city  option:selected").text();
	$("#cityName").val(cityName);
	setLocation();
}

function setCountyName(){
	var countyName=jQuery("#county  option:selected").text();
	$("#countyName").val(countyName);
	setLocation();
}

function setLocation(){
	var location=$("#procinceName").val()+" "+$("#cityName").val()+" "+$("#countyName").val();
	$("#location").val(location);
}

function setPerMoney(){
	var cryMoney=$("#cryMoney").val();
	var totalCopies=$("#totalCopies").val();
	var perMoney=cryMoney/totalCopies;
	$("#perMoney").val(Math.round(perMoney*100)/100);
}
</script>
<div class="pageContent">
	<input id="procinceName" name="procinceName" type="hidden"  />
	<input id="cityName" name="cityName"  type="hidden"  />
	<input id="countyName" name="countyName" type="hidden"  />
	
	<form method="post" action="project/editProject.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input id="id" name="id" type="hidden"  value="${project.id}"/>
		<div class="pageFormContent" layoutH="57">
				<div class="unit">
					<label>领域:</label>
					<select id="field" name="field"  style="width: 120px" >
						<option value="disease" <c:if test="${project.field == 'disease'}">selected="selected"</c:if>>疾病</option>
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
						<option value="disabled" <c:if test="${project.field == 'disabled'}">selected="selected"</c:if>>残障</option>
						<option value="garden" <c:if test="${project.field == 'garden'}">selected="selected"</c:if>>善园</option>
					</select>
				</div>
				<div class="unit">
					<label>标题:</label>
					<input name="title" type="text" size="50" maxlength="70" class=""  value="${project.title}"/>
				</div>
				<div class="unit">
					<label>子标题:</label>
					<input name="subTitle" type="text" size="50" maxlength="40" class=""  value="${project.subTitle}"/>
				</div>
				<div class="unit">
					<label>求助原因:</label>
					<input name="cryCause" type="text" size="50" maxlength="40" class=""  value="${project.cryCause}"/>
				</div>
				<div class="unit">
					<label>求救人信息:</label>
					<input name="information" type="text" size="50" maxlength="18" class=""  value="${project.information}"/>
				</div>
				<div class="unit">
					<label>内容:</label>
					<textarea name="content" class="required" rows="16" cols="60">${project.content}</textarea>
				</div>
				<%-- <div class="unit">
					<div id="ChinaArea">
						<label>所在地区:</label>
						<select id="province" style="width:100px;" name="provinceCode" onchange="setProcinceName()"></select>
						<select id="city" style="width:100px;" name="cityCode" onchange="setCityName()"></select>
						<select id="county" style="width:100px;" name="countyCode" onchange="setCountyName()"></select>
					</div>
				</div>
				<div class="unit">
					<label>详细地址:</label>
					<textarea name="detailAddress"  value="" class="required" rows="1" cols="60">${project.detailAddress}</textarea>
				</div> --%>
				<div class="unit">
					<label>求救金额:</label>
					<input name="cryMoney" type="text" size="30" value="${project.cryMoney}" class=" required"  id="cryMoney" onchange="setPerMoney()"/>
				</div>
				<div class="unit">
					<label>单价:</label>
					<input name="perMoney" type="text" size="30" value="${project.perMoney}" class=" readonly" readonly="readonly" id="perMoney"/>
				</div>
				<div class="unit">
					<label>总份数:</label>
					<input name="totalCopies" type="text" size="30" class="required" value="${project.totalCopies} " onchange="setPerMoney()" id="totalCopies"/>
				</div>
				<div class="unit">
					<label>项目截止时间:</label>
					<input name="deadline" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${project.deadline}" pattern="yyyy-MM-dd HH:mm:ss"/>"
		                   maxlength="19">
				</div> 
				<div class="unit">
					<label>开户单位:</label>
					<input name="accountName" type="text" size="30" value="${project.accountName}" class="" />
				</div>
				<div class="unit">
					<label>银行名:</label>
					<input name="accountBank" type="text" size="30" value="${project.accountBank}" class="" />
				</div>
				<div class="unit">
					<label>收款号码:</label>
					<input name="collectNum" type="text" size="30" value="${project.collectNum}" class="" />
				</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
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
