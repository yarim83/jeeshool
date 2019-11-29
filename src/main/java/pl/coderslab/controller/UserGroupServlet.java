package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usersOfGroup")
public class UsersGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        UserGroupDao userGroupDao = new UserGroupDao();
        int groupId = Integer.parseInt(req.getParameter("groupId"));
        String groupName = userGroupDao.read(groupId).getName();
        List<User> users = userDao.findAllByExerciseId(groupId);

        req.getSession().setAttribute("groupName", groupName);
        req.getSession().setAttribute("users", users);

        getServletContext().getRequestDispatcher("/users-of-group.jsp")
                .forward(req, resp);
    }
}