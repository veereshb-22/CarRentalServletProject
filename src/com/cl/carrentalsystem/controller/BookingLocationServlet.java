package com.cl.carrentalsystem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.carrentalsystem.dao.LocationDao;

@WebServlet("/bookinguserservlet")
public class BookingLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private LocationDao locationDAO;

	    @Override
	    public void init() throws ServletException {
	        locationDAO = new LocationDao();
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	            List<String> startingPoints = locationDAO.getStartingPoints();
	            List<String> endingPoints = locationDAO.getEndingPoints();
	            request.setAttribute("startingLocations", startingPoints);
	            request.setAttribute("endingLocations", endingPoints);
	            RequestDispatcher dispatcher=  request.getRequestDispatcher("booking/bookingform.jsp");
	            dispatcher.forward(request, response);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();  // Log the exception
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
	        }
	    }           
}

