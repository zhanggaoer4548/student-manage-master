package com.dayrain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.entity.Student;
import com.dayrain.entity.Teacher;
import com.dayrain.utils.DBUtils;
import com.dayrain.utils.ParamsUtils;

public class TeacherDao {
	/**
	 * 获取所有的老师
	 * 
	 * @return
	 */
	public List<Teacher> getTeacherList(String query) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<Teacher> res = new ArrayList<Teacher>();

		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_teacher";
			if(query != null && !"".equals(query.trim())) {
				query = ParamsUtils.wrapper(query);
				sql += " where teacher_no like " + query + " or teacher_name like " + query;
			}
			sql += " order by create_time desc";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				String teacherNo = resultSet.getString("teacher_no");
				String teacherName = resultSet.getString("teacher_name");
				Byte gender = resultSet.getByte("gender");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Teacher teacher = new Teacher();
				teacher.setTeacherNo(teacherNo);
				teacher.setTeacherName(teacherName);
				teacher.setGender(gender);
				teacher.setCreateTime(createTime);
				teacher.setUpdateTime(updateTime);
				res.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	
	
	
	}
	
	
	/**
	 * 获取所有的老师
	 * 
	 * @return
	 */
	public Teacher getTeacherByTeacherNo(String teacherNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_teacher where teacher_no = ? order by create_time desc";
			pre = con.prepareStatement(sql);
			pre.setNString(1, teacherNo);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				String teacherName = resultSet.getString("teacher_name");
				Byte gender = resultSet.getByte("gender");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Teacher teacher = new Teacher();
				teacher.setTeacherNo(teacherNo);
				teacher.setTeacherName(teacherName);
				teacher.setGender(gender);
				teacher.setCreateTime(createTime);
				teacher.setUpdateTime(updateTime);
				return teacher;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	
	
	
	}
	
	/**
	 * 添加教师
	 * @param teacher
	 * @return
	 */
	public boolean addTeacher(Teacher teacher) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "insert into tb_teacher(teacher_no, teacher_name, gender, create_time, update_time) values(?,?,?,?,?)";
			pre = con.prepareStatement(sql);
			pre.setString(1, teacher.getTeacherNo());
			pre.setString(2, teacher.getTeacherName());
			pre.setByte(3, teacher.getGender());
			pre.setDate(4, new java.sql.Date(teacher.getCreateTime().getTime()));
			pre.setDate(5, new java.sql.Date(teacher.getUpdateTime().getTime()));
			return pre.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return false;
	}
	
	/**
	 * 修改教师
	 */
	public boolean updateTeacher(Teacher teacher) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_teacher set teacher_name = ?, gender = ?, update_time = ? where teacher_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, teacher.getTeacherName());
			pre.setByte(2, teacher.getGender());
			pre.setDate(3, new java.sql.Date(teacher.getUpdateTime().getTime()));
			pre.setString(4, teacher.getTeacherNo());
			return pre.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return false;
	}
	
	/**
	 * 删除教师信息
	 * @param teacherNo 教师工号
	 */
	public void deleteTeacher(String teacherNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "delete from tb_teacher where teacher_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, teacherNo);
			pre.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}


	public Teacher getTeacherByCourseNo(String course) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		
		try {
			con = DBUtils.getConnection();
			String sql = "select te.* from tb_teacher te, tb_course co where te.teacher_no = co.teacher_no and co.course_no = ?";
			pre = con.prepareStatement(sql);
			pre.setNString(1, course);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				String teacherName = resultSet.getString("teacher_name");
				Byte gender = resultSet.getByte("gender");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				String teacherNo = resultSet.getString("teacher_no");
				Teacher teacher = new Teacher();
				teacher.setTeacherNo(teacherNo);
				teacher.setTeacherName(teacherName);
				teacher.setGender(gender);
				teacher.setCreateTime(createTime);
				teacher.setUpdateTime(updateTime);
				return teacher;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	}
}
