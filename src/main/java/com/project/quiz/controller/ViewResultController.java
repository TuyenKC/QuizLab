package com.project.quiz.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.quiz.model.Answer;
import com.project.quiz.model.History;
import com.project.quiz.model.Question;
import com.project.quiz.model.Quiz;
import com.project.quiz.model.User;
import com.project.quiz.service.AnswerService;
import com.project.quiz.service.HistoryService;
import com.project.quiz.service.QuestionService;
import com.project.quiz.service.QuizService;
import com.project.quiz.service.impl.AnswerServiceImpl;
import com.project.quiz.service.impl.HistoryServiceImpl;
import com.project.quiz.service.impl.QuestionServiceImpl;
import com.project.quiz.service.impl.QuizServiceImpl;
@WebServlet("/viewresult")
public class ViewResultController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String historyId = req.getParameter("history_id");
		HistoryService historyService = new HistoryServiceImpl();
		AnswerService answerService = new AnswerServiceImpl();
		QuestionService questionService = new QuestionServiceImpl();
		QuizService quizService = new QuizServiceImpl();
		
		History history = historyService.get(historyId);
		List<Question> questionList = questionService.getQuestionListByQuiz(history.getQuizId());
		Quiz quiz = quizService.get(history.getQuizId());
		List<Answer> answerList = answerService.getAnswerByHistory(historyId);
		Map<Question, String> quesAnsMap = new HashMap<>();
		for(Question question: questionList) {
			for(Answer answer: answerList) {
				if(question.getQuestionId() == answer.getQuestionId()) {
					quesAnsMap.put(question, answer.getAnswer());
					break;
				}
			}
		}
		req.setAttribute("maxScore", quiz.getTotalScore());
		req.setAttribute("quizId", history.getQuizId());
		req.setAttribute("score", history.getScore());
		req.setAttribute("quesAnsMap", quesAnsMap);
		req.setAttribute("questionList", questionList);
		req.getRequestDispatcher("/view/client/view/viewResult.jsp").forward(req, resp);
	}
}
