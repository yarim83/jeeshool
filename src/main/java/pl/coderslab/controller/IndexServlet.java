package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        UserDao userDao = new UserDao();
        int n = Integer.parseInt(getServletContext().getInitParameter("number-solution"));

        List<Solution> recent = solutionDao.findRecent(n);
        List<Object[]> solutions = new ArrayList<>();
        for (Solution solution : recent) {
            Object[] objects = new Object[3];
            objects[0] = exerciseDao.read(solution.getExercise_id());
            objects[1] = userDao.read(solution.getUsers_id());
            objects[2] = solution;
            solutions.add(objects);
        }

        req.setAttribute("recent", solutions);

        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}