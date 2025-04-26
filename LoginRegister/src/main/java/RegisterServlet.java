import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
        String email = request.getParameter("email");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
          
            // Insert user data into the database
            String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            int rowsInserted = pstmt.executeUpdate();

         // Display success message and login link
            if (rowsInserted > 0) {
                out.println("<html><body>");
                out.println("<h2>Registration successful!</h2>");
                out.println("<p>Click <a href='login.html'>here</a> to log in.</p>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Registration failed!</h2>");
                out.println("<p>Please try again later.</p>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h2>Error during registration:</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("</body></html>");
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
