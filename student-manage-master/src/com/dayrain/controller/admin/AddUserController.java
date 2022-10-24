package com.dayrain.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.User;
import com.dayrain.service.StudentService;
import com.dayrain.service.UserService;
import com.dayrain.utils.EncryptUtils;

/**
 * 添加用户
 */
@WebServlet("/admin/addUser")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentNo = request.getParameter("studentNo");
		String password = request.getParameter("password");
		User user = new User();
		user.setStudentNo(studentNo);
		user.setPassword(EncryptUtils.MD5Encode(password));
		UserService userService = new UserService();
		userService.addUser(user);
		request.getRequestDispatcher("/admin/adminUserUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
