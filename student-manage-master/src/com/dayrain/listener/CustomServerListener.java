package com.dayrain.listener;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CustomServerListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	private volatile ServletContext application = null;
	//上下文初始化，记录当前时间的时间戳，初始化人数统计变量
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("初始化开始---------");
		int onlineNum = 0;
		application = sce.getServletContext();
		application.setAttribute("onlineNum", onlineNum);
		application.setAttribute("startTime", new Date().getTime());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}

	//session创建的时候调用该方法。但是我们计算在线人数指的是登录成功的人
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
	}

	//连接断开
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

	//
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("有人登录了---------");
		int onlineNum = (int) application.getAttribute("onlineNum");
		application.setAttribute("onlineNum", ++onlineNum);
	}
	
	

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("有人退出了---------");
		int onlineNum = (int) application.getAttribute("onlineNum");
		application.setAttribute("onlineNum", --onlineNum);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		
	}
}
