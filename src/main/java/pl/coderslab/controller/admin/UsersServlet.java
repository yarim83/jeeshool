package pl.coderslab.controller.admin;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/adminPanel/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users;
        UserDao userDao = new UserDao();
        users = userDao.findAll();

        req.getSession().setAttribute("users", users);

        getServletContext().getRequestDispatcher("/admin/users.jsp")
                .forward(req, resp);
    }
}