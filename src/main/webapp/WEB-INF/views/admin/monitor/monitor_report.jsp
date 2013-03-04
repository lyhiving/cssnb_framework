<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/common/pageSet.jsp" %>
<%@ taglib uri="http://www.ecside.org" prefix="ec" %>
<html>
<head>
<title>用户操作统计报表</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" type="text/css"href="${ctx}/components/ecside/css/ecside.css">
<script type="text/javascript" src="${ctx}/components/ecside/js/prototype_mini.js"></script>
<script type="text/javascript" src="${ctx}/components/ecside/js/ecside_msg_utf8_cn.js"></script>
<script type="text/javascript" src="${ctx}/components/ecside/js/ecside.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">
$(function(){
	var total = $("#ec_table_foot tr td:last").text();
	$("#ec_table_body tr").each(function(i){
		var td3 = $(this).find("td:eq(2)");
		var val = td3.text();
		var rater = $('<div class="rater" style="background-position: 0 ' + (-16 * i) + 'px;" title="' + val + '"></div>');
		td3.html("").append(rater);
		rater.animate({width: val / total * 100 + '%'}, 800);
	});
});
</script>
<style>
.rater{float:left;height:16px;background:url(${ctx}/sysimages/rater_bg.gif) repeat-x;}
</style>
</head>
<body>
<body style="padding:0px;margin:0px;overflow-x:auto;">
<div align="center" class="main_table_title">
	<div style="height: 5px;"></div>
	<font size="4">用户操作统计报表</font>
</div>
<ec:table items="reportList" var="monitor" retrieveRowsCallback="process" sortRowsCallback="process" filterRowsCallback="process"
action="${ctx}/monitor.shtml?dispatch=report" method="post" title="" width="100%" listWidth="100%" classic="true"
pageSizeList="10,20,50,100" rowsDisplayed="10" sortable="true" filterable="true" xlsFileName="用户操作统计报表.xls" useAjax="false">
	<ec:row>
		<ec:column width="50" property="_0" title="序号" value="${GLOBALROWCOUNT}" filterable="false" sortable="false" />
		<ec:column property="BMMC" width="200" title="部门名称" calcTitle="合计" calc="${reportSize}" sortable="false" />
		<ec:column property="_1" title="状态" sortable="false" value="${monitor.SL}"></ec:column>
		<ec:column property="SL" width="100" title="访问数量" calc="total" filterable="false" sortable="false" />
	</ec:row>
</ec:table>
</body>
</html>