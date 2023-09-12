package lesson06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 07/09/2023 HelloSQL
 *
 * @author Wladimir Weizen
 */
public class UserDAO {

  private Connection connection;

  public UserDAO(Connection connection) {
    this.connection = connection;
  }

  public void createNewUser(String name, String password) {
    try {
      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into users (name, password) values (?, ?)");
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, password);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  public User findById(Integer id) {
    User user = null;

    try {
      PreparedStatement preparedStatement = connection
          .prepareStatement("select * from users where id = ?");
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
      }
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
    return user;
  }

  public void updateById(Integer id, String newName, String newPassword) {
    try {
      PreparedStatement preparedStatement = connection
          .prepareStatement("update users set name = ?, password = ? where id = ?");
      preparedStatement.setString(1, newName);
      preparedStatement.setString(2, newPassword);
      preparedStatement.setInt(3, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  public void deleteById(Integer id) {
    try {
      PreparedStatement preparedStatement = connection
          .prepareStatement("delete from users where id = ?");
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
