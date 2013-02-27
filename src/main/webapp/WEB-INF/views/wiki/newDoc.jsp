<%@ page language="java" contentType="text/html;  charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.8.1.min.js"></script>
<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" type="text/css">
<script charset="utf-8" src="${ctx}/resources/kindeditor-4.1.5/kindeditor.js"></script>
<script>
var editor, totalWords = 5000;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		resizeType: 0,
		cssPath : '${ctx}/resources/kindeditor-4.1.5/plugins/code/prettify.css',
		urlType : 'absolute',
		newlineTag: 'br',
		items : [
			'source', 'undo', 'redo', 'wordpaste', 'preview', 'print',
			'|', 'fontname', 'fontsize', 'formatblock', 'lineheight',
			'|', 'code', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'removeformat',
			'|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'table', 'hr', 'template', //'anchor',
			'|', 'emoticons', 'baidumap', 'image', 'link', 'unlink', '|', 'fullscreen'
		],
		afterChange : function() {
			$('.words b').text(totalWords - this.count());
		}/* ,
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['form'].submit();
			});
			K.ctrl(self.edit.doc, 13, function() {
				self.sync();
				document.forms['form'].submit();
			});
		} */
	});
});
function checkForm(){
	/* if(!$("#dir").val()){
		alert("请选择目录！");
		$("#dir").focus();
		return false;
	}else  */
	if(!$("#title").val()){
		alert("请填写标题！");
		$("#title").focus();
		return false;
	}
	/* else if(editor.isEmpty()){
		alert("文档不可以为空，请认真书写！");
		editor.focus();
		return false;
	} */
	return true;
}
function htmlspecialchars(str) {
	str = str.replace(/&/g, '&amp;');
	str = str.replace(/</g, '&lt;');
	str = str.replace(/>/g, '&gt;');
	str = str.replace(/\"/g, '&quot;');
	return str;
}
$(function(){
	var $tr = $(".table tr:not(#content_tr)");
	$("#content").css({
		width: $(window).width() - 2,
		height: $(window).height() - $tr.length * ($tr.height() - 1) - 14
	});
	$("#btnSubmit").click(function(){
		if(checkForm()){
			$("#content").val(editor.html().replace("	", ""));
			$("#form").attr("action", $("#cid").val() ? "${ctx}/wiki/updNewDoc" : "${ctx}/wiki/addNewDoc")
			$("#form").submit();
		}
		// editor.isEmpty()
		// editor.text()
		// editor.html()
		// editor.selectedHtml()
		// editor.html('<h3>Hello KindEditor</h3>');
		// editor.text('<h3>Hello KindEditor</h3>');
		// editor.insertHtml('<strong>插入HTML</strong>');
		// editor.appendHtml('<strong>添加HTML</strong>');
	});
	$("#btnBack").click(function(){
		window.history.go(-1);
	});
})
</script>
<style>
body,form,.table{padding:0px;margin:0px;}
.table th, .table td{line-height:28px;}
.table th{text-align:center;font-size:20px;}
.ke-button-common{vertical-align:10px;}
.words b{color:red;}
</style>
</head>
<body>
<form id="form" name="form" method="post" class="form-horizontal" action="${ctx}/wiki/addNewDoc" onsubmit="return checkForm()">
<input type="hidden" id="dirId" name="dirId" value="${pMap.dirId}"/>
<input type="hidden" id="cid" name="cid" value="${docMap.Cid}"/>
<table class="table table-hover">
	<tr style="background-color:#eeeeee;display:none;">
		<th colspan="2">发表新文章</th>
	</tr>
	<tr>
		<%-- <td width="220">
			<select id="dir" name="dir">
				<option value="">选择内容目录</option>
				<c:forEach items="${dirList}" var="dir">
					<c:if test="${empty dir.Url}"><optgroup label="项目简介"></optgroup></c:if>
					<c:if test="${!empty dir.Url}"><option value="${dir.DirId}">　${dir.DirName}</option></c:if>
				</c:forEach>
			</select>
		</td> --%>
		<td>标题：</td>
		<td><input type="text" id="title" name="title" class="span10" placeHolder="请输入标题" value="${docMap.Title}" /></td>
	</tr>
	<tr id="content_tr">
		<td colspan="2" style="padding:0px;border:0px;" align="center">
			<textarea id="content" name="content" style="overflow:hidden;">${docMap.Content}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input id="btnSubmit" type="button" value="提交内容" class="btn btn-success" />
			<span>(提交快捷键: Ctrl + Enter)</span>
			<span class="words">还可以输入<b>2500</b>个字</span>
			<input id="btnBack" type="button" value="返回" class="btn btn-success" />
		</td>
	</tr>
</table>
</form>
</body>
<html>