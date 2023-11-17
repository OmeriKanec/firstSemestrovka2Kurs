package com.semestr.firstsemestrovka2kurs.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        Cookie[] cookies = req.getCookies();
        for (Cookie c: cookies) {
            if (c.getName().equals("email")){
                c.setMaxAge(0);
                resp.addCookie(c);
            }
            if (c.getName().equals("password")){
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }
        resp.sendRedirect("../login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}