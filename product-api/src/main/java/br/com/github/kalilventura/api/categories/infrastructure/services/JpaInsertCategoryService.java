package br.com.github.kalilventura.api.categories.infrastructure.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.InsertCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.services.mappers.CategoryMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class JpaInsertCategoryService implements InsertCategoryService {

    @Getter(AccessLevel.PRIVATE)
    private final CategoriesRepository repository;

    public JpaInsertCategoryService(final CategoriesRepository categoriesRepository) {
        repository = categoriesRepository;
    }

    @Override
    public Category save(final Category category) {
        final var jpa = CategoryMapper.INSTANCE.mapToJpa(category);
        final var newCategory = getRepository().save(jpa);
        return CategoryMapper.INSTANCE.mapToEntity(newCategory);
    }
}
