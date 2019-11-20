package pl.coderslab;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

@WebServlet("/testser")
public class Test extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
        UserGroup userGroup = new UserGroup("grupa 1");
        UserGroupDao userGroupDao = new UserGroupDao();

        userGroupDao.create(userGroup);

        List<UserGroup> all = userGroupDao.findAll();
        resp.getWriter().println(all);

}
}