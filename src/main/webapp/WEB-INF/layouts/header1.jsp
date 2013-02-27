<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<header>
		<div class="container-fluid">
			<a href="#" class="brand">logo</a>
			<div class="nav-right">
				<ul class="nav nav-pills">
					<li class="dropdown">
						<a href="#">账户<b class="caret"></b></a>
						<ul id="menu-account" class="dropdown-menu anchor-right" style="min-width:130px;">
							<li><a href="#accountset">账号设置</a></li>
							<li class="divider"></li>
							<li><a href="${ctx}/logout"><i class="icon-off"></i>退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="nav-collapse">
				<ul class="nav nav-pills">
					<li ><a href="indexdh2.jsp">首页</a></li>
					<li class="active dropdown">
						<a class="link dropdown-toggle open" href="#" data-toggle="dropdown" data-target="#menu1">五预<b class="caret"></b></a>
						<ul id="menu1" class="dropdown-menu">
							<li><a href="#">预告</a></li>
							<li><a href="#">预测</a></li>
							<li class="divider"></li>
							<li><a href="#">预析</a></li>
							<li><a href="#">预警</a></li>
							<li><a href="#">预置</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="indexdh2.jsp">五查<b class="caret"></b></a>
						<ul id="menu1" class="dropdown-menu">
							<li><a href="#">日常巡查</a></li>
							<li><a href="#">监督抽查</a></li>
							<li class="divider"></li>
							<li><a href="#">执法检查</a></li>
							<li><a href="#">实地核查</a></li>
							<li><a href="#">工作督查</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="indexdh2.jsp">行政审批<b class="caret"></b></a></li>
					<li class="dropdown"><a href="indexdh2.jsp">执法办案<b class="caret"></b></a></li>
					<li class="dropdown"><a href="indexdh2.jsp">企业档案<b class="caret"></b></a></li>
					<li class="dropdown"><a href="indexdh2.jsp">信用监管<b class="caret"></b></a></li>
					<li class="dropdown"><a href="indexdh2.jsp">区域监管<b class="caret"></b></a></li>
					<li class="dropdown"><a href="indexdh2.jsp">系统设置<b class="caret"></b></a></li>
				</ul>
			</div>
		</div>
</header>
  
