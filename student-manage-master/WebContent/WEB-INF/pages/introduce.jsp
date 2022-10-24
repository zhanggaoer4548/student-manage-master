<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>说明</title>
<%@ include file="/WEB-INF/pages/css_template.jsp"%>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">DayRain学生管理系统</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/mainUrl">学生管理系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<!-- 导航条菜单 -->
				<%@ include file="/WEB-INF/pages/header_nav_template.jsp"%>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">

				<!-- 侧边栏 -->
				<jsp:include page="/WEB-INF/pages/side_nav_template.jsp">
					<jsp:param value="active" name="10" />
				</jsp:include>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">联系方式</h1>
				<div>
					<div class="jumbotron">

						<p>
							作者：小楼夜听雨<br /> 
							博客地址 <br/>
							CSDN：<a href="https://blog.csdn.net/qq_37855749">https://blog.csdn.net/qq_37855749</a><br />
							博客园：<a href="https://www.cnblogs.com/phdeblog/">https://www.cnblogs.com/phdeblog/</a><br />
							邮箱/qq: 826679708@qq.com
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>