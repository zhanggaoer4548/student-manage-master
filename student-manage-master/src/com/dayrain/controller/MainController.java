package com.dayrain.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.dto.ScoreDto;
import com.dayrain.service.CourseService;
import com.dayrain.service.ScoreService;
import com.dayrain.service.StudentService;


/**
 * 跳转到主界面
 */
@WebServlet("/mainUrl")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		ScoreService scoreService = new ScoreService();
		int studentNum = studentService.count();
		int courseNum = courseService.count();
		int onlineNum = (int) request.getServletContext().getAttribute("onlineNum");
		long startTime = (long) request.getServletContext().getAttribute("startTime");
		List<ScoreDto> scoreList = scoreService.getTopScoreList(10);
		
		int days = (int)((new Date().getTime() - startTime) / (1000*3600*24)) + 1;
		request.setAttribute("studentNum", studentNum);
		request.setAttribute("courseNum", courseNum);
		request.setAttribute("onlineNums", onlineNum);
		request.setAttribute("days", days);
		request.setAttribute("scores", scoreList);
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/pages/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
