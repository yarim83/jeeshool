package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        SolutionDao solutionDao = new SolutionDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        Map<Solution, Exercise> solutionExerciseMap = new HashMap<>();

        int userId = Integer.parseInt(req.getParameter("id"));
        User user = userDao.read(userId);

        for (Solution solution : solutionDao.findAllByUserId(userId)) {
            solutionExerciseMap.put(solution, exerciseDao.read(solution.getExercise_id()));
        }

        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("solutions", solutionExerciseMap);


        getServletContext().getRequestDispatcher("/user.jsp")
                .forward(req, resp);


    }
}