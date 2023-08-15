package com.project.quiz.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@WebServlet("/admin/quizlist")
public class QuizListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QuizService quizService = new QuizServiceImpl();
		List<Quiz> quizList = quizService.getAll();
		Map<Integer, String> categoryMap = new HashMap<>();
	    CategoryService categoryService = new CategoryServiceImpl();
	    List<Category> categoryList = categoryService.getAll();
	    for (Category category : categoryList) {
	        categoryMap.put(category.getId(), category.getTitle());
	    }
	    req.setAttribute("categoryMap", categoryMap);
		req.setAttribute("quizList", quizList);
		req.getRequestDispatcher("../view/admin/view/quizList.jsp").forward(req, resp);
	}
}
