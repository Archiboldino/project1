package model.data.dao.impl;

import model.data.dao.DaoFactory;
import model.data.dao.NecklaceDao;
import model.data.dao.PreciousStoneDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static util.Constants.*;

/**
 * JDBCDaoFactory
 * created on 09.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class JDBCDaoFactory extends DaoFactory {
    @Override
    public PreciousStoneDao createStoneDao() {
        return new JDBCPreciousStoneDao(getConnection());
    }

    @Override
    public NecklaceDao createNecklaceDao() {
        return new JDBCNecklaceDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_PATH, DATABASE_USER, DATABASE_PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
