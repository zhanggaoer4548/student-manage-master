package com.dayrain.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtils {
//	private static String username = "root";
//	private static String password = "Ph0716";
//	private static String url = "jdbc:mysql://175.24.15.179:3306/student_manage";
//	private static Connection con= null;
//	
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(url, username, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	private static DataSource dataSource;
	//使用数据库连接池
	static {
	
		try {
			Properties pro = new Properties();
			pro.load(DBUtils.class.getResourceAsStream("/druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void closeConnection(Connection con, Statement statement, ResultSet result) {
		try {
			if(con != null) {
				con.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(result != null) {
				result.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
