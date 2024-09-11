package com.cl.carrentalsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.carrentalsystem.dao.BookingDao;
import com.cl.carrentalsystem.dao.CarDao;
import com.cl.carrentalsystem.models.Booking;
import com.cl.carrentalsystem.models.Car;

/**
 * Servlet implementation class CarDispalyAdmin
 */
@WebServlet("/cardisplayadminservlet")
public class CarDisplayAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  CarDao carDao;
	
	private Car car;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 CarDao carDao = new CarDao();
    	 
        try {
        	List<Car> carlist=carDao.getAllCar();
            request.setAttribute("cars", carlist);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/cardisplay.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

}
