package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserReposority {

    private final Connection connection;

    public UserReposority(Connection connection) {
        this.connection = connection;
    }
    public int registerUser(User user) throws SQLException {

        String addUser = "INSERT INTO users(name, username,email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public User find(String username,String password) throws SQLException {

        String findUser = "SELECT * FROM users WHERE username = ? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            int id = resultSet.getInt("userid");
            String name = resultSet.getString("name");
            String fetchUsername = resultSet.getString("username");
            String email = resultSet.getString("email");
            String fetchpassword = resultSet.getString("password");
            User user = new User(id, name, fetchUsername,email, fetchpassword);
            return user;
        }
        else
            return null;
    }
}
