package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimsonlogic.carrentalsystem.dao.DriverDao;
import com.crimsonlogic.carrentalsystem.models.Driver;
import com.crimsonlogic.carrentalsystem.models.User;

/**
 * Servlet implementation class DriverDisplayServlet
 */
@WebServlet("/driverdisplayservlet")
public class DriverDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private DriverDao driverdao;

	    public void init() {
	        driverdao = new DriverDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            List<Driver> drivers = driverdao.getAllDriver();
	            request.setAttribute("drivers", drivers);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/driverdisplay.jsp");
	            dispatcher.forward(request, response);
	        } catch (ClassNotFoundException e) {
	            throw new ServletException(e);
	        }
	    }

}
