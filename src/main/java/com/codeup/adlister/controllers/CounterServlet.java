package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "controllers.CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    protected int count = 0;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>I'm for counting</h2>");

        String reset = request.getParameter("reset");

        if ("true".equals(reset)) {
            count = 0;
        } else {
            count += 1;
        }

        out.println("<h4>This page has been viewed: " + count
                + " time(s) during this browser session");
        out.println("<form method=GET action=\"" + request.getRequestURI() + "\">");
        out.println("<input type=submit " + "value=\"Hit page again\">");
        out.println("</form>");
        out.println("<a href='/count?reset=true'>Reset the counter</a>");

    }
}
