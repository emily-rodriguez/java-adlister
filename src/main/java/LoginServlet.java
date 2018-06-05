import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if (username.equals("admin") && password.equals("password")) {
//            response.sendRedirect("/profile");
//        } else {
//            message = "Username and/or password is incorrect";
//            request.setAttribute("message", message);
//            counter += 1;
//            request.setAttribute("counter", counter);
//            if (counter >= 2) {
////                message = "Too many login attempts! Try again later";
////                request.setAttribute("message", message);
//                request.getRequestDispatcher("/locked-out.jsp").forward(request,response);
//            }
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }
//    }
//}

