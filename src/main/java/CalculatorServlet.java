import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/get-operands.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        int operand2 = Integer.parseInt(request.getParameter("operand2"));
        int answer = 0;
        String operatorSymbol = "";
        String operator = request.getParameter("operator");
        request.setAttribute("operand1", operand1);
        request.setAttribute("operand2", operand2);
        request.setAttribute("operator", operator);

        if(operator.equals("Add")){
            answer = operand1 + operand2;
            operatorSymbol = "+";
        }
        if(operator.equals("Multiply")){
            answer = operand1 * operand2;
            operatorSymbol = "x";
        }
        if(operator.equals("Subtract")){
            answer = operand1 - operand2;
            operatorSymbol = "-";
        }
        if(operator.equals("Divide")){
            answer = operand1 / operand2;
            operatorSymbol = "/";
        }
        request.setAttribute("answer",answer);
        request.setAttribute("operatorSymbol", operatorSymbol);
        request.getRequestDispatcher("/display-answer.jsp").forward(request, response);
    }

}
