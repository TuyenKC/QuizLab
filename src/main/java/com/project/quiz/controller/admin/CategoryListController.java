package com.project.quiz.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.Category;
import com.project.quiz.service.CategoryService;
import com.project.quiz.service.impl.CategoryServiceImpl;

@WebServlet("/admin/categorylist")
public class CategoryListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.getAll();
		req.setAttribute("categoryList", categoryList);
		req.getRequestDispatcher("../view/admin/view/categoryList.jsp").forward(req, resp);
	}
}
