package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.service.CategoryService;
import com.project.quiz.service.impl.CategoryServiceImpl;

@WebServlet("/admin/deletecategory")
public class DeleteCategoryController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		categoryService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/categorylist");
	}
}