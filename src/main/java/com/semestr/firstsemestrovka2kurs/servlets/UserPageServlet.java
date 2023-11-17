package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.UserDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class UserPageServlet extends HttpServlet {
    UserDAOImpl userDAO;
    @Override
    public void init() {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        HashMap map = new HashMap<>();
        User user = userDAO.getByUserName(userName);
        map.put("username", user.getUserName());
        map.put("bio", user.getBio());
        map.put("profilePicture", user.getProfilePicture());
        Template template = FreemarkerConfigSingleton.getCfg().getTemplate("./UserPage.ftl");
        resp.setContentType("text/html");
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void destroy() {

    }
}
