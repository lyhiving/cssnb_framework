<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head runat="server">
    <title>Datatables</title>
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/media/css/demo_page.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/media/css/demo_table.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="${ctx}/resources/dataTable/media/css/demo_table_jui.css"/>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/dataTable/media/js/jquery.js"></script>
 	<script type="text/javascript" language="javascript" src="${ctx}/resources/dataTable/media/js/jquery.dataTables.js"></script>
 	<script type="text/javascript" language="javascript" src="${ctx}/resources/dataTable/media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" language="javascript">
				    $(function () {
				        $("#example").dataTable(
				          {
				            "bPaginate": true, //开关，是否显示分页器
//				            "bInfo": true,//开关，是否显示表格的一些信息
//				            "bFilter": true, //开关，是否启用客户端过滤器
//				            "sDom": "<>lfrtip<>",
//				            "bAutoWith": false,
//				            "bDeferRender": false,
				            "bJQueryUI": true, //开关，是否启用JQueryUI风格
				            "bLengthChange": true,//开关，是否显示每页大小的下拉框
//				            "bProcessing": true,
//				            "bScrollInfinite": false,
//				            "sScrollY": "800px", //是否开启垂直迁移转变，以及指定迁移转变区域大小，可设值：""disabled""，""2000px""
//				            "bSort": true, //开关，是否启用各列具有按列排序的功能
//				            "bSortClasses": true,
//				            "bStateSave": false, //开关，是否打开客户端状况记录功能。这个数据是记录在cookies中的，打开了这个记录后，即使刷新一次页面，或从头打开浏览器，之前的状况都是保存下来的-------当值为true时aoColumnDefs不克不及隐蔽列
//				            "sScrollX": "50％", //是否开启程度迁移转变，以及指定迁移转变区域大小，可设值：""disabled""，""2000％""
//				            "aaSorting": [[0, "asc"]],
//				            "aoColumnDefs": [{ "bVisible": false， "aTargets": [0]}]//隐蔽列
//				            "sDom": ""<"H"if>t<"F"if>"",
				            "bAutoWidth": false, //自适应宽度
				            "aaSorting": [[1, "asc"]],
				            "sPaginationType": "full_numbers",
				            "oLanguage": {
				                "sProcessing": "正在加载中......",
				                "sLengthMenu": "每页显示 _MENU_ 笔记录",
				                "sZeroRecords": "对不起，查询不到相干数据！",
				                "sEmptyTable": "表中无数据存在！",
				                "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 笔记录",
				                "sInfoFiltered": "数据表中共为 _MAX_ 笔记录",
				                "sSearch": "搜刮",
				                "oPaginate": {
				                    "sFirst": "首页",
				                    "sPrevious": "上一页",
				                    "sNext": "下一页",
				                    "sLast": "末页"
				                }
				            } //多说话设备
				          }
				        );
				    });
    </script>
</head>
<body>
<div id="dt_example">
<div id="container" align="center">
    <div id="demo">
           <table cellpadding="0" border="2" cellspacing="0" border="0" id="example" class="display">
           <thead>
                <tr>
                    <th>产品编号</th>
                    <th>产品名称</th>
                    <th>产品价格</th>
                    <th>产品状况</th>
                </tr>
            </thead>
            <tbody>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
               
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeX">
                    <td>1</td>
                    <td>产品1</td>
                    <td class="center">100</td>
                    <td class="center">正常</td>
                </tr>
                <tr class="gradeA">
                    <td>2</td>
                    <td>产品2</td>
                    <td class="center">2000</td>
                    <td class="center">不正常</td>
                </tr>
                <tr class="gradeC">
                    <td>3</td>
                    <td>产品3</td>
                    <td class="center">3890</td>
                    <td class="center">正常</td>
                </tr>
            </tbody>
           </table>
    </div>
</div>
</div>
</body>
</html>