<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/layout.css">
<script type="text/javascript">
document.onkeydown=banBackSpace;
</script>
<div class="pageContent">
	<div class="pageFormContent" layoutH="57">

		<div class="unit">
			<label><b>列表界面预览</b></label>
			<div class="about-dynamic-right" style="float: left;width: 100%">

				<div class="dynright-conn">
					<ul>
						<li>
							<div class="dyna-left"><img src="${fileVO.img_path}" width="126px" height="83px"  /></div>
							<div class="dyna-right">
								<h2>${article.title}<span style="float: right"><fmt:formatDate value="${article.createtime}" pattern="yyyy-MM-dd"/></span></h2>
								<p>${article.description }</p>                                </div>
						</li>

					</ul>

				</div>

			</div>
		</div>

		<div class="unit">
			<label><b>文章内容预览</b></label>
		</div>

		<div class="unit">
			${article.content }
		</div>



		

		</div>

	</form>
</div>

