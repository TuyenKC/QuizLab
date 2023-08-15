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

@WebServlet("/admin/editcategory")
public class EditCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.get(id);
		req.setAttribute("category", category);
		req.getRequestDispatcher("../view/admin/view/editCategory.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.update(new Category(id,title,description));
		resp.sendRedirect(req.getContextPath()+ "/admin/categorylist");
	}
}
