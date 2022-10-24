package com.dayrain.controller.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Course;
import com.dayrain.service.CourseService;

/**
 *更新课程
 */
@WebServlet("/admin/updateCourse")
public class UpdateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseNo = request.getParameter("courseNo");
		String courseName = request.getParameter("courseName");		
		String teacherNo = request.getParameter("teacherNo");
		Date createTime = new Date();
		Date updateTime = new Date();
		Course course = new Course();
		course.setCourseNo(courseNo);
		course.setCourseName(courseName);
		course.setTeacherNo(teacherNo);
		course.setCreateTime(createTime);
		course.setUpdateTime(updateTime);
		course.setStudentNum(0);
		CourseService courseService = new CourseService();
		
		Course query = courseService.getCourseByNo(courseNo);
		if(query == null) {
			request.setAttribute("msg", "课程号为"+courseNo+"的课程不存在！");
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
			return;
		}
		courseService.updateCourse(course);
		request.getRequestDispatcher("/admin/adminCourseUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
