package com.project.quiz.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.Category;
import com.project.quiz.model.Quiz;
import com.project.quiz.service.CategoryService;
import com.project.quiz.service.QuizService;
import com.project.quiz.service.impl.CategoryServiceImpl;
import com.project.quiz.service.impl.QuizServiceImpl;

@WebServlet("/admin/addquiz")
public class AddQuizController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.getAll();
		req.setAttribute("categoryList", categoryList);
		req.getRequestDispatcher("../view/admin/view/addQuiz.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId = Integer.parseInt(req.getParameter("category_id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int totalTime = Integer.parseInt(req.getParameter("total_time"));
		QuizService quizService = new QuizServiceImpl();
		quizService.insert(new Quiz(title,description,totalTime,0,0,categoryId));
		resp.sendRedirect(req.getContextPath()+ "/admin/quizlist");
	}
}
