package com.dayrain.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Teacher;
import com.dayrain.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetTeacher
 */
@WebServlet("/getTeacher")
public class GetTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTeacher() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherService teacherService = new TeacherService();
		String teacherNo = request.getParameter("teacherNo");
		Teacher teacher = teacherService.getTeacherByNo(teacherNo);
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/json; charset=utf-8");
		ObjectMapper objectMapper = new ObjectMapper();
		
		writer.print(objectMapper.writeValueAsString(teacher));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
