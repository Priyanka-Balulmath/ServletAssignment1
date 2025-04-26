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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get the email from the database
                String email = rs.getString("email");

                // Set session attributes for the user
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("email", email);

                // Forward the request to the SuccessServlet
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/SuccessServlet");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("<p>Invalid username or password. <a href='login.html'>Try again</a>.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
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