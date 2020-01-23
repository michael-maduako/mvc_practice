package com.michael.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.michael.model.LoginBean;
@WebServlet("/loginServlet")
public class LoginController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		String username= req.getParameter("un");
		String password= req.getParameter("pwd");
		
		LoginBean bean = new LoginBean();
		bean.setUsername(username);
		bean.setPassword(password);
		HttpSession session=req.getSession();
		session.setAttribute("abc", bean);
		
	
		
		//boolean status= bean.validateLogin();
		if(req.getParameter("login") != null) {
			//RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
			//rd.forward(req, res); (Forwarding)
			res.sendRedirect("success.jsp"); //(Redirecting)
		}
		else if(req.getParameter("register") != null){
			RequestDispatcher rd= req.getRequestDispatcher("create.jsp");

		}
		else {
			pw.println("<font color='red'> Invalid Username/Password Error</font>");
			RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
			rd.include(req, res);

		}
	}
}
