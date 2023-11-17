package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.CommentDAOImpl;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Comment;
import com.semestr.firstsemestrovka2kurs.models.Post;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PostServlet extends HttpServlet {
    PostDAOImpl postDao;
    CommentDAOImpl commentDAO;
    @Override
    public void init() {
        postDao = new PostDAOImpl();
        commentDAO = new CommentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Post post = postDao.get(id);
        List<Comment> comments = commentDAO.getAllWithPostId(post.getId());
        HashMap map = new HashMap<>();
        map.put("name", post.getName());
        map.put("content", post.getContent());
        map.put("posterName", post.getPosterName());
        map.put("dateOfPost", post.getDateOfPost());
        map.put("id", post.getId());
        map.put("comments", comments);
        Template template = FreemarkerConfigSingleton.getCfg().getTemplate("./Post.ftl");
        resp.setContentType("text/html");
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        resp.sendRedirect("createcomment?id="+id);
    }
}
