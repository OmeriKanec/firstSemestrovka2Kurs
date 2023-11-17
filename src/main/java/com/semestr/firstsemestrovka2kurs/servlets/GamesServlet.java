package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.GameDAOImpl;
import com.semestr.firstsemestrovka2kurs.dao.impl.PostDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Game;
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

public class GamesServlet extends HttpServlet {
    GameDAOImpl gameDAO;
    @Override
    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
        gameDAO = new GameDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./Games.ftl");
        resp.setContentType("text/html");
        List<Game> games = gameDAO.getAll();
        HashMap map = new HashMap<>();
        map.put("games", games);
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
