import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/FinalSubmitServlet")
public class FinalSubmitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn;
    
 // Initialize the database connection in the init() method
 	@Override
 	public void init() throws ServletException {
 		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl"; 
 		String username = "system"; 
 		String password = "orcl"; 

 		try {
 			// Load the Oracle JDBC driver
 			Class.forName("oracle.jdbc.driver.OracleDriver");

 			// Establish the connection
 			conn = DriverManager.getConnection(jdbcUrl, username, password);
 			System.out.println("Database connection initialized.");
 		} catch (Exception e) {
 			e.printStackTrace();
 			throw new ServletException("Failed to initialize database connection", e);
 		}
 	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
 		
         String firstname = (String) session.getAttribute("firstname");
         String lastname = (String) session.getAttribute("lastname");
         String middlename = (String) session.getAttribute("middlename");
         String gender = (String) session.getAttribute("gender");

         String address = (String) session.getAttribute("address");
         String city = (String) session.getAttribute("city");
         String state = (String) session.getAttribute("state");
         String country = (String) session.getAttribute("country");
         String phone = (String) session.getAttribute("phone");
         String bankName = request.getParameter("bankname"); // Last form input
         String bankAccount = request.getParameter("bankAccount"); 
         String ssn = request.getParameter("ssn"); 

         try {

            String sql = "INSERT INTO usersinfo (firstname, lastname, middlename, gender, address, city, state, country, bank_name, phone, bank_account, ssn) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, middlename);
            stmt.setString(4, gender);
            stmt.setString(5, address);
            stmt.setString(6, city);
            stmt.setString(7, state);
            stmt.setString(8, country);
            stmt.setString(9, bankName);
            stmt.setString(10, phone);
            stmt.setString(11, bankAccount);
            stmt.setString(12, ssn);
            ResultSet rs = stmt.executeQuery();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/success.html");
            dispatcher.forward(request, response);
           
        } catch (Exception e) {
            e.printStackTrace();
            
            
            } 
        
        
    }
    
 // Close the database connection in the destroy() method
 	@Override
 	public void destroy() {
 		try {
 			if (conn != null && !conn.isClosed()) {
 				conn.close();
 				System.out.println("Database connection closed.");
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 	}
      
}