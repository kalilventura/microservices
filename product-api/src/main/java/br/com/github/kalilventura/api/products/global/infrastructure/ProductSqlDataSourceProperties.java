package br.com.github.kalilventura.api.products.global.infrastructure;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@ConfigurationProperties(prefix = "datasource.product")
public class ProductSqlDataSourceProperties extends DataSourceProperties {
}
