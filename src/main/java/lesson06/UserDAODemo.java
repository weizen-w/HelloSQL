package lesson06;

import java.sql.SQLException;

/**
 * 07/09/2023 HelloSQL
 *
 * @author Wladimir Weizen
 */
public class UserDAODemo {

  public static void main(String[] args) {
    UserDAO userDAO = new UserDAO(MyConnection.getConnection(MyDataSource.getDataSource()));
    User user = userDAO.findById(1);
    System.out.println(user);
  }
}
