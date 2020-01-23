package com.michael.controller;

import java.io.*;
import java.sql.*;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.michael.model.RegisterBean;

public class RegisterController extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		String firstname = req.getParameter("cfn");
		String lastname = req.getParameter("cln");
		String username = req.getParameter("cun");
		String password = req.getParameter("cpwd");

		RegisterBean rb = new RegisterBean(firstname, lastname, username, password);

		PrintWriter pw = res.getWriter();
		//String valid= rb.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl");

			String sql = firstname + "," + lastname + "," + username + "," + password;
			Statement st = con.createStatement();
			st.executeUpdate("insert into Users_login values(" + sql + ")");

			pw.println("<font color='blue'> Successfully registered and entered into database");
			System.out.println("Successfully registered and entered into database");
			con.close();

			res.sendRedirect("login.jsp");

		} catch (SQLException e) {
			pw.println("<font color='red'> Unsuccessfully registered and entered into database");
			// System.out.println("Successfully registered and entered into database");
			e.printStackTrace();
			res.sendRedirect("create.jsp");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
