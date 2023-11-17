package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.helpers.PasswordHasher;
import com.semestr.firstsemestrovka2kurs.dao.impl.UserDAOImpl;
import com.semestr.firstsemestrovka2kurs.helpers.Validator;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {


    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./Login.ftl");

        response.setContentType("text/html");
        try {
            tmpl.process(null, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (req.getParameter("rememberMe") != null) {
            if (req.getParameter("rememberMe").equals("on")) {
                Cookie passwordCookie = new Cookie("password", password);
                Cookie emailCookie = new Cookie("email", email);
                Cookie rememberMeCookie = new Cookie("rememberMe", "on");
                resp.addCookie(emailCookie);
                resp.addCookie(passwordCookie);
                resp.addCookie(rememberMeCookie);
            }
        } else {
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
                if (c.getName().equals("on")){
                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
            }
        }
        if (!Validator.validateEmail(email) || !Validator.validatePassword(password)){
            PrintWriter out = resp.getWriter();
            out.write("invalid input");
            return;
        }
        password = PasswordHasher.hash(req.getParameter("password"));
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getByEmail(email);
        HttpSession session = req.getSession();
        if (user != null){
            if (user.getPassword().equals(password)){
                session.setAttribute("user", user);
                resp.sendRedirect("loggedin/myuserpage");
            }else {
                resp.sendRedirect("/login");
            }
        }
   }

    public void destroy() {
    }
}