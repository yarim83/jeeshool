package pl.coderslab.controller.admin;

import pl.coderslab.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPanel/exercises")
public class ExercisesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        req.setAttribute("exercises", exerciseDao.findAll());
        getServletContext().getRequestDispatcher("/admin/exercises.jsp")
                .forward(req, resp);
    }
}