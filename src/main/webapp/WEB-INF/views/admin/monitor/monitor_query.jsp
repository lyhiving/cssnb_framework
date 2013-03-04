<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/common/pageSet.jsp" %>
<html>
<head>
<title>用户操作记录查询</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<script type="text/javascript" src="${ctx}/components/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">
// 显示列表页
function showList(url){
	$("#ifList").attr("src", url).show();
}
// 隐藏列表页（返回搜索）
function hideList(){
	$("#ifList").hide().removeAttr("src");
};
// 隐藏详细页（返回列表页）
function hideDetail(){
	$("#ifDetail").hide().removeAttr("src");
	$("#queryForm").show();
	$("#ifList").show()[0].contentWindow.ECSideUtil.reload('ec');
};
// 显示详细页
function showDetail(url){
	$("#queryForm, #ifList").hide();
	$("#ifDetail").attr("src", url).show();
};
$(function(){
	$(".Wdate").each(function(){this.onclick = function(){WdatePicker({readOnly: true, dateFmt:'yyyy-MM-dd HH:mm:ss'});};});
	$("#ifList").height($(window).height() - $("#queryForm").height());
	$("#ifDetail").height($(window).height()).width($(window).width());
	$("#btnQuery").click(function(){
		var url = "${ctx}/monitor.shtml?dispatch=getMonitorList" + "&" + $("#queryForm").serialize();
		showList(url);
	});
	$("#BMID").change(function(){
		$.getJSON("${ctx}/monitor.shtml?dispatch=getYhList", {BMID: $(this).val()}, function(res){
			$("#YHID").getOptions({
				data: res,
				value: "YHID",
				key: "YHMC"
			});
		});
	});
	$("#btnQuery").fireEvent('click');
});
</script>
<style>
.input01,.Wdate,select{min-width:180px;padding:0px;}
.input01{padding:2px 0px;}
</style>
</head>
<body style="padding:0px;margin:0px;overflow-x:hidden;">
<form id="queryForm" style="padding:0px;margin:0px;width:100%;">
	<table id="table_style" width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr>
			<td class="table_title" colspan="4">用户操作记录查询</td>
		</tr>
		<tr>
			<td align="right" width="15%">部门：</td>
			<td width="35%">
				<select id="BMID" name="BMID">
					<option value="">请选择...</option>
					<c:forEach items="${bmList}" var="bm">
					<option value="${bm.BM_DM}">${bm.BM_MC}</option>
					</c:forEach>
				</select>
			</td>
			<td align="right" width="15%">用户：</td><td width="35%"><select id="YHID" name="YHID" style="width:150px;">
				<optgroup label="请先选择部门"></optgroup>
			</select></td>
		</tr>
		<tr>
			<td align="right" width="15%">IP地址：</td><td width="35%"><input class="input01" id="IP" name="IP" /></td>
			<td align="right" width="15%">MAC地址：</td><td width="35%"><input class="input01" id="MAC" name="MAC" /></td>
		</tr>
		<tr>
			<td align="right" width="15%">访问地址：</td><td width="35%"><input class="input01" id="URL" name="URL" /></td>
			<td align="right" width="15%">访问类名：</td><td width="35%"><input class="input01" id="LM" name="LM" /></td>
		</tr>
		<tr>
			<td align="right">操作时间（起）：</td><td><input class="Wdate" id="CZSJQ" name="CZSJQ" /></td>
			<td align="right">操作时间（止）：</td><td><input class="Wdate" name="CZSJZ" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'CZSJQ\')}',maxDate:'2020-10-01', dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
		</tr>
	</table>
	<div align="center" style="margin-top:5px;">
		<input type="button" id="btnQuery" class="button1" value="查询">
		<input type="reset" id="btnReset" class="button1" value="重置">
	</div>
</form>
<iframe id="ifList" frameborder="0" style="display:none;position:relative;top:0px;left:0px;border:0px;width:100%;padding:0px;margin:0px;"></iframe>
<iframe id="ifDetail" frameborder="0" style="display:none;position:absolute;top:0px;left:0px;border:0px;width:100%;padding:0px;margin:0px;"></iframe>
</body>
</html>