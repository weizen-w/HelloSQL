package lesson06;

/**
 * 07/09/2023 HelloSQL
 *
 * @author Wladimir Weizen
 */
public class User {

  private Integer id;
  private String name;
  private String password;

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
