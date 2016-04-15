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

</script>
<div class="pageContent">
	<input id="procinceName" name="procinceName" type="hidden"  />
	<input id="cityName" name="cityName"  type="hidden"  />
	<input id="countyName" name="countyName" type="hidden"  />
	
	<form method="post" action="/project/saveProject.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input id="location"  name="location" type="hidden"  />
		
		<div class="pageFormContent" layoutH="57">
				<div class="unit">
					<label>领域:</label>
					<select id="field_add" name="field"  style="width: 120px" class="combox">
						<option value="garden" >善园</option>
					</select>
				</div>
				<div class="unit">
					<label>标题:</label>
					<input name="title" type="text" size="50" maxlength="70" value="" class="required" />
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
					<input name="information" type="text" class="" size="50" maxlength="18" value="${project.information}"/>
				</div>
				<div class="unit">
					<label>内容:</label>
					<textarea name="content"  value="" class="required" rows="16" cols="60"></textarea>
				</div>
				<div class="unit">
					<div id="ChinaArea">
						<label>所在地区:</label>
						<select id="province" style="width:100px;" name="provinceCode" onchange="setProcinceName()"></select>
						<select id="city" style="width:100px;" name="cityCode" onchange="setCityName()"></select>
						<select id="county" style="width:100px;" name="countyCode" onchange="setCountyName()"></select>
					</div>
				</div>
				<div class="unit">
					<label>详细地址:</label>
					<textarea name="detailAddress"  value="" class="required" rows="1" cols="60"></textarea>
				</div>
				<div class="unit">
					<label>单价:</label>
					<input name="perMoney" type="text" size="30" value=""  class="required"/>
				</div>
				<div class="unit">
					<label>总份数:</label>
					<input name="totalCopies" type="text" size="30" value="" class="required" />
				</div>
				<div class="unit">
					<label>项目截止时间:</label>
					<input class="date textInput readonly valid"  dateFmt="yyyy-MM-dd HH:mm:ss" type="text"  readonly="true"  id="deadline" name="deadline">
				</div>
				<!-- <div class="unit">
					<label>开户单位:</label>
					<input name="accountName" type="text" size="30" value="" class="required" />
				</div>
				<div class="unit">
					<label>银行名:</label>
					<input name="accountBank" type="text" size="30" value="" class="required" />
				</div> -->
				<div class="unit">
					<label>收款号码:</label>
					<input name="collectNum" type="text" size="30" value="" class="" />
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
