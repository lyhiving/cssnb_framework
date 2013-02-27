<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html> 
<html>
<head>
    <title>jqgrid测试</title>
    <meta charset="utf-8">
    <title>宁波市质量安全监管平台新版本</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <meta content="no-store" http-equiv="Cache-Control">
    <meta content="no-cache" http-equiv="Pragma">
    <meta content="0" http-equiv="Expires">
    <meta content="IE=edge, chrome=1" http-equiv="X-UA-Compatible">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <link href="${ctx}/resources/jquery-validation/1.9.0/validate.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/global/css/base.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/resources/global/css/icon.css" rel="stylesheet" type="text/css">
    <link href="/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="${ctx}/resources/global/css/template2.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/css/datatable1.css?v=1" />

    <link href="${ctx}/resources/jquery-ui/css/cssnb/jquery-ui-1.8.21.custom.css" media="screen" rel="stylesheet" type="text/css">

    <!--[if lt IE 9]>
    <script src="${ctx}/resources/global/js/html5.js"></script>
    <![endif]-->
    <!--[if lt IE 7]>
    <script src="${ctx}/resources/global/js/iepngfix_tilebg.js"></script>
    <![endif]-->

    <title>预告信息列表</title>
</head>
<body>
    <h1 id='banner'></h1>
    <div id="container" class="page">
        <form action="${ctx}/tbl/members/list" id="queryForm" method="post" name="queryForm">
            <table>
                <tbody style="text-align: center">
                    <tr>
                        <td align="right" width="50">职位：</td>
                        <td align="left" width="80"><input name="zw" size="15" type="text" value=""></td>
                        <td align="right" width="50">姓名：</td>
                        <td align="left" width="80"><input name="name" size="15" type="text" value=""></td>
                        <td align="left"><input name="Submit" type="submit" value="查询 "></td>
                        <td align="left"><input id="addForm" name="Search" type="button" value="添加"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>

    <div id='gridcontainer'  class="page" style="display: none">
        <form id="formoper" method="post" name="formoper">
            <table border="1" class="et1" id="mytab" style="" >
                <tr>
                    <th colspan="4" id="item"></th>
                </tr>
                <tr>
                    <td align="right" width="30%">姓名：</td>
                    <td align="left" colspan="3"><input id="name" name="name" style="width:100px" type="text" value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%">职位：</td>
                    <td align="left" colspan="3"><input id="zw" name="zw" style="width:100px" type="text" value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%">areaid：</td>
                    <td align="left" colspan="3"><input id="areaid" name="areaid" style="width:100px" type="text"value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%">depteid：</td>
                    <td><input id="depteid" name="depteid" style="width:100px" type="text" value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%">passwd：</td>
                    <td><input id="passwd" name="passwd" style="width:100px" type="text" value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%">keyno：</td>
                    <td><input id="keyno" name="keyno" style="width:100px" type="text" value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%">px：</td>
                    <td><input id="px" name="px" style="width:100px" type="text" value=""></td>
                </tr>
                <tr>
                    <td align="right" width="30%"><input class="submitform" id="submitform" name="Submit" type="button" value="确定"></td>
                    <td align="right" width="30%"><input id="hidForm" name="cancer" type="button" value="收起"></td>
                </tr>
            </table>
        </form>
    </div>

    <div id='msgbox' style='display: none' title=''></div>

    <div id="dt_example" class="page">
        <div id="container" style="text-align: center">
            
                <table class="dtable" id="example">
                    <thead>
                        <tr>
                            <th width="5%">编 号</th>
                            <th width="15%">姓 名</th>
                            <th width="15%">职 位</th>
                            <th width="20%">区域</th>
                            <th width="15%">部门</th>
                            <th width="15%">其他</th>
                            <th width="15%">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="member">
                        <tr>
                            <td>${member.id}</td>
                            <td>${member.name}</td>
                            <td>${member.zw}</td>
                            <td>${member.areaid}</td>
                            <td>${member.depteid}</td>
                            <td>${member.keyno }</td>
                            <td><input class="updateForm" type="button" value="更新"><input class="deleteForm" type=
                            "button" value="删除"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            
        </div>
    </div>
    <script src="${ctx}/resources/jquery/jquery-1.7.2.min.js"></script>
    <script src="${ctx}/resources/global/js/jquery.hoverIntent.js"></script>
    <script src="${ctx}/resources/jquery-ui/js/jquery-ui-1.8.21.custom.min.js" type='text/javascript'></script>
    <script src="${ctx}/resources/My97DatePicker/WdatePicker.js" type='text/javascript'></script>
    <script src="${ctx}/resources/global/js/jquery.form.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/resources/jquery-validation/1.9.0/jquery.validate.min.js"></script>
    <script src="${ctx}/resources/dataTable/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/dataTable/js/jquery.dataTables.pagination4.js" type="text/javascript"></script>
    <script src="${ctx}/resources/dataTable/js/jquery.dataTables.reloadajax.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
    var oTable=$("#example").dataTable({
    //  "bPaginate": true, //开关，是否显示分页器
    //  "bInfo": true,//开关，是否显示表格的一些信息
    //  "bFilter": true, //开关，是否启用客户端过滤器
    //  "sDom": "<>lfrtip<>",
    //  "bAutoWith": false,
    //  "bDeferRender": false,
        "bJQueryUI": true,
    //  "bLengthChange": true,//开关，是否显示每页大小的下拉框
        "bProcessing": true,
    //  "bScrollInfinite": false,
    //  "sScrollY": "800px", //是否开启垂直迁移转变，以及指定迁移转变区域大小，可设值：""disabled""，""2000px""
    //  "bSort": true, //开关，是否启用各列具有按列排序的功能
    //  "bSortClasses": true,
    //  "bStateSave": false, //开关，是否打开客户端状况记录功能。这个数据是记录在cookies中的，打开了这个记录后，即使刷新一次页面，或从头打开浏览器，之前的状况都是保存下来的-------当值为true时aoColumnDefs不克不及隐蔽列
    //  "sScrollX": "50％", //是否开启程度迁移转变，以及指定迁移转变区域大小，可设值：""disabled""，""2000％""
    //  "aaSorting": [[0, "asc"]],
    //    "aoColumnDefs": [{ "bVisible": false,"aTargets": [0]}],//隐蔽列
        "sDom": '<"top"rf>t<"bottom"ipl><"clear">',
   	    "bAutoWidth": false, //自适应宽度
        "sPaginationType": "four_button",
        "oLanguage": {
            "sProcessing": "正在加载中......",
            "sLengthMenu": "每页 _MENU_ 条记录",
            "sZeroRecords": "没有找到记录",
            "sEmptyTable": "表中无数据存在！",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoFiltered": "数据表中共为 _MAX_ 笔记录",
            "sSearch": "搜索",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            }
        },
        "aLengthMenu": [[10, 20, 50, -1], [10, 20, 50, "所有"]],
      //  "aaSorting": [[0, "desc"]],
        "fnRowCallback": function(nRow, aData, iDisplayIndex, iDisplayIndexFull){ 
            var index = iDisplayIndexFull + 1; 
            $('td:eq(0)', nRow).html(index); 
            return nRow;
         }
    });
    
    $("#addForm").on("click",function(){
        $("#gridcontainer").show();
        $("#item").html("");
        $("#item").html("信息添加");
        $("#id").val("");
        $("#name").val("");
        $("#zw").val("");
        $("#areaid").val("");
        $("#depteid").val("");
        $("#passwd").val("");
        $("#keyno").val("");
        $("#px").val("");
        $("#dt_example").hide();
    });
    $("#hidForm").on("click",function(){
        $("#mytab #id").remove();
        $("#gridcontainer").hide();
        $("#dt_example").show();
    });
    $("#example").on("click",".updateForm",function(){
        var aPos = oTable.fnGetPosition($(this).closest("td").get(0));
        var rowdata = oTable.fnGetData(aPos[0]);
        buirowIdx = aPos[0];
        var id=rowdata[0];
        $("#mytab").append("<tr><td style='display:none'><input id='id' name='id'/><\/td><\/tr>");
        $("#dt_example").hide();
        $("#gridcontainer").show();
        $("#item").html("");
        $("#item").html("信息修改");
        $("#name").val("");
        $("#zw").val("");
        $("#areaid").val("");
        $("#depteid").val("");
        $("#passwd").val("");
        $("#keyno").val("");
        $("#px").val("");
        $.post(
            "${ctx}/tbl/members/show",
            {"id":id},
            function(data){
                $("#id").val(data.id);
                $("#name").val(data.name);
                $("#zw").val(data.zw);
                $("#areaid").val(data.areaid);
                $("#depteid").val(data.depteid);
                $("#passwd").val(data.passwd);
                $("#keyno").val(data.keyno);
                $("#px").val(data.px);
            },
            "json"
        );
    });
    $("#example").on("click",".deleteForm",function(){
        var aPos = oTable.fnGetPosition($(this).closest("td").get(0));
        var rowdata = oTable.fnGetData(aPos[0]);
        var id=rowdata[0];
        if(confirm("继续删除")){
        	$.post(
            	"${ctx}/tbl/members/delete",
            	{"id":id},
            	function(data){
            		oTable.fnDeleteRow(aPos[0]);
            	},
            	"json"
        	);
        }
    });
    var buirowIdx = -1;
    /*$("#submitform").on("click",function(){
        var name=$("#name").val();
        var zw=$("#zw").val();
        var areaid=$("#areaid").val();
        var depteid=$("#depteid").val();
        var passwd=$("#passwd").val();
        var keyno=$("#keyno").val();
        var px=$("#px").val();
        if(name=="" || zw=="" || areaid=="" || depteid=="" || passwd=="" || keyno=="" || px==""){
            alert("信息未填完");
        }else{
        	var id=$("#id").val();
        	if(id!=null && id!=""){
            	var options = {
                	url:"${ctx}/tbl/members/form",
                	type:"post",
                	dataType:"json",
                	success: function(data) {
                		oTable.fnUpdate(data.name,buirowIdx,1);
                    	oTable.fnUpdate(data.zw,buirowIdx,2);
                    	oTable.fnUpdate(data.areaid,buirowIdx,3);
                    	oTable.fnUpdate(data.depteid,buirowIdx,4);
                    	oTable.fnUpdate(data.keyno,buirowIdx,5);
                    	alert("确定!");
            		} 
        		};
            	$('#formoper').ajaxSubmit(options);
            	return false;
        	}else{
        		var options = {
            		url:"${ctx}/tbl/members/form",
            		type:"post",
                	dataType:"json",
                	success: function(data) {
                    	oTable.fnAddData([data.id,data.name,data.zw,data.areaid,data.depteid,data.keyno, '<input value="更新" type="button" class="updateForm" /><input value="删除" type="button" class="deleteForm" />']);
                    	alert("确定!");
        			} 
    			};
        		$('#formoper').ajaxSubmit(options);
        		return false;       
        	}
    	}
    });
    */
    jQuery.validator.addMethod("stringCheck", function(value, element) { 
	     return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value); 
}, "只能包括中文");
jQuery.validator.addMethod("intCheck",function(value,elememt){
		 return this.optional(elememt) || /^[0-9]+$/.test(value);
},"只能是数字");
jQuery.validator.addMethod("passwdCheck",function(value,elememt){
		 return this.optional(elememt) || /^[A-Za-z0-9]+$/.test(value);
},"只能包括英文字母和数字");
$("#formoper").validate(
	{
		rules:{
			name:{
				required: true,
				stringCheck:true,
				/*remote: {
			          url:"{ctx}/tbl/members/check",
			          type:"post",
			          async:true,
			          dataType:"json",
			          dataFilter:function(data){ 
			        	data = jQuery.parseJSON( data );
			        	console.log(data)
			          	return data;}
			        }*/
				},
			zw:{
				required:true,
				stringCheck:true
				},
			areaid:{
				required:true,
				minlength:2,
				intCheck:true
				},
			depteid:{
				required:true,
				minlength:12,
				intCheck:true
				},
			passwd:{
				required:true,
				minlength:2,
				passwdCheck:true
				},
			keyno:{
				required: true,
				stringCheck:true
				},
			px:{
				required:true,
				intCheck:true
				}
			},
		messages:{
			name:{
				required:"不能为空!",
				stringCheck:"只能使用中文!",
//				remote:"用户已存在!"
				},
			zw:{
				required:"不能为空!",
				stringCheck:"只能使用中文!"
				},
			areaid:{
				required:"不能为空!",
				minlength:"字段过短!",
				intCheck:"只能用数字!"
				},
			depteid:{
				required:"不能为空!",
				minlength:"字段过短!",
				intCheck:"只能用数字!"
				},
			passwd:{
				required:"不能为空!",
				minlength:"字段过短!",
				passwdCheck:"只能包括英文字母和数字!"
				},
			keyno:{
				required:"不能为空!",
				stringCheck:"只能使用中文!"
				},
			px:{
				required:"不能为空!",
				intCheck:"只能用数字!"
				}
			},
		submitHandler: function(form) { 
			var id=$("#id").val();
			console.log(id);
			if(id!=null && id!=""){
				console.log(1);
				var options = {
						url:"${ctx}/tbl/members/form",
						type:"post",
						dataType:"json",
						success: function(data) {
						oTable.fnUpdate(data.name,buirowIdx,1);
						oTable.fnUpdate(data.zw,buirowIdx,2);
						oTable.fnUpdate(data.areaid,buirowIdx,3);
						oTable.fnUpdate(data.depteid,buirowIdx,4);
						oTable.fnUpdate(data.keyno,buirowIdx,5);
						alert("确定!");
					} };
				    $('#formoper').ajaxSubmit(options);
				    return false;
			}else{
				console.log(2);
			var options = {
						url:"${ctx}/tbl/members/form",
						type:"post",
						dataType:"json",
						success: function(data) {
						oTable.fnAddData([data.id,data.name,data.zw,data.areaid,data.depteid,data.keyno, '<input value="更新" type="button" class="updateForm" /><input value="删除" type="button" class="deleteForm" />']);
						alert("确定!");
			} };
		    $('#formoper').ajaxSubmit(options);
		    return false;	    
			}
		}
	});
});

</script>
</body>
</html>