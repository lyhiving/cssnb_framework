<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/common/pageSet.jsp" %>
<%@ taglib uri="http://www.ecside.org" prefix="ec" %>
<html>
<head>
<title>系统用户操作记录</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" type="text/css"href="${ctx}/components/ecside/css/ecside.css">
<script type="text/javascript" src="${ctx}/components/ecside/js/prototype_mini.js"></script>
<script type="text/javascript" src="${ctx}/components/ecside/js/ecside_msg_utf8_cn.js"></script>
<script type="text/javascript" src="${ctx}/components/ecside/js/ecside.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.min.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function(){
	$("#if1").height($(window).height()).width($(window).width());
	$("a:not([d])").click(function(){
		parent.showDetail($(this).attr("url"));
	});
});
</script>
</head>
<body style="padding:0px;margin:0px;">
<ec:table items="monitorList" var="monitor" retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
action="${ctx}/monitor.shtml?dispatch=getMonitorList" method="post" width="100%" listWidth="100%" classic="true"
pageSizeList="10,20,50,100" rowsDisplayed="10" sortable="true" filterable="true" useAjax="false">
	<ec:row>
		<ec:column width="3%" property="_0" title="序号" value="${GLOBALROWCOUNT}" filterable="false" sortable="false" />
		<ec:column property="YHMC" title="用户名" sortable="false" />
		<ec:column property="BMMC" title="部门名称" sortable="false" />
		<ec:column property="LM" title="访问模块" sortable="false" />
		<ec:column property="FFM" title="方法名" sortable="false" />
		<ec:column property="URLZWM" title="URL中文名" sortable="false" />
		<ec:column property="CZSJ" title="操作时间" sortable="false" />
		<ec:column property="_1" title="操作" filterable="false" sortable="false">
			<a url="${ctx}/monitor.shtml?dispatch=getMonitorDetail&BH=${monitor.BH}" href="javascript:void(0);">查看详情</a>
		</ec:column>
	</ec:row>
</ec:table>
</body>
</html>