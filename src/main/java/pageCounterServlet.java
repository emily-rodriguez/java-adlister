import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class pageCounterServlet extends HttpServlet {
    static final String COUNTER_KEY = "Counter.count";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>I'm for counting</h2>");
        int count = 1;
        String resetCount = request.getParameter("reset");
        HttpSession session = request.getSession(true);
        Integer i = (Integer) session.getAttribute(COUNTER_KEY);
        if (i != null) {
            count = i.intValue() + 1;
        }
        if (resetCount != null) {
            count = 0;
        }


        session.setAttribute(COUNTER_KEY, new Integer(count));

        out.println("<h4>This page has been viewed: " + count
                + " time(s) during this browser session");

    }
}
