package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.service.UserService;
import com.project.quiz.service.impl.UserServiceImpl;
@WebServlet("/admin/deleteuser")
public class DeleteUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		userService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/userlist");
	}
}
