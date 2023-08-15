package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.service.QuestionService;
import com.project.quiz.service.impl.QuestionServiceImpl;

@WebServlet("/admin/deletequestion")
public class DeleteQuestionController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QuestionService questionService = new QuestionServiceImpl();
		int questionId = Integer.parseInt(req.getParameter("question_id"));
		int quizId = Integer.parseInt(req.getParameter("quiz_id"));
		questionService.delete(questionId);
		resp.sendRedirect(req.getContextPath() + "/admin/questionlist?quiz_id="+quizId);
	}
}