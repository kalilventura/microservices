package br.com.github.kalilventura.product.global.shared;

import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

@UtilityClass
public class SqlDataSourceHelper {
    private static final int CONNECTION_TIMEOUT = 20_000;
    private static final int MINIMUM_IDLE = 5;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int IDLE_TIMEOUT = 10_000;
    private static final int MAX_LIFE_TIME = 30_000;
    private static final String DEFAULT_DATABASE_NAME = "postgres";

    public static HikariDataSource buildDataSource(final DataSourceProperties properties) {
        final var dataSource = (HikariDataSource) properties.initializeDataSourceBuilder().build();
        applyTuning(dataSource);
        return dataSource;
    }

    public static HikariDataSource buildDefaultDataSource(final HikariDataSource brotherDataSource) {
        final var dataSource = (HikariDataSource) DataSourceBuilder.create()
                .url(getDefaultUrl(brotherDataSource.getJdbcUrl()))
                .driverClassName(brotherDataSource.getDriverClassName())
                .username(brotherDataSource.getUsername())
                .password(brotherDataSource.getPassword())
                .build();
        applyTuning(dataSource);
        return dataSource;
    }

    public static String getNameByUrl(final String jdbcUrl) {
        final var separator = getSeparator(jdbcUrl);
        return jdbcUrl.substring(jdbcUrl.lastIndexOf(separator) + 1);
    }

    private static String getDefaultUrl(final String jdbcUrl) {
        final var separator = getSeparator(jdbcUrl);
        final var baseUrl = jdbcUrl.substring(0, jdbcUrl.lastIndexOf(separator));
        return baseUrl.concat(String.valueOf(separator)).concat(DEFAULT_DATABASE_NAME);
    }

    private static char getSeparator(final String jdbcUrl) {
        final var count = jdbcUrl.chars().filter(ch -> ch == '/').count();
        return count >= 3 ? '/' : ':';
    }

    private static void applyTuning(final HikariDataSource dataSource) {
        dataSource.setConnectionTimeout(CONNECTION_TIMEOUT);
        dataSource.setMinimumIdle(
                EnvironmentHelper.coalesce("DATABASE_MINIMUM_CONNECTIONS", MINIMUM_IDLE)
        );
        dataSource.setMaximumPoolSize(
                EnvironmentHelper.coalesce("DATABASE_MAXIMUM_CONNECTIONS", MAXIMUM_POOL_SIZE)
        );
        dataSource.setIdleTimeout(IDLE_TIMEOUT);
        dataSource.setMaxLifetime(MAX_LIFE_TIME);
    }
}
