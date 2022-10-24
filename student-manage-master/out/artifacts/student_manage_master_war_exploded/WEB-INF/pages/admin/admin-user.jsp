<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
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
					<jsp:param value="active" name="8" />
				</jsp:include>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">

					<div class="col-sm-7">
						<form action="${pageContext.request.contextPath}/admin/adminUserUrl">
							<div class="input-group">
								<input name="query" type="text" class="form-control"
									   placeholder="Search for..."> <span
									class="input-group-btn">
								<button class="btn btn-primary" type="submit">搜索</button>
							</span>
							</div>
						</form>
					</div>

					<div class="col-sm-5">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#addUser">添加账号</button>
					</div>
				</div>


				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>账号</th>
								<th>密码</th>
								<th>账号状态</th>
								<th>编辑</th>
							</tr>
						</thead>
						<tbody>


							<c:forEach var="user" items="${users }" varStatus="status">
								<tr>
									<th>${status.index }</th>
									<th>${user.username }</th>
									<th>**********</th>
									<th>${user.state }</th>
									<th>
										<button class="btn btn-default" data-user-id="${user.userId }"
											data-toggle="modal" data-target="#changeState">禁用</button>
										<button class="btn btn-danger" data-user-id="${user.userId }"
											data-toggle="modal" data-target="#deleteUser">删除</button>
									</th>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</div>

				<div>
					<nav aria-label="...">
						<ul class="pager hidden">
							<li class="previous"><a href="#"><span
									aria-hidden="true">&larr;</span> 上一页</a></li>
							<li class="next"><a href="#">下一页 <span
									aria-hidden="true">&rarr;</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<!-- add user -->
	<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/addUser">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">添加账号</h4>
					</div>
					<div class="modal-body">

						<div class="form-group"></div>

						<div class="form-group">
							<label for="student-no" class="control-label">学生:</label> <select
								class="form-control" name="studentNo" id="student-no">
								<c:forEach var="student" items="${students }" varStatus="status">
									<option value="${student.studentNo }">${student.studentName }</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="user-password" class="control-label">密码:</label> <input
								type="text" class="form-control" name="password"
								id="user-password">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- delete user -->
	<div class="modal fade" id="deleteUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/deleteUser">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="udpate-myModalLabel">删除账号信息</h4>
					</div>
					<div class="modal-body">
						确认要删除该同学的所有信息吗（该操作不可逆）？
						<div class="form-group hidden">
							<label for="delete-user-id" class="control-label">用户id:</label> <input
								type="text" class="form-control" name="userId"
								id="delete-user-id">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-danger">删除</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="../js/jquery-3.5.1.js"></script>
	<script src="../js/bootstrap.js"></script>

	<script>
		$('#deleteUser').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var userId = button.data('user-id')
			var modal = $(this)
			modal.find('#delete-user-id').val(userId)
		})
	</script>
</body>

</html>