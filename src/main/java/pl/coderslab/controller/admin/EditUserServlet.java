package pl.coderslab.controller.admin;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPanel/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        UserGroupDao userGroupDao = new UserGroupDao();
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = userDao.read(userId);
        req.setAttribute("user", user);
        req.setAttribute("groups", userGroupDao.findAll());
        getServletContext().getRequestDispatcher("/admin/edit-user.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        int id = Integer.parseInt(req.getParameter("id"));
        int groupId = Integer.parseInt(req.getParameter("groupId"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        User user = userDao.read(id);

        user.setUserName(username);
        user.setEmail(email);
        user.setGoupId(groupId);

        userDao.update(user);

        resp.sendRedirect("/adminPanel/users");
    }
}