package dao;

import entity.Dao;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();

    private UserDao() {

    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> get(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
