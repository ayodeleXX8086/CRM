package com.programmers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.programmers.domain.Tutor;
import com.programmers.services.TutorManagement;

/**
 * A very basic servlet to display all the tutors in the college.
 * 
 * Uses basic MVC - see our Java Web Development course for details.
 */
public class DisplayAllTutorsServlet extends HttpServlet
{
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		// do some work
		TutorManagement service = TutorManagement.getService();	

		Object []arr= service.getTutorTotalSalary();
		request.setAttribute("allTutors", arr[0]);
		request.setAttribute("totalSalaryBill", arr[1]);
		
		// forward to the displayAllBooks.jsp page to display the results
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllTutors.jsp");
		dispatch.forward(request,response);
	}
}
