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
var tree_data = [
	{NODE: 1, PID: 0, NAME: '树'},
	{NODE: 2, PID: 1, NAME: '一次性加载', URL: '${ctx}/ztree/index'},
	{NODE: 2, PID: 1, NAME: '异步加载', URL: '${ctx}/ztree/index_lazy'},
	{NODE: 3, PID: 0, NAME: 'ajaxUpload', URL: '${ctx}/ajaxUpload/index'},
	{NODE: 4, PID: 0, NAME: '表格'},
	{NODE: 5, PID: 4, NAME: '表格', URL: '${ctx}/table/index'},
	{NODE: 6, PID: 4, NAME: '表格', URL: '${ctx}/table/ajax'}
];
$(function(){
	for(var i = 0; i < tree_data.length; i++){
		tree_data[i].target = "_self";
	}
	$.fn.zTree.init($("#tree"), setting, tree_data);
});
</script>
</head>
<body style="margin:0px;padding:0px;">
	<ul id="tree" class="ztree"></ul>
</body>
<html>