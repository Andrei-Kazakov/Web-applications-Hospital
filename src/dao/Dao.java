package dao;

import domain.Entity;

import java.sql.SQLException;

public interface Dao<T extends Entity> {
    Long create(T entity) throws DaoException;

    T read (Long id) throws DaoException;

    void update (T entity) throws DaoException;

    void delete (Long id) throws DaoException;


}
