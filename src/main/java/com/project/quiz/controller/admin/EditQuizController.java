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

@WebServlet("/admin/editquiz")
public class EditQuizController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		QuizService quizService = new QuizServiceImpl();
		List<Category> categoryList = categoryService.getAll();
		Integer quizId = Integer.parseInt(req.getParameter("id"));
		Quiz editQuiz = quizService.get(quizId);
		req.setAttribute("editQuiz", editQuiz);
		req.setAttribute("categoryList", categoryList);
		req.getRequestDispatcher("../view/admin/view/editQuiz.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quizId = Integer.parseInt(req.getParameter("quiz_id"));
		int categoryId = Integer.parseInt(req.getParameter("category_id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int totalTime = Integer.parseInt(req.getParameter("total_time"));
		QuizService quizService = new QuizServiceImpl();
		quizService.update(new Quiz(quizId, title,description,totalTime,0,0,categoryId));
		resp.sendRedirect(req.getContextPath()+ "/admin/quizlist");
	}
}

