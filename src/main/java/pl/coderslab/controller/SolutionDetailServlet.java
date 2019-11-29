package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solution")
public class SolutionDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Solution solution;
        SolutionDao solutionDao = new SolutionDao();
        int solutionId = Integer.parseInt(req.getParameter("id"));

        solution = solutionDao.read(solutionId);
        req.getSession().setAttribute("solution", solution);

        getServletContext().getRequestDispatcher("/solution-detail.jsp")
                .forward(req, resp);


    }
}