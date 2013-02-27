<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div class="lefttitle"><a></a></div>
 <div class="menu">
	<ul>
		<c:forEach items="${rightList}" var="right">
		<li><a href="${ctx}/${right.right_filename}" class="hide" target="main">${right.right_name}</a>
		</li>
		</c:forEach>
	</ul>
</div>

