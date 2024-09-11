package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimsonlogic.carrentalsystem.dao.UserDao;
import com.crimsonlogic.carrentalsystem.models.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
		response.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String firstName = request.getParameter("userfname");
		String lastName = request.getParameter("userlname");
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");
		String phonenumber=request.getParameter("phonenumber");
		int wallet= Integer.parseInt(request.getParameter("wallet"));
		int age=Integer.parseInt(request.getParameter("age"));
		User users = new User();
		String userid=users.randID("UID");
		// Data Entry
		users.setAge(age);
		users.setUserWallet(wallet);
		users.setUserID(userid);
		users.setUserEmail(useremail);
		users.setPassword(password);
		users.setUserFirstName(firstName);
		users.setUserLastName(lastName);
		users.setUserPhone(phonenumber);
		UserDao userDao= new UserDao();
		try {
			
		int result=userDao.registerUser(users);
		if(result >= 1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			}
		else {
			request.setAttribute("NOTIFICATION", "User Registration Failed Email Already Exists");
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
		}
	}

}
