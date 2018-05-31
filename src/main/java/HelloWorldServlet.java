<<<<<<< HEAD
=======
import java.io.*;
>>>>>>> servlets-exercise
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
//        if (name != null) {
//            out.println("<h1> Hello, " + name + "!</h1>");
//        } else {
//            out.println("<h1>Hello, World!</h1>");
//        }

        //in class solution

        if (name == null) {
            name = "World";
        }

        out.println("<h1>Hello, " + name + "!</h1>");
        out.println("<p>Enter your name: </p>");
        out.println("<form action=\"/hello\">");
        out.println("<input name=\"name\"/>");
        out.println("</form>");
    }
}

