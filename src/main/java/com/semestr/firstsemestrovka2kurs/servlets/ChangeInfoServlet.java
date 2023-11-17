package com.semestr.firstsemestrovka2kurs.servlets;

import com.semestr.firstsemestrovka2kurs.FreemarkerConfigSingleton;
import com.semestr.firstsemestrovka2kurs.dao.impl.UserDAOImpl;
import com.semestr.firstsemestrovka2kurs.models.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;


@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ChangeInfoServlet extends HttpServlet {

    UserDAOImpl userDAO;

    public void init() {
        FreemarkerConfigSingleton.setServletContext(this.getServletContext());
        userDAO = new UserDAOImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User) request.getSession().getAttribute("user");
        User user = userDAO.getByUserName(u.getUserName());
        HashMap map = new HashMap<>();
        map.put("bio", user.getBio());
        Template tmpl = FreemarkerConfigSingleton.getCfg().getTemplate("./ChangeInfo.ftl");
        response.setContentType("text/html");
        try {
            tmpl.process(map, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Part filePart = req.getPart("file");
            InputStream fileContent = filePart.getInputStream();
            if (fileContent.available() != 0) {
                User user = (User) req.getSession().getAttribute("user");
                String fileName = user.getUserName() + "profpic" + System.currentTimeMillis() + "." + filePart.getSubmittedFileName().split("\\.")[1];
                    String filePath = "C:\\Projects\\Firstsemestrovka2Kurs\\pictures1\\" + fileName;
                    File file = new File(filePath);
                    Files.copy(fileContent, file.toPath());
                    user.setProfilePicture("../../../../../pictures1/" + fileName);
                    userDAO.update(user);
                }
        } catch (ServletException e) {

        }
        String bio = req.getParameter("bio");
        User u = (User) req.getSession().getAttribute("user");
        User user = userDAO.getByUserName(u.getUserName());
        user.setBio(bio);
        userDAO.update(user);
        resp.sendRedirect("myuserpage");
    }

    public void destroy() {
    }
}
