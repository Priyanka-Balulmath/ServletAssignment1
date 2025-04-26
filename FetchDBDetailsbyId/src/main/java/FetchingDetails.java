import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class fetchingDetails
 */
@WebServlet("/fetchingDetails")
public class FetchingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn; // Declare the connection as an instance variable

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id"); // Retrieve the 'id' parameter from the request
		if (id == null || id.isEmpty()) {
			out.println("<p>Error: ID is missing!</p>");
			return;
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Prepare the SQL query with the provided ID
			String query = "SELECT * FROM Employees WHERE id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			// Execute the query
			rs = pstmt.executeQuery();

			// Display the results
			out.println("<html><body>");
			if (rs.next()) {
				out.println("<h3>Details for ID: " + id + "</h3>");
				out.println("<p>First name: " + rs.getString("firstname") + "</p>");
				out.println("<p>Last name: " + rs.getString("lastname") + "</p>");
				out.println("<p>Email: " + rs.getString("email") + "</p>");
			} else {
				out.println("<p>No record found for ID: " + id + "</p>");
			}
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<p>Error: " + e.getMessage() + "</p>");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
