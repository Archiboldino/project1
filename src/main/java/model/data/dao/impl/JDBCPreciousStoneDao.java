package model.data.dao.impl;

import model.data.dao.PreciousStoneDao;
import model.data.dao.util.DaoUtil;
import model.data.dao.util.PreciousStoneMaper;
import model.entity.PreciousStone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.data.dao.util.DaoConstants.*;

/**
 * JDBCPreciousStoneDao
 * created on 09.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class JDBCPreciousStoneDao implements PreciousStoneDao {
    private Connection connection;

    public JDBCPreciousStoneDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PreciousStone> getAll() {
        List<PreciousStone> res = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_STONES_QUERY);

            while (rs.next()) {
                res.add(PreciousStoneMaper.mapFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    @Override
    public PreciousStone getById(int id) {
        try (PreparedStatement st = connection.
                prepareStatement(SELECT_STONE_BY_ID_QUERY)) {
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            rs.next();
            return PreciousStoneMaper.mapFromResultSet(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(PreciousStone item) {
        try (PreparedStatement st = connection.
                prepareStatement(INSERT_STONE_QUERY)) {
            st.setString(1, item.getName());
            st.setLong(2, item.getPrice());
            st.setInt(3, item.getColor().ordinal());
            st.setDouble(4, item.getTransparency());
            st.setDouble(5, item.getWeight());

            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(PreciousStone item) {
        try (PreparedStatement st = connection.
                prepareStatement(DELETE_STONE_QUERY)) {
            st.setInt(1, item.getId());

            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PreciousStone item) {
        try (PreparedStatement st = connection.
                prepareStatement(UPDATE_STONE_QUERY)) {
            st.setString(1, item.getName());
            st.setDouble(2, item.getTransparency());
            st.setLong(3, item.getPrice());
            st.setDouble(4, item.getWeight());
            st.setInt(4, item.getId());

            st.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
