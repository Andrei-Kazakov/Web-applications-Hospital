package di;

import dao.UserDao;
import dao.mysql.UserDaoImpl;
import pool.ConnectionPool;
import pool.ConnectionPoolException;
import service.UserService;
import service.UserServiceImpl;

import java.sql.Connection;

public class ServiceCreator implements AutoCloseable {
    private UserService userService = null;
    public UserService getUserService() throws ServiceCreationException {
        if(userService == null) {
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            userServiceImpl.setUserDao(getUserDao());
            userService = userServiceImpl;
        }
        return userService;
    }

    private UserDao userDao = null;

    private UserDao getUserDao() throws ServiceCreationException {
        if (userDao == null) {
            UserDaoImpl userDaoImpl = new UserDaoImpl();
            userDaoImpl.setConnection(getConnection());
            userDao = userDaoImpl;
        }

        return userDao;
    }

    private Connection connection = null;

    private Connection getConnection() throws ServiceCreationException {
        if (connection == null) {
            try {
                connection = ConnectionPool.getInstance().getConnection();
            } catch (ConnectionPoolException e) {
                throw new ServiceCreationException(e);
            }
        }
        return connection;
    }

    @Override
    public void close() {
      try{connection.close();} catch (Exception e){}
    }
}