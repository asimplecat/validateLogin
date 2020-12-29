package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		session.setAttribute("uname",uname );
		session.setAttribute("password",password );
		if (uname.equals("dani") && password.equals("password"))
		{
			
			response.sendRedirect("loginsuccess.jsp");
		}	
		else {
			PrintWriter out = response.getWriter();
			
			request.getRequestDispatcher("login.html").include(request, response);
			out.println("<p style=\"color:red\";>Error Incorrect Username or Password</p>");
		}
	}
}

