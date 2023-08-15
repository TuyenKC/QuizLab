package com.project.quiz.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.User;
import com.project.quiz.service.UserService;
import com.project.quiz.service.impl.UserServiceImpl;

@WebServlet("/admin/userlist")
public class UserListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		List<User> userList = userService.getAll();
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("../view/admin/view/userList.jsp").forward(req, resp);
	}
}