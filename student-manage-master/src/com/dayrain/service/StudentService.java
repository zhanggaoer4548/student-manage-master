package com.dayrain.service;

import java.util.List;

import com.dayrain.Dao.StudentDao;
import com.dayrain.entity.Student;

public class StudentService {
	
	/**
	 * 获取学生列表
	 * @return 所有的学生信息
	 */
	public List<Student> getStudentList(String query) {
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList(query);
		return studentList;
	}
	
	/**
	 * 通过学号获取学生
	 * @param studentNo 学生
	 * @return
	 */
	public Student getStudentByNo(String studentNo) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudentByNo(studentNo);
		return student;
	}
	
	/*
	 *添加学生
	 */
	public Student addStudent(Student student) {
		StudentDao studentDao = new StudentDao();
		studentDao.addStudent(student);
		
		return this.getStudentByNo(student.getStudentNo());
	}
	
	/**
	 * 删除学生
	 * @return 
	 */
	public void deleteStudent(String studentNo) {
		StudentDao studentDao = new StudentDao();
		studentDao.deleteStudent(studentNo);
	}
	
	/**
	 * 更新学生
	 * @param student
	 */
	public void updateStudent(Student student) {
		StudentDao studentDao = new StudentDao();
		studentDao.updateStudent(student);
	}
	
	
	/**
	 * 获取未注册的学生
	 * @return
	 */
	public List<Student> getStudentUnRegister() {
		StudentDao studentDao = new StudentDao();
		return studentDao.getStudentUnRegister();
	}

	/**
	 * 统计
	 * @return
	 */
	public int count() {
		StudentDao studentDao = new StudentDao();
		return studentDao.count();
	}
	
	/**
	 * 更新
	 * @param studentNo
	 * @param description
	 */
	public void updateStudent(String studentNo, String description) {
		StudentDao studentDao = new StudentDao();
		studentDao.updateStudent(studentNo, description);
	}
	
	
}
