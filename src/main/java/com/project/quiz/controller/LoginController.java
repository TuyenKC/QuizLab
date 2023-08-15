package com.project.quiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.quiz.model.User;
import com.project.quiz.service.UserService;
import com.project.quiz.service.impl.UserServiceImpl;
import com.project.quiz.dao.UserDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessionUser = req.getSession();
		if(sessionUser.getAttribute("user") != null) {
			resp.sendRedirect("waiting");
		}else {
			req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = new UserServiceImpl();
		User user = userService.login(username, password);
		String alertMsg = "";
		if(user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			resp.sendRedirect("waiting");
		}else {
			alertMsg = "Username or password is not correct";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
		}
	}
	
}