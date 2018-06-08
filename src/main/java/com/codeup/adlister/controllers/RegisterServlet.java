package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    StringUtils util = new StringUtils();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        boolean validAttempt = (util.isNotBlank(username) && util.isNotBlank(email) && util.isNotBlank(password) & password.equals(passwordConfirmation));
        // validate input

        if (validAttempt) {
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("usernameDisplay", util.capitalize(username));
            response.sendRedirect("/profile");
            return;
        }
        String message = "Invalid input, please try again";
        request.setAttribute("errorMessage", message);

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);

    }
}
