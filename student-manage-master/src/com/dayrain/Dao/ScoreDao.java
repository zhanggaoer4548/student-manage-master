package com.dayrain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.entity.Course;
import com.dayrain.entity.Score;
import com.dayrain.entity.Student;
import com.dayrain.entity.dto.ScoreDto;
import com.dayrain.utils.DBUtils;
import com.dayrain.utils.ParamsUtils;

public class ScoreDao {

	//查分
	public List<ScoreDto> getScoreList(String query) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<ScoreDto> res = new ArrayList<ScoreDto>();
		
		try {
			con = DBUtils.getConnection();
			String sql = "select sc.id as id, sc.score as score, st.student_no as student_no, st.student_name as student_name"
					+ ", co.course_no as course_no, co.course_name as course_name from tb_score sc, tb_student st, tb_course co"
					+ " where (sc.course_no = co.course_no and sc.student_no = st.student_no) ";
			if(query != null && !"".equals(query.trim())) {
				query = ParamsUtils.wrapper(query);
				sql += " and ( sc.student_no like " + query + " or  co.course_no like " + query +" or co.course_name like " + query + " or st.student_name like " + query + ")";
			}
			sql += " order by sc.create_time desc";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				ScoreDto scoreDto = new ScoreDto();
				scoreDto.setId(resultSet.getInt("id"));
				scoreDto.setScore(resultSet.getFloat("score"));
				scoreDto.setStudentNo(resultSet.getString("student_no"));
				scoreDto.setStudentName(resultSet.getString("student_name"));
				scoreDto.setCourseNo(resultSet.getString("course_no"));
				scoreDto.setCourseName(resultSet.getString("course_name"));
				
				res.add(scoreDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	}
	
	/**
	 * 更新成绩
	 * @param score 成绩
	 */
	public void updateScore(Score score) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<ScoreDto> res = new ArrayList<ScoreDto>();
		
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_score set score = ? where id = ?";
			pre = con.prepareStatement(sql);
			pre.setFloat(1, score.getScore());
			pre.setInt(2, score.getId());
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	/**
	 * 删除成绩
	 * @param id 主键
	 */
	public void deleteScore(int id) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		
		try {
			con = DBUtils.getConnection();
			String sql = "delete from  tb_score where id = ?";
			pre = con.prepareStatement(sql);
		
			pre.setInt(1, id);
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	/**
	 * 根据学号和课程号获取成绩
	 * @param studenNo 学号
	 * @param courseNo 课程号
	 * @return
	 */
	public Score getScoreByStudentNoAndCourseNo(String studenNo, String courseNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_score where student_no = ? and course_no = ?";
			pre = con.prepareStatement(sql);
		
			pre.setString(1, studenNo);
			pre.setString(2, courseNo);
			resultSet = pre.executeQuery();
			while(resultSet.next()) {
	
				resultSet.getFloat("score");
				Score score = new Score();
				score.setId(resultSet.getInt("id"));
				score.setScore(resultSet.getFloat("score"));
				score.setStudentNo(resultSet.getString("student_no"));
				score.setCourseNo(resultSet.getString("course_no"));
				return score;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	}

	public void addScore(Score score) {
		
		Connection con = null;
		PreparedStatement pre = null;
		try {
			con = DBUtils.getConnection();
			String sql = "insert into tb_score(course_no, student_no, score, create_time, update_time) values(?, ?, ?, ?, ?)";
			pre = con.prepareStatement(sql);
			pre.setString(1, score.getCourseNo());
			pre.setString(2, score.getStudentNo());
			pre.setFloat(3, score.getScore());
			pre.setDate(4, new java.sql.Date(score.getCreateTime().getTime()));
			pre.setDate(5, new java.sql.Date(score.getUpdateTime().getTime()));
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, null);
		}
	}

	public List<ScoreDto> getTopScoreList(int top) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<ScoreDto> res = new ArrayList<ScoreDto>();
		
		try {
			con = DBUtils.getConnection();
			String sql = "select sc.id as id, sc.score as score, st.student_no as student_no, st.student_name as student_name"
					+ ", co.course_no as course_no, co.course_name as course_name from tb_score sc, tb_student st, tb_course co"
					+ " where sc.course_no = co.course_no and sc.student_no = st.student_no order by sc.score desc limit ?";
			pre = con.prepareStatement(sql);
			pre.setInt(1, top);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				ScoreDto scoreDto = new ScoreDto();
				scoreDto.setId(resultSet.getInt("id"));
				scoreDto.setScore(resultSet.getFloat("score"));
				scoreDto.setStudentNo(resultSet.getString("student_no"));
				scoreDto.setStudentName(resultSet.getString("student_name"));
				scoreDto.setCourseNo(resultSet.getString("course_no"));
				scoreDto.setCourseName(resultSet.getString("course_name"));				
				res.add(scoreDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	}

	public List<ScoreDto> getScoreListByStudentNo(String studentNo) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<ScoreDto> res = new ArrayList<ScoreDto>();
		
		try {
			con = DBUtils.getConnection();
			String sql = "select sc.id as id, sc.score as score, st.student_no as student_no, st.student_name as student_name"
					+ ", co.course_no as course_no, co.course_name as course_name from tb_score sc, tb_student st, tb_course co"
					+ " where sc.course_no = co.course_no and sc.student_no = st.student_no and sc.student_no = ? order by sc.create_time desc";
			pre = con.prepareStatement(sql);
			pre.setString(1, studentNo);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				ScoreDto scoreDto = new ScoreDto();
				scoreDto.setId(resultSet.getInt("id"));
				scoreDto.setScore(resultSet.getFloat("score"));
				scoreDto.setStudentNo(resultSet.getString("student_no"));
				scoreDto.setStudentName(resultSet.getString("student_name"));
				scoreDto.setCourseNo(resultSet.getString("course_no"));
				scoreDto.setCourseName(resultSet.getString("course_name"));
				
				res.add(scoreDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return res;
	}

	public int getBeforeScoreNum(String courseNo, Float score) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<ScoreDto> res = new ArrayList<ScoreDto>();
		
		try {
			con = DBUtils.getConnection();
			String sql = "select count(*) from tb_score where course_no = ? and score > ? ";
			pre = con.prepareStatement(sql);
			pre.setString(1, courseNo);
			pre.setFloat(2, score);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return 0;
	}
}
