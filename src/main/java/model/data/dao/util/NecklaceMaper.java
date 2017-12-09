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

    public static void makeUniqueStones(Necklace necklace, PreciousStone stone, Map<Integer, PreciousStone> stones, Map<Integer, Necklace> necklaces) {
        if (stone.getId() != 0) {
            necklaces.putIfAbsent(necklace.getId(), necklace);
            stones.putIfAbsent(stone.getId(), stone);
            stone = stones.get(stone.getId());
            necklace = necklaces.get(necklace.getId());
            necklace.getPreciousStones().add(stone);
        }
    }
}
