

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession httpSession = request.getSession();
        // Retrieve session attributes (username and email)
		
        String username = (String) httpSession.getAttribute("username");
        String email = (String) httpSession.getAttribute("email");
        
        // Generate HTML response
        writer.println("<html><body>");
        writer.println("<h2>Login Successful!</h2>");
        writer.println("<p>Welcome, <strong>" + username + "</strong></p>");
        writer.println("<p>Your email: <strong>" + email + "</strong></p>");
     ///   writer.println("<p>You can now <a href='login.html'>log in</a>.</p>");
        
        // Logout button
        writer.println("<form action='LogoutServlet' method='post'>");
        writer.println("<button type='submit'>Logout</button>");
        writer.println("</form>");
        writer.println("</body></html>");
    }
}
