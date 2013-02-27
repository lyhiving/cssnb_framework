<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>jqgrid测试</title>
	<meta charset="utf-8">
	<title>宁波市质量安全监管平台新版本</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="${ctx}/resources/jquery-validation/1.9.0/validate.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/global/css/base.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/global/css/icon.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/resources/superfish/css/superfish.css" type="text/css" rel="stylesheet" />
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	<!--[if lt IE 9]>
	<script src="${ctx}/resources/global/js/html5.js"></script>
	<![endif]-->
	<!--[if lt IE 7]>
	<script src="${ctx}/resources/global/js/iepngfix_tilebg.js"></script>
	<![endif]-->
	<script src="${ctx}/resources/jquery/jquery-1.7.2.min.js"></script>
	<script src="${ctx}/resources/global/js/jquery.hoverIntent.js"></script>
	
	<link href="${ctx}/resources/global/css/template2.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/jquery-ui/css/cssnb/jquery-ui-1.8.21.custom.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/jqgrid/css/ui.jqgrid.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/global/css/jqgrid-ext.css"/>
	<script type='text/javascript' src="${ctx}/resources/jquery-ui/js/jquery-ui-1.8.21.custom.min.js"/></script>
	<script type='text/javascript' src="${ctx}/resources/jqgrid/js/grid.locale-cn.js"></script>
	<script type='text/javascript' src="${ctx}/resources/jqgrid/js/jquery.jqGrid.min.js"></script>
	<script type='text/javascript' src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>
	<title>预告信息列表</title>	
	
	<script type='text/javascript'>
	$(function() {
		$("#grid").jqGrid({
		   	url:'${ctx}/yfive/yg/list2',
			datatype: 'json',
			mtype: 'post',
		   	colNames:['预告id','文件', '标题', '类型', '发布单位', '发布日期'],
		   	colModel:[
		   		{name:'yginfoId',index:'yginfoId', width:55,hidden:true},
		   		{name:'yginfoFs',index:'yginfoFs', width:55,hidden:true},
		   		{name:'yginfoTitle',index:'yginfoTitle',formatter:function(cellvalue, options, rowObject){return "<a href='${ctx}/public/download/"+rowObject.yginfoFs+"' title='"+cellvalue+"'>" + cellvalue + "</a>";}},
		   		{name:'yginfoType',index:'yginfoType',width:'15%',align:'center'},
		   		{name:'yginfoDw',index:'yginfoDw', width:'15%',align:'center'},
		   		{name:'yginfoKssj',index:'yginfoKssj',width:'15%',align:'center'}
		   	],
		   	//postData: $("#queryForm").serialize(),
			rowNum:10,
		   	rowList:[10,20,50,100],
		   	height: "auto",
		   	autowidth: true,
			rownumbers: true,
		   	pager: '#pager',
		   	sortname: 'yginfo_kssj',
		    viewrecords: true,
		    sortorder: "desc",
		    //caption:"重要预告信息",
		    emptyrecords: "无记录",
		    loadonce: false,
		    loadComplete: function() {
		    	//加载完毕后
		    },
		    jsonReader : {
		        root: "rows",
		        page: "page",
		        total: "total",
		        records: "records",
		        repeatitems: false,
		        cell: "cell",
		        id: "id"
		    }
		});

		$("#grid").jqGrid('navGrid','#pager',
				{edit:false, add:false, del:false, search:true},
				{}, {}, {}, 
				{ 	// search
					sopt:['cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew'],
					closeOnEscape: true, 
					//multipleSearch: true, 
					closeAfterSearch: true
				}
		);
		
		$.fn.serializeObject = function() {
		    var o = {};
		    var a = this.serializeArray();
		    $.each(a, function() {
		        if (o[this.name]) {
		            if (!o[this.name].push) {
		                o[this.name] = [ o[this.name] ];
		            }
		            o[this.name].push(this.value || '');
		        } else {
		            o[this.name] = this.value || '';
		        }
		    });
		    return o;
		}
		// Toolbar Search
		//$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
	});
	
	$(window).bind('resize', function() {

	    // Get width of parent container
	    var width = $("#gridcontainer").prop('clientWidth');
	    if (width == null || width < 1){
	        // For IE, revert to offsetWidth if necessary
	        width = $("#gridcontainer").prop('offsetWidth');
	    }
	    width = width - 2; // Fudge factor to prevent horizontal scrollbars
	    if (width > 0 &&
	        // Only resize if new width exceeds a minimal threshold
	        // Fixes IE issue with in-place resizing when mousing-over frame bars
	        Math.abs(width - $("#grid").width()) > 5)
	    {
	        $("#grid").setGridWidth(width);
	    }

	}).trigger('resize');
	
	function queryInfo() {
		var postData = $("#grid").jqGrid('getGridParam','postData');
		var formarray = $("form").serializeArray();
		var o = {};
		$.each(formarray,function(i,n){
			o[this.name] = this.value || '';
		});
		o['records'] = $("#grid").jqGrid('getGridParam','records');
		$.extend(postData,o);
		$("#grid").setGridParam({search: true,page:1,postData:postData}).trigger('reloadGrid',[{page:1}]);
		//postData = $("#grid").jqGrid('getGridParam','postData');
	}
	</script>
</head>

<body>
	<h1 id='banner'></h1>
	<div>
	<form id="queryForm" method="post" action="${ctx}/yfive/yg/list2">
  <table>  
  <tbody><tr>
    <td align="right" width="50">标题：</td>  
    <td align="left" width="80"><input name="title" value="" size="15" type="text"></td>  
    <td align="right" width="60">类型：</td>  
    <td align="left" width="80"><select name="type">
  		<option value="" selected="selected">请选择预告类型</option>
  		<option value="食品">食品</option>
  		<option value="安全类">安全类</option>
  		<option value="计量">计量</option>
  		<option value="特种设备">特种设备</option>
  		<option value="综合">综合</option>
		</select></td>  
    <td align="right" width="70">发布单位：</td>  
    <td align="left" width="80"><input name="fbdw" value="" type="text"></td>  
    <td align="right" width="100">日期区间：</td>  
    <td align="left" width="80"><input name="kssj" value="" style="width:100%" onclick="WdatePicker()" readonly="readonly" type="text"></td>  
    <td align="center" width="10">至</td>  
    <td align="left" width="80"><input name="jzsj" value="" style="width:100%" onclick="WdatePicker()" readonly="readonly" type="text"></td>  
    <td align="left"><input name="Submit" value=" 查询 " onclick="queryInfo()" type="button"></td>  
	</tr>
	</tbody>
	</table>
	</form>			
	</div>
	<div id='gridcontainer' style="width:80%;padding:20px;margin:0 auto;">
		<div class="grid-title">
			<strong>质量安全预告信息</strong>
		</div>
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
	<div id='msgbox' title='' style='display:none'></div>
</body>
</html>