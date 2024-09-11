package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crimsonlogic.carrentalsystem.dao.BookingDao;
import com.crimsonlogic.carrentalsystem.dao.CarDao;
import com.crimsonlogic.carrentalsystem.dao.TransactionDao;
import com.crimsonlogic.carrentalsystem.models.Booking;
import com.crimsonlogic.carrentalsystem.models.Transaction;

@WebServlet("/bookingcartransactionservlet")
public class BookingCarTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private BookingDao bookingDao;
	
	private Booking booking;
	
	private CarDao carDao;
	
	private TransactionDao transactionDao;
	
	private Transaction transaction;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		transactions(request,response);
		
	}	
	void transactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String carNum = (String)request.getParameter("carNum");		
		int userwallet=(Integer)session.getAttribute("userwallet");                     //userwallet
		int userLocationAmount= (Integer) session.getAttribute("locationCost");           //userLocationamount
		if(userwallet < userLocationAmount) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("demo/Oit.jsp");
			dispatcher.forward(request, response);	
		}
		else {	
			transactionDao =new TransactionDao();
			bookingDao=new BookingDao();
			booking=new Booking();
			carDao=new CarDao();
			transaction=new Transaction();
			 String bookingId=booking.randID("BID");
			 String bookingCarID=carDao.getCarIdbyNumber(carNum);
			 String bookingUserID=(String) session.getAttribute("userId");
			 int bookingDistance = (int) (userLocationAmount / 20);
			 String bookingStartPoint=(String)session.getAttribute("bookingStartPoint");
			 String bookingEndPoint=(String)session.getAttribute("bookingEndPoint");
			 int bookingAmount=userLocationAmount+ carDao.getPriceByModel(carNum);
			 Date bookingDate = null;
		     Time bookingTime = null;
		     String bookingDateString = (String) session.getAttribute("bookingDate");
		     String bookingTimeString = (String) session.getAttribute("bookingTime");
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
			 String bookingStatus="Sucessfull";
			 booking=new Booking(bookingId,bookingCarID,bookingUserID,bookingDistance,bookingStartPoint,bookingEndPoint,bookingAmount,bookingDate,bookingTime,bookingStatus);
			 try {
				bookingDao.registerBooking(booking);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String transactionID=transaction.randID("TID");
			String tranactionStats="Success";
			transaction=new Transaction(transactionID,bookingUserID, bookingId,tranactionStats,bookingAmount );
			try {
				transactionDao.registerTransaction(transaction);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("demo/sucesspayment.jsp");
			 dispatcher.forward(request, response);	
		}
		
		
	}
}
