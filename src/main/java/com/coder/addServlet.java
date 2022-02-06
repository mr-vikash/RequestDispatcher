package com.coder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		String gender = request.getParameter("user_gender");
		String course = request.getParameter("user_course");
		String cond = request.getParameter("condition");
		
	if(cond!=null)
	{
		if(cond.equals("checked"))
		{
			out.println("<h2>Name: "+name+"</h2>");
			out.println("<h2>Password: "+password+"</h2>");
			out.println("<h2>Email: "+email+"</h2>");
			out.println("<h2>Gender: "+gender+"</h2>");
			out.println("<h2>Course: "+course+"</h2>");
			//
			//jdbc
			//saved to db
			
			RequestDispatcher rd = request.getRequestDispatcher("success");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h2> You have not accepted term and conditions </h2>");
		}
	}
		
	else
	{
		out.println("<h2> You have not accepted term and conditions </h2>");
		
		///// i want to include output of index.html
		
		//// get the object of requestDispatcher
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		
		///include 
		
        rd.include(request, response);
	}
		
		
		
		
		
	}
}
