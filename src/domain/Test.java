package domain;

import dao.DaoException;
import dao.mysql.UserDaoImpl;
import di.ServiceCreationException;
import di.ServiceCreator;
import pool.ConnectionPool;
import pool.ConnectionPoolException;
import service.ServiceException;
import service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.List;
import java.util.TimeZone;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, DaoException, ConnectionPoolException {
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.init(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/hospital_db?serverTimezone=" + TimeZone.getDefault().getID(),
                "root",
                "password",
                5,
                100,
                0
        );
        //Connect to DB
        try(ServiceCreator sc = new ServiceCreator()) {
            UserService userService = sc.getUserService();
            List<User> users = userService.findAll();
            for (User user : users) {
                System.out.println(user);
            }
            System.out.println("OK findAll");
        }catch (ServiceCreationException | ServiceException e){
            System.out.println("ERROR");

        }


/*        Connection c = pool.getConnection();
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(c);
        List<User> users = userDao.readAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("OK, read all");
        User user = userDao.read(1L);
        System.out.println(user);
        System.out.println("OK, read");
        user.setPassword("12345");
        user.setRole(Role.NURSE);
        //c.close();
        userDao.update(user);
        System.out.println("OK, update");
        user = new User();
        user.setLogin("User" + Math.random());
        user.setPassword("12345");
        user.setRole(Role.ADMIN);
        Long id = userDao.create(user);
        System.out.println("OK, create, id = " + id);
        c.close();*/
    }
}



