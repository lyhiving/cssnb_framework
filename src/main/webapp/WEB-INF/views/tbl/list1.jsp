<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" />
		
		<title>DataTables example</title>
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/media/css/demo_page.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/media/css/demo_table.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/media/css/demo_table_jui.css"/>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/dataTable/js/jquery.js"></script>
 	<script type="text/javascript" language="javascript" src="${ctx}/resources/dataTable/js/jquery.dataTables.js"></script>
 	<script type="text/javascript" language="javascript" src="${ctx}/resources/dataTable/js/jjquery.jeditable.js"></script>
		<script type="text/javascript" charset="utf-8">
		function getDataSet(){
		}
			$(document).ready(function() {
				oTable = $("#example").dataTable({
					 "bProcessing": false,
		             "bServerSide": true,
		             "sAjaxSource": "${ctx}/tbl/members/list2",
		             "sServerMethod": "POST",
		             "aoColumns": [
		                                       { "sTitle": "id",
		                                           "bSearchable": false,
		                                           "bSortable": false,
		                                           "bVisible": false
		                                       },
		                                      { "sTitle": "name" }
		                                   ],
		             "fnServerData": function (sUrl, aoData, fnCallback) {
		            	aoData.push( { "name": "tblmembers", "value": $("#tblmembers").val() } );
		                 $.ajax({
		                     "url": sUrl,
		                     "data": aoData,
		                     "success": function(response) {
		                    	 fnCallback(response.returnObject); //服务器端返回的对象的returnObject部分是要求的格式
		                     },
		                     "dataType": "json",
		                     "cache": false
		                 });
		             }
				} );
				
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<div class="demo_jui">
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
</table>
			</div>
		</div>
	</body>
</html>