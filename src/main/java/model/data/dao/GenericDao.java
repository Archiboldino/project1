package model.data.dao;

import java.util.List;

/**
 * GenericDao
 * created on 09.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public interface GenericDao<T> {
    List<T> getAll();

    T getById(int id);

    void insert(T item);

    void delete(T item);

    void update(T item);
}
