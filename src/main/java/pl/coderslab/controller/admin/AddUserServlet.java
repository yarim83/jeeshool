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

@WebServlet("/adminPanel/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserGroupDao userGroupDao = new UserGroupDao();
        req.getSession().setAttribute("groups", userGroupDao.findAll());
        getServletContext().getRequestDispatcher("/admin/add-user.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        if (req.getParameter("pass").equals(req.getParameter("pass2"))) {
            User user = new User(
                    req.getParameter("username"),
                    req.getParameter("email"),
                    req.getParameter("pass"),
                    Integer.parseInt(req.getParameter("groupId"))
            );
            userDao.create(user);
            resp.sendRedirect("/adminPanel/users");
        } else {
            req.setAttribute("invalidPass", true);
            getServletContext().getRequestDispatcher("/admin/add-user.jsp")
                    .forward(req, resp);
        }
    }
}