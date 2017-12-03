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
import java.util.Locale;
import java.util.ResourceBundle;

import static util.Constants.*;

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
        necklaceId = Integer.parseInt(req.getParameter(NECKLACE_ID_REQUEST_PARAMETER));
        chosenNecklace = database.getNecklaces().get(necklaceId);

        req.setAttribute(NECKLACE_ATTRIBUTE_KEY, chosenNecklace);
        req.setAttribute(STONES_LIST_ATTRIBUTE_KEY, database.getStones());
        req.setAttribute(BUNDLE_ATTRIBUTE_KEY, ResourceBundle.getBundle(DETAIL_BUNDLE_PATH, req.getLocale()));

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/necklaceDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stoneId = Integer.parseInt(req.getParameter(STONE_ID_REQUEST_PARAMETER));
        chosenNecklace.getPreciousStones().add(database.getStones().get(stoneId));

        resp.sendRedirect(NECKLACE_DETAIL_URL + necklaceId);
    }
}
