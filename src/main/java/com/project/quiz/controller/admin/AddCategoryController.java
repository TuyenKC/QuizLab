package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.Category;
import com.project.quiz.service.CategoryService;
import com.project.quiz.service.impl.CategoryServiceImpl;

@WebServlet("/admin/addcategory")
public class AddCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../view/admin/view/addCategory.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.insert(new Category(title,description));
		resp.sendRedirect(req.getContextPath()+ "/admin/categorylist");
	}
}
