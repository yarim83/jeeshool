package pl.coderslab.controller.admin;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminPanel/editExercise")
public class EditExerciseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("exercise", exerciseDao.read(id));

        getServletContext().getRequestDispatcher("/admin/edit-exercise.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = new Exercise();

        exercise.setId(Integer.parseInt(req.getParameter("id")));
        exercise.setTitle(req.getParameter("title"));
        exercise.setDescription(req.getParameter("description"));

        exerciseDao.update(exercise);

        resp.sendRedirect("/adminPanel/exercises");
    }
}