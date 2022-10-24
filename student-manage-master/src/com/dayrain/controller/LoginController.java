package com.dayrain.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.LoginHistory;
import com.dayrain.entity.User;
import com.dayrain.service.LoginHistoryService;
import com.dayrain.service.UserService;
import com.dayrain.utils.EncryptUtils;

/**
 * 登录提交
 */
@WebServlet("/loginUrl")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		LoginHistoryService loginHistoryService = new LoginHistoryService();
		User res = userService.loginCheck(username, password);
		if(res != null) {
			//登录成功
			//添加记录
			LoginHistory loginHistory = new LoginHistory();
			loginHistory.setUserId(res.getUserId());
			loginHistory.setIp(request.getRemoteAddr());
			loginHistory.setCreateTime(new Date());
			loginHistoryService.addLoginHistory(loginHistory);
			//跳转
			request.getSession().setAttribute("loginUser", res);
			request.getRequestDispatcher("/mainUrl").forward(request, response);
		}else {
			//登录失败
			request.setAttribute("msg", "登录失败，请检查用户名和密码是否正确！");
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
