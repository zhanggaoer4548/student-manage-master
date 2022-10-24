<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav nav-sidebar">
    <c:choose>
    <c:when test="${loginUser.userType == 1 }">
    <li class="	<%=request.getParameter("1")%>"><a href="${pageContext.request.contextPath}/mainUrl">首页</a></li>
    <li class="	<%=request.getParameter("4")%>"><a href="${pageContext.request.contextPath}/admin/adminStudentUrl">学生管理</a></li>
	<li class="	<%=request.getParameter("5")%>"><a href="${pageContext.request.contextPath}/admin/adminScoreUrl">成绩管理</a></li>
	<li class="	<%=request.getParameter("6")%>"><a href="${pageContext.request.contextPath}/admin/adminCourseUrl">课程管理</a></li>
	<li class="	<%=request.getParameter("7")%>"><a href="${pageContext.request.contextPath}/admin/adminTeacherUrl">教师管理</a></li>
	<li class="	<%=request.getParameter("8")%>"><a href="${pageContext.request.contextPath}/admin/adminUserUrl">账号管理</a></li>
    </c:when>
    
    <c:otherwise>
    <li class="	<%=request.getParameter("1")%>"><a href="${pageContext.request.contextPath}/mainUrl">首页</a></li>
	<li class="	<%=request.getParameter("2")%>"><a href="${pageContext.request.contextPath}/scoreUrl">成绩查询</a></li>
	<li class="	<%=request.getParameter("3")%>"><a href="${pageContext.request.contextPath}/infoUrl">档案查询</a></li>
    </c:otherwise>
    </c:choose>
    
</ul>