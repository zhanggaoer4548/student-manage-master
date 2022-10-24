package com.dayrain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.entity.Student;
import com.dayrain.utils.DBUtils;
import com.dayrain.utils.ParamsUtils;

public class StudentDao {
	
	//获取所有的学生
	public List<Student> getStudentList(String query) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<Student> res = new ArrayList<Student>();

		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_student ";
			if(query != null && !"".equals(query.trim())) {
				query = ParamsUtils.wrapper(query);
				sql += "where student_no like " + query + " or student_name like " + query + " or description like " + query;
			}
			sql += " order by create_time desc";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while(resultSet.next()) {
				String studentNo = resultSet.getString("student_no");
				String studentName = resultSet.getString("student_name");
				String description = resultSet.getString("description");
				String idCard = resultSet.getString("id_card");
				Integer age = resultSet.getInt("age");
				Byte gender = resultSet.getByte("gender");
				String year = resultSet.getString("year");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Student student = new Student();
				student.setStudentNo(studentNo);
				student.setStudentName(studentName);
				student.setDescription(description);
				student.setIdCard(idCard);
				student.setAge(age);
				student.setGender(gender);
				student.setYear(year);
				student.setCreateTime(createTime);
				student.setUpdateTime(updateTime);
				res.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	}
	
	//通过学号获取学生信息
	public Student getStudentByNo(String studentNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_student where student_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, studentNo);
			resultSet = pre.executeQuery();
			while(resultSet.next()) {
				String studentName = resultSet.getString("student_name");
				String description = resultSet.getString("description");
				String idCard = resultSet.getString("id_card");
				Integer age = resultSet.getInt("age");
				Byte gender = resultSet.getByte("gender");
				String year = resultSet.getString("year");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Student student = new Student();
				student.setStudentNo(studentNo);
				student.setStudentName(studentName);
				student.setDescription(description);
				student.setIdCard(idCard);
				student.setAge(age);
				student.setGender(gender);
				student.setYear(year);
				student.setCreateTime(createTime);
				student.setUpdateTime(updateTime);
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	}
	
	//添加学生
	public boolean addStudent(Student student) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "insert into tb_student(student_no, student_name, description, id_card, age, gender, year, create_time, update_time) values(?,?,?,?,?,?,?,?,?)";
			pre = con.prepareStatement(sql);
			pre.setString(1, student.getStudentNo());
			pre.setString(2, student.getStudentName());
			pre.setString(3, student.getDescription());
			pre.setString(4, student.getIdCard());
			pre.setInt(5, student.getAge());
			pre.setByte(6, student.getGender());
			pre.setString(7, student.getYear());
			pre.setDate(8, new java.sql.Date(student.getCreateTime().getTime()));
			pre.setDate(9, new java.sql.Date(student.getUpdateTime().getTime()));
			return pre.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return false;
	}
	
	public void deleteStudent(String studentNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "delete from tb_student where student_no = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, studentNo);
			pre.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	public void updateStudent(Student student) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_student set student_name = ?, description = ?, id_card = ?, age = ?, gender = ?, year = ?, update_time = ? where student_no = ?";
			pre = con.prepareStatement(sql);

			pre.setString(1, student.getStudentName());
			pre.setString(2, student.getDescription());
			pre.setString(3, student.getIdCard());
			pre.setInt(4, student.getAge());
			pre.setByte(5, student.getGender());
			pre.setString(6, student.getYear());
			pre.setDate(7, new java.sql.Date(student.getUpdateTime().getTime()));			
			pre.setString(8, student.getStudentNo());
			pre.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	public List<Student> getStudentUnRegister() {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<Student> res = new ArrayList<Student>();
				
		try {
			con = DBUtils.getConnection();
			String sql = "select st.* from tb_student st where st.student_no not in (select student_no from tb_user) order by create_time desc";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while(resultSet.next()) {
				String studentNo = resultSet.getString("student_no");
				String studentName = resultSet.getString("student_name");
				String description = resultSet.getString("description");
				String idCard = resultSet.getString("id_card");
				Integer age = resultSet.getInt("age");
				Byte gender = resultSet.getByte("gender");
				String year = resultSet.getString("year");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				Student student = new Student();
				student.setStudentNo(studentNo);
				student.setStudentName(studentName);
				student.setDescription(description);
				student.setIdCard(idCard);
				student.setAge(age);
				student.setGender(gender);
				student.setYear(year);
				student.setCreateTime(createTime);
				student.setUpdateTime(updateTime);
				res.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	}

	public int count() {
		Connection con = null;
		PreparedStatement pre = null;		
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "select count(*) from tb_student";
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
	
	public void updateStudent(String studentNo, String description) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_student set description = ? where student_no = ?";
			pre = con.prepareStatement(sql);
		    pre.setString(1, description);
		    pre.setString(2, studentNo);
		    
		    pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
}
