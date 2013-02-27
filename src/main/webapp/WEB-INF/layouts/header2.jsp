<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header" class="span12">
<header>
    <div>
    <a href="#"><img src="" alt="在此处插入徽标"width="180" height="90" id="Insert_logo" style="background: #C6D580; " /></a>
    <span>fff</span>
    </div>
  </header>
  
	<div id="title">
	    	<h1>宁波市质量安全监管平台<small>--演示</small></h1>
	    	<shiro:user>
			<span class="pull-right">欢迎, <shiro:principal property="name"/>!!</span>
		</shiro:user>
	</div>
		
	<div id="menu">
		<ul class="nav nav-tabs">
			<shiro:user>
			<shiro:hasPermission name="user:view">
				<li id="user-tab"><a href="${ctx}/account/user/" >帐号列表</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="group:view">
				<li id="group-tab"><a href="${ctx}/account/group/">权限组列表</a></li>
			</shiro:hasPermission>
			<li><a href="${ctx}/logout">退出登录</a></li>
			</shiro:user>
			<shiro:guest>
				<li class="active"><a href="${ctx}/login">登录</a></li>
			</shiro:guest>
		</ul>
		
	</div>
</div>