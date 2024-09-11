package com.cl.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.carrentalsystem.dao.DriverDao;

/**
 * Servlet implementation class AddCarToDriver
 */
@WebServlet("/addcartodriver")
public class AddCarToDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarToDriver() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driverId = request.getParameter("id");
		 HttpSession session = request.getSession();
		 session.setAttribute("driverIdAdd",driverId);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("admin/addcardriver.jsp");
	     dispatcher.forward(request, response);	 
	       
	}

}
