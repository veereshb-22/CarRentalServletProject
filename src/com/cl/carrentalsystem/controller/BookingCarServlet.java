package com.cl.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.carrentalsystem.dao.LocationDao;
import com.cl.carrentalsystem.exception.LocationNotFoundException;


@WebServlet("/bookingcarservlet")   
public class BookingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doget(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 response.sendRedirect("login/login.jsp");
	 }
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	    	LocationDao locationDao=new LocationDao();
	    	HttpSession session = request.getSession();
	        String startLocationData =request.getParameter("startLocationf");
	        String endLocationData = request.getParameter("endLocationf");
	        String bookingDateData = request.getParameter("bookingDate");
	        String bookingTimeData = request.getParameter("bookingTime");
	       	int locationCostData = locationDao.getLocationCost(startLocationData,endLocationData);	
	        session.setAttribute("startLocation", startLocationData);
	        session.setAttribute("endLocation", endLocationData);
	        session.setAttribute("bookingDate", bookingDateData);
	        session.setAttribute("bookingTime", bookingTimeData);
	        session.setAttribute("locationCost", locationCostData);  
	        if(locationCostData <=0) {
	        	try {
	        	throw new LocationNotFoundException("Location Not Found");
	        	}
	        	catch(LocationNotFoundException e) {
	        		e.printStackTrace();
	        	}
	        	 RequestDispatcher dispatcher = request.getRequestDispatcher("demo/notfound.jsp");
	 	        dispatcher.forward(request, response);
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher("bookingavaliableservlet");
	        dispatcher.forward(request, response);
	        }
	    
	   

}
