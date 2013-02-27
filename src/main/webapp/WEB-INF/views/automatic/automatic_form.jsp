<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.util.*,java.lang.reflect.Field"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- ********************page begin******************** --%>
<html>
<head>
<title>添加</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/dataTable/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/global/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/dataTable/js/jquery.dataTables.pagination4.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/dataTable/js/jquery.dataTables.reloadajax.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/jquery-validation/1.9.0/jquery.validate.min.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/global/js/query.htmlcode-1.0.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/resources/global/js/jquery.hoverIntent.js"></script>	
<script type="text/javascript" language="javascript">
$(document).ready(function() {
	/*$.post(
		"${ctx}/tbl/members/show",
		function(data){
			input.jQuery("<option>"+data[i]+"</option>");
			$(".fields").append("<option>"+data[]+"</option>");
		},
		"json"
	);*/
	var i=0;
	$("#html").change(function(){
		var value = $("#html").val();
		console.log(value);
		if(value=="1"){
			$("#type").remove();
			$("#selectoption").empty();
			$("#optionadd").hide();
			$("#empty").append("<select id='type' name='type'></select>");
			$("#type").append("<option>checkbox</option>").append("<option>radio</option>").append("<option selected>text</option>").append("<option>button</option>").append("<option>submit</option>");   
		}else if(value=="2"){
			$("#type").remove();
			$("#selectoption").empty();
			$("#optionadd").show();
//			$("#selectoption").append("<input type='test' value='下拉框内容填写' id='id"+i+"'>");
		}else{
			console.log(value);
			$("#optionadd").hide();
			$("#type").remove();
			$("#selectoption").empty();
		}
	});
	$("#addoption").click(function(){
		i++;
		$("#selectoption").append("<br/><input type='test' value='下拉框内容填写' id='id"+i+"'>");
		console.log(i);
	});
	$("#name1").change(function(){
		var name=$("#name1").val();
		$("#zdmz").val(name);
	});
	$("#submitForm").click(function(){
		var name=$("#name1").val();
		var sx=$("#type").val();
		var zdmz=$("#zdmz").val();
		var ys=$("#html").val();
		if(name!=null && name!=''){
			if(ys=="1"){
				if(sx=="checkbox"){
					$("#formdiv").append("<lable for='"+name+"'>"+zdmz+"</lable>").append("<input id='"+name+"' name='"+name+"' type='checkbox'/>");
	//				$("#htmldiv").text("<lable for='"+name+"'>"+zdmz+"</lable><input id='"+name+"' name='"+name+"' type='checkbox'/>");
				}else if(sx=="radio"){
					$("#formdiv").append("<lable for='"+name+"'>"+zdmz+"</lable>").append("<input id='"+name+"' name='"+name+"' type='radio'/>");
	//				$("htmldiv").text("<lable for='"+name+"'>"+zdmz+"</lable><input id='"+name+"' name='"+name+"' type='radio'/>")
				}else if(sx=="text"){
					$("#formdiv").append("<br/><lable for='"+name+"'>"+zdmz+"</lable>").append("<input id='"+name+"' name='"+name+"' type='test'/><br/>");
					$("#htmldiv").text("<br/><lable for='"+name+"'>"+zdmz+"</lable><input id='"+name+"' name='"+name+"' type='test'/><br/>");
				}else if(sx=="button"){
					$("#formdiv").append("<br/><lable for='"+name+"'></lable>").append("<input id='"+name+"' name='"+name+"' type='button' value='"+zdmz+"'/><br/>");
	//				$("#htmldiv").text("<br/><lable for='"+name+"'></lable><input id='"+name+"' name='"+name+"' type='button' value='"+zdmz+"'/><br/>");
				}else if(sx=="submit"){
					$("#formdiv").append("<br/><lable for='"+name+"'></lable>").append("<input id='"+name+"' name='"+name+"' type='submit' value='"+zdmz+"'/><br/>");
	//				$("#htmldiv").text("<br/><lable for='"+name+"'></lable><input id='"+name+"' name='"+name+"' type='submit' value='"+zdmz+"'/><br/>");
				}				
			}else if(ys=="2"){
				$("#formdiv").append("<br/><lable for='"+name+"'>"+zdmz+"</lable>").append("<select id='"+name+"' name='"+name+"'></select><br/>");
				for(j=1;j<=i;j++){
					var value=$("#id"+j).val();
					$("#"+name).append("<option value='"+j+"'>"+value+"</option>");
				}
			}else if(ys=="3"){
				$("#formdiv").append("<br/><lable for='"+name+"'>"+zdmz+"</lable>").append("<textarea id='"+name+"' name='"+name+"'/><br/>");
			}
		}
		i=0;
		$("#selectoption").empty();
		$("#htmldiv").text($("#formdiv").html());
	});
	$("#htmldiv").hover(makeTall,makeShort);
	function makeTall(){ $(this).animate({"width":450});}
	function makeShort(){ $(this).animate({"width":400});} 
//	$("#mytab").htmlcode($("#htmldiv"));
});
</script>
<style>
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
</style>
</head>
<style>
.auto_hidden {
	width: 204px;
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	border-left: 1px solid #333;
	border-right: 1px solid #333;
	position: absolute;
	display: none;
}

.auto_show {
	width: 204px;
	text-align: left;
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	border-left: 1px solid #333;
	border-right: 1px solid #333;
	position: absolute;
	z-index: 99999; /* 设置对象的层叠顺序 */
	display: block;
}

.auto_onmouseover {
	color: #ffffff;
	background-color: highlight;
	width: 100%;
}

.auto_onmouseout {
	color: #000000;
	width: 100%;
	background-color: #ffffff;
}
</style>
<body>
	<form id="formoper" action="${ctx}/tbl/members/add" method="post">

		<table style="" width="60%" id="mytab" class="et1" align="center">
			<th colspan="4">自动生成表单</th>
			<tr>
				<td align="center" width="30%"><select id="name1" name="name1"
					class="fields">
						<c:forEach items="${fields }" var="data">
							<option>${data.name }</option>
						</c:forEach>
				</select></td>
				<td align="center" colspan="3">字段名<input type="text" id="zdmz"
					name="name" style="width: 100px" value="${fields[0].name }"></td>
				<td align="center" colspan="3">元素 <select id="html" name="html">
						<option value="4" selected></option>
						<option value="1">input</option>
						<option value="2">select</option>
						<option value="3">textarea</option>
				</select>
				</td>
				<td align="center" colspan="3" id="empty"><select id="type"
					style="display: none"></select></td>
				<td align="center" colspan="3"><input type="button" value="提交"
					id="submitForm"></td>
				<td align="center" colspan="3" id="optionadd" style="display:none"><input type="button" value="添加下拉框内容"
					id="addoption"></td>
			</tr>
		</table>
		<div id="selectoption" align="center">
				</div>
		<div style="width:40%; border: 1px solid rgb(85, 85, 85);float:left">
		<div id="htmldiv"></div>
		</div>
		<div align="left" style="width:40%;float:left;border: 1px solid rgb(85, 85, 85);" >
		<div id="formdiv"></div>
		</div>
		
	</form>
</body>
</html>