<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cmn-Hans"  xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>绿色共享基金会</title>
<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/layout.css">
</head>

<body>
<header>
	<div class="wrap-top"></div>
    <div class="wrap-middle">
    	<header>
        	<div class="share-top">
            	<div class="share-left"><a href="javascript:void(0)"><img src="image/shared-logo.png" /></a></div>
                <div class="share-right"><img src="image/shared-logo-prop.png" /></div>
            </div>
            <div class="share-nav">
                <ul class="shnav_left">
                    <li><a href="/index.do">首页</a></li>
                    <li><a href="/aboutus.do">关于我们</a></li>
                    <li><a  href="/disclosure.do">信息批露</a></li>
                    <li><a   href="/welfare.do">公益项目</a></li>
                    <li><a class="active" href="/poverty.do">专项基金</a></li>
                    <li><a href="/volunteers.do">志愿者</a></li>
                </ul>
                <div class="shnav_contact">
                咨询热线：0571-88900726
                </div>
            </div>
        </header>
    	<section>
        	<div class="about-intro-main">
                <div class="about-intro-left">
                    <div class="intleft-title">专项基金</div>
                    <div class="intleft-conn">
                        <ul>
                            <li><a <c:if test="${article.zrfp}">class="active"</c:if> href="/poverty.do">致瑞扶贫基金</a></li>
                            <li><a <c:if test="${article.zqkm}">class="active"</c:if> href="/povertyzqkm.do">智骐抗霾基金</a></li>
                            <li><a  <c:if test="${article.lsqt}">class="active"</c:if>href="/povertylsqt.do">绿色青藤残疾儿童艺术培训专项基金</a></li>
                        </ul>
                    </div>
                </div>
            	<div class="about-detail-right">
                	<div class="detail_title">
                        <h2>${article.title}</h2>
                        <p><span>发布时间：<fmt:formatDate value="${article.createtime}" pattern="yyyy-MM-dd"/></span></p>
                	</div>
                    <div class="detail_conn">
                        <p>
                            ${article.content}
                        </p>
                   </div>
                </div>
            </div>
        
        </section>
        <jsp:include page="/footer.do"/>
    
    </div>
	<div class="wrap-bottom"></div>
</header>
</body>
</html>
