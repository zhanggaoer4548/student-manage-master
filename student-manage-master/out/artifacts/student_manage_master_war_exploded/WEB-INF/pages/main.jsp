<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>主页</title>

<%@ include file="/WEB-INF/pages/css_template.jsp"%>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">学生管理系统</span> <span class="icon-bar"></span>
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
					<jsp:param value="active" name="1" />
				</jsp:include>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">欢迎您, ${loginUser.getDisplayName() }！</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<div class="imgBox">
							<img src="<%=basePath%>/img/nav1.jpg">
							<h1 class="imgText">${studentNum}</h1>
						</div>
						<h4>学生总数</h4>
						<span class="text-muted">Student</span>
					</div>

					<div class="col-xs-6 col-sm-3 placeholder">
						<div class="imgBox">
							<img src="<%=basePath%>/img/nav2.jpg">
							<h1 class="imgText">${courseNum }</h1>
						</div>
						<h4>课程总数</h4>
						<span class="text-muted">Class</span>
					</div>

					<div class="col-xs-6 col-sm-3 placeholder">
						<div class="imgBox">
							<img src="<%=basePath%>/img/nav3.jpg">
							<h1 class="imgText">${onlineNums }</h1>
						</div>
						<h4>在线人数</h4>
						<span class="text-muted">Teacher</span>
					</div>

					<div class="col-xs-6 col-sm-3 placeholder">
						<div class="imgBox">
							<img src="<%=basePath%>/img/nav4.jpg">
							<h1 class="imgText">${days}</h1>
						</div>
						<h4>运行天数</h4>
						<span class="text-muted">Days</span>
					</div>

				</div>

				<h2 class="sub-header">TOP</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>TOP</th>
								<th>学号</th>
								<th>姓名</th>
								<th>科目</th>
								<th>分数</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="score" items="${scores }" varStatus="status">
							<tr>
							    <td>${status.index + 1 }</td>
							    <td>${score.studentNo }</td>
							    <td>${score.studentName }</td>
							    <td>${score.courseName }</td>
							    <td>${score.score }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>