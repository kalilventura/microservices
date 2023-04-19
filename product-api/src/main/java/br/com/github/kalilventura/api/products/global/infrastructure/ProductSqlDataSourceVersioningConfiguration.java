package br.com.github.kalilventura.api.products.global.infrastructure;

import br.com.github.kalilventura.api.global.liquibase.SqlDataSourceVersioning;
import liquibase.integration.spring.SpringLiquibase;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@NoArgsConstructor
@EnableConfigurationProperties(ProductSqlDataSourceVersioningProperties.class)
public class ProductSqlDataSourceVersioningConfiguration extends SqlDataSourceVersioning {

    @Bean
    public SpringLiquibase liquibase(
            final DataSource dataSource, final Environment environment,
            final ProductSqlDataSourceVersioningProperties properties) {
        return generateSpringLiquibase(dataSource, environment, properties);
    }
}
