package com.forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registers
 */
@WebServlet("/Register")
public class registers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registers() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String Id = request.getParameter("id");
		String Fullname = request.getParameter("fullname");
		String Username = request.getParameter("username");
		String Email = request.getParameter("email");
		String PhoneNo = request.getParameter("phoneNo");
		String Password = request.getParameter("password");
		
		
		String qry = "insert into register( Id ,Fullname , Username , Email,PhoneNumber ,Password) values (?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "mysql");
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setString(1, Id);
			st.setString(2, Fullname);
			st.setString(3, Username);
			st.setString(4, Email);
			st.setString(5, PhoneNo);
			st.setString(6, Password);
			
			int count = st.executeUpdate();
			if(count==0) {
				pw.println("Registration unsuccessfull");
			}else {
				pw.println("Registration is successfull");
			}
			
			
		}catch(Exception e){
			
		}
	}
	}

