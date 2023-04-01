package br.com.github.kalilventura.product.global.liquibase;

import liquibase.changelog.IncludeAllFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LiquibaseIncludeAllFilter implements IncludeAllFilter {

    @Override
    public boolean include(final String changeLogPath) {
        return changeLogPath.contains("yml") || changeLogPath.contains("yaml");
    }
}
