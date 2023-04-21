package br.com.github.kalilventura.api.global.liquibase;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@ConfigurationProperties(prefix = "datasource.product.liquibase")
public class ApiSqlDataSourceVersioningProperties extends LiquibaseProperties {}
