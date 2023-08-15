package com.project.quiz.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.quiz.model.Question;
import com.project.quiz.model.Quiz;
import com.project.quiz.service.QuestionService;
import com.project.quiz.service.QuizService;
import com.project.quiz.service.impl.QuestionServiceImpl;
import com.project.quiz.service.impl.QuizServiceImpl;

@WebServlet("/admin/questionlist")
public class QuestionListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		QuestionService questionService = new QuestionServiceImpl();
		QuizService quizService = new QuizServiceImpl();
		int quizId = Integer.parseInt((String) req.getParameter("quiz_id"));
		quizService.updateTotal(quizId);
		List<Question> questionList = questionService.getQuestionListByQuiz(quizId);
		Quiz quiz = quizService.get(quizId);
		req.setAttribute("quiz",quiz);
		req.setAttribute("questionList", questionList);
		req.getRequestDispatcher("../view/admin/view/questionList.jsp").forward(req, resp);
	}
}