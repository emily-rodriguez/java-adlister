import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PickColorServlet", urlPatterns = "/pickcolor")
public class PickColorServlet extends HttpServlet {

    private String favoriteColor;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-color.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        favoriteColor = request.getParameter("color");
        request.setAttribute("FavColor", favoriteColor);
        request.getRequestDispatcher("/display-color.jsp").forward(request, response);

    }
}
