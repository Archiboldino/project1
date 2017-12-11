package model.data.dao.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DaoUtil
 * created on 11.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class DaoUtil {
    public static void closeConnection(Connection c) {
        try {
            c.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
