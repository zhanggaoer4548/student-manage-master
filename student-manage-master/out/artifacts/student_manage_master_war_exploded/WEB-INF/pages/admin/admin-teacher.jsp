<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师管理</title>
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
					<jsp:param value="active" name="7" />
				</jsp:include>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">

					<div class="col-sm-7">
						<form action="${pageContext.request.contextPath}/admin/adminTeacherUrl">
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
							data-target="#addTeacher">添加教师</button>
					</div>

				</div>


				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>教师工号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>编辑</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="teacher" items="${teachers }" varStatus="status">

								<tr>
									<th>${status.index + 1}</th>
									<th>${teacher.teacherNo }</th>
									<th>${teacher.teacherName }</th>
									<th><c:choose>
											<c:when test="${teacher.gender == 1}">
	                                                                                               男
	                                        </c:when>

											<c:otherwise>
	                                                                                               女
	                                        </c:otherwise>
										</c:choose></th>
									<th>
										<button class="btn btn-default"
											data-teacher-no="${teacher.teacherNo }" data-toggle="modal"
											data-target="#updateTeacher">编辑</button>
										<button class="btn btn-danger"
											data-teacher-no="${teacher.teacherNo }" data-toggle="modal"
											data-target="#deleteTeacher">删除</button>
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

	<!-- add teacher -->
	<div class="modal fade" id="addTeacher" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/addTeacher">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">录入教师信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="teacher-no" class="control-label">教师工号:</label> <input
								type="text" class="form-control" name="teacherNo"
								id="teacher-no">
						</div>

						<div class="form-group">
							<label for="teacher-name" class="control-label">教师名:</label> <input
								type="text" class="form-control" name="teacherName"
								id="teacher-name">
						</div>

						<div class="form-group">

							<label for="gender" class="control-label">性别:</label> <select
								class="form-control" name="gender" id="gender">
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
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

	<!-- update teacher -->
	<div class="modal fade" id="updateTeacher" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/updateTeacher">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">更新教师信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="update-teacher-no" class="control-label">教师工号:</label>
							<input type="text" readonly class="form-control" name="teacherNo"
								id="update-teacher-no">
						</div>

						<div class="form-group">
							<label for="update-teacher-name" class="control-label">姓名:</label>
							<input type="text" class="form-control" name="teacherName"
								id="update-teacher-name">
						</div>

						<div class="form-group">

							<label for="update-gender" class="control-label">性别:</label> <select
								class="form-control" name="gender" id="update-gender">
								<option value="1">男</option>
								<option value="2">女</option>
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

	<!-- delete Teacher -->
	<div class="modal fade" id="deleteTeacher" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/admin/deleteTeacher">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">删除教师信息</h4>
					</div>
					<div class="modal-body">
						确认要删除该教师的所有信息吗（该操作不可逆）？
						<div class="form-group hidden">
							<label for="delete-teacher-no" class="control-label">工号:</label>
							<input type="text" class="form-control" name="teacherNo"
								id="delete-teacher-no">
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
		$('#updateTeacher').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var teacherNo = button.data('teacher-no')
			var modal = $(this)
			var params = {
				"teacherNo" : teacherNo
			}
			$.ajax({
				url : '${pageContext.request.contextPath}/getTeacher',
				type : "get",
				data : params,
				success : function(result) {
					modal.find('#update-teacher-no').val(result.teacherNo)
					modal.find('#update-teacher-name').val(result.teacherName)
					modal.find('#update-gender').val(result.gender)
				}
			})
		})

		$('#deleteTeacher').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var teacherNo = button.data('teacher-no')
			var modal = $(this)
			modal.find('#delete-teacher-no').val(teacherNo)
		})
	</script>
</body>

</html>