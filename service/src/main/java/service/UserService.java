package service;

import dao.UserDao;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserDao userDao = UserDao.getInstance();


    public Optional<User> get(Integer id) {
        return userDao.get(id);
    }


    public List<User> getAll() {
        return userDao.getAll();
    }


    public boolean delete(Integer id) {
        return userDao.delete(id);
    }


    public boolean save(User user) {
        return userDao.save(user);
    }


    public boolean update(User user) {
        return userDao.update(user);
    }
}

