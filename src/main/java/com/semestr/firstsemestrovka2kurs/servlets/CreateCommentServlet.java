package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.CommentDAOImpl;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Comment;
import com.semestr.firstsemestrovka2kurs.models.Post;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateCommentServlet extends HttpServlet {
    CommentDAOImpl commentDAO;

    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
        commentDAO = new CommentDAOImpl();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./CreateComment.ftl");
        response.setContentType("text/html");
        Map map = new HashMap<>();
        map.put("id", request.getParameter("id"));
        try {
            tmpl.process(map, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String content = req.getParameter("content");
        long postId = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        User u = (User) req.getSession().getAttribute("user");
        long commenterId = u.getId();
        String posterName = u.getUserName();
        Comment comment = new Comment(name, content, commenterId, postId, posterName);
        commentDAO.create(comment);
        resp.sendRedirect("post?id="+postId);
    }
}
