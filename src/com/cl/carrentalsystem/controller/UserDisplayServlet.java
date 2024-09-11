package com.cl.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.carrentalsystem.dao.UserDao;
import com.cl.carrentalsystem.models.User;

/**
 * Servlet implementation class UserDisplayAll
 */
@WebServlet("/userdisplayall")
public class UserDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  private UserDao userDao;

	    public void init() {
	        userDao = new UserDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            List<User> users = userDao.getAllUsers();
	            request.setAttribute("users", users);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/userdisplay.jsp");
	            dispatcher.forward(request, response);
	        } catch (ClassNotFoundException e) {
	            throw new ServletException(e);
	        }
	    }

}
