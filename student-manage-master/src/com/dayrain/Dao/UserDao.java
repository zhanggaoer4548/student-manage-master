package com.dayrain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.entity.User;
import com.dayrain.utils.DBUtils;
import com.dayrain.utils.ParamsUtils;

public class UserDao {

	public User getUserByUserNameAndPassword(String username, String password) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_user where username = ? and password = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				Integer userId = resultSet.getInt("user_id");

				Byte userType = resultSet.getByte("user_type");
				Byte state = resultSet.getByte("state");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				String displayName = resultSet.getString("display_name");
				String studentNo = resultSet.getString("student_no");
				User user = new User();

				user.setUserId(userId);
				user.setUserType(userType);
				user.setPassword(password);
				user.setUsername(username);
				user.setState(state);
				user.setDisplayName(displayName);
				user.setCreateTime(createTime);
				user.setUpdateTime(updateTime);
				user.setStudentNo(studentNo);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	}
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> getUserList(String query) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<User>res = new ArrayList<User>();
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_user where username != 'admin'";
			if(query != null && !"".equals(query.trim())) {
				query = ParamsUtils.wrapper(query);
				sql += " where username like " + query + " or display_name like " + query;
			}
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				Integer userId = resultSet.getInt("user_id");
				Byte userType = resultSet.getByte("user_type");
				Byte state = resultSet.getByte("state");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				String password = resultSet.getString("password");
				String username = resultSet.getString("username");
				String displayName = resultSet.getString("display_name");
				User user = new User();
				user.setUserId(userId);
				user.setUserType(userType);
				user.setPassword(password);
				user.setUsername(username);
				user.setState(state);
				user.setCreateTime(createTime);
				user.setUpdateTime(updateTime);
				user.setDisplayName(displayName);
				res.add(user);
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
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;

		try {
			con = DBUtils.getConnection();
			String sql = "insert into tb_user(user_type, username, password, student_no, state, create_time, update_time, display_name) "
					+ "values(?, ?, ?, ?, ?, ? , ?, ?)";
			pre = con.prepareStatement(sql);
		    pre.setInt(1, user.getUserType());
		    pre.setString(2, user.getUsername());
		    pre.setString(3, user.getPassword());
		    pre.setString(4, user.getStudentNo());
		    pre.setByte(5, user.getState());
		    pre.setDate(6, new java.sql.Date(user.getCreateTime().getTime()));
		    pre.setDate(7, new java.sql.Date(user.getUpdateTime().getTime()));
		    pre.setString(8, user.getDisplayName());

		    pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	
	//删除用户
	public void deleteUser(int id) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "delete from tb_user where user_id = ? and username != 'admin'";
			pre = con.prepareStatement(sql);
		    pre.setInt(1, id);
		
		    pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	/**
	 * 改变状态
	 * @param state 状态
	 * @param userId 用户id
	 */
	public void changeStatus(Byte state, int userId) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "update tb_user set state = ? where user_id = ?";
			pre = con.prepareStatement(sql);
		    pre.setByte(1, state);
		    pre.setInt(2, userId);
		    
		    pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
	}
	
	public User getUserByUserName(String username) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_user where username = ?";
			pre = con.prepareStatement(sql);
			pre.setString(1, username);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				Integer userId = resultSet.getInt("user_id");

				Byte userType = resultSet.getByte("user_type");
				Byte state = resultSet.getByte("state");
				Date createTime = resultSet.getDate("create_time");
				Date updateTime = resultSet.getDate("update_time");
				String password = resultSet.getString("password");
				User user = new User();

				user.setUserId(userId);
				user.setUserType(userType);
				user.setPassword(password);
				user.setUsername(username);
				user.setState(state);
				user.setCreateTime(createTime);
				user.setUpdateTime(updateTime);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return null;
	}

	

}
