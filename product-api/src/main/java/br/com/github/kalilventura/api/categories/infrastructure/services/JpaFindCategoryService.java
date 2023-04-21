package br.com.github.kalilventura.api.categories.infrastructure.services;

import br.com.github.kalilventura.api.categories.domain.entities.Category;
import br.com.github.kalilventura.api.categories.domain.services.FindCategoryService;
import br.com.github.kalilventura.api.categories.infrastructure.repositories.contracts.CategoriesRepository;
import br.com.github.kalilventura.api.categories.infrastructure.services.mappers.CategoryMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaFindCategoryService implements FindCategoryService {

    @Getter(AccessLevel.PRIVATE)
    private final CategoriesRepository repository;

    public JpaFindCategoryService(final CategoriesRepository categoriesRepository) {
        repository = categoriesRepository;
    }

    @Override
    public Optional<Category> findByDescription(final String description) {
        final var category = getRepository().findByDescription(description);
        return category.map(CategoryMapper.INSTANCE::mapToEntity);
    }
}
