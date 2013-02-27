<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- ********************page begin******************** --%>
<html>
<head>
<title>添加</title>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<script src="chosen/jquery-1.6.4.min.js" type="text/javascript"></script>
<script src="chosen/chosen/chosen.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
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
<link href="../Skins/templates/images/skin.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" href="chosen/chosen/chosen.css" />
<link href="css/twocolumn.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" ></script>
</head>
<style>
.auto_hidden {
    width:204px;border-top: 1px solid #333;
    border-bottom: 1px solid #333;
    border-left: 1px solid #333;
    border-right: 1px solid #333;
    position:absolute;
    display:none;
}
.auto_show {
    width:204px;
    text-align:left;
    border-top: 1px solid #333;
    border-bottom: 1px solid #333;
    border-left: 1px solid #333;
    border-right: 1px solid #333;
    position:absolute;
    z-index:99999; /* 设置对象的层叠顺序 */
    display:block;
}
.auto_onmouseover{
    color:#ffffff;
    background-color:highlight;
    width:100%;
}
.auto_onmouseout{
    color:#000000;
    width:100%;
    background-color:#ffffff;
}



</style>
<body>
<form id="formoper" action="${ctx}/tbl/members/update" method="post">

<table style="" width="100%" id="mytab"  border="1" class="et1">  
    <th colspan="4"> 信息提醒录入</th>
     <tr> 
    <td align="right" width="30%">id：</td>  
    <td align="left" colspan="3">
    <input type="text" id="xxlrbt" name="id" style="width:100px" value="${member.id }" readonly></td>  
    </tr>  
  <tr> 
    <td align="right" width="30%">姓名：</td>  
    <td align="left" colspan="3">
    <input type="text" id="xxlrbt" name="name" style="width:100px" value="${member.name }"></td>  
    </tr>
    <tr>  
    <td align="right" width="30%">职位：</td>  
    <td align="left" colspan="3">
    <input type="text" id="xxlrbt" name="zw" style="width:100px" value="${member.zw }"></td>
    </tr>
  <tr>  
    <td align="right" width="30%">areaid：</td>  
    <td align="left" colspan="3">
    <input type="text" id="xxlrgqqx" name="areaid" style="width:100px" value="${member.areaid }"></td>  
  </tr>
  <tr>
  	<td align="right" width="30%">depteid：</td>
  	<td><input type="text" id="depteid" name="depteid" style="width:100px" value="${member.depteid }"></td>
  </tr>
  <tr>
  	<td align="right" width="30%">passwd：</td>
  	<td><input type="text" id="passwd" name="passwd" style="width:100px" value="${member.passwd }"></td>
  </tr>
  <tr>
  	<td align="right" width="30%">keyno：</td>
  	<td><input type="text" id="keyno" name="keyno" style="width:100px" value="${member.keyno }"></td>
  </tr>
  <tr>
  	<td align="right" width="30%">px：</td>
  	<td><input type="text" id="px" name="px" style="width:100px" value="${member.px }"></td>
  </tr>
  <tr>
  	<td align="right" width="30%"><input type="submit" value="update" name="Submit"/>
	<input type="button" name="Submit" value=" 返回 " onclick="javascript:history.go(-1);"/>
	</td>
  </tr>
</table> 

<div id="footer">
</div>
    
	</td>
  </tr>
</table>
</form>
</body>
</html>
<%-- ********************page end******************** --%>


<%-- ********************form begin******************** --%>

<%-- ********************form end******************** --%>

<%-- ********************javascript begin******************** --%>

<%-- ********************javascript end******************** --%>