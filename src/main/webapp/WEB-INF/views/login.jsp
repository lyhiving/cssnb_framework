<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN" xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>宁波市质量安全监管业务平台</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/zjj2011.css"></link>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.7.2.min.js"></script>
<script src="${ctx}/resources/jquery-validation/1.9.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/jquery-validation/1.9.0/messages_cn.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$('#loginForm img').click(function () { 
		    $(this).hide().attr('src', '${ctx}/captcha?' + Math.floor(Math.random()*100) ).fadeIn(); 
		})
		$("#submit").click(function(){
			//console.log("submit it");
			//$("#loginForm").submit();
			//$("form:first").submit();
		});
		//$("#loginForm").validate();
	});
</script>
<style type="text/css">
body {
	background:url(${ctx}/resources/global/images/bgbody.jpg) center center repeat-x;
}
</style>
</head>

<body class="loginbody">
<br>${shiroLoginFailure}</br>
<div class="login_main">
	<div class="logink01">
	<form:form id="loginForm" action="${ctx}/login" method="post" >
	<p>用户名：<input name="username" id="username" class="required input01" value="${username}" /></p>
	<p>密　码：<input  class="required input01" type="password" id="password" name="password" /></p>
	<p>验证码：<input type="text" id="captcha" name="captcha" class="input02" /> <img src="${ctx}/captcha"/><input id="submit" type="submit" class="inputbtn01" value=""/></p>
	<p class="help01"><a href="javascript:;" >清除用户记忆</a>  <a href="javascript:;">忘记密码?</a> <input type="checkbox" id="AllScreen" name="AllScreen"  value="1"/><span id="qpid" style="color:#fff;">全屏</span></p>
	</form:form>
	</div>
	<div class="logink03">
		<a href="#">市局OA</a><a href="#">质量安全</a><a href="#">省局OA</a><a href="${ctx}/demo">测试</a>
	</div>
	<br></br>
	<div class="lfont">版权所有(c)宁波市质量技术监督局   管理员电话：123525855<br /><strong>注：如果页面登录后关闭，请尝试做如下设置：IE菜单【工具】-&gt;弹出窗口阻止程序-&gt;弹出窗口阻止程序设置　要允许的网站地址填写平台地址点添加</strong></div>

</div>
</body>
</html>
