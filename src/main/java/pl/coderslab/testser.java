package pl.coderslab;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/testser")
public class testser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserGroup userGroup = new UserGroup("grupa 1 ");

        UserGroupDao userGroupDao = new UserGroupDao();

        userGroupDao.create(userGroup);

        List<UserGroup> all = Arrays.asList(userGroupDao.findAll());
        resp.getWriter().println(all);
    }
}
