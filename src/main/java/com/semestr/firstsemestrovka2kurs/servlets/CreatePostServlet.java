package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;;
import com.semestr.firstsemestrovka2kurs.models.Post;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class CreatePostServlet extends HttpServlet {
    PostDAOImpl postDAO;

    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
        postDAO = new PostDAOImpl();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./NewPost.ftl");
        response.setContentType("text/html");
        try {
            tmpl.process(null, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String content = req.getParameter("content");
        String name = req.getParameter("name");
        User u = (User) req.getSession().getAttribute("user");
        long posterId = u.getId();
        String posterName = u.getUserName();
        boolean allowcomments;
        if (req.getParameter("allowcomments").equals("on")){
            allowcomments = true;
        }else {
            allowcomments = false;
        }
        Post post = new Post(name, content, posterId, allowcomments, posterName);
        postDAO.create(post);
        resp.sendRedirect("posts");
    }
}
