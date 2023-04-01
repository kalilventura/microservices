package br.com.github.kalilventura.product.products.global.infrastructure;

import br.com.github.kalilventura.product.global.shared.SqlDataSourceHelper;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@NoArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"br.com.github.kalilventura.product.products.infrastructure.repositories"}
)
@EnableConfigurationProperties(ProductSqlDataSourceProperties.class)
public class ProductSqlDataSourceConfiguration {

    @Bean
    public DataSource dataSource(final ProductSqlDataSourceProperties properties) {
        return SqlDataSourceHelper.buildDataSource(properties);
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
