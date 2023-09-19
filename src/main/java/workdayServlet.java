

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
 * Servlet implementation class workdayServlet
 */
@WebServlet("/workdayServlet")
public class workdayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public workdayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

        String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("days");
		
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "mysql");
		    PreparedStatement st = con.prepareStatement("insert into workday(year ,month ,days) values (?,?,?)");
		    
		    st.setString(1,year);
		    st.setString(2, month);
	        st.setString(3,day);
	    
		    int count = st.executeUpdate();
		    
		    if(count==0) {
			pw.println("Registration unsuccessfull");
			pw.println("Registration is successfull");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
