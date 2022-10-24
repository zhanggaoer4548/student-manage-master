<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理</title>

<%@ include file="/WEB-INF/pages/css_template.jsp" %>
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
					<jsp:param value="active" name="4" />
				</jsp:include>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">

					<div class="col-sm-7">
						<form action="${pageContext.request.contextPath}/admin/adminStudentUrl" method="get">
							<div class="input-group">
								<input type="text" name="query" class="form-control"
									   placeholder="Search for..."> <span
									class="input-group-btn">
								<button class="btn btn-primary" type="submit">搜索</button>
							</span>
							</div>
						</form>
					</div>

					<div class="col-sm-5">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#addStudent">添加学生</button>
					</div>
				</div>


				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>学号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>入学年份</th>
								<th>编辑</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${studentList}"
								varStatus="status">
								<tr>
									<th>${status.index + 1}</th>
									<th>${student.studentNo}</th>
									<th>${student.studentName}</th>
									<th><c:choose>
											<c:when test="${student.gender == 1}">
	                                                                                               男
	                                        </c:when>

											<c:otherwise>
	                                                                                               女
	                                        </c:otherwise>
										</c:choose></th>
										
									<th>${student.age}</th>
									<th>${student.year}</th>
									<th>
										<button class="btn btn-default" data-student-no="${student.studentNo }"
											data-toggle="modal" data-target="#updateStudent">编辑</button>
										<button class="btn btn-danger" data-student-no="${student.studentNo }"
											data-toggle="modal" data-target="#deleteStudent">删除</button>
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

	<!-- add student -->
	<div class="modal fade" id="addStudent" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/addStudent">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">录入学生信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="student-no" class="control-label">学号:</label> <input
								type="text" class="form-control" name="studentNo"
								id="student-no">
						</div>

						<div class="form-group">
							<label for="student-name" class="control-label">姓名:</label> <input
								type="text" class="form-control" name="studentName"
								id="student-name">
						</div>

						<div class="form-group">
							<label for="id-card" class="control-label">身份证号:</label> <input
								type="text" class="form-control" name="idCard" id="id-card">
						</div>


						<div class="form-group">
							<label for="gender" class="control-label">性别:</label> <select
								class="form-control" name="gender" id="gender">
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</div>

						<div class="form-group">
							<label for="age" class="control-label">年龄:</label> <input
								type="text" class="form-control" name="age"  id="age">
						</div>

						<div class="form-group">
							<label for="year" class="control-label">入学年份:</label> <input
								type="text" class="form-control" name="year" id="year">
						</div>



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- update student -->
	<div class="modal fade" id="updateStudent" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/updateStudent">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="udpate-myModalLabel">更新学生信息</h4>
					</div>
					<div class="modal-body">
		
						<div class="form-group">
							<label for="update-student-no" class="control-label">学号:</label> <input
								type="text" readonly class="form-control" name="studentNo" id="update-student-no">
						</div>

						<div class="form-group">
							<label for="update-student-name" class="control-label">姓名:</label> <input
								type="text" class="form-control"  name="studentName" id="update-student-name">
						</div>

						<div class="form-group">
							<label for="update-id-card" class="control-label">身份证号:</label> <input
								type="text" class="form-control" name="idCard" id="update-id-card">
						</div>


						<div class="form-group">
							<label for="update-gender" class="control-label">性别:</label> <select
								class="form-control" name="gender" id="udpate-gender">
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</div>

						<div class="form-group">
							<label for="update-age" class="control-label">年龄:</label> <input
								type="text" class="form-control" name="age" id="update-age">
						</div>

						<div class="form-group">
							<label for="update-year" class="control-label">入学年份:</label> <input
								type="text" class="form-control" name="year" id="update-year">
						</div>



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- delete student -->
	<div class="modal fade" id="deleteStudent" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/deleteStudent">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="udpate-myModalLabel">删除学生信息</h4>
					</div>
					<div class="modal-body">
						确认要删除该同学的所有信息吗（该操作不可逆）？
						<div class="form-group hidden">
							<label for="delete-student" class="control-label">学号:</label> <input
								type="text" class="form-control" name="studentNo" id="delete-student-no">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button submit" class="btn btn-danger">删除</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="<%=basePath%>/js/jquery-3.5.1.js"></script>
	<script src="<%=basePath%>/js/bootstrap.js"></script>

	<script>
		$('#updateStudent').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var studentNo = button.data('student-no')
			var modal = $(this)
			var params = {
				"studentNo": studentNo
			}
			$.ajax({
				url:'${pageContext.request.contextPath}/getStudent',
				type:"get",
				data: params,
				success:function(result) {
					modal.find('#update-student-no').val(result.studentNo)
					modal.find('#update-student-name').val(result.studentName)
					modal.find('#update-id-card').val(result.idCard)
					modal.find('#update-gender').val(result.gender)
					modal.find('#update-age').val(result.age)
					modal.find('#update-year').val(result.year)
				}
			})
		})

		$('#deleteStudent').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var studentNo = button.data('student-no')
			var modal = $(this)
			modal.find('#delete-student-no').val(studentNo)
		})
	</script>
</body>

</html>