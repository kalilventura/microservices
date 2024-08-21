package br.com.github.kalilventura.api.categories.infrastructure.services.doubles;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class InMemoryFindCategoryService implements FindCategoryService {

    private final List<Category> items = new ArrayList<>(1);

    public InMemoryFindCategoryService(final List<Category> categories) {
        items.addAll(categories);
    }

    @Override
    public Optional<Category> findById(final Long id) {
        return items.stream().findFirst();
    }

    @Override
    public Optional<Category> findByDescription(final String description) {
        return items.stream().filter(category -> category.description().equals(description)).findFirst();
    }

    @Override
    public List<Category> findAll() {
        return items;
    }
}
