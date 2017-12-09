package model.data.dao;

import model.data.dao.impl.JDBCDaoFactory;

/**
 * DaoFactory
 * created on 04.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public static DaoFactory getInstance() {
        if (daoFactory == null) { // Double checked
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }

    public abstract PreciousStoneDao createStoneDao();

    public abstract NecklaceDao createNecklaceDao();
}
