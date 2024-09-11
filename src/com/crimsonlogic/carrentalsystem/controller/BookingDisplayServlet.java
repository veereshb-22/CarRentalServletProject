package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimsonlogic.carrentalsystem.dao.BookingDao;
import com.crimsonlogic.carrentalsystem.models.Booking;


/**
 * Servlet implementation class BookingDisplayServlet
 */
@WebServlet("/bookingdisplayservlet")
public class BookingDisplayServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
    
		private BookingDao bookingdao;

		public void init() {
	        bookingdao = new BookingDao();
	    }
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	        	List<Booking> booking=bookingdao.getAllBooking();
	            request.setAttribute("bookings", booking);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/bookingdisplay.jsp");
	            dispatcher.forward(request, response);
	        } catch (ClassNotFoundException e) {
	            throw new ServletException(e);
	        }
	    }
}
