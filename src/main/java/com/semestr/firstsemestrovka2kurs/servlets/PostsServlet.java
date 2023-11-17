package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Post;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PostsServlet extends HttpServlet {
    PostDAOImpl postDAO;
    @Override
    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
        postDAO = new PostDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./Posts.ftl");
        resp.setContentType("text/html");
        List<Post> posts = postDAO.getAll();
        HashMap map = new HashMap<>();
        map.put("posts", posts);
        try {
            tmpl.process(map, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
