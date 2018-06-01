import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MultiplyServlet", urlPatterns = "/multiplication")
public class MultiplyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-operands.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        int operand2 = Integer.parseInt(request.getParameter("operand2"));
        int product = operand1 * operand2;
        request.setAttribute("product", product);
        request.getRequestDispatcher("/display-product.jsp").forward(request, response);
    }

}
