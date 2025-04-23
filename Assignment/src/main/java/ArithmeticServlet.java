import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/arithmetic")
public class ArithmeticServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num1 = request.getParameter("var1");
		String num2 = request.getParameter("var2");
		
		int res = Integer.parseInt(num1)+Integer.parseInt(num2);
		response.getWriter().append("The result is"+res);
		
	}
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            String operation = request.getParameter("operation");

            double result = 0;
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        out.println("<h3>Division by zero is not allowed.</h3>");
                        return;
                    }
                    break;
                default:
                    out.println("<h3>Invalid operation.</h3>");
                    return;
            }

            out.println("<h3>Result: " + result + "</h3>");
        } catch (NumberFormatException e) {
            out.println("<h3>Invalid input. Please enter valid numbers.</h3>");
        } finally {
            out.close();
        }
    }
}

  

	