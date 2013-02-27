<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>宁波市质量安全监管业务平台</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/zjj2011.css"></link>
<style>
.layer_select_aqlb {
  background-color:rgba(255, 255, 255, 0.6);
  border: 1px solid #FFFFFF;
  border-radius: 3px 3px 3px 3px;
  line-height: 17px;
  padding: 6px 1px;
  position: absolute;
  right: 54px;
  top: 457px;
  width: 100px;
  z-index: 9999;
}
.layer_select_aqlb ul{
	margin: 0 4px;
	padding:0;
	list-style:none outside none;
}
.layer_select_aqlb li{
	color: #595959;
    line-height: 14px;
    padding: 5px 4px;
    list-style: none outside none;
}
.layer_select_aqlb div{
	text-align:center;
}
.layer_select_aqlb label{
	cursor: pointer;
}
.layer_select_aqlb input{
	vertical-align:middle;
	line-height:normal;
	margin-right:5px;
}
.layer_msgbox {
	position: absolute;
  	left: 50%;
  	top: 407px;
  	font-size:18px;
  	font-weight:bold;
 	color: white;
}


</style>
</head>
<body class="loginbody">
<div class="login_main dhmain">
<div class="dhnav dhnavc"></div>
<div class="dhnavb2">
	<a href="${ctx}/wiki" target="_blank">wiki系统</a>
	<a href="${ctx}/rapid/child" target="_blank">rapid演示</a>
	<a href="${ctx}/ztree/index" target="_blank">ztree演示</a>
	<a href="${ctx}/rapid/1" target="_blank">布局首页</a>
</div>
</div>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
var aqlb_all;
var curAqlb="${user_aqlb}";
var curAqlbmc="";
$(function(){
	$.getJSON('getAqlbList.action',{},function(data){
		if(data.res_code=='000'){
			var list = data.res_data;
			aqlb_all = list[0].id;
			$(".dhnavb2 a.aqlbclz").each(function(index,domEle){
				$(this).attr("id","aqlb_"+list[index+1].id);
			});
			$("a.aqlbclz").filter('[id=aqlb_${user_aqlb}]').addClass("selected");
		}
	});
	$(".aqlbclz").click(function(e){
		e.preventDefault();
		var selectedAqlb = $(this).attr("id").substring(5);
		if(selectedAqlb!=curAqlb){
			selectedContent = $(this).text();
			$(this).addClass("selected").siblings().removeClass("selected");
			$.post("setAqlb.action",{lb:selectedAqlb},function(data){
				curAqlb = selectedAqlb;
				$("#msgcontent").text("您选择了"+selectedContent);
				$(".layer_msgbox").stop().fadeIn().delay(3000).fadeOut();
			},'json');
		}else if(selectedAqlb==curAqlb){
			$(this).removeClass("selected");
			$.post("setAqlb.action",{lb:aqlb_all},function(data){
				curAqlb = aqlb_all;
				$("#msgcontent").text("您恢复查看所有类别");
				$(".layer_msgbox").stop().fadeIn().delay(3000).fadeOut();
			},'json');
		}
	});
});
</script>
</body>
</html>