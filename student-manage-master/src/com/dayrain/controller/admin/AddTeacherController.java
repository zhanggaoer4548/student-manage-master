package com.dayrain.controller.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dayrain.entity.Teacher;
import com.dayrain.service.TeacherService;

/*
 * 添加教师
 */
@WebServlet("/admin/addTeacher")
public class AddTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String teacherNo = request.getParameter("teacherNo");
		String teacherName = request.getParameter("teacherName");		
		Byte gender = Byte.valueOf(request.getParameter("gender"));
		Date createTime = new Date();
		Date updateTime = new Date();
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherName(teacherName);
		teacher.setGender(gender);
		teacher.setUpdateTime(updateTime);
		teacher.setCreateTime(createTime);
		
		TeacherService teacherService = new TeacherService();
		

		Teacher query = teacherService.getTeacherByNo(teacherNo);
		if(query != null) {
			request.setAttribute("msg", "工号为" + teacherNo + "的教师已存在！");
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
			return;
		}
		teacherService.addTeacher(teacher);
		request.getRequestDispatcher("/admin/adminTeacherUrl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
