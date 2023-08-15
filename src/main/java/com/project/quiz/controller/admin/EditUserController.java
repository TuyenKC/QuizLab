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

@WebServlet("/admin/edituser")
public class EditUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		User editUser = (User) userService.get(id);
		req.setAttribute("editUser", editUser);
		req.getRequestDispatcher("../view/admin/view/editUser.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		int roleId = 2;
		String role = req.getParameter("role");
		if(role.equals("Admin"))
			roleId = 1;
		UserService userService = new UserServiceImpl();
		userService.edit(new User(id,username,password,email,roleId));
		resp.sendRedirect(req.getContextPath()+ "/admin/userlist");
		
	}

}

