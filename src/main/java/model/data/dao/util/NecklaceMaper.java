package model.data.dao.util;

import model.entity.Necklace;
import model.entity.PreciousStone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * NecklaceMaper
 * created on 10.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class NecklaceMaper {
    public static Necklace mapFromResultSet(ResultSet rs) {
        try {
            Necklace necklace = new Necklace(rs.getString("necklace_name"));
            necklace.setId(rs.getInt("necklace_id"));
            return necklace;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void makeUniqueStones(Necklace necklace, PreciousStone stone, Map<Integer, PreciousStone> stones) {
        if (stone.getId() != 0) {
            stones.putIfAbsent(stone.getId(), stone);
            necklace.getPreciousStones().add(stones.get(stone.getId()));
        }
    }
}
