package com.dayrain.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Course;
import com.dayrain.entity.Student;
import com.dayrain.entity.Teacher;
import com.dayrain.service.CourseService;
import com.dayrain.service.StudentService;
import com.dayrain.service.TeacherService;

/**
 * 跳转到课程管理界面
 */
@WebServlet("/admin/adminCourseUrl")
public class AdminCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseService courseService = new CourseService();
		TeacherService teacherService = new TeacherService();
		String query = request.getParameter("query");
		List<Course> courses = courseService.getCourseList(query);
		List<Teacher> teachers = teacherService.getTeacherList(null);
		request.setAttribute("courseList", courses);
		request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("/WEB-INF/pages/admin/admin-course.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
