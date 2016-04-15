<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lsgx.admin.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>p" %>

<c:set scope="request" var="exception_message"></c:set>
<%
	if (ActionUtil.isAjaxRequest(request)) {
		String exception_message = (String)request.getAttribute("exception_message");
		exception_message = ActionUtil.replaceSpecialCharactersForJson(exception_message);
		out.print("{\"statusCode\":\"300\", \"message\":\"");
		out.print(exception_message);
		out.print("\"}");
		return;
	}
%>
<html>
<head><title>该页面出错啦</title></head>
<body>
    <h3>Exception:</h3>

    <h3>Stack trace:</h3>
    <pre>
    </pre>
</body>
</html>