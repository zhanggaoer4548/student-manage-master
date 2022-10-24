package com.dayrain.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayrain.entity.User;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(value = "/*")
public class LoginFilter implements Filter {

	private static List<String> passUrlList = Arrays.asList("login.jsp", "css"
			, "js", "jpg", "loginUrl");

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		// 登录页以及静态资源放行
		boolean needLogin = true;
		//页面名称
		String pageName = "";
		//后缀名
		String endName = "";
		if(uri.lastIndexOf("/") != -1 && uri.lastIndexOf("/") + 1 < uri.length()) {
			pageName = uri.substring(uri.lastIndexOf("/") + 1);
		}
		
		if(uri.lastIndexOf(".") != -1 && uri.lastIndexOf(".") + 1 < uri.length()) {
			endName = uri.substring(uri.lastIndexOf(".") + 1);
		}
		
		for (String passUrl : passUrlList) {
			if(passUrl.equals(pageName) || passUrl.equals(endName)) {
				//不需要登录
				needLogin = false;
			}
		}
		
		User user = (User) req.getSession().getAttribute("loginUser");
		
		if(needLogin && user == null) {
			//该资源需要登录，并且当前用户没有登录
			resp.sendRedirect("/StudentManage/login.jsp");
		}else {
			//不需要登录
			chain.doFilter(req, resp);
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
