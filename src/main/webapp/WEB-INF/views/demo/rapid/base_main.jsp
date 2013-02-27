<%@ page language="java" contentType="text/html;"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><rapid:block name="title">内容页</rapid:block></title>
	<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	<%-- 可编辑的meta部分，默认无 --%>
	<rapid:block name="meta"></rapid:block>
</head>
<body>
<rapid:block name="content">默认内容</rapid:block>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	if(document.body.scrollHeight > window.screen.availHeight){
		parent.resizeIframe(document.body.scrollHeight);
	}else{
		parent.resizeIframe();
	}
});
</script>
<!-- <script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script> -->
<%-- 可编辑的脚本区域，默认无 --%>
<rapid:block name="script"></rapid:block>
</body>
</html>