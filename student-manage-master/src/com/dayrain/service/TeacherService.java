package com.dayrain.service;

import java.util.List;

import com.dayrain.Dao.TeacherDao;
import com.dayrain.entity.Teacher;

public class TeacherService {
	/**
	 * 获取教师列表
	 * @return 所有的课程信息
	 */
	public List<Teacher> getTeacherList(String query) {
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teachers = teacherDao.getTeacherList(query);
		return teachers;
	}
	
	/**
	 * 通过工号获取教师
	 * @param teacherNo 教师编号
	 * @return
	 */
	public Teacher getTeacherByNo(String teacherNo) {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.getTeacherByTeacherNo(teacherNo);
		return teacher;
	}
	
	/**
	 * 添加教师
	 * @param teacher 教师
	 * @return
	 */
	public Teacher addTeacher(Teacher teacher) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.addTeacher(teacher);
		return teacherDao.getTeacherByTeacherNo(teacher.getTeacherNo());
	}
	
	/**
	 * 删除教师
	 */
	public void deleteTeacher(String teacherNo) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(teacherNo);
	}
	
	/**
	 * 更新教师
	 * @param teacher 教师
	 */
	public void updateTeacher(Teacher teacher) {
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.updateTeacher(teacher);
	}
	
	public Teacher getTeacherByCourseNo(String course) {
		TeacherDao teacherDao = new TeacherDao();
		return teacherDao.getTeacherByCourseNo(course);
	}
}
