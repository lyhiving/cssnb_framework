<%@ page language="java" contentType="text/html;  charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>目录管理页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${ctx}/resources/global/css/jquery-ui-1.7.2.custom.css" type="text/css">
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<script>
function getCol(isPk){return isPk ? $("<td></td>") : $("<td><span></span><input value=\"\" /></td>");}
/**
 * 序列化行数据
 */
function serializeRow(_tr_){
	var params = "";
	if(_tr_){
		params = {
			tag: _tr_.attr("tag"),
			dirId: _tr_.find("td:eq(0)").text(),
			pid: _tr_.find(":text:eq(0)").val(),
			dirName: _tr_.find(":text:eq(1)").val(),
			order: _tr_.find(":text:eq(2)").val(),
			icon: _tr_.find(":text:eq(3)").val()
		}
	}
	return params ? params : null;
}
//刷新排序号码
function refreshOrder(_tr_){
	if(_tr_){
		var this_order = _tr_.find(":text:eq(2)");
		var this_pid = _tr_.find(":text:eq(1)").text();
		this_order.val($(".table").find(":text[val=" + this_pid + "]").length + 1);
	}
}
// 检查录入数据
function checkRow(_tr_){
	if(_tr_){
		if(!_tr_.find(":text:eq(0)").val()){return false;}
		else if(!_tr_.find(":text:eq(1)").val()){return false;}
		else if(!_tr_.find(":text:eq(2)").val()){return false;}
		return true;
	}
	return false;
}
$(function(){
var _tr,_tr2;
	// 行点击
	$(".table tr:gt(1)").live("click", function(){
		// 修改行时，点击两次不同行，记录上一次被修改的行
		if(_tr && _tr.attr("tag")){_tr2 = _tr;}
		_tr = $(this);
		$(".table tr").removeClass("alert");
		$(this).addClass("alert");
	});
	// 添加行
	$(".add").click(function(){
		if($(".table").find(":text:visible").length){alert("请先保存当前行数据！");return;}
		var $tr = $("<tr></tr>").append(getCol(true)).append(getCol()).append(getCol()).append(getCol()).append(getCol());
		$(".table:eq(0)").append($tr.attr("tag", "add"));
		refreshOrder($tr);
		$tr.find(":text").show();
	});
	// 删除行
	$(".del").click(function(){
		if(!_tr){alert("请先选择一行！");return;}
		if(_tr.attr("tag") == "add"){_tr.remove();_tr = null;}else{
			if(confirm("确定删除改行数据吗？")){
				$(this).attr("disabled", "disabled");
				var dirId = _tr.find("td:first").text();
				$.getJSON("${ctx}/wiki/delDirById", {dirId: dirId}, function(res){
					if(res && res == 1){
						_tr.remove();
						_tr = null;
						$(this).removeAttr("disabled");
					}else{
						alert("删除失败！");
					}
				});
			}
		}
	});
	// 修改行
	$(".edit").click(function(){
		if(!_tr){alert("请先选择一行！");return;}
		if(_tr2){alert("亲，还有没有保存的数据哦！");return;}
		// TODO: 点击添加，应该禁用修改按钮，暂不处理
		if(_tr.attr("tag") != "upd"){
			_tr.attr("tag", "upd");
			_tr.find("td span").hide();
			_tr.find("td :text").show();
		}else{
			alert("该行尚未保存到数据库！");return;
		}
	});
	// 保存行
	$(".save").click(function(){
		if(!$(".table").find(":text:visible").length){
			alert("尚未发现可保存行！");
			return;
		}
		if(_tr2 && _tr2.attr("tag")){_tr = _tr2;}
		if(!checkRow(_tr)){
			alert("请补全数据！");
			return;
		}
		var tag = _tr.attr("tag"), dirId = _tr.find("td:first").text(), action = "${ctx}/wiki/" + (tag == "add" ? "addDir" : (tag == "upd" ? "updDirById" : ""));
		$.getJSON(action, serializeRow(_tr), function(res){
			if(res){
				if(res == 1){
					window.location.href = window.location.href;
				}
				// TODO: 更新行数据
			}else{
				alert("删除失败！");
			}
		});
	});
	// 返回文档页
	$(".back").click(function(){
		window.location.href = "${from}" || "http://localhost:8080/nbzjpt/wiki";
	});
});
</script>
<style>
#example{border:1px solid #eeeeee;border-collapse:collapse;}
#example th{text-align:center;}
#example th,#example td{height:20px;line-height:20px;padding:5px 0px;border:1px solid #eeeeee;text-align:center;}
#example .btn{width:80px;}
#example td input{display:none;width:90%;margin:0px;padding:5px 0px;text-indent:5px;}
.icon-plus,.icon-ok,.icon-edit,.icon-remove{margin:1px 4px;}
.table tbody + tbody{border-top:0px;}
</style>
</head>
<body>
<table id="example" class="table table-hover" cellpadding="0" cellspacing="0" border="0" width="100%" align="center">
	<tr>
		<td colspan="6" align="left">
			<button class="btn btn-success add" style="width:auto;height:28px;" title="添加一行"><b class="icon-plus icon-white"></b></button>
			<button class="btn btn-primary edit"><b class="icon-edit icon-white"></b>修改</button>
			<button class="btn btn-primary del"><b class="icon-remove icon-white"></b>删除</button>
			<button class="btn btn-primary save"><b class="icon-ok icon-white"></b>保存</button>
			<button class="btn btn-warning back"><b class="icon-ok icon-white"></b>返回</button>
		</td>
	</tr>
	<tr>
		<th width="8%">编号</th>
		<th width="8%">父级编号</th>
		<th width="40%">目录名称</th>
		<th width="8%">排序</th>
		<th>图标</th>
	</tr>
	<tbody>
	<c:forEach items="${dirList}" var="dir" varStatus="i">
		<tr>
			<td>${dir.DirId}</td>
			<td><span>${dir.Pid}</span><input value="${dir.Pid}" /></td>
			<td><span>${dir.DirName}</span><input value="${dir.DirName}" /></td>
			<td><span>${dir.Order}</span><input value="${dir.Order}" /></td>
			<td><span>${dir.Icon}</span><input value="${dir.Icon}" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
<html>