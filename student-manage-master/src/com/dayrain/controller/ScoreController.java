package com.dayrain.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Student;
import com.dayrain.entity.User;
import com.dayrain.entity.dto.ScoreDto;
import com.dayrain.entity.dto.StudentScoreDto;
import com.dayrain.service.ScoreService;
import com.dayrain.service.StudentService;


/**
 * 跳转到个人分数查询界面
 */
@WebServlet("/scoreUrl")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScoreService scoreService = new ScoreService();
		StudentService studentService = new StudentService();
		User user = (User) request.getSession().getAttribute("loginUser");
		List<StudentScoreDto> scores = scoreService.getScoreListByStudentNo(user.getStudentNo());
		Student student = studentService.getStudentByNo(user.getStudentNo());
		request.setAttribute("student", student);
		request.setAttribute("scores", scores);
		request.getRequestDispatcher("/WEB-INF/pages/score.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
