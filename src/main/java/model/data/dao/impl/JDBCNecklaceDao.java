package model.data.dao.impl;

import model.data.dao.NecklaceDao;
import model.data.dao.util.NecklaceMaper;
import model.data.dao.util.PreciousStoneMaper;
import model.entity.Necklace;
import model.entity.PreciousStone;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBCNecklaceDao
 * created on 09.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class JDBCNecklaceDao implements NecklaceDao {
    private Connection connection;

    public JDBCNecklaceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Necklace> getAll() {
        Map<Integer, Necklace> necklaces = new HashMap<>();
        Map<Integer, PreciousStone> stones = new HashMap<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(" SELECT n.id necklace_id, n.name necklace_name, p.name stone_name, " +
                    "p.id stone_id, p.name stone_name, p.price stone_price, " +
                    "p.color stone_color, p.transparency stone_transparency, p.weight stone_weight " +
                    "FROM necklace n LEFT JOIN stone_to_necklace j ON n.id = j.necklace_id " +
                    "LEFT JOIN precious_stone p ON p.id = j.stone_id; ");
            while (rs.next()) {
                Necklace necklace = NecklaceMaper.mapFromResultSet(rs);
                PreciousStone stone = PreciousStoneMaper.mapFromResultSet(rs);
                NecklaceMaper.makeUniqueStones(necklace, stone, stones, necklaces);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>(necklaces.values());
    }

    @Override
    public Necklace getById(int id) {
        Map<Integer, PreciousStone> stones = new HashMap<>();
        Map<Integer, Necklace> necklaces = new HashMap<>();
        try (PreparedStatement st = connection.prepareStatement(" SELECT n.id necklace_id, n.name necklace_name, p.name stone_name, " +
                "p.id stone_id, p.name stone_name, p.price stone_price, " +
                "p.color stone_color, p.transparency stone_transparency, p.weight stone_weight " +
                "FROM necklace n LEFT JOIN stone_to_necklace j ON n.id = j.necklace_id " +
                "LEFT JOIN precious_stone p ON p.id = j.stone_id " +
                "WHERE n.id = ?")) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Necklace necklace = NecklaceMaper.mapFromResultSet(rs);
                PreciousStone stone = PreciousStoneMaper.mapFromResultSet(rs);
                NecklaceMaper.makeUniqueStones(necklace, stone, stones, necklaces);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return necklaces.values().stream().findFirst().get();
    }

    @Override
    public void insert(Necklace item) {

    }

    @Override
    public void delete(Necklace item) {

    }

    @Override
    public void update(Necklace item) {

    }
}
