<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Role and Permissions Security Home Page</title>
</head>
<body>
<h3>Welcome to The Role and Permissions Security Home Page</h3>
<p>Our web site does have security and it includes security by ROLE and by PERMISSION, so NOT everyone
who is logged in can visit all our pages.</p>

<shiro:guest>
<p><a href="login.jsp">Please login.</a></p>
</shiro:guest>

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

</body>
</html>