<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<div class="tabs">
		<div class="tabsContent">
			<form method="post" action="action/actionRoleFun.do" class="pageForm required-validate" onsubmit="kkk(); return iframeCallback(this,navTabAjaxDone);">
				<input type="hidden" name="roleId" value="${roleId}">
				<input id="values" type="hidden" name="values">
				<div layoutH="50" style="float:left; display:block; padding-top:5px; margin-bottom:5px; overflow:auto; width:800px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
					<h2>分配权限</h2>
					<div id="resultBox"></div>
					<ul class="tree treeFolder treeCheck expand" oncheck="kkk">
						${actionStr}
					</ul>
				</div>
				<div class="formBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit" onclick="kkk();">提交</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function kkk() {
	var result = "";
	var n = 0;
	var str = '';
	$("div.ckbox.checked input").each(function(i) {
		if (n == 0) {
			result += $(this).attr('value');
		} else {
			result += "," + $(this).attr('value');
		}
		n++;
	});
//	alert(result);
//	$("#values").attr('value', result);
	$("#values").val(result);
}
</script>
