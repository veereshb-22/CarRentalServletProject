package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crimsonlogic.carrentalsystem.dao.CarDao;
import com.crimsonlogic.carrentalsystem.models.Car;

/**
 * Servlet implementation class AddedCarToDriver
 */
@WebServlet("/addedcartodriver")
public class AddedCarToDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin/addcardriver.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car car=new Car();
		HttpSession session=request.getSession();
		String carId=car.randID("CID");
		String driverId=(String)session.getAttribute("driverIdAdd");
		String carNumber=request.getParameter("carNumber");
		String carModel=request.getParameter("carModel");
		String carType=request.getParameter("carType");
		CarDao cardao=new CarDao();
		car=new Car(carId, driverId, carNumber, carModel, carType);
		try {
			int result=cardao.registerCar(car);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminhome.jsp");
			dispatcher.forward(request, response);
			}
		
		
	}

}
