package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.helpers.PasswordHasher;
import com.semestr.firstsemestrovka2kurs.dao.impl.UserDAOImpl;
import com.semestr.firstsemestrovka2kurs.helpers.Validator;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpServlet extends HttpServlet {


    @Override
    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./SignUp.ftl");

        response.setContentType("text/html");
        try {
            tmpl.process(null, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (!Validator.validateEmail(email) || !Validator.validatePassword(password)){
            PrintWriter out = resp.getWriter();
            out.write("invalid input");
            return;
        }
        password = PasswordHasher.hash(req.getParameter("password"));
        User user = new User(req.getParameter("username"), password, email);
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.create(user);
        }
}

