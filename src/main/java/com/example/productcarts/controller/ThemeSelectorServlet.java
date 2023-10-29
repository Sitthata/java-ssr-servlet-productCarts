package com.example.productcarts.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ThemeSelectorServlet", value = "/ThemeSelector")
public class ThemeSelectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String theme = request.getParameter("theme");
        if (theme == null || theme.isEmpty()) {
            // Check cookies for an existing theme preference if no theme parameter is found in the request
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (var cookie : cookies) {
                    if (cookie.getName().equals("theme")) {
                        theme = cookie.getValue();
                        break;
                    }
                }
            }
            // If still no theme found (neither from the request nor from cookies), set a default
            if (theme == null || theme.isEmpty()) {
                theme = "white"; // Default theme
            }
        }
        Cookie cookie = new Cookie("theme", theme);
        response.addCookie(cookie);
        System.out.println(cookie);
        request.setAttribute("theme", theme);
        getServletContext().getRequestDispatcher("/theme.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}