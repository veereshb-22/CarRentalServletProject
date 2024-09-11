package com.crimsonlogic.carrentalsystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimsonlogic.carrentalsystem.dao.DemoDao;

/**
 * Servlet implementation class demoController
 */

	import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
	import java.time.ZonedDateTime;
	

	@WebServlet("/demoController")
	public class demoController extends HttpServlet {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		  @Override
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String dateStr = request.getParameter("date");
	        String timeStr = request.getParameter("time");

	        // Convert strings to LocalDate and LocalTime
	        LocalDate localDate = LocalDate.parse(dateStr);
	        LocalTime localTime = LocalTime.parse(timeStr);

	        // Combine LocalDate and LocalTime into LocalDateTime
	        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

	        // Optionally convert to ZonedDateTime if needed for timezone
	        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

	       
	        DemoDao ta = new DemoDao();
	       ta.saveDataTime(zonedDateTime);

	        // Redirect or forward to another page
	        response.sendRedirect("success.jsp");
	    }
		    }

