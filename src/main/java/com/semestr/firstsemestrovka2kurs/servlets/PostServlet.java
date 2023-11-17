package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;
import com.semestr.firstsemestrovka2kurs.dao.impl.UserDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Post;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class PostServlet extends HttpServlet {
    PostDAOImpl postDao;
    @Override
    public void init() {
        postDao = new PostDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Post post = postDao.get(id);
        HashMap map = new HashMap<>();
        map.put("name", post.getName());
        map.put("content", post.getContent());
        map.put("posterName", post.getPosterName());
        map.put("dateOfPost", post.getDateOfPost());
        Template template = FreemarkerConfigSingleton.getCfg().getTemplate("./Post.ftl");
        resp.setContentType("text/html");
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
