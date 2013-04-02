<%@ page language="java" contentType="text/html;  charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<link rel="stylesheet" href="${ctx}/resources/global/css/wiki.css" type="text/css">
<!--[if IE 6]>
<style type="text/css">
html{background-image:url(about:blank);background-attachment:fixed;}
#content{overflow-x:hidden;}
.bottomnav{position:absolute;top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-30));}
</style>
<![endif]-->
<script>
$(function(){
	// 构造目录列表
	$.getJSON("${ctx}/wiki/getDirList", function(data){
		if(data){
			var $parent, $ul, subDiv = false;
			$("#mw-panel").append('<ul><li><a href="${ctx}/wiki/" class="index">首页</a></li></ul>');
			$.each($(data), function(i){
				if(this.PID == 0 || !this.PID){
					$parent = $('<div class="portal ' + this.DIRID + '" style="margin-top:-1px;"></div>');
					$parent.append($('<h5><span class="portal_arrow"></span>' + this.DIRNAME + '</h5>'));
					$parent.appendTo($("#mw-panel"));
				}else{
					$parent = $("." + this.PID);
					if(!$parent.find(".body").length){
						$child = $('<div class="body" style="display:none;"></div>');
						$ul = $('<ul></ul>');
					}
					$ul.append('<li><a href="javascript:void(0);" tag="' + this.DIRID + '">' + this.DIRNAME + '</a></li>');
					$child.append($ul);
					$parent.append($child);
				}
			});
			// 默认展开已经点击过的菜单
			$(".portal > .body").each(function(){
				if($(this).find('a[tag=${dirId}]').length){
					$(this).slideDown(300);
					$(this).find('a[tag=${dirId}]').parent().addClass("active");
					$(this).parent().addClass("active");
					return false;
				}
			});
		}
	});
	// 伸缩左侧菜单
	$(".portal").live("click", function(e){
		if(e.target.tagName == "A") return;
		$(".portal").removeClass("active").find(".body").slideUp();
		var $body = $(this).find(".body");
		if($body.is(":visible") || !$body.length){
			$body.slideUp(100);
			$(this).removeClass("active");
		}else{
			$body.slideDown(200);
			$(this).addClass("active");
		}
	}).find("a").live("click", function(){
		var dirId = $(this).attr("tag");
		window.location.href = "${ctx}/wiki/getDocByDirId?dirId=" + dirId;
		/* $("#loading").toggle();
		$("#dirId").val(dirId);
		$.getJSON("${ctx}/wiki/getDocByDirId", {dirId: dirId}, function(data){
			if(data){
				$("#content_title").text(data.TITLE);
				$("#contents").html(data.Content);
			}else{
				$("#content_title").text("");
				$("#contents").html("");
			}
			$("#loading").toggle();
		}); */
	});
	// 悬浮显示编辑
	$("#content").hover(
		function(){$(this).addClass("gray");$("#editContent").toggle();},
		function(){$(this).removeClass("gray");$("#editContent").toggle();
	});
	$("#mw-panel").hover(function(){$("#editTree").toggle();},function(){$("#editTree").toggle();});
	$("#editContent").click(function(){
		window.location.href = "${ctx}/wiki/newDoc?dirId=" + $("#dirId").val();
	});
	$("#loading").height($(window).height());
	scrollToTop();
	$("#editTree").click(function(){
		window.location.href = "${ctx}/wiki/directory?from=" + document.URL;
	});
});
function scrollToTop(){
	if($.browser.msie && $.browser.version == '6.0') return;
	$(window).scroll(function () {
		if ($(this).scrollTop() > 50){
			$('.bottomnav').stop(false, true).fadeIn();
		}else {
			$('.bottomnav').stop(false, true).fadeOut();
		}
	});
	$('.topbtn').click(function(){$('body,html').animate({scrollTop: 0}, 300);})
}
</script>
<style>
#editTree{float:right;margin:6px 14px 0px 0;width:16px;height:16px;background:url(${ctx}/resources/global/images/wiki/config.png) no-repeat;}
#editContent{display:none;margin-right:5px;text-decoration:underline;}
#editTree:hover,#editContent:hover{color:blue;text-decoration:none;}
#loading{display:none;position:fixed;width:100%;background:url(${ctx}/resources/global/images/wiki/loading.gif) no-repeat #EEEEEE center center;opacity:0.8;filter:(opacity=80);}
.gray{background-color:#F9F9F9;}
.bodyContent h2, .bodyContent h3, .bodyContent h4, .bodyContent h5, .bodyContent h6{border-bottom:0px;}
</style>
</head>
<body style="margin:0px;padding:0px;">
<div class="headWrap">
	<div id="header" class="headInside">
		<h1><a title="open.t.qq.com" href="javascript:void(0);"></a></h1>
		<ul class="topNav">
			<li><a href="javascript:void(0);">首页</a></li>
			<li><a href="javascript:void(0);" class="active">开发文档</a></li>
			<li><a href="${ctx}/rapid/1">外围平台</a></li>
		</ul>
		<div class="userNav" id="login_status">
			<c:if test="${!empty username}">
			<a class="txt" href="javascript:;" title="${username}">${username}<em></em></a>
			 | 
			<a href="javascript:;" id="logoutBtn">退出</a>
			</c:if>
			<c:if test="${empty username}">
			<a title="点击此处登录" class="txt" href="javascript:void(0);" id="loginBtn">登录</a>
			</c:if>
		</div>
	</div>
	<div class="mainwrapper">
		<!-- 右侧内容 -->
		<div id="content">
			<input type="hidden" id="dirId" value="<c:if test='${empty dirId}'>0</c:if><c:if test='${!empty dirId}'>${dirId}</c:if>" />
			<h1 id="firstHeading" class="firstHeading">
				<div>
					<c:if test="${!empty username}">
						<a id="editContent" href="javascript:void(0);">编辑</a>
					</c:if>
					<c:if test="${docMap.DIRID ne 0}">
						<a class="back" href="javascript:;" onclick="window.history.go(-1);">返回</a>
					</c:if>
				</div>
				<span id="content_title">${docMap.TITLE}</span>
				<span style="font-size:12px;color:gray;">${docMap.DATE}</span>
			</h1>
			<div id="bodyContent" class="bodyContent">
				<div id="contents">${docMap.CONTENT}</div>
				<div class="visualClear"></div>
			</div>
		</div>
		<!-- /右侧内容 -->
		<!-- 左侧树菜单 -->
		<div id="mw-panel" class="noprint">
			<form class="searchform">
				<input type="text" name="search" placeholder="搜索关键字 " accesskey="s" class="searchform_text">
				<input type="submit" name="fulltext" value="搜索" title="搜索该文字的页面" class="searchform_btn">
			</form>
			<c:if test="${!empty username}">
				<a id="editTree" style="display:none;" title="管理目录" href="javascript:void(0);"></a>
			</c:if>
		</div>
		<!-- /左侧树菜单 -->
	</div>
</div>
<div class="bottomnav">
	<a onclick="document.getElementById('header').scrollIntoView(true);" href="javascript:;" title="回顶部" class="topbtn"></a>
</div>
<div id="loading"></div>
</body>
<html>