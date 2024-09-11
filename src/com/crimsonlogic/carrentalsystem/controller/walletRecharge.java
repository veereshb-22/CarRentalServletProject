package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crimsonlogic.carrentalsystem.dao.UserDao;

/**
 * Servlet implementation class walletRecharge
 */
@WebServlet("/walletrecharge")
public class walletRecharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("home/wallet.jsp");
		
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			    String numberParam = request.getParameter("user_wallet");	 
				int number = Integer.parseInt(numberParam);
				
				HttpSession session = request.getSession();
				String userEmail=(String) session.getAttribute("useremail");
				Object ok=session.getAttribute("userwallet");
				int intValue = (Integer)ok;
				
				UserDao ud=new UserDao();
				ud.addMoneyToWallet(number, intValue, userEmail);
				RequestDispatcher dispatcher = request.getRequestDispatcher("home/wallet.jsp");
				dispatcher.forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
