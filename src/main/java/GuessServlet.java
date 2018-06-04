import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-guess.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userGuess = Integer.parseInt(request.getParameter("guess"));
        Random rand = new Random();
        int randomNum = rand.nextInt(100) + 1;
        request.setAttribute("guess", userGuess);
        request.setAttribute("answer", randomNum);
        request.getRequestDispatcher("/higher-lower.jsp").forward(request, response);
    }
}
