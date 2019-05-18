package com.hasu.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set up data base variables
		String user = "hbstudent";
		String password = "hbstudent";
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";

		// Get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to Data Base URL : " + url);
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(url, user, password);
			out.println("Successful connection ");
			myCon.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);

		}
	}

}
