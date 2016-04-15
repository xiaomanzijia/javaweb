<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>

<script type="text/javascript">
document.onkeydown=banBackSpace;
function resetSysLogQuery()
{
	$("#capitalinoutName").val("");
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
	<form id="pagerForm" method="post" action="capital/capitalInOutList.do">
		<input type="hidden" name="pageNum" value="${page.pageNum }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize}" />
		<input type="hidden" name="orderField" value="${orderField}" />
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<input type="hidden" name="payState" value="${capitalinout.payState}" />
		<input type="hidden" name="startDate" value="<fmt:formatDate value="${capitalinout.startDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="endDate" value="<fmt:formatDate value="${capitalinout.endDate}" pattern="yyyy-MM-dd"/>" />
		<input type="hidden" name="userId" value="${capitalinout.userId}" />
		<input type="hidden" name="type" value="${capitalinout.type}" />
		<input type="hidden" name="payType" value="${capitalinout.payType}" />
		<input type="hidden" name="tranNum" value="${capitalinout.tranNum}" />
		<input type="hidden" name="payNum" value="${capitalinout.payNum}" />
		<input type="hidden" name="source" value="${capitalinout.source}" />
		<input type="hidden" name="bankType" value="${capitalinout.bankType}" />
		<input type="hidden" name="id" value="${capitalinout.id}" />
	</form>
	<div class="searchBar">
		<form method="post" rel="pagerForm" action="capital/capitalInOutList.do" onsubmit="return navTabSearch(this)">
			<table class="searchContent">
				<tr>
					<td><label for="name" style="width:70px">资金明细ID：</label>
						<input class="textInput" value="${capitalinout.id }" style="width:114px" id="id" name="id"  type="text" onkeypress="onlyNumber()">
					</td>
					<td>
						<label for="name" style="width:50px">类别：</label>
						<select id="type" name="type"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="0" <c:if test="${capitalinout.type == 0}">selected="selected"</c:if>>资金进</option>
							<option value="1" <c:if test="${capitalinout.type == 1}">selected="selected"</c:if>>资金出</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:60px">交易号：</label>
						<input class="textInput" value="${capitalinout.tranNum }" style="width:114px" id="tranNum" name="tranNum"  type="text">
					</td>
					<td>
						<label for="name" style="width:40px">支付号：</label>
						<input class="textInput" value="${capitalinout.payNum }" style="width:114px" id="payNum" name="payNum"  type="text">
					</td>
					<td>
						<label for="name" style="width:50px">来源：</label>
						<select id="source" name="source"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="PC"  <c:if test="${capitalinout.source == 'PC'}">selected="selected"</c:if> >PC</option>
							<option value="Andrews"  <c:if test="${capitalinout.source == 'Andrews'}">selected="selected"</c:if> >安卓</option>
							<option value="iPhone"  <c:if test="${capitalinout.source == 'iPhone'}">selected="selected"</c:if> >苹果</option>
							<option value="H5"  <c:if test="${capitalinout.source == 'H5'}">selected="selected"</c:if> >H5</option>
							<option value="iPad"  <c:if test="${capitalinout.source == 'iPad'}">selected="selected"</c:if> >iPad</option>
						</select>
					</td>
				</tr> 
				<tr>
					<td><label for="name" style="width:70px">用户ID：</label>
						<input class="textInput" value="${capitalinout.userId }" style="width:114px" id="userId" name="userId"  type="text" onkeypress="onlyNumber()">
					</td>
					<td>
						<label for="name" style="width:50px">支付状态：</label>
						<select id="payState" name="payState"  style="width: 120px" >
							<option value=""  >全部</option>
							<option value="300"  <c:if test="${capitalinout.payState==300}">selected="selected"</c:if>>未支付</option>
							<option value="301"  <c:if test="${capitalinout.payState==301}">selected="selected"</c:if>>支付失败</option>
							<option value="302"  <c:if test="${capitalinout.payState==302}">selected="selected"</c:if>>支付成功</option>
						</select>
					</td>
					<td>
						<label for="name" style="width:60px;">创建时间：</label>
						<input name="startDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}'})"
		                   id="startDate"
		                   value="<fmt:formatDate value="${capitalinout.startDate}" pattern="yyyy-MM-dd "/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:40px">- 到 -</label>
						<input name="endDate" type="text" class="textInput readonly valid Wdate" style="width:114px;height:15px;"
		                   onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}'})"
		                   id="endDate"
		                   value="<fmt:formatDate value="${capitalinout.endDate}" pattern="yyyy-MM-dd"/>"
		                   maxlength="19">
					</td>
					<td>
						<label for="name" style="width:50px">支付类型：</label>
						<select id="payType" name="payType"  style="width: 120px">
							<option value=""  >全部</option>
							<option value="alipay"  <c:if test="${capitalinout.payType=='alipay'}">selected="selected"</c:if>>支付宝</option>
							<option value="lianlian"  <c:if test="${capitalinout.payType=='lianlian'}">selected="selected"</c:if>>连连支付</option>
							<option value="freezType" <c:if test="${capitalinout.payType=='freezType'}">selected="selected"</c:if>>冻结支付</option >
							<option value="back" <c:if test="${capitalinout.payType=='back'}">selected="selected"</c:if>>系统退款</option >
							<option value="bankpay" <c:if test="${capitalinout.payType=='bankpay'}">selected="selected"</c:if>>网上银行</option>
							<option value="yinhanghuikuan" <c:if test="${capitalinout.payType=='yinhanghuikuan'}">selected="selected"</c:if>>银行汇款</option> 
							<option value="otherpay" <c:if test="${capitalinout.payType=='otherpay'}">selected="selected"</c:if>>其他存入</option>
						</select> 
					</td>
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
		</ul>
	</div>
	<table class="table" width="100%"   layoutH="140">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="80">资金明细ID</th>
				<th width="100">类别</th>
				<th width="80">金额</th>
				<th width="140">交易号</th>
				<th width="200">支付号</th>
				<th width="60">来源</th>
				<th width="80">支付类型</th>
				<th width="160">帐号</th>
				<th width="60">用户ID</th>
				<th width="60">支付状态</th>
				<th width="120">创建时间</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  items="${list}" var="capitalinout"  varStatus="status">
				<tr target="list_item_id" rel="${capitalinout.id }">
					<td>${status.count}</td>
					<td >${capitalinout.id }</td>
					<td >
						<c:if test="${capitalinout.type == 0}">资金进</c:if>
						<c:if test="${capitalinout.type == 1}">资金出</c:if>
						<c:if test="${capitalinout.inType == 0}"><font color="#E00000">(募捐)</font></c:if>
						<c:if test="${capitalinout.inType == 1}"><font color="#0086D1">(充值)</font></c:if>
						<c:if test="${capitalinout.inType == 2}"><font color="#52B74F">(助善)</font></c:if>
						<c:if test="${capitalinout.inType == 3}"><font color="#E17D25">(提款)</font></c:if>
						<c:if test="${capitalinout.inType == 4}"><font color="#922621">(退款)</font></c:if>
						<c:if test="${capitalinout.inType == 5}"><font color="#922621">(退款)</font></c:if>
						<c:if test="${capitalinout.inType == 6}"><font color="#922621">(退款)</font></c:if>
						<c:if test="${capitalinout.inType == 7}"><font color="#922621">(退款)</font></c:if>
					</td>
					<td >${capitalinout.money }</td>
					<td >${capitalinout.tranNum }</td>
					<td >${capitalinout.payNum }</td>
					<td >
						<c:if test="${capitalinout.source == 'PC'}">PC</c:if>
						<c:if test="${capitalinout.source == 'Andrews'}">安卓</c:if>
						<c:if test="${capitalinout.source == 'iPhone'}">苹果</c:if>
						<c:if test="${capitalinout.source == 'H5'}">H5</c:if>
						<c:if test="${capitalinout.source == 'iPad'}">iPad</c:if>
					</td>
					<td >
						<c:choose> 
							<c:when  test="${capitalinout.payType == 'alipay'}">支付宝</c:when >
							<c:when  test="${capitalinout.payType == 'tenpay'}">微信支付</c:when >
							<c:when  test="${capitalinout.payType == 'lianlian'}">连连支付</c:when >
							<c:when  test="${capitalinout.payType == 'freezType'}">冻结支付</c:when >
							<c:when  test="${capitalinout.payType == 'back'}">系统退款</c:when >
							<c:when  test="${capitalinout.payType == 'bankpay'}">网上银行</c:when >
							<c:when  test="${capitalinout.payType == 'yinhanghuikuan'}">银行汇款</c:when >
							<c:when  test="${capitalinout.payType == 'otherpay'}">其他存入</c:when >
							<c:otherwise>${capitalinout.payType}</c:otherwise>
						</c:choose>
					</td>
					<td >${capitalinout.account }</td>
					<td >
						<a
							href="user/showDetail.do?id=${capitalinout.userId}"
							target="dialog" width="680" height="580" style="color:blue;"
							rel="show_project" title="前端用户详情"  resizable="true" mask="true"
							maxable="false" drawable="true">${capitalinout.userId }
						</a>
					</td>
					<td >
						<c:if test="${capitalinout.payState == 300}">未支付</c:if>
						<c:if test="${capitalinout.payState == 301}">支付失败</c:if>
						<c:if test="${capitalinout.payState == 302}">支付成功</c:if>
					</td>
					<td ><fmt:formatDate value="${capitalinout.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<c:if test="${capitalinout.payState == 300 && capitalinout.type == 0}">
						<priveliege:enable buttonCode="cancelCapitalIn">
							<a class="btnDel" href="capital/cancelCapitalIn.do?id=${capitalinout.id}" target="ajaxTodo"
							 rel="cancelCapitalIn" title="取消"><span>取消</span></a>
						</priveliege:enable>
						<priveliege:enable buttonCode="mendCapitalIn">
							<a class="btnUlogo" href="capital/mendCapitalIn.do?id=${capitalinout.id}" target="ajaxTodo"
							 rel="mendCapitalIn" title="补单"><span>补单</span></a>
						</priveliege:enable>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:import url="../common/panelBar.jsp" />

</div>
	