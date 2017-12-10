package model.data.dao.impl;

import model.data.dao.DaoFactory;
import model.data.dao.NecklaceDao;
import model.data.dao.PreciousStoneDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/stoneDB");
            return ds.getConnection();
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
