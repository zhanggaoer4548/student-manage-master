package com.dayrain.service;

import java.util.Date;
import java.util.List;

import com.dayrain.Dao.UserDao;
import com.dayrain.entity.Student;
import com.dayrain.entity.User;
import com.dayrain.utils.EncryptUtils;

public class UserService {
	
	/**
	 * 登录校验
	 * @param username 用户
	 * @param password 密码
	 * @return 是否登录成功
	 */
	public User loginCheck(String username, String password) {
		UserDao userDao = new UserDao();
		
		User userRes = userDao.getUserByUserNameAndPassword(username, EncryptUtils.MD5Encode(password));
		
		return userRes;
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<User> getUserList(String query) {
		UserDao userDao = new UserDao();
		return userDao.getUserList(query);
	}
	
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		StudentService studentService = new StudentService();
		Student student = studentService.getStudentByNo(user.getStudentNo());
		user.setDisplayName(student.getStudentName());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setUserType((byte)2);
		user.setState((byte)1);	
		user.setUsername(user.getStudentNo());
		UserDao userDao = new UserDao();
		User res = userDao.getUserByUserName(user.getUsername());
		if(res != null) {
			return;
		}
		userDao.addUser(user);
	}
	
	/*
	 *删除用户 
	 */
	public void deleteUser(int id) {
		UserDao userDao = new UserDao();
		userDao.deleteUser(id);
	}
	
	/**
	 * 改变状态
	 * @param state 状态
	 * @param userId 用户id
	 */
	public void changeStatus(Byte state, int userId) {
		UserDao userDao = new UserDao();
		userDao.changeStatus(state, userId);
	}
}
