package com.dayrain.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.Dao.CourseDao;
import com.dayrain.Dao.StudentDao;
import com.dayrain.entity.Course;
import com.dayrain.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetCourse
 */
@WebServlet("/getCourse")
public class GetCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseNo = request.getParameter("courseNo");
		CourseDao courseDao = new CourseDao();
		Course course = courseDao.getCourseByNo(courseNo);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/json; charset=utf-8");
		ObjectMapper objectMapper = new ObjectMapper();
		
		writer.print(objectMapper.writeValueAsString(course));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
