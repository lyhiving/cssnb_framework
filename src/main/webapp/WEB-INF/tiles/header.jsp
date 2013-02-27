<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/resources/superfish/js/superfish.js"></script>
<script>
$(function(){
	$('ul.sf-menu').superfish();
});
</script>

<div id="header" class="navbar">
	<div class="logo">logo</div>
	<div class="nav">
		<ul class="sf-menu">
			<li><a href="${ctx}/">首页</a></li>
			<li class="current"><a href="#">五预</a>
				<ul>
					<li class="current"><a href="${ctx}/main?right_id=109">预告</a>
					</li>
					<li><a href="${ctx}/main?right_id=124">预测</a></li>
					<li><a href="${ctx}/main?right_id=119">预析</a></li>
					<li><a href="${ctx}/main?right_id=115">预警</a></li>
					<li><a href="${ctx}/main?right_id=128">预制</a></li>
				</ul></li>
			<li><a href="#">五查</a>
				<ul>
					<li><a href="${ctx}/main?right_id=39">日常巡查</a></li>
					<li><a href="${ctx}/main?right_id=132">监督抽查</a></li>
					<li><a href="${ctx}/main?right_id=140">执法检查</a></li>
					<li><a href="${ctx}/main?right_id=150">实地核查</a></li>
					<li><a href="${ctx}/main?right_id=152">工作督查</a></li>
				</ul></li>
			<li><a href="${ctx}/main?right_id=154">行政审批</a></li>
			<li><a href="${ctx}/main?right_id=265">执法办案</a></li>
			<li><a href="${ctx}/main?right_id=163">企业档案</a></li>
			<li><a href="${ctx}/main?right_id=294">信用监管</a></li>
			<li><a href="${ctx}/main?right_id=172">区域监管</a></li>
			<li><a href="${ctx}/main?right_id=5">系统设置</a></li>
		</ul>
	</div>
	<div class="nav-right">
		<div style="float:left;color:#ffffff;line-height: 1;padding: 0.65em 1em;text-decoration: none;">
		<shiro:user>
		欢迎：<shiro:principal property="name"/>
		</shiro:user>
		</div>
		<ul class="sf-menu">
			<li class="current"><a href="#">账户</a>
				<ul>
					<li><a href="#">修改密码</a></li>
					<li><a href="${ctx}/logout">退出</a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>