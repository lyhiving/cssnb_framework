<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/common/pageSet.jsp" %>
<html>
<head>
<title>监控记录查看</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.min.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
jQuery.fn.extend({
	unselectable: function(){
		this.bind(($.support.selectstart ? "selectstart": "mousedown" ),function(e){e.preventDefault()});
		return this.each(function(){this.onselectstart = function(){return false;};});
	}
});
$(function(){
	$("#table_style td").attr("nowrap", "nowrap").css({"white-space": "nowrap"});
	$("td > div:empty").html("&nbsp;");
	$("textarea").each(function(){$(this).css("height", $(this).attr("scrollHeight"));});
	// 点击返回
	$("#btnBack").click(function(){
		window.parent.hideDetail();
	});
});
</script>
</head>
<body>
<div id="mainDiv">
	<table id="table_style" width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td class="table_title" colspan="4">监控记录查看</td>
		</tr>
		<tr>
			<td align="right" width="10%">用户名：</td><td width="40%">${monitorMap.YHMC}</td>
			<td align="right" width="9%">用户部门：</td><td width="40%">${monitorMap.BMMC}</td>
		</tr>
		<tr>
			<td align="right">IP地址：</td><td>${monitorMap.IP}</td>
			<td align="right">MAC地址：</td><td>${monitorMap.MAC}</td>
		</tr>
		<tr>
			<td align="right">访问模块：</td><td>${monitorMap.LM}</td>
			<td align="right">调用方法名：</td><td>${monitorMap.FFM}</td>
		</tr>
		<tr>
			<td align="right">访问地址：</td><td>${monitorMap.URL}</td>
			<td align="right">访问URL中文名：</td><td>${monitorMap.URLZWM}</td>
		</tr>
		<tr>
			<td align="right">数据权限：</td><td colspan="3">${monitorMap.BZ}</td>
		</tr>
		<tr>
			<td align="right">操作时间：</td><td colspan="3">${monitorMap.CZSJ}</td>
		</tr>
		<tr>
			<td class="textarea_label">参数列表：</td>
			<td colspan="3" style="padding:0px;">
				<textarea id="CS" name="CS" class="textarea" readonly="readonly">${monitorMap.CS }</textarea>
			</td>
		</tr>
	</table>
	<div align="center" style="margin-top:5px;">
		<input type="button" id="btnBack" class="button1" value="返回">
	</div>
</div>
</body>
</html>