

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ContactInfoServlet")
public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("address", request.getParameter("address"));
		session.setAttribute("city", request.getParameter("city"));
		session.setAttribute("state", request.getParameter("state"));
		session.setAttribute("country", request.getParameter("country"));
		session.setAttribute("phone", request.getParameter("phone"));

		response.sendRedirect("bankinfo.html"); // Redirect to the next form
	}
}
