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

@WebServlet("/editprofile")

public class EditProfileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		req.setAttribute("user", user);
		req.getRequestDispatcher("/view/client/view/editProfile.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		UserService userService = new UserServiceImpl();
		user.setEmail(email);
		userService.edit(user);
		req.getRequestDispatcher("/view/client/view/profile.jsp").forward(req, resp);
	}
}