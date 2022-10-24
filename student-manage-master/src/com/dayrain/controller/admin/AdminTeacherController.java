package com.dayrain.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Teacher;
import com.dayrain.service.TeacherService;

/**
 * 
 * 跳转到教师管理
 *
 */
@WebServlet("/admin/adminTeacherUrl")
public class AdminTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		TeacherService teacherService = new TeacherService();
	    List<Teacher> teachers = teacherService.getTeacherList(query);
	    request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("/WEB-INF/pages/admin/admin-teacher.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
