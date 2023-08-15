package com.project.quiz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.quiz.model.User;
@WebFilter(urlPatterns="/admin/*")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && user.getRoleId() == 1) {
			chain.doFilter(request,response);
			return;
		}else {
			resp.sendRedirect(req.getContextPath() + "/logout");
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	

}
