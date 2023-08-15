package com.project.quiz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.quiz.model.User;
import com.project.quiz.dao.UserDAO;

@WebServlet("/welcome")
public class HomeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user =  (User) session.getAttribute("user");
            req.setAttribute("username", user.getUsername());
            if (user.getRoleId() == 1) {
                resp.sendRedirect("admin/welcome"); 
            } else {
        		req.getRequestDispatcher("/view/client/view/home.jsp").forward(req, resp);
            }
        }else {
        	RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/home.jsp");
    		dispatcher.forward(req, resp);	
        }
	}	
}
