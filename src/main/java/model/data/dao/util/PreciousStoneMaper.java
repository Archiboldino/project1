package model.data.dao.util;

import model.entity.Color;
import model.entity.PreciousStone;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreciousStoneMaper
 * created on 09.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class PreciousStoneMaper {
    public static PreciousStone mapFromResultSet(ResultSet rs) {
        try {
            PreciousStone stone = new PreciousStone.Builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .color(Color.values()[rs.getInt("color")])
                    .transparency(rs.getDouble("transparency"))
                    .price(rs.getLong("price"))
                    .weight(rs.getDouble("weight")).build();

            return stone;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
