<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<rapid:block name="head">
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="${ctx}/resources/jquery-ui/css/cssnb/jquery-ui-1.8.21.custom.css" type="text/css">
<link rel="stylesheet" href="${ctx}/resources/JQuery.zTree-v3.5.02/css/zTreeStyle/zTreeStyle.css" type="text/css">
</rapid:block>
<style>
#wrap{min-width:800px;overflow-x:auto;overflow-y:hidden;}
#top{height:auto;margin:0px 0px 0px 0;position:relative;z-index:4;}
#top .user{float:right;position:absolute;right:5px;top:90px;}
#top .user .info{float:left;width:140px;height:48px;overflow:hidden;}
#top .user .info em{margin-right:2px;}
#top .user .control{float:left;width:80px;overflow:hidden;}
#top .buttons{white-space:nowrap;}
#top .btn{width:70px;height:30px;white-space:nowrap;}
.btn-primary.active, .btn-warning.active, .btn-danger.active, .btn-success.active, .btn-info.active, .btn-inverse.active{color:#FFFFFF;}
#bottom{background-color:#FFFFFF;height:auto;overflow-x:auto;overflow-y:hidden;}
#left{width:20%;height:auto;float:left;position:relative;z-index:1;overflow-x:hidden;overflow-y:auto;margin:0px;/*background-color:#F2F2F2;*/}
#right{width:80%;height:auto;float:left;position:relative;z-index:2;margin:0px;}
.switch_bar{display:block;width:8px;height:10000px;position:fixed;top:0px;z-index:3;background-color:transparent;overflow:hidden;}
.switch_bar .switch_arrow{display:block;position:absolute;width:9px;height:46px;left:0px;margin-top:-23px;background:url(${ctx}/resources/global/images/switch_arrow.png) no-repeat;cursor:pointer;}
.switch_bar .switch_arrow:hover{background-position:-14px 0px;}
.switch_bar .arrow_hidden{background-position:-28px 0px;}
.switch_bar .arrow_hidden:hover{background-position:-42px 0px;}
</style>
</head>
<body style="margin:0px;padding:0px;overflow-x:hidden;">
<div id="wrap" class="container-fluid">
	<div id="top" class="row-fluid">
		<div class="title">
			<img src="http://img.blog.163.com/photo/Jc7EWJsFv1G7TXoPRgOOUA==/479070410362818542.jpg" width="100%" style="width:100%;border:0px;height:150px;">
		</div>
		<div class="user" align="center">
			<div class="info">
				<em><img src="${ctx}/resources/global/images/head/android.jpg" width="48" height="50" style="width:48px;height:50px;"></em>
				<span>系统管理员</span>
			</div>
			<div class="control">
				<p><a href="javascrip:void(0);">修改资料</a></p>
				<p><a href="javascrip:void(0);">退出系统</a></p>
			</div>
		</div>
		<div class="buttons btn-group" data-toggle="buttons-radio">
			<button class="btn btn-info" id="p1" serverPath="http://localhost:8012:/p1">子项目01</button>
			<button class="btn btn-info" id="p2">子项目02</button>
			<button class="btn btn-info" id="p3">子项目03</button>
			<button class="btn btn-info" id="p4">子项目04</button>
			<button class="btn btn-info" id="p5">子项目05</button>
			<button class="btn btn-info">子项目06</button>
			<button class="btn btn-info">子项目07</button>
			<button class="btn btn-info">子项目08</button>
			<button class="btn btn-info">子项目09</button>
			<button class="btn btn-info">子项目10</button>
			<button class="btn btn-info">子项目11</button>
			<button class="btn btn-info">子项目12</button>
		</div>
	</div>
	<div id="bottom" class="row-fluid">
		<div id="left" class="span2">
			<a href="http://www.qq.com" target="mainFrame">腾讯首页</a>
			<ul id="ztree" class="ztree"></ul>
		</div>
		<div class="switch_bar">
			<a class="switch_arrow" title="收缩"></a>
		</div>
		<div id="right" class="span10">
			<rapid:block name="main">
				<iframe id="mainFrame" name="mainFrame" src="${ctx}/rapid/base_main" frameborder="0" scrolling="no" width="100%"></iframe>
			</rapid:block>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery-ui/js/jquery-ui-1.8.21.custom.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/JQuery.zTree-v3.5.02/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/global/views/demo/demo1.js"></script>
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
</script>
</body>
<html>