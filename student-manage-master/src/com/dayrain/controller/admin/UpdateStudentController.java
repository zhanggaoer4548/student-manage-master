package com.dayrain.controller.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.Student;
import com.dayrain.service.StudentService;

/**
 * 更新学生
 */
@WebServlet("/admin/updateStudent")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNo = request.getParameter("studentNo");
		System.out.println(studentNo);
		String studentName = request.getParameter("studentName");
		System.out.println(studentName);
		String idCard = request.getParameter("idCard");
		Byte gender = Byte.parseByte(request.getParameter("gender"));
		String year = request.getParameter("year");
		Integer age = Integer.valueOf(request.getParameter("age"));
		StudentService studentService = new StudentService();
		Student query = studentService.getStudentByNo(studentNo);
		if(query == null) {
			request.setAttribute("msg", "学号为"+studentNo+"的学生不存在！");
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
			return;
		}
		
		Student student = new Student();
		student.setStudentNo(studentNo);
		student.setStudentName(studentName);
		student.setIdCard(idCard);
		student.setGender(gender);
		student.setYear(year);
		student.setAge(age);
		student.setUpdateTime(new Date());
		studentService.updateStudent(student);
		request.getRequestDispatcher("/admin/adminStudentUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
