package com.project.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.project.quiz.util.RandomUUID;

@WebServlet("/doquiz")
public class DoQuizController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		QuestionService questionService = new QuestionServiceImpl();
		int quizId = Integer.parseInt(req.getParameter("quiz_id"));
		List<Question> questionList = new ArrayList<>();
		questionList = questionService.getQuestionListByQuiz(quizId);
		QuizService quizService = new QuizServiceImpl();
		Quiz quiz = quizService.get(quizId);
		req.setAttribute("quizId", quizId);
		req.setAttribute("questionList", questionList);
		req.setAttribute("totalTime", quiz.getTotalTime());
		req.getRequestDispatcher("/view/client/view/doQuiz.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int quizId = Integer.parseInt(req.getParameter("quiz_id"));
		HistoryService historyService = new HistoryServiceImpl();
		AnswerService answerService = new AnswerServiceImpl();
		QuestionService questionService = new QuestionServiceImpl();
		List<Question> questionList = new ArrayList<>();
		questionList = questionService.getQuestionListByQuiz(quizId);
		String historyId = RandomUUID.getRandomID();
		History newHistory = new History(historyId,user.getId(),quizId,0);
		int totalScore = 0;
		historyService.insert(newHistory);
		for(Question question: questionList) {
			String answer = req.getParameter(String.valueOf(question.getQuestionId()));
			if(answer.equals(question.getCorrectOption()))
				totalScore += question.getScore();
			answerService.insert(new Answer(historyId,question.getQuestionId(),answer));
		}
		newHistory.setScore(totalScore);
		historyService.update(newHistory);
		resp.sendRedirect("viewresult?history_id=" + historyId);		
	}
}
