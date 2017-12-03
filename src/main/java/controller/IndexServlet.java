package controller;

import model.data.Database;
import model.entity.Necklace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Constants.NECKLACES_LIST_ATTRIBUTE_KEY;
import static util.Constants.NECKLACE_NAME_REQUEST_PARAMETER;
import static util.Constants.STONES_LIST_ATTRIBUTE_KEY;

/**
 * controller.TestServlet
 * created on 02.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
@WebServlet(urlPatterns = "/")
public class TestServlet extends HttpServlet {
    private Database database = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(STONES_LIST_ATTRIBUTE_KEY, database.getStones());
        req.setAttribute(NECKLACES_LIST_ATTRIBUTE_KEY, database.getNecklaces());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        database.getNecklaces().add(new Necklace(((String) req.getParameter(NECKLACE_NAME_REQUEST_PARAMETER))));
        resp.sendRedirect("/");
    }
}
