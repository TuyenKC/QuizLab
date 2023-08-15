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

import com.project.quiz.model.History;
import com.project.quiz.model.User;
import com.project.quiz.service.HistoryService;
import com.project.quiz.service.QuizService;
import com.project.quiz.service.impl.HistoryServiceImpl;
import com.project.quiz.service.impl.QuizServiceImpl;

@WebServlet("/history")

public class HistoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		HistoryService historyService = new HistoryServiceImpl();
		QuizService quizService = new QuizServiceImpl();
		List<History> historyList = historyService.getHistoryListByUser(user.getId());
		Map<History, Integer> historyMap = new HashMap<History, Integer>();
		Map<History, String> historyQuizNameMap = new HashMap<History, String>();
		for(History history: historyList) {
			historyMap.put(history, quizService.get(history.getQuizId()).getTotalScore());
			historyQuizNameMap.put(history, quizService.get(history.getQuizId()).getTitle());
		}
		req.setAttribute("historyMap", historyMap);
		req.setAttribute("historyQuizNameMap", historyQuizNameMap);
		req.setAttribute("historyList", historyList);
		req.getRequestDispatcher("/view/client/view/history.jsp").forward(req, resp);
	}
}