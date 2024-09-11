package com.cl.carrentalsystem.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.carrentalsystem.dao.CarDriverInfoDao;
import com.cl.carrentalsystem.models.CarDriverInfo;

/**
 * Servlet implementation class BookingAvaliableServlet
 */
@WebServlet("/bookingavaliableservlet")
public class BookingAvaliableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private CarDriverInfoDao driverInfoDao;// DAO to fetch driver and car info

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        // Retrieve data from session
	        HttpSession session = request.getSession();
	        String startLocation = (String) session.getAttribute("startLocation");
	        String endLocation =  (String) session.getAttribute("endLocation");
	        String bookingDateString = (String) session.getAttribute("bookingDate");
	        String bookingTimeString = (String) session.getAttribute("bookingTime");
	        int bookingCost=(Integer)session.getAttribute("locationCost");
	        driverInfoDao = new CarDriverInfoDao(); 
	        session.setAttribute("bookingStartPoint", startLocation);
	        session.setAttribute("bookingEndPoint", endLocation);
	        Date bookingDate = null;
	        Time bookingTime = null;
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	        
	        try {
	            if (bookingDateString != null && bookingTimeString != null) {
	                java.util.Date parsedDate = dateFormat.parse(bookingDateString);
	                java.util.Date parsedTime = timeFormat.parse(bookingTimeString);
	                bookingDate = new Date(parsedDate.getTime());
	                bookingTime = new Time(parsedTime.getTime());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exception (e.g., redirect to an error page)
	        }
	        // Validate session data
	        if (startLocation != null && endLocation != null && bookingDate != null && bookingTime != null) {
	            // Get available cars and drivers
	            List<CarDriverInfo> availableCars = driverInfoDao.getAvailableCars(bookingDate, bookingTime,bookingCost);

	            // Set the list as a request attribute
	            request.setAttribute("availableCars", availableCars);

	            // Forward to JSP page to display results
	            RequestDispatcher dispatcher = request.getRequestDispatcher("booking/bookinglist.jsp");
	            dispatcher.forward(request, response);
	        } 

	    }

}
