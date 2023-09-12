package lesson06.spring;

import lesson06.UserDAO;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 07/09/2023 HelloSQL
 *
 * @author Wladimir Weizen
 */
@Configuration
public class AppConfig {
  @Bean
  public DataSource dataSource() {
    PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
    pgSimpleDataSource.setServerName("localhost");
    pgSimpleDataSource.setDatabaseName("cohort26");
    pgSimpleDataSource.setUser("postgres");
    pgSimpleDataSource.setPassword("root");
    return pgSimpleDataSource;
  }

  @Bean
  public Connection connection() {
    try{
      return dataSource().getConnection();
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Bean
  public UserDAO userDAO() {
    return new UserDAO(connection());
  }
}
