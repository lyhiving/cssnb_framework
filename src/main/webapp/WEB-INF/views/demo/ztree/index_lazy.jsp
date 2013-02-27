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
<script type="text/javascript" src="${ctx}/resources/JQuery.zTree-v3.5.02/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
var setting = {
	async: {
		enable: true,
		url: "${ctx}/ztree/getTreeListByPID",
		autoParam: ["NODE", "NAME"],
		dataFilter: function(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i = 0; i < childNodes.length; i++) {
				childNodes[i].target = "_self";
			}
			return childNodes;
		}
	},
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
	},
	callback:{
		// 异步刷新节点
		beforeExpand: function(treeId, treeNode){
			if(!treeNode.children){
				$.getJSON("${ctx}/ztree/getTreeListByPID", {PID: treeNode.NODE}, function(data){
					if(data){
						convertData(data);
						treeAPI.addNodes(treeNode, data);
						treeNode.children = data;
					}
				})
			}
		}
	}
};
var treeAPI;
// 转换数据，如遇#删除，否则target=_self;
function convertData(data){
	for(var i = 0; i < data.length; i++){
		if(data[i].URL == "#"){
			data[i].isParent = true;
			delete data[i].URL;
		}else{
			data[i].target = "_self";
		}
	}
}
$(function(){
	// 首次加载第一层模块数据
	$.getJSON("${ctx}/ztree/getTreeListFirst", function(data){
		if(data){
			convertData(data);
			treeAPI = $.fn.zTree.init($("#ztree"), setting, data);
		}
	})
});
</script>
</head>
<body style="margin:0px;padding:0px;">
<a href="./index" style="position:absolute;top:10px;right:100px;">一次性加载ztree示例页面</a>
<ul id="ztree" class="ztree"></ul>
</body>
<html>