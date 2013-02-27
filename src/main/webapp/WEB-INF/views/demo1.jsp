<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ page session="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>首页</title>
<link href="${ctx}/resources/global/css/demo1.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<h1>欢迎</h1>
	<shiro:guest>
		<h2>You are our guest!</h2>
	We would love to make you a more permanent part of the family. <br />
	How about <a href="identity/registration">Registering</a> ?
	</shiro:guest>
	
	<shiro:user>
	显示名：<shiro:principal property="name"/> 登录名：<shiro:principal />
	</shiro:user>
	
	<shiro:authenticated>
<shiro:hasPermission name="secure">
<p>Below link is available only for authenticated users with a permission of secure.</p>
<p><a href="staff/index.jsp">Secure Area</a></p>
</shiro:hasPermission>

<shiro:hasRole name="admin"> 
<p>Below link is available only for authenticated users with a role of admin.</p>
<p><a href="admin/index.jsp" >Admin Area</a></p>
</shiro:hasRole>


<p><a href="LogoutUser">Log out when you're finished.</a></p>
</shiro:authenticated>
<div style="height:800px;">
	<c:forEach items="${tblrights}" var="tblright">
		${tblright.right_name},${tblright.RIGHT_NAME} <br />
	</c:forEach>
</div>
</body>
</html>
