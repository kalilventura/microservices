package br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class DummyCategoriesRepository implements CategoriesRepository {

    @Override
    public Optional<JpaCategory> findByDescription(final String description) {
        return Optional.empty();
    }

    @Override
    public List<JpaCategory> findAll() {
        return new ArrayList<>(1);
    }

    @Override
    public JpaCategory save(final JpaCategory jpa) {
        return null;
    }
}
