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
import com.dayrain.entity.dto.ScoreDto;
import com.dayrain.service.CourseService;
import com.dayrain.service.ScoreService;
import com.dayrain.service.StudentService;

/**
 * 跳转到成绩上传界面
 */
@WebServlet("/admin/adminScoreUrl")
public class AdminScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminScoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		ScoreService scoreService = new ScoreService();
		List<ScoreDto> scores = scoreService.getScoreList(query);
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		List<Course> courses = courseService.getCourseList(null);
		List<Student>students = studentService.getStudentList(null);
				
		request.setAttribute("scores", scores);
		request.setAttribute("courses", courses);
		request.setAttribute("students", students);
		request.getRequestDispatcher("/WEB-INF/pages/admin/admin-score.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
