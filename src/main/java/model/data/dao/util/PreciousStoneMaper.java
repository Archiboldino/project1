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
                    .id(rs.getInt("stone_id"))
                    .name(rs.getString("stone_name"))
                    .color(Color.values()[rs.getInt("stone_color")])
                    .transparency(rs.getDouble("stone_transparency"))
                    .price(rs.getLong("stone_price"))
                    .weight(rs.getDouble("stone_weight")).build();

            return stone;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
