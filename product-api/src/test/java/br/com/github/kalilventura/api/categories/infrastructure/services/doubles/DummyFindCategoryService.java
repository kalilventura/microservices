package br.com.github.kalilventura.api.categories.infrastructure.services.doubles;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class DummyFindCategoryService implements FindCategoryService {

    @Override
    public Optional<Category> findByDescription(final String description) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(1);
    }
}
