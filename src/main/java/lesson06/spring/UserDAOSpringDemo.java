package lesson06.spring;

import lesson06.User;
import lesson06.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 07/09/2023 HelloSQL
 *
 * @author Wladimir Weizen
 */
public class UserDAOSpringDemo {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    UserDAO userDAO = applicationContext.getBean(UserDAO.class);
    User user = userDAO.findById(1);
    System.out.println(user);
    userDAO.updateById(1, "NoName", "qwerty111");
    user = userDAO.findById(1);
    System.out.println(user);
    userDAO.deleteById(2);
    userDAO.createNewUser("Alex", "fghtzs");
  }
}
