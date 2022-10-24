package com.dayrain.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.Dao.StudentDao;
import com.dayrain.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetStudent
 */
@WebServlet("/getStudent")
public class GetStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudentByNo(studentNo);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/json; charset=utf-8");
		ObjectMapper objectMapper = new ObjectMapper();
		
		writer.print(objectMapper.writeValueAsString(student));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
