package com.project.quiz.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.Question;
import com.project.quiz.service.QuestionService;
import com.project.quiz.service.impl.QuestionServiceImpl;

@WebServlet("/admin/editquestion")
public class EditQuestionController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int questionId = Integer.parseInt(req.getParameter("question_id"));
		QuestionService questionService = new QuestionServiceImpl();
		Question editQuestion = questionService.get(questionId);
		req.setAttribute("editQuestion", editQuestion);
		req.getRequestDispatcher("../view/admin/view/editQuestion.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int questionId = Integer.parseInt(req.getParameter("question_id"));
		int quizId = Integer.parseInt(req.getParameter("quiz_id"));
		String content = req.getParameter("content");
		String optionA = req.getParameter("option_a");
		String optionB = req.getParameter("option_b");
		String optionC = req.getParameter("option_c");
		String optionD = req.getParameter("option_d");
		String correctOption = req.getParameter("correct_option");
		int score = Integer.parseInt(req.getParameter("score"));
		QuestionService questionService = new QuestionServiceImpl();
		questionService.update(new Question(questionId, quizId, content, optionA, optionB, optionC, optionD, correctOption,score));
		resp.sendRedirect(req.getContextPath()+ "/admin/questionlist?quiz_id=" + quizId );
	}
}
