package service;

import domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll() throws ServiceException;

    void save(User user) throws ServiceException;
}
