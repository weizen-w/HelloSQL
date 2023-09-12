package lesson06;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

/**
 * 07/09/2023 HelloSQL
 *
 * @author Wladimir Weizen
 */
public class MyDataSource {

  private static DataSource dataSource;

  public static DataSource getDataSource() {
    if (dataSource == null) {
      PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
      pgSimpleDataSource.setServerName("localhost");
      pgSimpleDataSource.setDatabaseName("cohort26");
      pgSimpleDataSource.setUser("postgres");
      pgSimpleDataSource.setPassword("root");
      dataSource = pgSimpleDataSource;
    }
    return dataSource;
  }
}
