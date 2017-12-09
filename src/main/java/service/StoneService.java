package service;

import model.data.dao.DaoFactory;
import model.data.dao.PreciousStoneDao;
import model.entity.PreciousStone;

import java.util.List;

/**
 * StoneService
 * created on 10.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class StoneService {
    public static List<PreciousStone> getAll() {
        PreciousStoneDao stoneDao = DaoFactory.getInstance().createStoneDao();
        return stoneDao.getAll();
    }

    public static PreciousStone getById(int stoneId) {
        PreciousStoneDao stoneDao = DaoFactory.getInstance().createStoneDao();
        return stoneDao.getById(stoneId);
    }
}
