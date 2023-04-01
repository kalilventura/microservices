package br.com.github.kalilventura.product.products.global.infrastructure;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@ConfigurationProperties(prefix = "datasource.product.liquibase")
public class ProductSqlDataSourceVersioningProperties extends LiquibaseProperties {}
