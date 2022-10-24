<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理</title>
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
					<jsp:param value="active" name="6" />
				</jsp:include>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">

					<div class="col-sm-7">
						<form action="${pageContext.request.contextPath}/admin/adminCourseUrl">
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
						<!-- <button class="btn addBtn">添加学生</button> -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#addCourse">添加课程</button>
					</div>
				</div>


				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>课程号</th>
								<th>课程名</th>
								<th>授课老师</th>
								<th>选课人数</th>
								<th>编辑</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="course" items="${courseList}" varStatus="status">
								<tr>
									<th>${status.index + 1}</th>
									<th>${course.courseNo}</th>
									<th>${course.courseName}</th>
									<th>${course.teacherNo }</th>

									<th>${course.studentNum}</th>

									<th>
										<button class="btn btn-default"
											data-course-no="${course.courseNo }" data-toggle="modal"
											data-target="#updateCourse">编辑</button>
										<button class="btn btn-danger"
											data-course-no="${course.courseNo }" data-toggle="modal"
											data-target="#deleteCourse">删除</button>
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

	<!-- add Course -->
	<div class="modal fade" id="addCourse" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/addCourse">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">录入课程信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="course-no" class="control-label">课程号:</label> <input
								type="text" class="form-control" name="courseNo" id="course-no">
						</div>

						<div class="form-group">
							<label for="course-name" class="control-label">课程名:</label> <input
								type="text" class="form-control" name="courseName"
								id="course-name">
						</div>

						<div class="form-group">
							<label for="course-teacher" class="control-label">授课老师:</label> <select
								class="form-control" name="teacherNo"
								id="course-teacher">
								<c:forEach var="teacher" items="${teachers }" varStatus="status">
									<option value="${teacher.teacherNo }">${teacher.teacherName }</option>
								</c:forEach>
								</select>
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

	<!-- update Course -->
	<div class="modal fade" id="updateCourse" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/updateCourse">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">更新课程信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="update-course-no" class="control-label">课程号:</label>
							<input type="text" readonly class="form-control" name="courseNo"
								id="update-course-no">
						</div>

						<div class="form-group">
							<label for="update-course-name" class="control-label">课程名:</label>
							<input type="text" class="form-control" name="courseName"
								id="update-course-name">
						</div>

						<div class="form-group">
							<label for="update-course-teacher" class="control-label">授课老师:</label>
							<select class="form-control" name="teacherNo"
								id="update-course-teacher">
								<c:forEach var="teacher" items="${teachers }" varStatus="status">
									<option value="${teacher.teacherNo }">${teacher.teacherName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- delete Course -->
	<div class="modal fade" id="deleteCourse" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/deleteCourse">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="udpate-myModalLabel">删除课程信息</h4>
					</div>
					<div class="modal-body">
						确认要删除该课程的所有信息吗（该操作不可逆）？
						<div class="form-group hidden">
							<label for="delete-course-no" class="control-label">学号:</label> <input
								type="text" class="form-control" name="courseNo"
								id="delete-course-no">
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
		$('#updateCourse').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var courseNo = button.data('course-no')
			var modal = $(this)
			var params = {
				"courseNo" : courseNo
			}
			$.ajax({
				url : '${pageContext.request.contextPath}/getCourse',
				type : "get",
				data : params,
				success : function(result) {
					modal.find('#update-course-no').val(result.courseNo)
					modal.find('#update-course-name').val(result.courseName)
					modal.find('#update-course-teacher').val(result.teacherNo)
				}
			})
		})

		$('#deleteCourse').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var courseNo = button.data('course-no')
			var modal = $(this)
			modal.find('#delete-course-no').val(courseNo)
		})
	</script>
</body>

</html>