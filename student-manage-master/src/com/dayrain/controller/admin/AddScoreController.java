package com.dayrain.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Score;
import com.dayrain.entity.User;
import com.dayrain.service.ScoreService;
import com.dayrain.service.UserService;

/*
 *添加分数 
 */
@WebServlet("/admin/addScore")
public class AddScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		String courseNo = request.getParameter("courseNo");
		Float score = Float.valueOf(request.getParameter("score"));
		
		Score scoreObj = new Score();
		scoreObj.setCourseNo(courseNo);
		scoreObj.setStudentNo(studentNo);
		scoreObj.setScore(score);
		ScoreService scoreService = new ScoreService();
		scoreService.addScore(scoreObj);
		request.getRequestDispatcher("/admin/adminScoreUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
