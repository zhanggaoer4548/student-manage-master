package com.dayrain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.entity.Course;
import com.dayrain.utils.DBUtils;
import com.dayrain.utils.ParamsUtils;

public class CourseDao {

	// 获取所有的课程
	public List<Course> getCourseList(String query) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<Course> res = new ArrayList<Course>();

		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_course";

			if(query != null && !"".equals(query.trim())) {
				query = ParamsUtils.wrapper(query);
				sql += " where course_no like " + query + " or course_name like " + query + " or teacher_no like " + query;
			}

			sql += " order by create_time desc";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				String courseNo = resultSet.getString("course_no");
				String courseName = resultSet.getString("course_name");
				String teacherNo = resultSet.getString("teacher_no");
				Integer studentNum = resultSet.getInt("student_num");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Course course = new Course();
				course.setCourseName(courseName);
				course.setCourseNo(courseNo);
				course.setTeacherNo(teacherNo);
				course.setStudentNum(studentNum);
				course.setCreateTime(createTime);
				course.setUpdateTime(updateTime);
				res.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	}

	// 通过课程号获取课程信息
	public Course getCourseByNo(String courseNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_course where course_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, courseNo);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
			
				String courseName = resultSet.getString("course_name");
				String teacherNo = resultSet.getString("teacher_no");
				Integer studentNum = resultSet.getInt("student_num");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Course course = new Course();
				course.setCourseName(courseName);
				course.setCourseNo(courseNo);
				course.setTeacherNo(teacherNo);
				course.setStudentNum(studentNum);
				course.setCreateTime(createTime);
				course.setUpdateTime(updateTime);
				return course;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	}

	// 添加课程
	public boolean addCourse(Course course) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "insert into tb_course(course_no, course_name, teacher_no, student_num, create_time, update_time) values(?,?,?,?,?,?)";
			pre = con.prepareStatement(sql);
			pre.setString(1, course.getCourseNo());
			pre.setString(2, course.getCourseName());
			pre.setString(3, course.getTeacherNo());
			pre.setInt(4, course.getStudentNum());
			pre.setDate(5, new java.sql.Date(course.getCreateTime().getTime()));
			pre.setDate(6, new java.sql.Date(course.getUpdateTime().getTime()));
			return pre.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return false;
	}

	public void deleteCourse(String courseNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "delete from tb_course where course_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, courseNo);
			pre.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}

	public void updateCourse(Course course) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_course set course_name = ?, teacher_no = ?, update_time = ? where course_no = ?";
			pre = con.prepareStatement(sql);

			pre.setString(1, course.getCourseName());
			pre.setString(2, course.getTeacherNo());
			pre.setDate(3, new java.sql.Date(course.getUpdateTime().getTime()));
			pre.setString(4, course.getCourseNo());
			pre.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}

	public int count() {
		Connection con = null;
		PreparedStatement pre = null;		
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "select count(*) from tb_course";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while(resultSet.next()) {
				int num = resultSet.getInt(1);
				return num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return 0;
	}

	public void plusStudentNum(String courseNo) {
		Connection con = null;
		PreparedStatement pre = null;		
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_course set student_num = student_num + 1 where course_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, courseNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
}
