package controller;

import model.entity.Necklace;
import service.NecklaceService;
import service.StoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

import static util.Constants.*;

/**
 * controller.IndexServlet
 * created on 02.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(STONES_LIST_ATTRIBUTE_KEY, StoneService.getAll());
        req.setAttribute(NECKLACES_LIST_ATTRIBUTE_KEY, NecklaceService.getAll());
        req.setAttribute(BUNDLE_ATTRIBUTE_KEY, ResourceBundle.getBundle(INDEX_BUNDLE_PATH, req.getLocale()));


        getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NecklaceService.add(new Necklace(req.getParameter(NECKLACE_NAME_REQUEST_PARAMETER)));
        resp.sendRedirect("/");
    }
}
