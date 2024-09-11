package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crimsonlogic.carrentalsystem.dao.UserBookingListDao;
import com.crimsonlogic.carrentalsystem.models.UserBookingList;



/**
 * Servlet implementation class UserBookedList
 */
@WebServlet("/userbookedlist")
public class UserBookedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {   
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBookingListDao userBookingListDao =new UserBookingListDao();
		 HttpSession session = request.getSession();
		 String UserId=(String) session.getAttribute("userId");
			List<UserBookingList> bookingListUser=userBookingListDao.getUserBookingsByUserId(UserId);
			session.setAttribute("bookingListUsers", bookingListUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home/userbookinglist.jsp");
			dispatcher.forward(request, response);	
	}
		


}
