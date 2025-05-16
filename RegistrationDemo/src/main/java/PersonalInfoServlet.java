import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PersonalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("firstname", request.getParameter("firstname"));
        session.setAttribute("lastname", request.getParameter("lastname"));
        session.setAttribute("middlename", request.getParameter("middlename"));
        session.setAttribute("gender", request.getParameter("gender"));
       

        response.sendRedirect("contactinfo.html"); // Redirect to the next form
    }
}
