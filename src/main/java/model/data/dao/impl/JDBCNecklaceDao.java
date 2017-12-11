package model.data.dao.impl;

import model.data.dao.NecklaceDao;
import model.data.dao.util.DaoUtil;
import model.data.dao.util.NecklaceMaper;
import model.data.dao.util.PreciousStoneMaper;
import model.entity.Necklace;
import model.entity.PreciousStone;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.data.dao.util.DaoConstants.*;

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
            ResultSet rs = st.executeQuery(GET_ALL_NECKLACES_QUERY);
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
        try (PreparedStatement st = connection.prepareStatement(GET_NECKLACE_BY_ID_QUERY)) {

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

        return new ArrayList<>(necklaces.values()).get(0);
    }

    @Override
    public void insert(Necklace item) {
        try (PreparedStatement st = connection.prepareStatement(INSERT_NECKLACE_QUERY)) {
            st.setString(1, item.getName());

            st.execute();

            for (PreciousStone s : item.getPreciousStones()) {
                System.out.println(s.getId());
                saveStoneToNecklace(item, s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveStoneToNecklace(Necklace necklace, PreciousStone stone) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_STONE_TO_NECKLACE_QUERY)) {
            PreparedStatement stones_to_necklace = connection.prepareStatement(SELECT_JOIN_TABLE_QUERY);

            stones_to_necklace.setInt(1, stone.getId());
            stones_to_necklace.setInt(2, necklace.getId());

            boolean isEmpty = !stones_to_necklace.executeQuery().next();
            if (isEmpty) {
                st.setInt(1, stone.getId());
                st.setInt(2, necklace.getId());
                st.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Necklace item) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_NECKLACE_QUERY)) {

            st.setInt(1, item.getId());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Necklace item) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_NECKLACE_QUERY)) {

            st.setString(1, item.getName());
            st.setInt(2, item.getId());

            st.execute();
            for (PreciousStone s : item.getPreciousStones()) {
                saveStoneToNecklace(item, s);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
