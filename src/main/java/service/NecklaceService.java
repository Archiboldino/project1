package service;

import model.data.dao.DaoFactory;
import model.data.dao.NecklaceDao;
import model.entity.Necklace;

import java.util.List;

/**
 * NecklaceService
 * created on 10.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class NecklaceService {
    public static List<Necklace> getAll() {
        NecklaceDao necklaceDao = DaoFactory.getInstance().createNecklaceDao();
        return necklaceDao.getAll();
    }

    public static void add(Necklace necklace) {
        NecklaceDao necklaceDao = DaoFactory.getInstance().createNecklaceDao();
        necklaceDao.insert(necklace);
    }

    public static Necklace getById(int necklaceId) {
        NecklaceDao necklaceDao = DaoFactory.getInstance().createNecklaceDao();
        return necklaceDao.getById(necklaceId);
    }

    public static void save(Necklace chosenNecklace) {
        NecklaceDao necklaceDao = DaoFactory.getInstance().createNecklaceDao();
        necklaceDao.update(chosenNecklace);
    }
}
