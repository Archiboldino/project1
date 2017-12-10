package model.data.dao.util;

/**
 * DaoConstants
 * created on 10.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public interface DaoConstants {
    String GET_ALL_NECKLACES_QUERY =
            "SELECT n.id necklace_id, n.name necklace_name, p.name stone_name, " +
                    "p.id stone_id, p.name stone_name, p.price stone_price, " +
                    "p.color stone_color, p.transparency stone_transparency, p.weight stone_weight " +
                    "FROM necklace n LEFT JOIN stone_to_necklace j ON n.id = j.necklace_id " +
                    "LEFT JOIN precious_stone p ON p.id = j.stone_id; ";
    String GET_NECKLACE_BY_ID_QUERY = "SELECT n.id necklace_id, n.name necklace_name, p.name stone_name, " +
            "p.id stone_id, p.name stone_name, p.price stone_price, " +
            "p.color stone_color, p.transparency stone_transparency, p.weight stone_weight " +
            "FROM necklace n LEFT JOIN stone_to_necklace j ON n.id = j.necklace_id " +
            "LEFT JOIN precious_stone p ON p.id = j.stone_id " +
            "WHERE n.id = ?";
    String INSERT_NECKLACE_QUERY = "INSERT INTO necklace (name) VALUES (?)";
    String SAVE_STONE_TO_NECKLACE_QUERY = "INSERT INTO stone_to_necklace " +
            "(stone_id, necklace_id) VALUES (?, ?)";
    String DELETE_NECKLACE_QUERY = "DELETE FROM necklace " +
            "WHERE id=?";
    String UPDATE_NECKLACE_QUERY = "UPDATE necklace" +
            " SET name=? WHERE id=?";
    String SELECT_JOIN_TABLE_QUERY = "SELECT * FROM stone_to_necklace";


    String SELECT_STONES_QUERY = "SELECT id stone_id, name stone_name, price stone_price," +
            " color stone_color, transparency stone_transparency, weight stone_weight FROM precious_stone";
    String SELECT_STONE_BY_ID_QUERY = "SELECT id stone_id, name stone_name, price stone_price, " +
            "color stone_color, transparency stone_transparency, weight stone_weight FROM precious_stone " +
            "WHERE id=?;";
    String INSERT_STONE_QUERY = "INSERT INTO  precious_stone (name, price, color, transparency, weight) " +
            "VALUES (?, ?, ?, ?, ?)";
    String DELETE_STONE_QUERY = "DELETE FROM  precious_stone " +
            "WHERE id=?";
    String UPDATE_STONE_QUERY = "UPDATE  precious_stone " +
            " SET name=?, color=?, transparency=?, price=?, weight=? WHERE id=?";
}
