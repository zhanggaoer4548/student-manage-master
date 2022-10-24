package com.dayrain.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.User;
import com.dayrain.service.StudentService;
import com.dayrain.service.UserService;

 
/**
 * 
 * 跳转到更新信息界面
 * 
 */
@WebServlet("/updateInfo")
public class UpdateInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		User user = (User) request.getSession().getAttribute("loginUser");
		StudentService studentService = new StudentService();
		studentService.updateStudent(user.getStudentNo(), description);
		request.getRequestDispatcher("/infoUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
