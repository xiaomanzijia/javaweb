<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="js/location.js"></script>
<script type="text/javascript" src="js/YlChinaArea.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#ChinaArea").jChinaArea({aspnet:false,s1:"浙江省",s2:"",s3:""});
	$("#procinceName").val("浙江省");
});

function setProcinceName(){
	var procinceName=jQuery("#province  option:selected").text();
	$("#procinceName").val(procinceName);
}

function setCityName(){
	var cityName=jQuery("#city  option:selected").text();
	$("#cityName").val(cityName);
}

function setCountyName(){
	var countyName=jQuery("#county  option:selected").text();
	$("#countyName").val(countyName);
}
</script>
<div class="pageContent">
	<form method="post" action="area/save.do" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<input id="procinceName" name="procinceName" type="hidden"  />
		<input id="cityName" name="cityName" type="hidden"  />
		<input id="countyName" name="countyName" type="hidden"  />
		
		<div class="pageFormContent" layoutH="57">
			<div id="ChinaArea">
				<div class="unit">
					<label>省:</label>
					<select id="province" style="width:100px;" name="provinceCode" onchange="setProcinceName()"></select>
					<!-- <input name="areaName" type="text" size="30" value="" class="required" /> -->
				</div>
				<div class="unit">
					<label>市:</label>
					<select id="city" style="width:100px;" name="cityCode" onchange="setCityName()">
					</select>
					<!-- <input id="areaCode" name="areaCode" size="31" class="required" type="text" value="" class="required " /> -->
				</div>
				<div class="unit">
					<label>县:</label>
					<select id="county" style="width:100px;" name="countyCode" onchange="setCountyName()">
					</select>
					<!-- <input type="text" name="upperCode" size="30" class="required" value=""/> -->
				</div>
				<!-- <div class="unit">
					<label>状态:</label>
					<select name="state" id="state">
						<option value="100" selected="selected">启用 </option>
						<option value="101">停用</option>
					</select>
				</div> -->
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
