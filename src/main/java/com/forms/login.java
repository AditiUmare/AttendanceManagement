package com.forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    String StrQuery="select * from users where username = ? and password = ?";
	    
	    try {
	    	
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "mysql");
	      
	      PreparedStatement ps = con.prepareStatement(StrQuery);
	      ps.setString(1, username);
	      ps.setString(2, password);
	      
	      ResultSet rs = ps.executeQuery();
	      
	      if (rs.next()){
	    	  if(rs.getString(3).equalsIgnoreCase("admin")) 
	    	  {
	    		  response.sendRedirect("admin.html");
	    	  }
	    	  else 
	    	  {
	    		  response.sendRedirect("emp.jsp");
	    	  }
	  }
	      else 
	      {
	                out.println("error");
	      }
	    } 
	    catch (Exception e) {
	      out.println("Error: " + e.getMessage());
	    }
	}
	}


