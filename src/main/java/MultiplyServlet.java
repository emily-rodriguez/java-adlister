import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet", urlPatterns = "/addition")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-summands.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int summand1 = Integer.parseInt(request.getParameter("summand1"));
        int summand2 = Integer.parseInt(request.getParameter("summand2"));
        int sum = summand1 + summand2;
        request.setAttribute("sum", sum);
        request.getRequestDispatcher("/display-sum.jsp").forward(request, response);
    }

}
