package service;

import dao.DaoException;
import dao.UserDao;
import domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            return userDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(User user) throws ServiceException {
        try {
            if(user.getId() != null){
            userDao.update(user);
            }else {
                userDao.create(user);
            }
        } catch (DaoException e) {
                throw  new ServiceException(e);
        }
    }
    }

