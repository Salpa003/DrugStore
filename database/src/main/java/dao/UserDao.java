package dao;

import entity.User;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {

    private final static String GET_ALL_SQL = """
            SELECT id, name, email, password
            FROM drug_store.users.users
            """;

    private final static String GET_BY_ID_SQL = GET_ALL_SQL + " WHERE id = ?";

    private final static String DELETE_BY_ID_SQL = """
            DELETE FROM drug_store.users.users
            WHERE id = ?;
            """;

    private final static String SAVE_SQL = """
            INSERT INTO drug_store.users.users(name, email, password)
            VALUES (?,?,?);
            """;

    private final static String UPDATE_SQL = """
            UPDATE drug_store.users.users
            set name = ? , email = ?, password = ?
            WHERE id = ?;
            """;

    private static final UserDao INSTANCE = new UserDao();

    private UserDao() {

    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> get(Integer id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(resultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении пользователя : " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(resultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка пользователей : " + e.getMessage());
        }
        return users;
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении пользователя : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean save(User user) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Ошибка при сохранении user : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Ошибка update user :" + e.getMessage());
            return false;
        }
    }

    private User resultSetToUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("password")
        );
    }
}
