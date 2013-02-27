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
	
	<script type='text/javascript' src="${ctx}/resources/jquery-ui/js/jquery-ui-1.8.21.custom.min.js"/></script>
	<script type='text/javascript' src="${ctx}/resources/jqgrid/js/grid.locale-cn.js"></script>
	<script type='text/javascript' src="${ctx}/resources/jqgrid/js/jquery.jqGrid.min.js"></script>
	
	<title>预告信息列表</title>
	
	<script type='text/javascript'>
	$(function() {
		$("#grid").jqGrid({
		   	url:'${ctx}/yfile/yg/list2',
			datatype: 'json',
			mtype: 'GET',
		   	colNames:['预告id', '标题', '类型', 'yginfoFs', '发布日期','yginfoCzy'],
		   	colModel:[
		   		{name:'yginfoId',index:'yginfoId', width:55,hidden:true},
		   		{name:'yginfoTitle',index:'yginfoTitle', width:100},
		   		{name:'yginfoType',index:'yginfoType', width:100,hidden:true},
		   		{name:'yginfoFs',index:'yginfoFs', width:100},
		   		{name:'yginfoKssj',index:'yginfoKssj',width:100},
		   		{name:'yginfoCzy',index:'yginfoCzy'}
		   	],
		   	postData: {},
			rowNum:10,
		   	rowList:[10,20,40,60],
		   	height: 240,
		   	autowidth: true,
			rownumbers: true,
		   	pager: '#pager',
		   	sortname: 'yginfo_kssj',
		    viewrecords: true,
		    sortorder: "desc",
		    caption:"重要预告信息",
		    emptyrecords: "无记录",
		    loadonce: false,
		    loadComplete: function() {},
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
		
		$("#grid").navButtonAdd('#pager',
				{ 	caption:"Add", 
					buttonicon:"ui-icon-plus", 
					onClickButton: addRow,
					position: "last", 
					title:"", 
					cursor: "pointer"
				} 
		);
		
		$("#grid").navButtonAdd('#pager',
				{ 	caption:"Edit", 
					buttonicon:"ui-icon-pencil", 
					onClickButton: editRow,
					position: "last", 
					title:"", 
					cursor: "pointer"
				} 
		);
		
		$("#grid").navButtonAdd('#pager',
			{ 	caption:"Delete", 
				buttonicon:"ui-icon-trash", 
				onClickButton: deleteRow,
				position: "last", 
				title:"", 
				cursor: "pointer"
			} 
		);

		// Toolbar Search
		$("#grid").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true, defaultSearch:"cn"});
	});

	function addRow() {
   		$("#grid").jqGrid('setColProp', 'username', {editoptions:{readonly:false, size:10}});
   		$("#grid").jqGrid('setColProp', 'password', {hidden: false});
   		$("#grid").jqGrid('setColProp', 'password', {editrules:{required:true}});
   		
		// Get the currently selected row
		$('#grid').jqGrid('editGridRow','new',
	    		{ 	url: '${addUrl}', 
					editData: {},
	                serializeEditData: function(data){ 
	                    data.id = 0; 
	                    return $.param(data);
	                },
				    recreateForm: true,
				    beforeShowForm: function(form) {
			            $('#pData').hide();  
			            $('#nData').hide();
			            $('#password',form).addClass('ui-widget-content').addClass('ui-corner-all');
				    },
					beforeInitData: function(form) {},
					closeAfterAdd: true,
					reloadAfterSubmit:true,
					afterSubmit : function(response, postdata) 
					{ 
				        var result = eval('(' + response.responseText + ')');
						var errors = "";
						
				        if (result.success == false) {
							for (var i = 0; i < result.message.length; i++) {
								errors +=  result.message[i] + "<br/>";
							}
				        }  else {
				        	$('#msgbox').text('Entry has been added successfully');
							$('#msgbox').dialog( 
									{	title: 'Success',
										modal: true,
										buttons: {"Ok": function()  {
											$(this).dialog("close");} 
										}
									});
		                }
				    	// only used for adding new records
				    	var newId = null;
				    	
						return [result.success, errors, newId];
					}
	    		});

   		$("#grid").jqGrid('setColProp', 'password', {hidden: true});
	} // end of addRow


	function editRow() {
   		$("#grid").jqGrid('setColProp', 'username', {editoptions:{readonly:true, size:10}});
   		$("#grid").jqGrid('setColProp', 'password', {hidden: true});
   		$("#grid").jqGrid('setColProp', 'password', {editrules:{required:false}});
   		
		// Get the currently selected row
		var row = $('#grid').jqGrid('getGridParam','selrow');
		
		if( row != null ) {
		
			$('#grid').jqGrid('editGridRow', row,
				{	url: '${editUrl}', 
					editData: {},
			        recreateForm: true,
			        beforeShowForm: function(form) {
			            $('#pData').hide();  
			            $('#nData').hide();
			        },
					beforeInitData: function(form) {},
					closeAfterEdit: true,
					reloadAfterSubmit:true,
					afterSubmit : function(response, postdata) 
					{ 
			            var result = eval('(' + response.responseText + ')');
						var errors = "";
						
			            if (result.success == false) {
							for (var i = 0; i < result.message.length; i++) {
								errors +=  result.message[i] + "<br/>";
							}
			            }  else {
			            	$('#msgbox').text('Entry has been edited successfully');
							$('#msgbox').dialog( 
									{	title: 'Success',
										modal: true,
										buttons: {"Ok": function()  {
											$(this).dialog("close");} 
										}
									});
		                }
				    	// only used for adding new records
				    	var newId = null;
			        	
						return [result.success, errors, newId];
					}
				});
		} else {
			$('#msgbox').text('You must select a record first!');
			$('#msgbox').dialog( 
					{	title: 'Error',
						modal: true,
						buttons: {"Ok": function()  {
							$(this).dialog("close");} 
						}
					});
		}
	}
	
	function deleteRow() {
		// Get the currently selected row
	    var row = $('#grid').jqGrid('getGridParam','selrow');

	    // A pop-up dialog will appear to confirm the selected action
		if( row != null ) 
			$('#grid').jqGrid( 'delGridRow', row,
	          	{	url:'${deleteUrl}', 
					recreateForm: true,
				    beforeShowForm: function(form) {
				    	//Change title
				        $(".delmsg").replaceWith('<span style="white-space: pre;">' +
				        		'Delete selected record?' + '</span>');
		            	//hide arrows
				        $('#pData').hide();  
				        $('#nData').hide();
				    },
	          		reloadAfterSubmit:true,
	          		closeAfterDelete: true,
	          		serializeDelData: function (postdata) {
		          	      var rowdata = $('#grid').getRowData(postdata.id);
		          	      // append postdata with any information 
		          	      return {id: postdata.id, oper: postdata.oper, username: rowdata.username};
		          	},
	          		afterSubmit : function(response, postdata) 
					{ 
			            var result = eval('(' + response.responseText + ')');
						var errors = "";
						
			            if (result.success == false) {
							for (var i = 0; i < result.message.length; i++) {
								errors +=  result.message[i] + "<br/>";
							}
			            }  else {
			            	$('#msgbox').text('Entry has been deleted successfully');
							$('#msgbox').dialog( 
									{	title: 'Success',
										modal: true,
										buttons: {"Ok": function()  {
											$(this).dialog("close");} 
										}
									});
		                }
				    	// only used for adding new records
				    	var newId = null;
			        	
						return [result.success, errors, newId];
					}
	          	});
		else {
			$('#msgbox').text('You must select a record first!');
			$('#msgbox').dialog( 
					{	title: 'Error',
						modal: true,
						buttons: {"Ok": function()  {
							$(this).dialog("close");} 
						}
					});
		}
	}
	</script>
</head>

<body>
	<h1 id='banner'>System Records</h1>
	
	<div id='jqgrid' style="width:80%;padding:20px;margin:0 auto;">
		<table id='grid'></table>
		<div id='pager'></div>
	</div>
	
	<div id='msgbox' title='' style='display:none'></div>
</body>
</html>