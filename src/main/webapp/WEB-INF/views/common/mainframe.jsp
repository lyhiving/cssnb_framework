<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>宁波市质量安全监管平台2.0</title>	
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="${ctx}/resources/jquery-validation/1.9.0/validate.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/global/css/base.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/global/css/icon.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/superfish/css/superfish.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/global/css/template2.css" type="text/css" rel="stylesheet" />
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	<!--[if lt IE 9]>
	<script src="${ctx}/resources/global/js/html5.js"></script>
	<![endif]-->
	<!--[if lt IE 7]>
	<script src="${ctx}/resources/global/js/iepngfix_tilebg.js"></script>
	<![endif]-->
	<script src="${ctx}/resources/jquery/jquery-1.7.2.min.js"></script>
	<script src="${ctx}/resources/global/js/jquery.hoverIntent.js"></script>
	<script src="${ctx}/resources/global/js/jquery.iframe-auto-height.plugin.js"></script>
	
</head>
<body>
<c:import url="header.jsp" />
<div class="colmask leftmenu">
    <div class="colright">
        <div class="col1wrap">
            <div class="col1">
            	<iframe id="main" name="main" frameborder="0" scrolling="no" style="width:100%;border: 0;" src="${ctx}/default"></iframe>
            </div>
        </div>
        <div class="col2">
        	<c:import url="/sidebar/${rightId}" />
        </div>
    </div>
</div>
<c:import url="footer.jsp" />
<script type="text/javascript">
	$('iframe').iframeAutoHeight({debug: true, minHeight:600,diagnostics: false}); 
	
	$(function(){
		console.log("col2 height");
		$("iframe").load(function(){
			console.log("iframe loaded");
			console.log($("iframe").height());
			
		});
	});
</script>
</body>
</html>