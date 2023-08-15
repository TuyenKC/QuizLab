package com.project.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/quizlist")
public class QuizListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		QuizService quizService = new QuizServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		List<Quiz> quizList = new ArrayList<>();
		if(req.getParameter("category_id") == null ||  req.getParameter("category_id").equals("all")) {
			quizList = quizService.getAll();
			req.setAttribute("categoryId", null);
		}else {
			Integer categoryId = Integer.parseInt(req.getParameter("category_id"));
			quizList = quizService.getListQuizByCategory(categoryId);
			req.setAttribute("categoryId", categoryId);
		}
		List<Category> categoryList = categoryService.getAll();
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("quizList", quizList);		
		req.getRequestDispatcher("/view/client/view/quizList.jsp").forward(req, resp);
	}
}
