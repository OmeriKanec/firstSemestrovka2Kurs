package com.semestr.firstsemestrovka2kurs.servlets;

import com.google.gson.Gson;
import com.semestr.firstsemestrovka2kurs.dao.impl.UserDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AjaxCheckIfUsernameAlreadyTakenServlet extends HttpServlet {
    private UserDAOImpl userDAO;
    @Override
    public void init() {
        userDAO = new UserDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = userDAO.getByUserName(username);
        boolean taken;
        if (user == null){
            taken = false;
        }else {
            taken = true;
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        gson.toJson(taken, out);
    }
}
