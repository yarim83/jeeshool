package pl.coderslab.controller.admin;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminPanel/groups")
public class GroupsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserGroupDao userGroupDao = new UserGroupDao();
        List<UserGroup>  userGroups = userGroupDao.findAll();

        req.getSession().setAttribute("groups", userGroups);
        getServletContext().getRequestDispatcher("/admin/groups.jsp")
                .forward(req, resp);
    }
}