package br.com.github.kalilventura.api.categories.infrastructure.repositories.doubles;

import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final List<JpaCategory> items = new ArrayList<>(1);

    public InMemoryCategoriesRepository(final List<JpaCategory> categories) {
        items.addAll(categories);
    }

    @Override
    public Optional<JpaCategory> findByDescription(final String description) {
        return items.stream().filter(jpa -> jpa.getDescription().equals(description)).findFirst();
    }

    @Override
    public List<JpaCategory> findAll() {
        return items;
    }

    @Override
    public JpaCategory save(final JpaCategory jpa) {
        items.add(jpa);
        return jpa;
    }
}
