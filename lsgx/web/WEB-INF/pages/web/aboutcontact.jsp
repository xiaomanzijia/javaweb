<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cmn-Hans"  lang="zh-cmn-Hans"  xmlns="http://www.w3.org/1999/xhtml">
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
                    <li><a class="active" href="/aboutintroduc.do">关于我们</a></li>
                    <li><a href="/disclosure.do">信息批露</a></li>
                    <li><a href="/welfare.do">公益项目</a></li>
                    <li><a href="/poverty.do">专项基金</a></li>
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
                	<div class="intleft-title">关于我们</div>
                    <div class="intleft-conn">
                    	<ul>
                        	<li><a href="/aboutintroduc.do">基金会介绍</a></li>
                            <li><a href="/aboutsponsors.do">基金会发起人</a></li>
                            <li><a href="/aboutstructur.do">基金会组织结构</a></li>
                            <li><a href="/aboutboard.do">基金会理事会</a></li>
                            <li><a href="/aboutarticles.do">基金会章程</a></li>
                            <li><a class="active" href="/aboutcontact.do">联系我们</a></li>
                        </ul>
                    </div>
                </div>
            	<div class="about-intro-right">
                	<div class="intright-title">联系我们</div>
                	<div class="intright-contact">
                    	<img src="image/about-contact-maps.jpg" />
                        <div class="conta-plon">
                        	<h2>浙江绿色共享教育基金会</h2>
                            <ul>
                            	<li><div class="demo">联系地址：</div><div class="demo-add lhm24">浙江省杭州市余杭区五常大道181号华立科技园办公大楼东7楼705</div></li>
                            	<li><div class="demo">联系电话：</div><div class="demo-add">0571-88900802</div></li>
                            	<li><div class="demo">传真号码：</div><div class="demo-add">0571-88901795</div></li>
                            	<li><div class="demo">电子邮箱：</div><div class="demo-add">lijuan.sun@holley.cn</div></li>
                                <li><img src="image/about-contact-weix.jpg" /><p>扫描二维码<br />关注基金会微信号</p></li>
                            </ul>
                        </div>
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
