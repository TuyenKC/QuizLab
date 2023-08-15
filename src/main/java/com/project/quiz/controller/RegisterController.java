package com.project.quiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.quiz.service.UserService;
import com.project.quiz.service.impl.UserServiceImpl;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessionUser = req.getSession();
		if(sessionUser.getAttribute("user") != null) {
			resp.sendRedirect("waiting");
		}else {
			req.getRequestDispatcher("/view/client/view/register.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm-password");
		String email = req.getParameter("email");
		int roleId = 2;
		String alert = "";
		if(password.equals(confirmPassword) == false) {
			alert = "Password is different from confirm password";
		}
		if(userService.checkExistUsername(username)) {
			alert = "Username is existed";
		}
		if(alert.equals("")) {
			boolean isSuccess = userService.register(username, password, email, roleId);
			req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);	
		}else {
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("/view/client/view/register.jsp").forward(req, resp);	
		}	
	}
}