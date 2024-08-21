package br.com.github.kalilventura.api.categories.infrastructure.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.InsertCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.models.JpaCategory;
import org.springframework.stereotype.Service;

@Service
public class JpaInsertCategoryService implements InsertCategoryService {

    private final CategoriesRepository repository;

    public JpaInsertCategoryService(final CategoriesRepository categoriesRepository) {
        repository = categoriesRepository;
    }

    @Override
    public Category save(final Category category) {
        final var jpa = JpaCategory.toJpa(category);
        final var newCategory = repository.save(jpa);
        return newCategory.toDomain();
    }
}
