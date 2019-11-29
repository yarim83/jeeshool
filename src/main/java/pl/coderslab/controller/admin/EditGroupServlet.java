package pl.coderslab.controller.admin;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPanel/editGroup")
public class EditGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserGroup userGroup;
        UserGroupDao userGroupDao = new UserGroupDao();

        int groupId = Integer.parseInt(req.getParameter("groupId"));
        userGroup = userGroupDao.read(groupId);
        req.getSession().setAttribute("group", userGroup);

        getServletContext().getRequestDispatcher("/admin/edit-group.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserGroup userGroup = new UserGroup();
        UserGroupDao userGroupDao = new UserGroupDao();

        String groupName = req.getParameter("groupName");
        int groupId = Integer.parseInt(req.getParameter("groupId"));

        userGroup.setId(groupId);
        userGroup.setName(groupName);
        userGroupDao.update(userGroup);

        resp.sendRedirect("/adminPanel/groups");
    }
}