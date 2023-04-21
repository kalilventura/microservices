package br.com.github.kalilventura.api.global.liquibase;

import br.com.github.kalilventura.api.global.shared.SqlDataSourceHelper;
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
        basePackages = {
                "br.com.github.kalilventura.api.products.infrastructure.repositories",
                "br.com.github.kalilventura.api.categories.infrastructure.repositories"
        }
)
@EnableConfigurationProperties(ApiSqlDataSourceProperties.class)
public class ApiSqlDataSourceConfiguration {

    @Bean
    public DataSource dataSource(final ApiSqlDataSourceProperties properties) {
        return SqlDataSourceHelper.buildDataSource(properties);
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
