package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.User;
import com.project.quiz.service.UserService;
import com.project.quiz.service.impl.UserServiceImpl;

@WebServlet("/admin/adduser")
public class AddUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../view/admin/view/addUser.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String role = req.getParameter("role");
		int roleId = role.equals("Admin") ? 1:2;
		System.out.println(email);
		UserService userService = new UserServiceImpl();
		userService.insert(new User(username, password, email, roleId));
		resp.sendRedirect(req.getContextPath()+ "/admin/userlist");
	}
}
