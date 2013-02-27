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
#wrap{min-width:800px;}
#top{margin:5px 0px;}
#top .btn{width:70px;height:50px;margin-left:3px;border-shadow:4px;box-shadow:0px 0px 0px 2px #eeeeee;}
#bottom{background-color:#FFFFFF;border-top:1px solid #cccccc;height:auto;}
#left{width:20%;height:auto;float:left;position:relative;z-index:1;overflow-x:hidden;overflow-y:auto;margin:0px;padding:5px;border-right:1px solid #cccccc;background-color:#eeeeee;}
#right{width:80%;height:auto;float:right;position:relative;z-index:3;margin:0px;padding:2px;}
.switch_arrow{position:fixed;z-index:1111;;top:50%;margin-top:-23px;display:block;width:9px;height:46px;background:url(${ctx}/resources/global/images/switch_arrow.png) 0 0 no-repeat;cursor:pointer;}
.switch_arrow:hover{background-position:-14px 0px;}
.arrow_hidden{background-position:-28px 0px;}
.arrow_hidden:hover{background-position:-42px 0px;}
</style>
</head>
<body style="margin:0px;padding:0px;">
<div id="wrap" class="container-fluid">
	<div id="top" class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<button class="btn btn-warning" id="p1" serverPath="http://localhost:8012:/p1">子项目01</button>
				<button class="btn btn-warning">子项目02</button>
				<button class="btn btn-warning">子项目03</button>
				<button class="btn btn-warning">子项目04</button>
				<button class="btn btn-warning">子项目05</button>
				<button class="btn btn-warning">子项目06</button>
				<button class="btn btn-warning">子项目07</button>
				<button class="btn btn-warning">子项目08</button>
				<button class="btn btn-warning">子项目09</button>
				<button class="btn btn-warning">子项目10</button>
				<button class="btn btn-warning">子项目11</button>
				<button class="btn btn-warning">子项目12</button>
			</div>
		</div>
	</div>
	<div id="bottom" class="row-fluid">
		<a class="switch_arrow" title="收缩"></a>
		<div id="left" class="span2">
			<ul id="ztree" class="ztree"></ul>
		</div>
		<div id="right" class="span10">
			<rapid:block name="main">
				<iframe id="mainFrame" name="mainFrame" src="${ctx}/rapid/2" frameborder="0" scrolling="no" width="100%"></iframe>
			</rapid:block>
		</div>
	</div>
</div>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery-ui/js/jquery-ui-1.8.21.custom.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/JQuery.zTree-v3.5.02/js/jquery.ztree.core-3.5.min.js"></script>
<!-- <script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script> -->
<script>
var setting = {
	data: {
		key:{
			url: 'URL',
			name: 'NAME'
		},
		simpleData:{
			enable: true,
			idKey: 'NODE',
			pIdKey: 'PID',
			rootPId: '000'
		}
	}
};
//重设iframe高度
function resizeIframe(height){
	if(height){
		$("#mainFrame").height(height);
	}else{
		$("#mainFrame").height(
			$("#bottom").height()
			- $("#right").css("paddingTop").replace("px", "")
			- $("#right").css("paddingBottom").replace("px", "")
		);
	}
}
var zTreeAPI, target_serverPath;
function jsonpcallback(data){
	if(data){
		for(var i = 0; i < data.length; i++){
			if(data[i].URL == "#"){
				data[i].isParent = true;
				delete data[i].URL;
			}else{
				data[i].target = "_self";
				data[i].URL = target_serverPath + data[i].URL;
			}
			data[i].target = "mainFrame";
		}
		// 初始化树
		treeAPI = $.fn.zTree.init($("#ztree"), setting, data);
		// 如果树的高度大于窗口高度
		if($("#ztree").height() > $(window).height()){
			$("html,body").css("scrollTop", 0);
			resizeIframe();
		}
	}
}
$(function(){
	// 左右拉伸
	$("#left").resizable({
		//ghost: true, // 克隆复制移动
		handles: "e",
		/* minWidth: 100,
		maxWidth: $(window).width() * 0.15, */
		resize: function(event, element){
			$("#right").css("width", document.body.clientWidth - $("#left").width() - (window.scrollbars.visible ? 13 : 0));
		}
	});
	// 左侧菜单收起展开
	$(".switch_arrow").css("left", $("#left").width() + $(".switch_arrow").width() + 1).click(function(){
		var $this = $(this);
		if($("#left").is(":visible")){
			$("#left").hide();
			$this.attr("title", "展开").hide().css("left", 0).addClass("arrow_hidden");
			$("#right").data("lastWidth", $("#right").width()).animate({"width": "100%"}, 200, function(){
				$this.show();
			});
		}else{
			$("#right").animate({"width": $("#right").data("lastWidth")}, {
				duration: 200,
				complete: function(){
					$("#left, .switch_arrow").show();
				}
			});
			$this.attr("title", "展开").hide().css("left", $("#left").width() + $this.width() + 1).removeClass("arrow_hidden");
		}
	});
	// 初始化页面高度
	var _height = $(window).height() - $("#top").height() - $("#top").css("marginTop").replace("px", "") - $("#top").css("marginBottom").replace("px", "") - 1;
	if($("#left").height() < _height){
		$("#left").css("min-height", _height);
	}
	// 重设iframe高度
	resizeIframe();
	// 项目点击（跨域），读取树
	$("#p1").click(function(e){
		if($("#ztree").data("p") != e.target.id){
			/* $("#ztree").data("p", e.target.id);
			target_serverPath = $(this).attr("serverPath");
			$.ajax({
				type: "get",		//使用get方法访问后台
				dataType: "jsonp",	//返回json格式的数据
				jsonp: "jsonpcallback",
				url: "http://localhost:8012/p1/ztree/getQxList_jsonp?callback=jsonpcallback",	//要访问的后台地址
				data: {},
				async: true,
				complete: function(e){
					// alert("完成！");
					alert(1);
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					alert(2);
					if(XMLHttpRequest.status == 404){
						alert("页面不存在，访问出错！");
					}
				}
			}); */
		}
	});
});
</script>
</body>
<html>