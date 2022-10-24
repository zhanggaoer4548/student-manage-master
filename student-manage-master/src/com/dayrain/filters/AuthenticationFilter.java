package com.dayrain.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.dayrain.entity.User;
@WebFilter(value = "/admin/*", filterName = "B")
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		
		User user = (User) req.getSession().getAttribute("loginUser");
		Byte type = user.getUserType();
		if(type != 1) {
			//不是管理员，跳转到错误页面
			req.setAttribute("msg", "抱歉，您没有权限访问！");
			req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, response);;
		}else {
			chain.doFilter(req, response);
		}
	}

}
