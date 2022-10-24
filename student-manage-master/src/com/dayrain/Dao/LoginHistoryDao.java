package com.dayrain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.entity.LoginHistory;
import com.dayrain.utils.DBUtils;

public class LoginHistoryDao {
	
	public void addLoginHistory(LoginHistory loginHistory) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<LoginHistory>loginHistories = new ArrayList<LoginHistory>();
		try {
			con = DBUtils.getConnection();
			String sql = "insert into tb_login_history(user_id, ip, create_time) values(?, ?, ?)";
			pre = con.prepareStatement(sql);
			pre.setInt(1, loginHistory.getUserId());
			pre.setString(2, loginHistory.getIp());
			pre.setDate(3, new java.sql.Date(loginHistory.getCreateTime().getTime()));
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		
	}
	
	
	public List<LoginHistory>getLoginHistoryList() {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultSet = null;
		List<LoginHistory>loginHistories = new ArrayList<LoginHistory>();
		try {
			con = DBUtils.getConnection();
			String sql = "select * from tb_login_history";
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				Integer userId = resultSet.getInt("user_id");
				String ip = resultSet.getString("ip");
				Date createTime= resultSet.getDate("create_time");
				
				LoginHistory loginHistory = new LoginHistory();
				loginHistory.setId(id);
				loginHistory.setUserId(userId);
				loginHistory.setIp(ip);
				loginHistory.setCreateTime(createTime);
				loginHistories.add(loginHistory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(con, pre, resultSet);
		}
		return loginHistories;
	}
}
