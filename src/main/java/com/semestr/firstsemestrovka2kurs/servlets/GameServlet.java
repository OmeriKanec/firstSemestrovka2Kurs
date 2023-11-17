package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.GameDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.Game;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class GameServlet extends HttpServlet {
    GameDAOImpl gameDAO;
    @Override
    public void init() {
        gameDAO = new GameDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Game game = gameDAO.get(id);
        HashMap map = new HashMap<>();
        map.put("name", game.getName());
        map.put("developer", game.getDeveloper());
        map.put("publisher", game.getPublisher());
        map.put("dateofrelise", game.getDateOfRelise());
        map.put("genre", game.getGenre());
        Template template = FreemarkerConfigSingleton.getCfg().getTemplate("./Game.ftl");
        resp.setContentType("text/html");
        try {
            template.process(map, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
