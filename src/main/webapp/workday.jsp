<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Workday Page</title>
</head>
<body>
<form>

	</form>
		<center>
			<table border=1
				class="table table-Secondary table-hover table-striped table-sm"
				style="width: 30%; margin-top: 30px">
				<tr>
					<th>Year</th>
					<th>Month</th>
					<th>Working Days</th>
					<th>Delete</th>
				</tr>
				<% 
			    try{
			    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "mysql");
			    	Statement stmt = con.createStatement();
			    	String Query = "select * from workday";
					ResultSet rs = stmt.executeQuery(Query);
					while (rs.next()){
			%>
				<tr>
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><a
						href="DeleteWorkdays.jsp?id=<%=rs.getString(1)%>&id2=<%=rs.getString(2)%>">delete</a></td>
				</tr>
				<% 
			}
			    }catch(Exception e){
			    	e.printStackTrace();
			    }
			%>
			</table>
			<br>
			<button class="submit-btn" type="submit">Enter</button>
		</center>
	</form>
	<form action="http://localhost:8080/LeaveAttendanceManagement/addWorkdays.html"
			method="get">
			<input type="submit" value="ADD WORKDAYS">
		</form>
	
</body>
</html>