package controller;

import model.data.Database;
import model.entity.Necklace;
import model.entity.PreciousStone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Constants.NECKLACE_ATTRIBUTE_KEY;
import static util.Constants.STONES_LIST_ATTRIBUTE_KEY;

/**
 * NecklaceDetailServlet
 * created on 03.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
@WebServlet(urlPatterns = "/necklace")
public class NecklaceDetailServlet extends HttpServlet {
    private Database database = Database.getInstance();
    private Necklace chosenNecklace;
    private int necklaceId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        necklaceId = Integer.parseInt(req.getParameter("id"));
        chosenNecklace = database.getNecklaces().get(necklaceId);
        req.setAttribute(NECKLACE_ATTRIBUTE_KEY, chosenNecklace);
        req.setAttribute(STONES_LIST_ATTRIBUTE_KEY, database.getStones());

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/necklaceDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stoneId = Integer.parseInt(req.getParameter("stoneId"));
        chosenNecklace.getPreciousStones().add(database.getStones().get(stoneId));

        resp.sendRedirect("necklace?id=" + necklaceId);
    }
}
