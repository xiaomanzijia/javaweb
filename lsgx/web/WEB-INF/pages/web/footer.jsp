<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
    	<footer>
        	<div class="foot-link">
            	<div class="folink-title">友情链接<span>FRIENDLY LINKS</span></div>
                <div class="folink-conn">
                    <c:forEach  items="${links}" var="bean">
                	<a href="${bean.linkurl}" target="_blank">${bean.webtitle}</a>
                    </c:forEach>
                </div>
            </div>
            
            <div class="foot-copy">
            	<p><a href="/index.do">首页</a> - <a href="/aboutus.do">关于我们</a> - <a href="/disclosure.do">信息披露</a> - <a href="/welfare.do">公益项目</a> - <a href="/volunteers.do">志愿者</a></p>
                <p>浙江省绿色共享教育基金会 版权所有 2015 浙ICP备10046535号</p>
            </div>
        </footer>
