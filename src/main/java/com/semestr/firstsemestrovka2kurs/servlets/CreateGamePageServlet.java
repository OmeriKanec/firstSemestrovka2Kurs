package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.GameDAOImpl;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Game;
import com.semestr.firstsemestrovka2kurs.models.Post;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class CreateGamePageServlet extends HttpServlet {
    GameDAOImpl gameDAO;

    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
        gameDAO = new GameDAOImpl();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./CreateGamePage.ftl");
        response.setContentType("text/html");
        try {
            tmpl.process(null, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String genre = req.getParameter("genre");
        String name = req.getParameter("name");
        User u = (User) req.getSession().getAttribute("user");
        long creatorId = u.getId();
        String developer = req.getParameter("developer");
        String publisher = req.getParameter("publisher");
        LocalDate dateOfRelise = LocalDate.parse(req.getParameter("dateofrelise"));
        Game game = new Game(name, genre, dateOfRelise, developer, publisher, creatorId);
        gameDAO.create(game);
        resp.sendRedirect("games");
    }
}
