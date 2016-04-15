<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<div class="pageContent">
	<table class="table" width="1800"   layoutH="150">
		<thead>
			<tr>
				<th width="160">企业名称</th>
				<th width="160">企业地址</th>
				<th width="100">负责人</th>
				<th width="100">手机号</th>
				<th width="160">企业简介</th>
				<th width="120">余额</th>
				<th width="120">企业注册号</th>
				<th width="180">组织机构代码</th>
				<th width="120">法定代表人姓名</th>
				<th width="120">身份证</th>
				<th width="120">手机验证状态</th>
				<th width="120">公司网址</th>
				<th width="120">企业类型</th>
				<th width="120">企业信息</th>
				<th width="120">企业使用状态</th>
				<th width="120">企业认证状态</th>
				<th width="120">业务范围</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td >百度</td>
				<td >北京</td>
				<td >李彦宏</td>
				<td >18510065860</td>
				<td >搜索</td>
				<td >6667</td>
				<td >234534SDFGHFGH</td>
				<td >BAIDU</td>
				<td >张三</td>
				<td >362325199005262980</td>
				<td >201</td>
				<td>www.baidu.com</td>
				<td >0</td>
				<td >搜索引擎</td>
				<td >100</td>
				<td>201</td>
				<td >地图，搜索</td>
			</tr>
			<tr>
				<td >阿里巴巴</td>
				<td >杭州</td>
				<td >马云</td>
				<td >18510065861</td>
				<td >网购</td>
				<td >1000000.32</td>
				<td >DSFGDS52345234</td>
				<td >ALIBABA</td>
				<td >二蛋</td>
				<td >362325192345262980</td>
				<td >201</td>
				<td>www.taobao.com</td>
				<td >0</td>
				<td >电商平台</td>
				<td >100</td>
				<td>201</td>
				<td >B2B，天猫</td>
			</tr>
			<tr>
				<td >腾讯</td>
				<td >深圳</td>
				<td >马化腾</td>
				<td >18510065866</td>
				<td >社交</td>
				<td >88889</td>
				<td >SDGFSDG341234</td>
				<td >TECENT</td>
				<td >李四</td>
				<td >362325199003569020</td>
				<td >203</td>
				<td>www.qq.com</td>
				<td >1</td>
				<td >社交平台</td>
				<td >100</td>
				<td>201</td>
				<td >社交，游戏</td>
			</tr>
		</tbody> 
	</table>
	<div style="width:100%;height:160px;float: center; overflow: auto;">
		<h2><font color="#F03C35">注明:填写excel表格时以下信息请勿随意填写，且不能有空，严格按照数值的代表意思填写相应数字!</font></h2></br></br>
		<font color="#F03C35">手机验证状态</font>：201是未审核，202是审核未通过，203验证审核通过</br></br>
		<font color="#F03C35">企业类型</font>：0是企业，1是事业单位，2是社会团体，3是党政及国家机关</br></br>
		<font color="#F03C35">企业使用状态</font>：100是正常，101是信用，102是暂停</br></br>
		<font color="#F03C35">企业认证状态</font>：201是未认证，202是认证失败，203是认证通过
	</div>
	
</div>
