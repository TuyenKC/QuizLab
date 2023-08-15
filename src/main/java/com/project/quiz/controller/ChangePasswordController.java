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

@WebServlet("/changepassword")

public class ChangePasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/client/view/changePassword.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		UserService userService = new UserServiceImpl();
		user.setPassword(password);
		userService.edit(user);
		req.getRequestDispatcher("/view/client/view/profile.jsp").forward(req, resp);
		}
}