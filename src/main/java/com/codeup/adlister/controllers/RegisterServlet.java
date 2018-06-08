package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    StringUtils util = new StringUtils();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean validAttempt = (util.isNotBlank(username) && util.isNotBlank(email) && util.isNotBlank(password));

        if (validAttempt) {
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("user", util.capitalize(username));
            response.sendRedirect("/profile");
        }
            String message = "Invalid entry, try again";
            request.setAttribute("errorMessage", message);

            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        // TODO: ensure the submitted information is valid //not empty
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
    }
}
