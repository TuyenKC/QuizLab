package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.service.QuizService;
import com.project.quiz.service.impl.QuizServiceImpl;

@WebServlet("/admin/deletequiz")
public class DeleteQuizController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QuizService quizService = new QuizServiceImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		quizService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/quizlist");
	}
}