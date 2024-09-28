package br.com.github.kalilventura.api.global.liquibase;

import br.com.github.kalilventura.api.global.shared.SqlDataSourceHelper;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.sql.DataSource;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.core.env.Environment;

@Slf4j
@NoArgsConstructor
public class SqlDataSourceVersioning {

  protected SpringLiquibase generateSpringLiquibase(
      final DataSource dataSource,
      final Environment environment,
      final LiquibaseProperties properties) {

    initDatabase((HikariDataSource) dataSource);

    final var springLiquibase = new SpringLiquibase();
    springLiquibase.setDataSource(dataSource);
    springLiquibase.setChangeLog(properties.getChangeLog());
    springLiquibase.setContexts(String.join(",", environment.getActiveProfiles()));
    springLiquibase.setDefaultSchema(properties.getDefaultSchema());
    springLiquibase.setDropFirst(properties.isDropFirst());
    springLiquibase.setShouldRun(properties.isEnabled());
    springLiquibase.setLabelFilter(properties.getLabelFilter());
    springLiquibase.setChangeLogParameters(properties.getParameters());
    springLiquibase.setRollbackFile(properties.getRollbackFile());

    final var dataSourceName =
        SqlDataSourceHelper.getNameByUrl(((HikariDataSource) dataSource).getJdbcUrl());
    checkDatabaseLock(dataSourceName, generateLiquibase(springLiquibase));
    return springLiquibase;
  }

  private void initDatabase(final HikariDataSource dataSource) {
    final var defaultDataSource = SqlDataSourceHelper.buildDefaultDataSource(dataSource);
    final var brotherDataSourceName = SqlDataSourceHelper.getNameByUrl(dataSource.getJdbcUrl());

    try {
      log.info("Trying to initialize a new database");
      try (var connection = defaultDataSource.getConnection();
          var statement = connection.createStatement()) {
        statement.execute(MessageFormat.format("CREATE DATABASE \"{0}\";", brotherDataSourceName));
      }
    } catch (SQLException exception) {
      log.error("Ignored exception: " + exception.getMessage());
    }

    defaultDataSource.close();
    log.info("Database " + brotherDataSourceName + " was initialized.");
  }

  @SneakyThrows
  private Liquibase generateLiquibase(final SpringLiquibase springLiquibase) {
    final var connection = springLiquibase.getDataSource().getConnection();
    final var database =
        DatabaseFactory.getInstance()
            .findCorrectDatabaseImplementation(new JdbcConnection(connection));

    return new Liquibase(
        springLiquibase.getChangeLog(), new ClassLoaderResourceAccessor(), database);
  }

  @SneakyThrows
  private void checkDatabaseLock(final String databaseName, final Liquibase liquibase) {
    for (final var databaseChangeLogLock : liquibase.listLocks()) {
      log.error(
          MessageFormat.format(
              "Database {0} is locked! Locked by {1} and granted on {2}",
              databaseName,
              databaseChangeLogLock.getLockedBy(),
              databaseChangeLogLock.getLockGranted()));
    }
    liquibase.close();
  }
}
