package com.cl.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.carrentalsystem.dao.DriverDao;
import com.cl.carrentalsystem.models.Driver;


@WebServlet("/driverinsertservlet")
public class DriverInsertServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			register(request, response);
		}
				
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.sendRedirect("admin/driverinsert.jsp");
		}

		private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			Driver driver=new Driver();            
            String driverId=driver.randID("DID");
			String drivername = request.getParameter("username");
			String driverLicense = request.getParameter("license");
			String driverEmail = request.getParameter("useremail");
			String driverPhone = request.getParameter("phonenumber");	
			driver.setDriverID(driverId);
			driver.setDriverName(drivername);
			driver.setDriverEmail(driverEmail);
			driver.setDriverLicense(driverLicense);
			driver.setDriverPhone(driverPhone);
			DriverDao driverDao=new DriverDao();		
			try {
			int result=driverDao.registerDriver(driver);
			if(result >= 1) {
					request.setAttribute("NOTIFICATION", "Driver Registered Successfully!");
				}
			else {
				request.setAttribute("NOTIFICATION", "Driver Registered Unsuccessful");
			}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin/driverinsert.jsp");
			dispatcher.forward(request, response);
			}
		}
}
