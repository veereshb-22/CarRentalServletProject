package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crimsonlogic.carrentalsystem.dao.LoginDao;
import com.crimsonlogic.carrentalsystem.models.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login/login.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");
		Login loginBean = new Login();
		loginBean.setLogin_email(useremail);
		loginBean.setLogin_password(password);

		try {
			String username=loginDao.getNameDataByMail(useremail);
			int userwallet=loginDao.getUserWalletDataByMail(useremail);
			String userId=loginDao.getUserIDByEmail(useremail);
			if (loginDao.validate(loginBean)) {
				 HttpSession session = request.getSession();
				 session.setAttribute("username", username);
				 session.setAttribute("useremail", useremail);
				 session.setAttribute("userwallet",userwallet);
				 session.setAttribute("userId", userId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("home/home.jsp");
				dispatcher.forward(request, response);
			}else if(useremail.equals("admin@gmail.com") && password.equals("admin@123")){
				 HttpSession session = request.getSession();
				 session.setAttribute("admin","Admin");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminhome.jsp");
				dispatcher.forward(request, response);
				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("errorMessage", "Invalid email or password");
				response.sendRedirect("login/login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
