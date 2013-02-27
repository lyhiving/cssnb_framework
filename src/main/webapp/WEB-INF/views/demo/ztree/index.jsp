<%@ page language="java" contentType="text/html;  charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<link rel="stylesheet" href="${ctx}/resources/JQuery.zTree-v3.5.02/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/resources/JQuery.zTree-v3.5.02/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript">
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
$(function(){
	$.getJSON("${ctx}/ztree/getQxList",{},function(data){
		if(data){
			for(var i = 0; i < data.length; i++){
				data[i].target = "_self";
			}
			$.fn.zTree.init($("#treeDemo"), setting, data);
		}
	});
});
</script>
</head>
<body style="margin:0px;padding:0px;">
<a href="./index_lazy" style="position:absolute;top:10px;right:100px;">异步加载ztree示例页面</a>
<ul id="treeDemo" class="ztree"></ul>
</body>
<html>