package br.com.github.kalilventura.api.global.liquibase;

import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@NoArgsConstructor
@EnableConfigurationProperties(ApiSqlDataSourceVersioningProperties.class)
public class ApiSqlDataSourceVersioningConfiguration extends SqlDataSourceVersioning {

  @Bean
  public SpringLiquibase liquibase(
      final DataSource dataSource,
      final Environment environment,
      final ApiSqlDataSourceVersioningProperties properties) {
    return generateSpringLiquibase(dataSource, environment, properties);
  }
}
